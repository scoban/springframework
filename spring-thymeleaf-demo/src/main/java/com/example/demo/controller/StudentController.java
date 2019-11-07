package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.repository.RepositoryStudent;
import com.example.demo.repository.entity.Student;

@Controller
public class StudentController {

	private final RepositoryStudent repositoryStudent;
	
	public StudentController(RepositoryStudent repositoryStudent) {
		this.repositoryStudent = repositoryStudent;
	}

	@PostMapping("/student/student")
	public String saveStudent(Model model, @Valid Student student) {
		repositoryStudent.save(student);
		model.addAttribute("student", student); 
		return listStudent(model);
	}
	
	@GetMapping("/student/students")
	public String listStudent(Model model) {
		Iterable<Student> students = repositoryStudent.findAll();
		model.addAttribute("students", students);
		return "ListStudent";
	}
	
	@GetMapping("/student/form")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student()); 
		return "AddStudent";
	}
	
	@GetMapping("/student/{studentId}")
	public String listStudent(Model model, @PathVariable("studentId") Long studentId) {
		Student student = repositoryStudent.findById(studentId).orElse(null);
		if(student!=null) {
			model.addAttribute("student", student);
			return "AddStudent";
		}
		return listStudent(model);
	}
	
	@GetMapping("/student/delete/{studentId}")
	public String deleteStudent(Model model, @PathVariable("studentId") Long studentId) {
		Student student = repositoryStudent.findById(studentId).orElse(null);
		if(student == null)
			return listStudent(model);
		repositoryStudent.delete(student); 
		return listStudent(model); 
	}
}
