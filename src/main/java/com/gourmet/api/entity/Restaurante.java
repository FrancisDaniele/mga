package com.gourmet.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurantes")
public class Restaurante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "res_id") 
	private Integer id;
	
	@Column(name = "res_nombre") 
	private String nombre;
	
	@Column(name = "res_direccion") 
	private String direccion;
	
	@Column(name = "res_puntuacion") 
	private Double puntuacion;
	
	@Column(name = "res_votaciones") 
	private Integer votaciones;
	
	@Column(name = "res_descripcion") 
	private String descripcion;
	
	
	@OneToOne
	@JoinColumn(name = "res_loc_id")  
	private Localidad localidad;
	
	
	/*
    @JoinColumn(name = "res_loc_id", referencedColumnName = "loc_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Localidad localidad;
    */
    
	
	@OneToOne
	@JoinColumn(name = "res_cat_id") 
	private Categoria categoria;
	
	 // Atribut que representa restaurant a la classe Opinion
	@OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY)
	private List<Opinion> opiniones;

	
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}
	public Integer getVotaciones() {
		return votaciones;
	}
	public void setVotaciones(Integer votaciones) {
		this.votaciones = votaciones;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/*
	public List<Opinion> getOpiniones() {
		return opiniones;
	}
	public void setOpiniones(List<Opinion> opiniones) {
		this.opiniones = opiniones;
	}
	*/
	
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", puntuacion=" + puntuacion + ", votaciones="
				+ votaciones + ", descripcion=" + descripcion + "]";
	}
	
	
	
}