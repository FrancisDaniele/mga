package com.gourmet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gourmet.api.entity.Opinion;


public interface OpinionesRepository extends JpaRepository<Opinion, Integer>{
	
}