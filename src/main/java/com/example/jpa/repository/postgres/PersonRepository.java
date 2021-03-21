package com.example.jpa.repository.postgres;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.entity.postgres.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	String FIND_BY_ID = "FIND_BY_ID";
	String HINT_CACHEABLE = "HINT_CACHEABLE";

	@Query("Select p from Person p where p.id=1")
    @Cacheable(cacheNames = FIND_BY_ID)
	public Person find1();

}
