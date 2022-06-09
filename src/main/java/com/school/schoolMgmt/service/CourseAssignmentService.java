package com.school.schoolMgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolMgmt.model.CourseAssignment;
import com.school.schoolMgmt.repository.CourseAssignmentRepository;

@Service
public class CourseAssignmentService {

	private CourseAssignmentRepository crepository;
	
	@Autowired
    public CourseAssignmentService(CourseAssignmentRepository repository) {
        this.crepository = repository;
    }
	
	public List<CourseAssignment> findAll() {
        return StreamSupport.stream(crepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<CourseAssignment> findById(Long id) {
        return crepository.findById(id);
    }

    public CourseAssignment saveRecord(long sid,long cid) {
    	if(crepository.findByCourseId(cid)<50 && crepository.findByStudentId(sid)<5 && crepository.findByCourseIdStudentId(cid, sid)==0)
        {
    		//return crepository.save(sid,cid);
    		}
    	return new CourseAssignment();
    }

    public void deleteById(Long id) {
        crepository.deleteById(id);
    }
    public Boolean checkMaxCourseRecord(long cid ) {
    	if(crepository.findByCourseId(cid)<50){
    		return true;
    	}
        return false;
    }
    public Boolean checkMaxStudentRecord(long sid ) {
    	if(crepository.findByStudentId(sid)<5){
    		return true;
    	}
        return false;
    }
    
}
