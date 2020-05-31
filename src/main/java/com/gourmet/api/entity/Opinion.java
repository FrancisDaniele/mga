package com.gourmet.api.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="opiniones")
public class Opinion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "opi_id") 
	private Integer id;
	
	@Column(name = "opi_puntuacion") 
	private Double puntuacion;
	
	@Column(name = "opi_opinion") 
	private String opinion;
	
	@Column(name = "opi_fecha") 
	private Date fecha;
	
	@OneToOne
	@JoinColumn(name = "opi_res_id") 
	private Restaurante restaurante;
	
	@OneToOne
	@JoinColumn(name = "opi_usu_id") 
	private Usuario usuario;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Opinion [id=" + id + ", puntuacion=" + puntuacion + ", opinion=" + opinion + ", fecha=" + fecha
				+ ", restaurante=" + restaurante + ", usuario=" + usuario + "]";
	}

	
		
}
	
	