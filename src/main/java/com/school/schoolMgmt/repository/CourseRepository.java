package com.school.schoolMgmt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolMgmt.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	
	@Query("SELECT count(c) FROM Course c WHERE c.courseName = ?1")
	int findByCourseName(String courseName);
	
	
	@Query("SELECT c FROM Course c join CourseAssignment ca WHERE ca.student.sid = ?1")
	Set<Course>findByStudentId(long studentId);
	
	@Query("SELECT c FROM Course c WHERE c.cid not in(select distinct course.cid from CourseAssignment)")
	Set<Course>findNotAssignedCourses();
}
