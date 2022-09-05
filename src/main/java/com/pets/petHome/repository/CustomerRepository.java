package com.pets.petHome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets.petHome.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
