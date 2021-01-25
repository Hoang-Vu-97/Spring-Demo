//package com.example.demo.services.mapper;
//
//import com.example.demo.models.entities.Grade;
//import com.example.demo.models.in.GradeCreate;
//import com.example.demo.models.out.GradeDto;
//
//public class GradeMapper {
//
//	public GradeDto toGradeDto(Grade grade) {
//		GradeDto gradeDto = new GradeDto();
//		gradeDto.setId(grade.getId());
//		gradeDto.setName(grade.getName());
//		return gradeDto;
//	}
//	
//	public Grade toGrade(Grade grade, GradeCreate gradeCreate) {
//		grade.setId(gradeCreate.getId());
//		grade.setName(gradeCreate.getName());
//		return grade;
//	}
//}
