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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	@Autowired
	BookRepo serviceRepository;
	@Autowired
	ApiService service;
	
	@GetMapping("/")
	List<Book> getList()
	{
		return serviceRepository.findAll();
		
	}
	
	@GetMapping("{id}")
	public Optional<Book>getbyid(@PathVariable int id)
	{
		return service.getBook(id);
	}
	
	@PostMapping("/")
	public Book create(@RequestBody Book boo)
	{
		return serviceRepository.save(boo);
	}
	
	@PutMapping("/")

	public String update(@RequestBody Book boo)
	{
		return service.updateDetails(boo);
	}
	
	@DeleteMapping("/del")

	public String delete(@RequestParam int id)
	{
	   return service.deleteDetails(id);
	}

}
