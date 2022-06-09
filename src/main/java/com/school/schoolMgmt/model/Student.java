package com.school.schoolMgmt.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	long sid;
	String sname;
	String address;
	
	@OneToMany(mappedBy = "student")
    Set<CourseAssignment> registrations;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public Set<CourseAssignment> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(Set<CourseAssignment> registrations) {
		this.registrations = registrations;
	}
	
	

}
