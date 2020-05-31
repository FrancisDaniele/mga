package com.gourmet.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gourmet.api.entity.Categoria;
import com.gourmet.api.service.ICategoriasService;




@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CategoriasController {
	
	@Autowired
	private ICategoriasService serviceCategorias;
	
	@GetMapping("/categorias")
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	public List<Categoria> buscar() {
		System.out.println("categorias");
		return serviceCategorias.BuscarTodos();
	}
	
	@GetMapping("/categorias/{id}")
	public Categoria recuperar(@PathVariable("id") int idCategoria) {
		Categoria categoria = serviceCategorias.recuperar(idCategoria);
		return categoria;
	}
	
	@PostMapping("/categorias")
	public Categoria insertar(@RequestBody Categoria categoria) {
		serviceCategorias.guardar(categoria);
		return categoria;
	}
	
	@PutMapping("/categorias")
	public Categoria modificar(@RequestBody Categoria categoria) {
		serviceCategorias.guardar(categoria);// al pasarle el id, modificará el categoria correspondiente 
		return categoria;
	}
	
	@DeleteMapping("/categorias/{id}")
	public String eliminar(@PathVariable("id") int idCategoria) {
		serviceCategorias.eliminar(idCategoria);
		return "Categoria Eliminado";
	}
}