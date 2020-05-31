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

import com.gourmet.api.entity.Opinion;
import com.gourmet.api.service.IOpinionesService;


@RestController
@RequestMapping("/api")
public class OpinionesController {
	
	@Autowired
	private IOpinionesService serviceOpiniones;
	
	@GetMapping("/opiniones")
	public List<Opinion> buscar(){
		return serviceOpiniones.BuscarTodos();
	}
	
	@GetMapping("/opiniones/{id}")
	public Opinion recuperar(@PathVariable("id") int idOpinion) {
		Opinion opinion = serviceOpiniones.recuperar(idOpinion);
		return opinion;
	}
	
	@PostMapping("/opiniones")
	public Opinion insertar(@RequestBody Opinion opinion) {
		serviceOpiniones.guardar(opinion);
		return opinion;
	}
	
	@PutMapping("/opiniones")
	public Opinion modificar(@RequestBody Opinion opinion) {
		serviceOpiniones.guardar(opinion);// al pasarle el id, modificará la opininión correspondiente
		return opinion;
	}
	
	@DeleteMapping("/opiniones/{id}")
	public String eliminar(@PathVariable("id") int idOpinion) {
		serviceOpiniones.eliminar(idOpinion);
		return "Opinion Eliminado";	
	}
}
	
	