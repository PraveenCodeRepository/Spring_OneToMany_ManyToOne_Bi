package com.praveen.Spring_OneToMany_ManyToOne_Bi.dto;

import java.util.ArrayList;
import java.util.List;


public class DepartmentDto { //inverse side - parent 
	
	private Long departmentId;
	
	private String departmentName;
	
	private String departmentCodeNo;
	
	private List<StudentDto> students = new ArrayList<>();


	public DepartmentDto() {
		super();
	}


	public DepartmentDto(Long departmentId, String departmentName, String departmentCodeNo, List<StudentDto> students) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentCodeNo = departmentCodeNo;
		this.students = students;
	}


	public Long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentCodeNo() {
		return departmentCodeNo;
	}


	public void setDepartmentCodeNo(String departmentCodeNo) {
		this.departmentCodeNo = departmentCodeNo;
	}


	public List<StudentDto> getStudents() {
		return students;
	}


	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}
	
	


}
