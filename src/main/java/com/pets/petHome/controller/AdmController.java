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

import com.pets.petHome.model.Adm;
import com.pets.petHome.repository.AdmRepository;


@RestController
@RequestMapping("/adm")
@CrossOrigin("*")
public class AdmController {
	
	@Autowired
	private AdmRepository repository;
	
	@GetMapping("/all") //catches the list of all adms
	public ResponseEntity<List<Adm>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //catches an specific adm by the id
	public ResponseEntity<Adm>getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/signup") // creates a new adm
	public ResponseEntity<Adm> post(@RequestBody Adm adm){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(adm));
	}
	
	@PutMapping("/update") //updates an existing adm
	public ResponseEntity<Adm> put (@RequestBody Adm adm){
		return ResponseEntity.ok(repository.save(adm));
	}
	
	@DeleteMapping("/{id}") //deletes an existing adm
	public void delete (@PathVariable long id){
		repository.deleteById(id);
	}

}
