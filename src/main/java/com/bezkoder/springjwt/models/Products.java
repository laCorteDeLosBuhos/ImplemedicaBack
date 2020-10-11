package com.bezkoder.springjwt.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Productos")
public class Products {
	@Size(max = 4000)
	private String nombre;
	@Id
	private String codigo;
	private String marca;
	@Size(max = 4000)
	private String descripcion;
	@Size(max = 4000)
	private String urlImg;
	@Size(max = 4000)
	private String linea;
	@Size(max = 4000)
	private String presentacion;
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
	
}
