package com.bezkoder.springjwt.models;

import javax.persistence.*;

@Entity
@Table(name = "Productos")
public class Products {
	private String nombre;
	@Id
	private String codigo;
	private String marca;
	private String descripcion;
	private String urlImg;
	private String linea;
	private String presentacion;
	@Column(columnDefinition = "boolean default false")
	private boolean destacado;
	@Column(columnDefinition = "boolean default false")
	private boolean promocion;
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public Products() {
	}
	public Products(String nombre, String Codigo, String Marca, String Descripcion, String UrlImg) {
		this.nombre=nombre;
		this.codigo=Codigo;
		this.marca=Marca;
		this.descripcion=Descripcion;
		this.urlImg=UrlImg;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public boolean isDestacado() {
		return destacado;
	}
	public void setDestacado(boolean destacado) {
		this.destacado = destacado;
	}
	public boolean isPromocion() {
		return promocion;
	}
	public void setPromocion(boolean promocion) {
		this.promocion = promocion;
	}
	
}
