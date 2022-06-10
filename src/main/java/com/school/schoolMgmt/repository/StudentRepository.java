package com.school.schoolMgmt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolMgmt.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("SELECT count(s) FROM Student s WHERE s.sname = ?1 and s.address = ?2")
	int findByNameAndAddress(String sname,String address);

	@Query("SELECT s FROM Student s join CourseAssignment ca WHERE ca.course.cid = ?1")
	Set<Student>findByStudentId(long courseId);
	
	@Query("SELECT s FROM Student s WHERE s.sid not in(select distinct student.sid from CourseAssignment)")
	Set<Student>findNotAssignedStudents();
}
