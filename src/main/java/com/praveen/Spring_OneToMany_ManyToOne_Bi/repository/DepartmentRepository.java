package com.praveen.Spring_OneToMany_ManyToOne_Bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
