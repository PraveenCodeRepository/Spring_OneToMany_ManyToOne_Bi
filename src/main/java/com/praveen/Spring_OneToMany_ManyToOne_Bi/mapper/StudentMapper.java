package com.praveen.Spring_OneToMany_ManyToOne_Bi.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.praveen.Spring_OneToMany_ManyToOne_Bi.dto.DepartmentDto;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.dto.StudentDto;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Department;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Student;
@Component
public class StudentMapper {

    public static StudentDto toStudentDto(Student student) {
        if (student == null) return null;

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setStudentName(student.getStudentName());
        studentDto.setStudentRollNo(student.getStudentRollNo());

        if (student.getDepartment() != null) {
            studentDto.setDepartment(student.getDepartment());
        }

        return studentDto;
    }

    public static List<StudentDto> toStudentDtoList(List<Student> students) {
        if (students == null) return null;

        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student : students) {
            studentDtoList.add(toStudentDto(student));
        }
        return studentDtoList;
    }

    public static List<Student> toStudentEntityList(List<StudentDto> studentDtos) {
        if (studentDtos == null) return null;

        List<Student> studentList = new ArrayList<>();
        for (StudentDto studentDto : studentDtos) {
            studentList.add(toStudentEntity(studentDto));
        }
        return studentList;
    }

    public static Student toStudentEntity(StudentDto studentDto) {
        if (studentDto == null) return null;

        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentRollNo(studentDto.getStudentRollNo());

        if (studentDto.getDepartment() != null) {
            student.setDepartment(studentDto.getDepartment());
        }

        return student;
    }
}
