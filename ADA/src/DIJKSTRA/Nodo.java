package DIJKSTRA;

import java.util.Comparator;

public class Nodo implements Comparator<Nodo> {
	String usuario;//el usuario
	//esto nos servira para la implementacion de la pila
	//y la lsita enlazada
	Nodo siguiente;//el siguiente nodo
	int id;
	int d;
	int pi;
	public Nodo(String user,int id ){
		usuario = user;		
		this.id = id;
	}
	public String toString(){
		return usuario;//qu retorne el usuario
	}
	public Nodo(Nodo nodo){
		this.usuario = nodo.usuario;
		this.id = nodo.id;
		this.d = nodo.d;
		this.pi = nodo.pi;
	}

	public int compare(Nodo node1, Nodo node2) { 
	        if (node1.d < node2.d) 
	            return -1; 
	        if (node1.d > node2.d) 
	            return 1;
	        return 0;
	 } 
}
