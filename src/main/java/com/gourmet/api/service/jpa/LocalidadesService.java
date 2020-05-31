package com.gourmet.api.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.api.entity.Localidad;
import com.gourmet.api.repository.LocalidadesRepository;
import com.gourmet.api.service.ILocalidadesService;

@Service
public class LocalidadesService implements ILocalidadesService {
	
	@Autowired
	private LocalidadesRepository repoLocalidades;
	
	public List<Localidad> BuscarTodos() {
		return repoLocalidades.findAll();
	}
	
	public void guardar(Localidad localidad) {
		repoLocalidades.save(localidad);
	}
	
	public Localidad recuperar(int idLocalidad) {
		Optional<Localidad> optional = repoLocalidades.findById(idLocalidad);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void eliminar(int idLocalidad) {
		repoLocalidades.deleteById(idLocalidad);
	}
}