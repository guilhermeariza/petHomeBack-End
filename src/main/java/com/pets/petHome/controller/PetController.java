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

import com.pets.petHome.model.Pet;
import com.pets.petHome.repository.PetRepository;


@RestController
@RequestMapping("/pet")
@CrossOrigin("*")
public class PetController {
	
	@Autowired
	private PetRepository repository;
	
	@GetMapping("/all") //catches the list of all pets
	public ResponseEntity<List<Pet>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //catches an specific pet by the id
	public ResponseEntity<Pet>getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/signup") // creates a new pet
	public ResponseEntity<Pet> post(@RequestBody Pet pet){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pet));
	}
	
	@PutMapping("/update") //updates an existing pet
	public ResponseEntity<Pet> put (@RequestBody Pet pet){
		return ResponseEntity.ok(repository.save(pet));
	}
	
	@DeleteMapping("/{id}") //deletes an existing pet
	public void delete (@PathVariable long id){
		repository.deleteById(id);
	}
	
}







//ctrl M