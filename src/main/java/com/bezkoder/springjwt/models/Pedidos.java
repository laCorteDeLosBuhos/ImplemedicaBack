package com.bezkoder.springjwt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name = "Pedidos")
public class Pedidos {
	@Id
	@GeneratedValue
	private int id; 
	private String nombre;
	private Date fecha;
	private String tipoDoc;
	private int numDoc;
	private String correo;
	private String direccion;
	private String telefono;
    @OneToOne
    @JoinColumn(name = "id_ciudad")
	private Ciudad ciudad;
	private String observaciones;
	private String estado;
	@ManyToMany
	@JoinColumn(name = "id_detalle")
	private List<DetallePedido> productos;
	
	public Pedidos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pedidos(int id, String nombre, Date fecha, String tipoDoc, int numDoc, String correo, String direccion,
			String telefono, Ciudad ciudad, String observaciones, String estado, List<DetallePedido> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.observaciones = observaciones;
		this.estado = estado;
		this.productos = productos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public int getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public List<DetallePedido> getProductos() {
		return productos;
	}
	public void setProductos(List<DetallePedido> productos) {
		this.productos = productos;
	}
}
