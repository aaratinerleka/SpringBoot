package com.school.schoolMgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolMgmt.model.Course;
import com.school.schoolMgmt.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository crepository;
	
	@Autowired
    public CourseService(CourseRepository repository) {
        this.crepository = repository;
    }
	
	public List<Course> findAll() {
        return StreamSupport.stream(crepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Course> findById(Long id) {
        return crepository.findById(id);
    }

    public Course save(Course stock) {
        return crepository.save(stock);
    }

    public void deleteById(Long id) {
        crepository.deleteById(id);
    }
    public Boolean checkUniqueRecord(Course c ) {
    	if(crepository.findByCourseName(c.getCourseName())>0){
    		return false;
    	}
        return true;
    }
    
    public Set<Course>findByStudentId(long sid){
    	return crepository.findByStudentId(sid);
    }
    
    public Set<Course>notMappedWithAnyCourse(){
    	return crepository.findNotAssignedCourses();
    }
     
    
}
