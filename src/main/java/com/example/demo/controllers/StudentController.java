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

import com.example.demo.models.entities.Student;
import com.example.demo.models.in.StudentIn;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findById(@PathVariable("id") int id) {
    	return studentService.findById(id);
    }
    
    @PostMapping("/students")  
    public Student add(@RequestBody StudentIn studentIn) {
    	return studentService.add(studentIn);
    }
    
    @PutMapping("/students/{id}")
    public Student update(@PathVariable("id") int id, @RequestBody StudentIn studentUpdate) {
    	return studentService.update(id, studentUpdate);
    }
    
    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable("id") int id) {
    	return studentService.delete(id);
    }
    
    @GetMapping("/students/{id}/grades")
    public List<String> getGradesByStudentId(@PathVariable("id") int id) {
    	return studentService.getGradesByStudentId(id);
    }
    
}
