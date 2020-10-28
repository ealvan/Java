package Arboles;

public class Nodo<T> {
 
	T dato;
	Nodo<T> izquierdo;
	Nodo<T> derecho;
	public Nodo(T data){
		dato = data;
	}
	public Nodo(T data,Nodo izquierdo,Nodo derecho){
		dato = data;
		this.izquierdo = izquierdo;
		this.derecho = derecho;
	}
	public T valorNodo(){
		return dato;
	}
	public Nodo izquierdo(){
		return izquierdo;
	}
	public Nodo derecho(){
		return derecho;
	}
	public void cambiarValor(T data){
		dato = data;
	}
	public void ramaIzquierda(Nodo nodo){
		izquierdo = nodo;
	}
	public void ramaDerecha(Nodo nodo){
		derecho = nodo;
	}
	public void visitar(){
		System.out.print(dato+" ");
	}
}
