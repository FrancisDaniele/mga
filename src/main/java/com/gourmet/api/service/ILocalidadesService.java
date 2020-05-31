package com.gourmet.api.service;

import java.util.List;

import com.gourmet.api.entity.Localidad;



public interface ILocalidadesService {
	List<Localidad> BuscarTodos();
	Localidad recuperar (int idLocalidad);
	void guardar (Localidad localidad);
	void eliminar (int idLocalidad);
	
}