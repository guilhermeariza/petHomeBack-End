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

import com.pets.petHome.model.Transporter;
import com.pets.petHome.repository.TransporterRepository;


@RestController
@RequestMapping("/transporter")
@CrossOrigin("*")
public class TransporterController {
	
	@Autowired
	private TransporterRepository repository;
	
	@GetMapping("/all") //catches the list of all transporters
	public ResponseEntity<List<Transporter>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //catches an specific transporter by the id
	public ResponseEntity<Transporter>getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/signup") // creates a new transporter
	public ResponseEntity<Transporter> post(@RequestBody Transporter transporter){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(transporter));
	}
	
	@PutMapping("/update") //updates an existing transporter
	public ResponseEntity<Transporter> put (@RequestBody Transporter transporter){
		return ResponseEntity.ok(repository.save(transporter));
	}
	
	@DeleteMapping("/{id}") //deletes an existing transporter
	public void delete (@PathVariable long id){
		repository.deleteById(id);
	}
	

}
