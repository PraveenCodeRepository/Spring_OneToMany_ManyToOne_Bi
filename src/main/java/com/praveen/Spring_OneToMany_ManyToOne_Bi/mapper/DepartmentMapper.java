package com.praveen.Spring_OneToMany_ManyToOne_Bi.mapper;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.dto.DepartmentDto;
import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Department;

@Component
public class DepartmentMapper {

    public static DepartmentDto toDepartmentDto(Department department) {
        if (department == null) return null;

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentId(department.getDepartmentId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentCodeNo(department.getDepartmentCodeNo());

      
        if (department.getStudents() != null) {
            departmentDto.setStudents(StudentMapper.toStudentDtoList(department.getStudents()));
        }

        return departmentDto;
    }

    public static Department toDepartmentEntity(DepartmentDto departmentDto) {
        if (departmentDto == null) return null;

        Department department = new Department();
        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentCodeNo(departmentDto.getDepartmentCodeNo());

       
        if (departmentDto.getStudents() != null) {
            department.setStudents(StudentMapper.toStudentEntityList(departmentDto.getStudents()));
        }

        return department;
    }

    public static List<DepartmentDto> toDepartmentDtoList(List<Department> departments) {
        if (departments == null) return null;

        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department : departments) {
            departmentDtoList.add(toDepartmentDto(department));
        }
        return departmentDtoList;
    }

    public static List<Department> toDepartmentEntityList(List<DepartmentDto> departmentDtos) {
        if (departmentDtos == null) return null;

        List<Department> departmentList = new ArrayList<>();
        for (DepartmentDto departmentDto : departmentDtos) {
            departmentList.add(toDepartmentEntity(departmentDto));
        }
        return departmentList;
    }
}
