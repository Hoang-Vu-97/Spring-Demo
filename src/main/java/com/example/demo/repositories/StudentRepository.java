package com.example.demo.repositories;

import com.example.demo.models.entities.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query(value = "select Grade.name \n" + 
			"from Student\n" + 
			"join grade_student on (Student.id=grade_student.student_id)\n" + 
			"join Grade on (Grade.id=grade_student.grade_id)\n" + 
			"where Student.id=:id",  nativeQuery = true)
	List<String> getGradesByStudentId(@Param("id") int id);
}
