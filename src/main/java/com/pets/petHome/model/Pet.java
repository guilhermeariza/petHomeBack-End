package com.pets.petHome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int age;
	
	@NotNull
	private String gender;
	
	@NotNull
	private String race;
	
	@NotNull
	private int rationPeriodizationInDays;
	
	@ManyToOne
	@JsonIgnoreProperties(value = "pet")
	private Customer customer;

	public Pet(Long id, String name, int age, String gender, String race,
			int rationPeriodizationInDays, Customer customer) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.race = race;
		this.rationPeriodizationInDays = rationPeriodizationInDays;
		this.customer = customer;
	}
	
	public Pet() {}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getRationPeriodizationInDays() {
		return rationPeriodizationInDays;
	}

	public void setRationPeriodizationInDays(int rationPeriodizationInDays) {
		this.rationPeriodizationInDays = rationPeriodizationInDays;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
