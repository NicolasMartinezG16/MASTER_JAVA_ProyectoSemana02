package com.curso.model;

public class Producto {
	private final String nombre;
	private String seccion;
	private double precio;
	private int stock;
	
	public Producto(String nombre, String seccion, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.seccion = seccion;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSeccion() {
		return seccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}
}
