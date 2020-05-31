package com.gourmet.api.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.api.entity.Opinion;
import com.gourmet.api.repository.OpinionesRepository;
import com.gourmet.api.service.IOpinionesService;


@Service
public class OpinionesService implements IOpinionesService {
	
	@Autowired
	private OpinionesRepository repoOpiniones;
	
	public List<Opinion> BuscarTodos() {
		return repoOpiniones.findAll();	
	}
	
	public void guardar(Opinion opinion) {
		repoOpiniones.save(opinion);
	}
	
	public Opinion recuperar(int idOpinion) {
		Optional<Opinion> optional = repoOpiniones.findById(idOpinion);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void eliminar(int idOpinion) {
		repoOpiniones.deleteById(idOpinion);
	}
	
}