package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ciudades")
public class Ciudad {
	@Id
	private int id;
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return descripcion;
	}
	public void setDesc(String desc) {
		this.descripcion = desc;
	}
	
}
