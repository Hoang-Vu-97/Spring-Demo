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
import com.example.demo.models.in.GradeIn;
import com.example.demo.services.GradeService;

@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;
    
    @GetMapping("/grades")
    public List<Grade> findAll() {
        return gradeService.findAll();
    }

    @GetMapping("/grades/{id}")
    public Grade findById(@PathVariable("id") int id) {
    	return gradeService.findById(id);
    }
    
    @PostMapping("/grades")
    public Grade add(@RequestBody GradeIn gradeIn) {
        return gradeService.add(gradeIn);
    }

    @PutMapping("/grades/{id}")
    public Grade update(@PathVariable("id") int id, @RequestBody GradeIn gradeUpdate) {
    	return gradeService.update(id, gradeUpdate);
    }
    
    @DeleteMapping("/grades/{id}")
    public String delete(@PathVariable("id") int id) {
    	return gradeService.delete(id);
    }
    
    @GetMapping("/grades/{id}/students")
    public List<Student> getStudentsByGradeId(@PathVariable("id") int id) {
        return gradeService.getStudentsByGradeId(id);
    }
    
}
