package Grafo;

public class Nodo {
	String usuario;//el usuario
	//esto nos servira para la implementacion de la pila
	//y la lsita enlazada
	Nodo siguiente;//el siguiente nodo
	int id;
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
	}
}
