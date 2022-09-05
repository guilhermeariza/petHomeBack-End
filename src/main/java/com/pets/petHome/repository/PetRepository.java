package com.pets.petHome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pets.petHome.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
