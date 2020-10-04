package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetallePedidos")
public class DetallePedido {
	@Id
	@GeneratedValue
	private int id;
	private int cantidad;
	@OneToOne
	@JoinColumn(name = "id_producto")
	private Products producto;
	public DetallePedido() {
	}
	public DetallePedido(int id, int cantidad, Products producto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.setProducto(producto);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Products getProducto() {
		return producto;
	}
	public void setProducto(Products producto) {
		this.producto = producto;
	}
}
