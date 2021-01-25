package com.example.demo.models.in;

import java.util.List;

import com.example.demo.models.entities.Student;

public class GradeIn {
    private String name;
    private List<Student> student;
    
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
    
}
