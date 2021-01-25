package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entities.Grade;
import com.example.demo.models.entities.Student;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
	@Query(name = "showStudents",  nativeQuery = true)
	List<Student> getStudentsByGradeId(@Param("id") int id);
}
