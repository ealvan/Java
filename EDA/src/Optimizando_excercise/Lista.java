package Optimizando_excercise;

public class Lista<T> {
 
	Nodo cabeza = null;
	
	public Lista(Nodo cabeza){
		this.cabeza = cabeza;
	}
	public void insertar_alfinal(T elemento){
		if(cabeza == null){
			cabeza = new Nodo(elemento);
		}else{
			Nodo puntero = cabeza;
			while(puntero.siguiente != null ){
				puntero = puntero.siguiente;
			}
			Nodo al_final = new Nodo(elemento);
			puntero.siguiente = al_final;
			al_final.siguiente = null;
		}
	}
	public T mostrar_elprimero(){
		if(cabeza != null){
			return (T) cabeza.elemento;
		}else{
			return null;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
