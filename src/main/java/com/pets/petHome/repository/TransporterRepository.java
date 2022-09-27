package com.pets.petHome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets.petHome.model.Transporter;

@Repository
public interface TransporterRepository extends JpaRepository<Transporter, Long>{

}
