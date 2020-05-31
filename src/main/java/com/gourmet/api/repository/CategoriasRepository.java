package com.gourmet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gourmet.api.entity.Categoria;



public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}