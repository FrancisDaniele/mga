package com.gourmet.api.service;

import java.util.List;

import com.gourmet.api.entity.Opinion;


public interface IOpinionesService {
	List<Opinion> BuscarTodos();
	Opinion recuperar (int idOpinion);
	void guardar (Opinion opinion);
	void eliminar (int idOpinion);
}