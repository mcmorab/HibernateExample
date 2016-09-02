package com.ibm.cio.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class Empleados {

public Empleados(){
	super();
}
	

private int codigo;
private String nombre;
private String sexo;
private String dpto;
private String ciudad;
private String zona;
private String ingreso;
private Cargos cargo;    //esta es la FK


public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}

public String getDpto() {
	return dpto;
}
public void setDpto(String dpto) {
	this.dpto = dpto;
}
public String getCiudad() {
	return ciudad;
}
public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}
public Cargos getCargo() {
	return cargo;
}
public void setCargo(Cargos cargo) {
	this.cargo = cargo;
}
public String getZona() {
	return zona;
}
public void setZona(String zona) {
	this.zona = zona;
}
public String getIngreso() {
	return ingreso;
}
public void setIngreso(String ingreso) {
	this.ingreso = ingreso;
}


}
