package com.gourmet.api.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.api.entity.Categoria;
import com.gourmet.api.repository.CategoriasRepository;
import com.gourmet.api.service.ICategoriasService;

@Service
public class CategoriasService implements ICategoriasService {
	
	@Autowired
	private CategoriasRepository repoCategorias;
	
	public List<Categoria> BuscarTodos() {
		return repoCategorias.findAll();
	}
	
	public void guardar(Categoria categoria) {
		repoCategorias.save(categoria);
	}
	
	public Categoria recuperar(int idCategoria) {
		Optional<Categoria> optional = repoCategorias.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void eliminar(int idCategoria) {
		repoCategorias.deleteById(idCategoria);
	}
}