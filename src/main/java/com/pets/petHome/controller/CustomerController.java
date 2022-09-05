package com.pets.petHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets.petHome.model.Customer;
import com.pets.petHome.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/all") //catches the list of all customers
	public ResponseEntity<List<Customer>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //catches an specific customer by the id
	public ResponseEntity<Customer>getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/signup") // creates a new customer
	public ResponseEntity<Customer> post(@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(customer));
	}
	
	@PutMapping("/update") //updates an existing customer
	public ResponseEntity<Customer> put (@RequestBody Customer customer){
		return ResponseEntity.ok(repository.save(customer));
	}
	
	@DeleteMapping("/{id}") //deletes an existing customer
	public void delete (@PathVariable long id){
		repository.deleteById(id);
	}
	

}
