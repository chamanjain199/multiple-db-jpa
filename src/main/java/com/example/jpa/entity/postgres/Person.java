package com.example.jpa.entity.postgres;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "person")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String roll;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String roll) {
		super();
		this.name = name;
		this.roll = roll;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", roll=" + roll + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getRoll()=" + getRoll() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
