package com.school.schoolMgmt.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	long cid;
	String courseName;
	String description;
	
	@OneToMany(mappedBy = "course")
    Set<CourseAssignment> registrations;
	

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Set<CourseAssignment> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(Set<CourseAssignment> registrations) {
		this.registrations = registrations;
	}
	
	

}
