package com.bezkoder.springjwt.payload.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.bezkoder.springjwt.models.Ciudad;
import com.bezkoder.springjwt.models.DetallePedido;

public class SavePedidoRequest {
	@NotNull
	private int id;
	@NotNull
	private String nombre;
	@NotNull
	private Date fecha;
	@NotNull
	private String tipoDoc;
	@NotNull
	private int numDoc;
	@NotNull
	private String correo;
	@NotNull
	private String direccion;
	@NotNull
	private String telefono;
	@NotNull
	private Ciudad ciudad;
	@NotNull
	private String observaciones;
	@NotNull
	private String estado;
	@NotNull
	private List<DetallePedido> productos;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public List<DetallePedido> getProductos() {
		return productos;
	}
	public void setProductos(List<DetallePedido> productos) {
		this.productos = productos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
