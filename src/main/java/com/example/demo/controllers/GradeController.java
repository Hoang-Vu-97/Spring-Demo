package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entities.Grade;
import com.example.demo.models.entities.Student;
import com.example.demo.models.in.GradeCreate;
import com.example.demo.repositories.GradeRepository;
import com.example.demo.services.GradeService;

@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;
    
    @Autowired
    private GradeRepository gradeRepository;
    
    @GetMapping("/grade")
    public List<Grade> findAll() {
        return gradeService.findAll();
    }

    @PostMapping("/grade/add")
    public Grade add(@RequestBody GradeCreate gradeCreate) {
        return gradeService.add(gradeCreate);
    }

    @PutMapping("/grade/update/{id}")
    public Grade update(@PathVariable("id") int id, @RequestBody GradeCreate gradeCreate) {
    	Grade grade = gradeService.findById(id);
    	grade.setName(gradeCreate.getName());
    	grade.setStudent(gradeCreate.getStudent());
    	gradeService.save(grade);
    	return grade;
    }
    
    @DeleteMapping("/grade/delete/{id}")
    public String delete(@PathVariable("id") int id) {
    	return gradeService.delete(id);
    }
    
    // Try
    @GetMapping("/grade/student/{id}")
    public List<Student> getStudentNamesByGradeId(@PathVariable("id") int id) {
        return gradeRepository.getStudentNamesByGradeId(id);
    }
    
}
