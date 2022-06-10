package com.school.schoolMgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolMgmt.model.Student;
import com.school.schoolMgmt.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository srepository;
	
	@Autowired
    public StudentService(StudentRepository repository) {
        this.srepository = repository;
    }
	
    public List<Student> findAll() {
        return StreamSupport.stream(srepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Student> findById(Long id) {
        return srepository.findById(id);
    }
    public Boolean checkUniqueRecord(Student s ) {
    	if(srepository.findByNameAndAddress(s.getSname(), s.getAddress())>0){
    		return false;
    	}
        return true;
    }
    public Student save(Student stock) {
        return srepository.save(stock);
    }

    public void deleteById(Long id) {
        srepository.deleteById(id);
    }
    
    public Set<Student>findByStudentId(long sid){
    	return srepository.findByStudentId(sid);
    }
    
    public Set<Student>notMappedWithAnyCourse(){
    	return srepository.findNotAssignedStudents();
    }
}
