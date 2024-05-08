package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	private String studentName;
	
	@Id
	private int idNo;
	
	public String getstudentName() {
		return studentName;
	}
	public void setstudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + "]";
	}
	
	public int getIdNo() {
		return idNo;
	}
	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}
	

}
