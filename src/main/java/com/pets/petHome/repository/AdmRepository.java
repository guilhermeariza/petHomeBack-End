package com.pets.petHome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets.petHome.model.Adm;

@Repository
public interface AdmRepository extends JpaRepository<Adm, Long>{

}
