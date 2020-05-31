package com.gourmet.api.service;

import java.util.List;

import com.gourmet.api.entity.Usuario;



public interface IUsuariosService {
	List<Usuario> BuscarTodos();
	Usuario recuperar (int idUsuario);
	void guardar (Usuario usuario);
	void eliminar (int idUsuario);
}