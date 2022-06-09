package com.school.schoolMgmt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolMgmt.model.CourseAssignment;

@Repository
public interface CourseAssignmentRepository extends CrudRepository<CourseAssignment, Long> {
	
	@Query("SELECT count(sc) FROM CourseAssignment sc WHERE sc.student.sid = ?1")
	int findByStudentId(long sid);
	
	@Query("SELECT count(sc) FROM CourseAssignment sc WHERE sc.course.cid = ?1")
	int findByCourseId(long cid);
	
	@Query("SELECT count(sc) FROM CourseAssignment sc WHERE sc.course.cid = ?1 and sc.student.sid = ?2")
	int findByCourseIdStudentId(long cid,long sid);
	
	/*@Query("insert into CourseAssignment (id,student_id, course_id) values (?1,?2,?3)")
	CourseAssignment saveRecord(long id, long sid,long cid);*/
}
