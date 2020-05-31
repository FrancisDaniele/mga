package com.gourmet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gourmet.api.entity.Restaurante;



public interface RestaurantesRepository extends JpaRepository<Restaurante, Integer> {

}