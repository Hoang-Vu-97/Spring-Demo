package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entities.Student;
import com.example.demo.models.in.StudentCreate;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void save(Student student) {
    	studentRepository.save(student);
    }
    
    public Student findById(int id) {
    	return studentRepository.findById(id).orElse(null);
    }
    
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student add(StudentCreate studentCreate) {
    	Student student = new Student();
    	
    	student.setName(studentCreate.getName());
    	student.setBirthday(studentCreate.getBirthday());
    	student.setAddress(studentCreate.getAddress());
    	student.setPhoneNumber(studentCreate.getPhoneNumber());
    	studentRepository.save(student);
    	
    	return student;
    }
    
    public String delete(int id) {
    	Student student = studentRepository.findById(id).orElse(null);
    	if(student == null) return "Fail !";
    	
    	studentRepository.deleteById(id);
    	return "Success !";
    }
    
    // Get grade name by student id
    public List<String> getGradeNamesByStudentId(int id) {
    	return studentRepository.getGradeNamesByStudentId(id);
    }
    
}
