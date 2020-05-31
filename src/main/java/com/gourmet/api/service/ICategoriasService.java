package com.gourmet.api.service;

import java.util.List;

import com.gourmet.api.entity.Categoria;



public interface ICategoriasService {
	List<Categoria> BuscarTodos();
	Categoria recuperar (int idCategoria);
	void guardar (Categoria categoria);
	void eliminar (int idCategoria);
	
}