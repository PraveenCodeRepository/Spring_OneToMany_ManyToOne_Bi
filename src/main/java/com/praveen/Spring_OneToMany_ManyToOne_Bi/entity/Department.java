package com.praveen.Spring_OneToMany_ManyToOne_Bi.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="department_tb")
public class Department {   // inverse side - parent side
	
	@Id
	@Column(name="department_id")
	private Long departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_code_No")
	private String departmentCodeNo;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Student> students = new ArrayList<>();

	public Department() {
		super();
	}

	public Department(Long departmentId, String departmentName, String departmentCodeNo, List<Student> students) {
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
   
	public void addStudent(Student student) {
		 this.students.add(student);
		student.setDepartment(this);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
		student.setDepartment(this);
	}

}
