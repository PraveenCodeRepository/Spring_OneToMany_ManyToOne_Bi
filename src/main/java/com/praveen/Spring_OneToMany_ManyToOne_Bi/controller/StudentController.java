package com.praveen.Spring_OneToMany_ManyToOne_Bi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.Spring_OneToMany_ManyToOne_Bi.dto.StudentDto;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.exception.StudentNotFoundException;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/createStudent")
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
	 try {	
	StudentDto studentDtoCreated =studentService.createStudent(studentDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(studentDtoCreated);
	}catch(IllegalArgumentException ex) {
		return ResponseEntity.badRequest().body(null);
	}
	 catch(Exception ex) {
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	 }
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<StudentDto>> getAllStudents(){
		try {
		List<StudentDto> studentDtoListFound =studentService.getAllStudents();
	    	return ResponseEntity.status(HttpStatus.OK).body(studentDtoListFound);
		}catch(StudentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch(Exception ex) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		 }
	}
	
	@GetMapping("/getStudent/{studentId}")
	public ResponseEntity<StudentDto> getStudentByStudentId(@PathVariable Long studentId){
		try {
		StudentDto studentDtoFound =studentService.getStudentByStudentId(studentId);
	    	return ResponseEntity.status(HttpStatus.OK).body(studentDtoFound);
		}catch(StudentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch(Exception ex) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		 }
	}
	
	@PutMapping("/updateStudent/{studentId}")
	public ResponseEntity<StudentDto> updateStudentByStudentId(@PathVariable Long studentId,
			@RequestBody StudentDto studentDto){
		try {
		StudentDto studentDtoUpdated =studentService.updateStudent(studentId,studentDto);
		        return ResponseEntity.status(HttpStatus.OK).body(studentDtoUpdated);
		}catch(StudentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@DeleteMapping("/deleteStudent/{studentId}")
	public ResponseEntity<?> deleteStudentByStudentId(@PathVariable Long studentId){
		try {
			studentService.deleteStudentByStudentId(studentId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(StudentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	


}
