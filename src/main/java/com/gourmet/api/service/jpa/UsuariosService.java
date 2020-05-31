package com.gourmet.api.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.api.entity.Usuario;
import com.gourmet.api.repository.UsuariosRepository;
import com.gourmet.api.service.IUsuariosService;



@Service
public class UsuariosService implements IUsuariosService {
	
	@Autowired
	private UsuariosRepository repoUsuarios;
	
	public List<Usuario> BuscarTodos() {
		return repoUsuarios.findAll();	
	}
	
	public void guardar(Usuario usuario) {
		repoUsuarios.save(usuario);
	}
	
	public Usuario recuperar(int idUsuario) {
		Optional<Usuario> optional = repoUsuarios.findById(idUsuario);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void eliminar(int idUsuario) {
		repoUsuarios.deleteById(idUsuario);
	}
	
}