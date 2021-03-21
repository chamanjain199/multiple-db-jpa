package com.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.entity.mysql.Student;
import com.example.jpa.entity.postgres.Person;
import com.example.jpa.repository.mysql.StudentRepository;
import com.example.jpa.repository.postgres.PersonRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner
{

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRepository.save(new Person("Chaman","101"));
		studentRepository.save(new Student("Kamal","101"));
		
	}

}
