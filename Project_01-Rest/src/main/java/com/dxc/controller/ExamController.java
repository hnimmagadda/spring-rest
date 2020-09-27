package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.beans.Exam;
import com.dxc.repository.ExamRepository;


@RestController
public class ExamController {

	@Autowired
	ExamRepository examRepository;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("exams")
	public List<Exam> getExams()
	{
		List<Exam> exams = (List<Exam>) examRepository.findAll();
		return exams;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="exam/{id}")
	public Exam getStudent(@PathVariable("id") String id) 
	{
		Exam exam = examRepository.findById(id).orElse(new Exam());
		return exam;
	}	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("exam")
	public Exam save(Exam exam)
	{
		return examRepository.save(exam);
	}
	
	
	
}