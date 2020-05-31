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

import com.gourmet.api.entity.Restaurante;
import com.gourmet.api.service.IRestaurantesService;




@RestController
@RequestMapping("/api")
// Aceptar peticiones de otro dominio
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RestaurantesController {
	
	@Autowired
	private IRestaurantesService serviceRestaurantes;
	
	@GetMapping("/restaurantes")
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	public List<Restaurante> buscar() {
		return serviceRestaurantes.BuscarTodos();
	}
	
	@GetMapping("/restaurantes/{id}")
	public Restaurante recuperar(@PathVariable("id") int idRestaurante) {
		Restaurante restaurante = serviceRestaurantes.recuperar(idRestaurante);
		return restaurante;
	}
	
	@PostMapping("/restaurantes")
	public Restaurante insertar(@RequestBody Restaurante restaurante) {
		serviceRestaurantes.guardar(restaurante);
		return restaurante;
	}
	
	@PutMapping("/restaurantes")
	public Restaurante modificar(@RequestBody Restaurante restaurante) {
		serviceRestaurantes.guardar(restaurante);// al pasarle el id, modificará el restaurante correspondiente 
		return restaurante;
	}
	
	@DeleteMapping("/restaurantes/{id}")
	public String eliminar(@PathVariable("id") int idRestaurante) {
		serviceRestaurantes.eliminar(idRestaurante);
		return "Restaurante Eliminado";
	}
}