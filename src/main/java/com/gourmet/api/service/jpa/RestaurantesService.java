package com.gourmet.api.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.api.entity.Restaurante;
import com.gourmet.api.repository.RestaurantesRepository;
import com.gourmet.api.service.IRestaurantesService;

@Service
public class RestaurantesService implements IRestaurantesService {
	
	@Autowired
	private RestaurantesRepository repoRestaurantes;
	
	public List<Restaurante> BuscarTodos() {
		return repoRestaurantes.findAll();
	}
	
	public void guardar(Restaurante restaurante) {
		repoRestaurantes.save(restaurante);
	}
	
	public Restaurante recuperar(int idRestaurante) {
		Optional<Restaurante> optional = repoRestaurantes.findById(idRestaurante);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void eliminar(int idRestaurante) {
		repoRestaurantes.deleteById(idRestaurante);
	}
}