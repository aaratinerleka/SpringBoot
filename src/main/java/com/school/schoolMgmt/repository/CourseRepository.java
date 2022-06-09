package com.school.schoolMgmt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolMgmt.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	
	@Query("SELECT count(c) FROM Course c WHERE c.courseName = ?1")
	int findByCourseName(String courseName);
}
