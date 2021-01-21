package com.example.demo.models.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "grade_student",
    		joinColumns = { @JoinColumn(name = "grade_id") }, 
    			    inverseJoinColumns = {@JoinColumn(name = "student_id") })
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Student> student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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