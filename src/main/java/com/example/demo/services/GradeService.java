package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entities.Grade;
import com.example.demo.models.entities.Student;
import com.example.demo.models.in.GradeIn;
import com.example.demo.repositories.GradeRepository;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
      
    public Grade findById(int id) {
    	return gradeRepository.findById(id).orElse(null);
    }
    
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    public Grade add(GradeIn gradeIn) {
        Grade grade = new Grade();

        grade.setName(gradeIn.getName());
        gradeRepository.save(grade);

        return grade;
    }
    
    public Grade update(int id, GradeIn gradeUpdate) {
    	Grade grade = gradeRepository.findById(id).orElse(null);
    	
    	grade.setName(gradeUpdate.getName());
    	grade.setStudent(gradeUpdate.getStudent());
    	
    	return gradeRepository.save(grade);
    }
    
    public String delete(int id) {
    	
    	Grade grade = gradeRepository.findById(id).orElse(null);
        if(grade == null) return "Fail !";
        
        gradeRepository.deleteById(id);
        
        return "Success !";
    }
    
    public List<Student> getStudentsByGradeId(int id) {
    	return gradeRepository.getStudentsByGradeId(id);
    }
    
    
}
