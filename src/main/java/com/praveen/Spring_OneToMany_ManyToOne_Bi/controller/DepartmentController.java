package com.praveen.Spring_OneToMany_ManyToOne_Bi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.Spring_OneToMany_ManyToOne_Bi.dto.DepartmentDto;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Department;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.exception.DepartmentNotFoundException;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/createDepartment")
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		try {
		DepartmentDto departmentDtoCreated = departmentService.createDepartment(departmentDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentDtoCreated);
		}catch(IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(null);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
		try {
		List<DepartmentDto> departmentDtosFound =departmentService.getAllDepartments();
		    return ResponseEntity.status(HttpStatus.OK).body(departmentDtosFound);
		}catch(DepartmentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/getDepartment/{departmentId}")
	public ResponseEntity<DepartmentDto> getDepartmentByDepartmentId(@PathVariable Long departmentId){
		try {
			DepartmentDto departmentDtoFound =departmentService.getDepartmentByDepartmentId(departmentId);
			return ResponseEntity.status(HttpStatus.OK).body(departmentDtoFound);
		}catch(DepartmentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PutMapping("/updateDepartment/{departmentId}")
	public ResponseEntity<DepartmentDto> updateDepartmentByDepartmentId(@PathVariable Long departmentId,
			@RequestBody DepartmentDto departmentDto){
		try {
		DepartmentDto departmentDtoUpdated =departmentService.updateDepartment(departmentId,departmentDto);
		        return ResponseEntity.status(HttpStatus.OK).body(departmentDtoUpdated);
		}catch(DepartmentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@DeleteMapping("/deleteDepartment/{departmentId}")
	public ResponseEntity<?> deleteDepartmentByDepartmentId(@PathVariable Long departmentId){
		try {
			departmentService.deleteDepartmentByDepartmentId(departmentId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(DepartmentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	}
   
   