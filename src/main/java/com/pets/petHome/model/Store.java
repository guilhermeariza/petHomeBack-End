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
@Table(name = "tb_store")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String corporateName;

	@NotNull
	private String address;
	
	@NotNull
	private String cnpj;
	
	@NotNull
	private String email;
	
	@NotNull
	private String phoneNumber;
	
	@NotNull
	@OneToOne
	@JsonIgnoreProperties(value = "store")
	private User user;

	public Store(Long id, String name, String corporateName,
			String address, String cnpj, String email, String phoneNumber, User user) {
		this.id = id;
		this.name = name;
		this.corporateName = corporateName;
		this.address = address;
		this.cnpj = cnpj;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.user = user;
	}
	
	public Store() {}


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

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cNPJ) {
		cnpj = cNPJ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
