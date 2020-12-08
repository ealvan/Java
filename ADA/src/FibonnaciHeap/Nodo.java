package FibonnaciHeap;

public class Nodo<T> {

	Nodo<T> padre;
	Nodo<T> hijo;
	Nodo<T> izquierdo;
	Nodo<T> derecho;
	T dato;
	int grado = 0;
	public Nodo(T dato){
		this.dato = dato;
	}
}

