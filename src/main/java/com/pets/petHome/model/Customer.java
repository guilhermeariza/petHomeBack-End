package com.pets.petHome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String nickName;
	
	@NotNull
	private String address;
	
	@NotNull
	private String cep;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private String birthDate;
	
	@NotNull
	private String phoneNumber;
	
	@NotNull
	private String email;
	
	@NotNull
	private boolean notifications;
	
	@NotNull
	private int qttPets;

	public Customer(Long id, String name, String lastName,  String nickName,
			String address, String cep, String cpf, String birthDate,
			String phoneNumber, String email, boolean notifications, int qttPets) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.nickName = nickName;
		this.address = address;
		this.cep = cep;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.notifications = notifications;
		this.qttPets = qttPets;
	}
	
	public Customer() {}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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

	public boolean isNotifications() {
		return notifications;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}

	public int getQttPets() {
		return qttPets;
	}

	public void setQttPets(int qttPets) {
		this.qttPets = qttPets;
	}
	
	
	
	

}
