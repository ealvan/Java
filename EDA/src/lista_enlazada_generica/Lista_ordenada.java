package lista_enlazada_generica;
import java.lang.reflect.Array;
import java.util.*;
public class Lista_ordenada<T extends Comparable> extends Lista<T>{
	public Lista_ordenada(Nodo cabeza) {
		super(cabeza);
	}
	 
	public  void insertar_en_orden( T elemento ){
		Nodo nuevo = new Nodo(elemento);
		if(cabeza == null){
			cabeza = nuevo;
		}else if(cabeza.elemento.compareTo(elemento) < 0){
			nuevo.siguiente = cabeza;
			cabeza = nuevo;
		}else{
			Nodo anterior = cabeza;
			Nodo presente=cabeza;
			while(presente.siguiente != null && ((Comparable) presente.elemento).compareTo(elemento) > 0){
				anterior = presente;
				presente = presente.siguiente;
			}
			if(((Comparable) presente.elemento).compareTo(elemento) > 0){
				anterior = presente;
			}
			/*Nodo temp = anterior.siguiente;
			anterior.siguiente = nuevo;
			nuevo.siguiente = temp;
			temp.siguiente = null;*/
			nuevo.siguiente = anterior.siguiente;
			anterior.siguiente = nuevo;
		}
	}
	public Lista_ordenada(Class<T> c , Nodo cabeza){
		super(cabeza);
		@SuppressWarnings("unchecked")
		final T[] lista = (T[]) Array.newInstance(c, this.longitud);
	}
	 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista_ordenada<String> mi_lista = new Lista_ordenada<String>(new Nodo("g"));
		mi_lista.insertar_en_orden(new String("f"));
		System.out.println(mi_lista.mostrar());
		mi_lista.insertar_en_orden(new String("e"));
		mi_lista.insertar_en_orden(new String("h"));
		System.out.println(mi_lista.mostrar());
		mi_lista.insertar_en_orden(new String("c"));
		mi_lista.insertar_en_orden(new String("b"));
		System.out.println(mi_lista.mostrar());
		mi_lista.insertar_en_orden(new String("z"));
		System.out.println(mi_lista.mostrar());
		Lista_ordenada<Integer> lista_ = new Lista_ordenada<Integer>(new Nodo(new Integer(0)));
		lista_.inserta_alPrincipio(new Integer(12));
		lista_.insertar_alFinal(new Integer(5));
		lista_.insertar_alFinal(new Integer(32));
		lista_.insertar_alFinal(new Integer(-1));
		lista_.ordenar_lista();
		System.out.print("******************************\n"+  lista_.mostrar());
		
		
	}
 

}
