package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ApiService {
	@Autowired
	ChildRepo repository;
	public Optional<Child>getChild(int babyId){
		return repository.findById(babyId);
	}
	public List<Child> getSort(String field)
	{
		return repository.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	public List<Child>setPages(@PathVariable int offset,@PathVariable int pageSize)
	{
		Page<Child>page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	
	public List<Child>setPages(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		Page<Child>page=repository.findAll(PageRequest.of(offset,pageSize,Sort.Direction.ASC,field));
		return page.getContent();
	}

}
