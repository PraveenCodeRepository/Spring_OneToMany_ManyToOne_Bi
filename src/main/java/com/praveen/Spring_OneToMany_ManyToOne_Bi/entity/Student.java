package com.praveen.Spring_OneToMany_ManyToOne_Bi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student_tb")
public class Student {    //owning side - child 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private Long studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_roll_No")
	private long studentRollNo;
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

	public Student() {
		super();
	}

	public Student(Long studentId, String studentName, long studentRollNo, Department department) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
		this.department = department;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(long studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
    
    
}
