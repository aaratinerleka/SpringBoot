package com.school.schoolMgmt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolMgmt.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("SELECT count(s) FROM Student s WHERE s.sname = ?1 and s.address = ?2")
	int findByNameAndAddress(String sname,String address);

}
