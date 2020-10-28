package cola_generica;

public class Nodo<T> {

	Nodo<T> siguiente;
	T elemento;	
	
	public Nodo(T elemen){
		this.elemento = elemen;
	}
}
