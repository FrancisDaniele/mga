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

import com.gourmet.api.entity.Localidad;
import com.gourmet.api.service.ILocalidadesService;




@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LocalidadesController {
	
	@Autowired
	private ILocalidadesService serviceLocalidades;
	
	@GetMapping("/localidades")
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	public List<Localidad> buscar() {
		return serviceLocalidades.BuscarTodos();
	}
	
	@GetMapping("/localidades/{id}")
	public Localidad recuperar(@PathVariable("id") int idLocalidad) {
		Localidad localidad = serviceLocalidades.recuperar(idLocalidad);
		return localidad;
	}
	
	@PostMapping("/localidades")
	public Localidad insertar(@RequestBody Localidad localidad) {
		serviceLocalidades.guardar(localidad);
		return localidad;
	}
	
	@PutMapping("/localidades")
	public Localidad modificar(@RequestBody Localidad localidad) {
		serviceLocalidades.guardar(localidad);// al pasarle el id, modificará el localidad correspondiente 
		return localidad;
	}
	
	@DeleteMapping("/localidades/{id}")
	public String eliminar(@PathVariable("id") int idLocalidad) {
		serviceLocalidades.eliminar(idLocalidad);
		return "Localidad Eliminado";
	}
}