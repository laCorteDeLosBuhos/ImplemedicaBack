package com.bezkoder.springjwt.models;

public class SendMail {

	private String nombre;
	private String correo;
	private String telefono;
	private String dedica;
	private String comentario;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDedica() {
		return dedica;
	}
	public void setDedica(String dedica) {
		this.dedica = dedica;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
