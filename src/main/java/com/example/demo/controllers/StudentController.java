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
import com.example.demo.models.in.StudentCreate;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping("/student/add")
    public Student add(@RequestBody StudentCreate studentCreate) {
    	return studentService.add(studentCreate);
    }
    
    @PutMapping("/student/update/{id}")
    public Student update(@PathVariable("id") int id, @RequestBody StudentCreate studentCreate) {
    	Student student = studentService.findById(id);
    	
    	student.setName(studentCreate.getName());
    	student.setBirthday(studentCreate.getBirthday());
    	student.setAddress(studentCreate.getAddress());
    	student.setPhoneNumber(studentCreate.getPhoneNumber());
    	
    	studentService.save(student);
    	return student;
    }
    
    @DeleteMapping("/student/delete/{id}")
    public String delete(@PathVariable("id") int id) {
    	return studentService.delete(id);
    }
    
    // Tra ve ten cac lop hoc cua mot hoc sinh
    @GetMapping("/student/grade/{id}")
    public List<String> getGradeNamesByStudentId(@PathVariable("id") int id) {
    	return studentService.getGradeNamesByStudentId(id);
    }
    
}
