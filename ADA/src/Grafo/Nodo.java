package Grafo;

public class Nodo {
	//este sera el contenido de nuestro nodo(su nombre)
	String name;
	//el nodo servira para la implementacion de la pila
	//y la lista enlazada
	Nodo siguiente;//el siguiente nodo
	int id;
	//constructor 1
	public Nodo(String name_,int id ){
		name = name_;		
		this.id = id;
	}
	public String toString(){
		return name;//qu retorna el nombre
	}
	//constructor 2
	public Nodo(Nodo nodo){
		this.name = nodo.name;
		this.id = nodo.id;
	}
}
