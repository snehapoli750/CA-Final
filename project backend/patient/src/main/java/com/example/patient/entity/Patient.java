package com.example.patient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String visitedDoctor;
	private String dateOfVisit;
	private String prescription;
	
	//@Transient
	private int visitedDoctorId;
	
	
	public int getVisitedDoctorId() {
		return visitedDoctorId;
	}
	public void setVisitedDoctorId(int visitedDoctorId) {
		this.visitedDoctorId = visitedDoctorId;
	}
	
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public Patient( String name, String dateOfVisit) {
		super();
		this.name = name;
		this.dateOfVisit = dateOfVisit;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int id2, String string, String string2, String string3, String string4, int i) {
		// TODO Auto-generated constructor stub
	}
	
	

}
