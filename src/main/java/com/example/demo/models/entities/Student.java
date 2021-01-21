package com.example.demo.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@SqlResultSetMapping(name = "StudentMapping",
classes = @ConstructorResult(
        targetClass = Student.class,
        columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "birthday", type = Date.class),
                @ColumnResult(name = "address", type = String.class),
                @ColumnResult(name = "phone_number", type = String.class),
        }
)
)
@NamedNativeQuery(name = "showStudents", query = "select Student.id, Student.name, Student.birthday, Student.address, Student.phone_number\n" + 
		"from Grade\n" + 
		"join grade_student on (Grade.id=grade_student.grade_id)\n" + 
		"join Student on (Student.id=grade_student.student_id)\n" + 		
		"where Grade.id=:id\n" +
		"order by Student.id ASC", resultSetMapping = "StudentMapping")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date birthday;
    private String address;
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "grade_student", 
    	    joinColumns = { @JoinColumn(name = "student_id") }, 
    	    	    inverseJoinColumns = {@JoinColumn(name = "grade_id") })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Grade> grade;

    
    public Student() {
	}

	public Student(Integer id, String name, Date birthday, String address, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	public List<Grade> getGrade() {
		return grade;
	}

	public void setGrade(List<Grade> grade) {
		this.grade = grade;
	}

}
