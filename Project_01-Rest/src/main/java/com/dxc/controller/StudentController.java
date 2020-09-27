package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.beans.Student;
import com.dxc.repository.StudentRepository;



@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("students")
	public List<Student> getStudents()
	{
		List<Student> students = (List<Student>) studentRepository.findAll();
		return students;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="student/{id}")
	public Student getStudent(@PathVariable("id") int id) 
	{
		Student student = studentRepository.findById(id).orElse(new Student());
		return student;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("student")
	public Student save(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("student")
	public Student update(Student student)
	{
		return ((StudentController) studentRepository).update(student);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping(path = "student/{id}")
	public void delete(@PathVariable("id") int id)
	{
	studentRepository.deleteById(id);	
	}
}