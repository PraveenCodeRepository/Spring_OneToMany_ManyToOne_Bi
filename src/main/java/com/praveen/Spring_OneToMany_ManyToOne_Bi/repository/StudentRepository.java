package com.praveen.Spring_OneToMany_ManyToOne_Bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.Spring_OneToMany_ManyToOne_Bi.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
