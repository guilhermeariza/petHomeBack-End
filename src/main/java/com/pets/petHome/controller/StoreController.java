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

import com.pets.petHome.model.Store;
import com.pets.petHome.repository.StoreRepository;

@RestController
@RequestMapping("/store")
@CrossOrigin("*")
public class StoreController {
	
	@Autowired
	private StoreRepository repository;
	
	@GetMapping("/all") //catches the list of all stores
	public ResponseEntity<List<Store>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //catches an specific store by the id
	public ResponseEntity<Store>getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/signup") // creates a new store
	public ResponseEntity<Store> post(@RequestBody Store store){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(store));
	}
	
	@PutMapping("/update") //updates an existing store
	public ResponseEntity<Store> put (@RequestBody Store store){
		return ResponseEntity.ok(repository.save(store));
	}
	
	@DeleteMapping("/{id}") //deletes an existing store
	public void delete (@PathVariable long id){
		repository.deleteById(id);
	}

}
