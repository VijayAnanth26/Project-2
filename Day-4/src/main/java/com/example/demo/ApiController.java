package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class ApiController {
	@Autowired
	StudentRepo serviceRepository;
	@Autowired
	ApiService service;
	
	@GetMapping("/")
	List<Student> getList()
	{
		return serviceRepository.findAll();
		
	}
	@GetMapping("/getvalue/{id}")
	public Optional<Student>getbyid(@PathVariable int id)
	{
		return service.getStudent(id);
	}
	@PostMapping("{id}")
	public Student create(@RequestBody Student stu)
	{
		return serviceRepository.save(stu);
	}
	@PutMapping("/student")
	
	public String update(@RequestBody Student stu)
	{
		return service.updateDetails(stu);
	}
	@DeleteMapping("/del")
	
	public String delete(@RequestParam int id)
	{
	   return service.deleteDetails(id);
	}
}
