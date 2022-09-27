package com.pets.petHome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets.petHome.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

}
