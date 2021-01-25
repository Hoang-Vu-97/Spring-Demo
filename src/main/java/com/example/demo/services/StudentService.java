package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entities.Student;
import com.example.demo.models.in.StudentIn;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student findById(int id) {
    	return studentRepository.findById(id).orElse(null);
    }
    
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    
    public Student add(StudentIn studentIn) {
    	Student student = new Student();
    	
    	student.setName(studentIn.getName());
    	student.setBirthday(studentIn.getBirthday());
    	student.setAddress(studentIn.getAddress());
    	student.setPhoneNumber(studentIn.getPhoneNumber());    
    	studentRepository.save(student);
    	
    	return student;
    }
    
    public Student update(int id, StudentIn studentUpdate) {
        Student student = studentRepository.findById(id).orElse(null);
    	
    	student.setName(studentUpdate.getName());
    	student.setBirthday(studentUpdate.getBirthday());
    	student.setAddress(studentUpdate.getAddress());
    	student.setPhoneNumber(studentUpdate.getPhoneNumber());
    	
    	return studentRepository.save(student);  
    }
    
    public String delete(int id) {
    	Student student = studentRepository.findById(id).orElse(null);
    	if(student == null) return "Fail !";
    	
    	studentRepository.deleteById(id);
    	return "Success !";
    }
    
    public List<String> getGradesByStudentId(int id) {
    	return studentRepository.getGradesByStudentId(id);
    }
    
}
