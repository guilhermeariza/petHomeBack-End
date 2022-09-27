package com.pets.petHome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_transporter")
public class Transporter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//private User User;
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String nickName;
	
	@NotNull
	private String automobile;
	
	@NotNull
	private String licensePlate;
	
	@NotNull
	private String phoneNumber;
	
	@NotNull
	private String email;
	
	@NotNull
	private String cpf;
	
	@NotNull
	@OneToOne
	@JsonIgnoreProperties(value = "transporter")
	private User user;

	public Transporter(Long id, String name, String lastName, String nickName,
			String automobile, String licensePlate, String phoneNumber,
			String email, String cpf, User user) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.nickName = nickName;
		this.automobile = automobile;
		this.licensePlate = licensePlate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.cpf = cpf;
		this.user = user;
	}
	
	public Transporter() {}


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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAutomobile() {
		return automobile;
	}

	public void setAutomobile(String automobile) {
		this.automobile = automobile;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
