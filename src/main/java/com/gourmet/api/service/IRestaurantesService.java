package com.gourmet.api.service;

import java.util.List;

import com.gourmet.api.entity.Restaurante;



public interface IRestaurantesService {
	List<Restaurante> BuscarTodos();
	Restaurante recuperar (int idRestaurante);
	void guardar (Restaurante restaurante);
	void eliminar (int idRestaurante);
	
}