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

import com.pets.petHome.model.User;
import com.pets.petHome.repository.UserRepository;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping("/all") //catches the list of all users
	public ResponseEntity<List<User>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //catches an specific user by the id
	public ResponseEntity<User>getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/signup") // creates a new user
	public ResponseEntity<User> post(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
	}
	
	@PutMapping("/update") //updates an existing user
	public ResponseEntity<User> put (@RequestBody User user){
		return ResponseEntity.ok(repository.save(user));
	}
	
	@DeleteMapping("/{id}") //deletes an existing user
	public void delete (@PathVariable long id){
		repository.deleteById(id);
	}
	
}
