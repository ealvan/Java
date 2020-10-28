package lista_enlazada_generica;

public class Nodo<T> {

	public T elemento;
	public Nodo<T> siguiente = null;
	
	public Nodo(T elemento){
		this.elemento = elemento;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
