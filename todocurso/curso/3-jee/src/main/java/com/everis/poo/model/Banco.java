package com.everis.poo.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Banco {
	
	private int idBanco;
	private String nombre;
	private String direccion;
	
	
	
	public int getIdBanco() {
		return idBanco;
	}


	public  void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
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


	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
}
