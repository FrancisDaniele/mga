package com.gourmet.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "localidades")
public class Localidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	@Column(name = "loc_id") 
	private Integer id;
	
	@Column(name = "loc_nombre") 
	private String nombre;
	
	// atributo localidad de la clase RSestaurante
    
	/*@OneToMany(mappedBy = "localidad", fetch = FetchType.LAZY)
    private List<Restaurante> retaurantes; 
    */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
/*
	public List<Restaurante> getRetaurantes() {
		return retaurantes;
	}

	public void setRetaurantes(List<Restaurante> retaurantes) {
		this.retaurantes = retaurantes;
	}

	*/


}
