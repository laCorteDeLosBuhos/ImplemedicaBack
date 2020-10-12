package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Inventario")
public class Inventario {
	@Id
	private int product_id;
	@OneToOne
	@JoinColumn(name = "id_producto")
	private Products producto;
	private int cantidad;
	public Products getProducto() {
		return producto;
	}
	public void setProducto(Products producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
}
