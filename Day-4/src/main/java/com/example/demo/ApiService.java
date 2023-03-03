package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ApiService {
	@Autowired
	StudentRepo repository;
	public Optional<Student>getStudent(int id){
		return repository.findById(id);
	}
	public String updateDetails(Student stu) {
		repository.save(stu);
		return "updated";
	}
	public String deleteDetails(int id)
	{
		repository.deleteById(id);
		return "Id deleted";
	}
	
}
