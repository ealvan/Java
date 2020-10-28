package Agenda;

import java.util.*;

public class Persona {
	public static Scanner sc = new Scanner(System.in);
	private String nombre;
	private String apellido;
	private String edad;
	
	public Persona(String name, String apell , String eda){
		nombre = name;
		apellido = apell;
		edad = eda;
	}
	public void setNombre(String name){
		nombre = name;
	}
	public void setApellido(String apell){
		apellido = apell;
	}
	public void setEdad(String eda){
		edad = eda;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public String getEdad(){
		return edad;
	}
	public String toString(){
		return "nombre : "+nombre + "  apellido: "+apellido;
	}
	
	
	
}










