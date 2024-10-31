package com.praveen.Spring_OneToMany_ManyToOne_Bi.dto;

import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Department;

public class StudentDto {  //owning side - child
	
	
	private Long studentId;
	
	private String studentName;
	
	private long studentRollNo;
	
    private Department department;

	public StudentDto() {
		super();
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
