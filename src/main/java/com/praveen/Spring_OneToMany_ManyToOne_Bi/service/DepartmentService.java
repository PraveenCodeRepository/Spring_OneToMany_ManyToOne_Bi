package com.praveen.Spring_OneToMany_ManyToOne_Bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.Spring_OneToMany_ManyToOne_Bi.dto.DepartmentDto;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Department;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Student;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.exception.DepartmentNotFoundException;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.mapper.DepartmentMapper;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.repository.DepartmentRepository;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.repository.StudentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		 
		Department department =  DepartmentMapper.toDepartmentEntity(departmentDto);
		
		Department savedDepartment =departmentRepository.save(department);
		
		List<Student> studentList =  department.getStudents();
		
		     if(studentList!=null) {
		    	 
		    	 for(Student student:studentList) {
		    		 studentRepository.save(student);
		    		 }
		     }
		     
		 DepartmentDto savedDepartmentDto = DepartmentMapper.toDepartmentDto(savedDepartment);
		
		return savedDepartmentDto;
	}

	public List<DepartmentDto> getAllDepartments() {
		 
		List<Department> departmentList =departmentRepository.findAll();
		
		return DepartmentMapper.toDepartmentDtoList(departmentList);
		
		
	}

	public DepartmentDto getDepartmentByDepartmentId(Long departmentId) {
		
	    Department department =	departmentRepository.findById(departmentId)
		                    .orElseThrow(()->new DepartmentNotFoundException
		                    		             ("Department not found with id :"+departmentId));
		DepartmentDto departmentDtoFound = DepartmentMapper.toDepartmentDto(department);
		return departmentDtoFound;
	}

	public DepartmentDto updateDepartment(Long departmentId,DepartmentDto departmentDto) {
		
		  Department department =	departmentRepository.findById(departmentId)
                  .orElseThrow(()->new DepartmentNotFoundException
                  		             ("Department not found with id :"+departmentId));
            
		   department.setDepartmentName(departmentDto.getDepartmentName());
		   department.setDepartmentCodeNo(departmentDto.getDepartmentCodeNo());
		   
		 Department departmentUpdated =  departmentRepository.save(department);
		 
		DepartmentDto departmentDtoUpdated = DepartmentMapper.toDepartmentDto(departmentUpdated);
		
		return departmentDtoUpdated;
	}

	public void deleteDepartmentByDepartmentId(Long departmentId) {
		
		 Department department =	departmentRepository.findById(departmentId)
                 .orElseThrow(()->new DepartmentNotFoundException
                 		             ("Department not found with id :"+departmentId));
        departmentRepository.delete(department);
		
	}

}
