package com.gourmet.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gourmet.api.entity.Usuario;
import com.gourmet.api.service.IUsuariosService;


@RestController
@RequestMapping("/api")
public class UsuariosController {
	
	@Autowired
	private IUsuariosService serviceUsuarios;
	
	@GetMapping("/usuarios")
	public List<Usuario> buscar(){
		return serviceUsuarios.BuscarTodos();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario recuperar(@PathVariable("id") int idUsuario) {
		Usuario usuario = serviceUsuarios.recuperar(idUsuario);
		return usuario;
	}
	
	@PostMapping("/usuarios")
	public Usuario insertar(@RequestBody Usuario usuario) {
		serviceUsuarios.guardar(usuario);
		return usuario;	
	}
	
	@PutMapping("/usuarios")
	public Usuario modificar(@RequestBody Usuario usuario) {
		serviceUsuarios.guardar(usuario);// al pasarle el id, modificará el usuario correspondiente
		return usuario;	
	}
	
	@DeleteMapping("/usuarios/{id}")
	public String eliminar(@PathVariable("id") int idUsuario) {
		serviceUsuarios.eliminar(idUsuario);
		return "Usuario Eliminado";	
	}
}