package com.eventManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventManagement.entities.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	private List<Student> students = new ArrayList<>(List.of(
			new Student(1,"Abhishek",87),
			new Student(2,"Jack",72)
		));


	@GetMapping("/student")
	public List<Student> getAllStudents(){
		return this.students;
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	}
	
//	@PostMapping("/student")
//	public Student addStudent(@RequestBody Student student) {
//		this.students.add(student);
//		return student; 
//	}
	
}

