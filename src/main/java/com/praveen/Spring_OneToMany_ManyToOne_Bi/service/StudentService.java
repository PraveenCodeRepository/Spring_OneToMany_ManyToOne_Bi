package com.praveen.Spring_OneToMany_ManyToOne_Bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.Spring_OneToMany_ManyToOne_Bi.dto.DepartmentDto;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.dto.StudentDto;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Department;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Student;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.exception.DepartmentNotFoundException;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.exception.StudentNotFoundException;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.mapper.DepartmentMapper;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.mapper.StudentMapper;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.repository.DepartmentRepository;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public StudentDto createStudent(StudentDto studentDto) {

		Student student = StudentMapper.toStudentEntity(studentDto);

		Department department = student.getDepartment();

		if (department != null && department.getDepartmentId() != null) {

			if (departmentRepository.existsById(department.getDepartmentId())) {

				Student savedstudent = studentRepository.save(student);

				StudentDto savedStudentDto = StudentMapper.toStudentDto(savedstudent);

				return savedStudentDto;
			} else {
				throw new DepartmentNotFoundException("Department not found with id ");
			}
		} else {
			throw new IllegalArgumentException("Department information is missing");
		}

	}

	public List<StudentDto> getAllStudents() {

		List<Student> studentList = studentRepository.findAll();

		List<StudentDto> studentDtoList = StudentMapper.toStudentDtoList(studentList);

		return studentDtoList;
	}

	public StudentDto getStudentByStudentId(Long studentId) {

		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id :" + studentId));
		StudentDto studentDtoFound = StudentMapper.toStudentDto(student);
		return studentDtoFound;

	}
	
	public StudentDto updateStudent(Long studentId,StudentDto studentDto) {
		
		  Student student =	studentRepository.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException
                		             ("Department not found with id :"+studentId));
          
		   student.setStudentName(studentDto.getStudentName());
		   student.setStudentRollNo(studentDto.getStudentRollNo());
		   
		 Student studentUpdated =  studentRepository.save(student);
		 
		StudentDto studenttDtoUpdated = StudentMapper.toStudentDto(studentUpdated);
		
		return studenttDtoUpdated;
	}
	
	
	public void deleteStudentByStudentId(Long studentId) {
		 Student student = studentRepository.findById(studentId)
	                .orElseThrow(()->new StudentNotFoundException
	                		             ("Student not found with id :"+studentId));
	       studentRepository.delete(student);
		
	}

	

}
