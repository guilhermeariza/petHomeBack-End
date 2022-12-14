package com.pets.petHome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets.petHome.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

}
