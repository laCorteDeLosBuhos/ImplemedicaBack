package com.bezkoder.springjwt.payload.request;

import javax.validation.constraints.NotBlank;

public class SetProductRequest {
	@NotBlank
	private String base64;
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}
}
