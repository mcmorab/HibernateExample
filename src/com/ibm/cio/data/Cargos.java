package com.ibm.cio.data;

import javax.persistence.*;


public class Cargos {
	
	public Cargos(){
		super();
	}

	private int id;
	private String cargo;
	private int sueldo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	
	
}
