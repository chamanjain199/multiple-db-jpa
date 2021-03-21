package com.example.jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.postgres.Person;
import com.example.jpa.repository.postgres.PersonRepository;

@RestController
public class TestController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/save")
	public void save() {
		Person p=new Person();
		p.setName("Chaman");
		p.setRoll("101");
		personRepository.save(p);
	
		
	}
	@GetMapping("/test")
	public void get1() {
		
		Optional<Person> findById = personRepository.findById(2l);
		System.out.println(findById.get());
		Optional<Person> findById1 = personRepository.findById(2l);
		System.out.println(findById1.get());
		
	}
	@GetMapping("/test2")
	public void get2() {
		
		Optional<Person> findById = personRepository.findById(2l);
		System.out.println(findById.get());
		Optional<Person> findById1 = personRepository.findById(2l);
		System.out.println(findById1.get());
		
	}
	@GetMapping("/test3")
	public void get3() {
		
		Person findById = personRepository.find1();
		System.out.println(findById);
		Person findById1 = personRepository.find1();
		System.out.println(findById1);
		
	}
}
