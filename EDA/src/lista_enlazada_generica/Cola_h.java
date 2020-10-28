package lista_enlazada_generica;
//los elementos deben tener implementado la interface Comparable
public class Cola_h<T extends Comparable> extends Lista {
	
	Nodo ultimo;//mi lista no tiene un ultimo, por eso lo implemente aqui
	int longitud=0;//hago esto para contar cuantos elementos hay
	public Cola_h(Nodo cabeza){
		super(cabeza);//heredo su constructor
		ultimo = cabeza;//como es el primero, la cabeza == ultimo
		longitud++;//aumentar un elemento
	}
	//encolar es poner un elemento al final de una cola
	//como si fuera una cola de la vida real
	public void encolar(T elemento){
		Nodo nuevo = new Nodo(elemento);//empaquetamos el elemento
		if(cabeza==null){//si esta vacia
			cabeza = nuevo; //el primero y el ultimo son iguales
			ultimo = cabeza;
		}else{
			super.insertar_alFinal(elemento);//heredo el metodo de la lista
			ultimo = nuevo;//ahora el ultimo sera el ultimo en encolarse
		}
		this.longitud++;//un elemento mas en mi cola
	}
	//eliminar , siginifica eliminar la cabeza actual
	public Nodo eliminar(){
		this.longitud--;//ya eliminamos, bajamos en uno los elementos
		return super.eliminar_cabeza();//implemento el metodo a partir de la Lista
	}
	//obtener significa obtener la cabeza
	public T obtener(){
		//implementamos el metodo obtener item de la lista enlazada
		return (T)super.obtener_item(0);
	}
	public String mostrar(){
		//implementamos el metodo mostrar de la lista enlazada
		return super.mostrar();
	}
	public static void main(String args[]){
		
		Cola_h<Integer> cola = new Cola_h<Integer>(new Nodo(0));
		cola.encolar(1);
		cola.encolar(2);
		cola.encolar(3);
		cola.encolar(4);
		cola.encolar(5);
		System.out.println("Mostrar cola: "+ cola.mostrar());
		System.out.println("Mostrar longitud: "+ cola.longitud);
		System.out.println("Obtener cabeza : "+cola.cabeza.elemento);
		System.out.println("Obtener ultimo : "+cola.ultimo.elemento);
		
		System.out.println("Elemento eliminado(cabeza): "+cola.eliminar().elemento);
		System.out.println("Elemento eliminado(cabeza): "+cola.eliminar().elemento);
		System.out.println("Elemento eliminado(cabeza): "+cola.eliminar().elemento);
		
		
		System.out.println("Mostrar cola : "+ cola.mostrar());
		System.out.println("Mostrar longitud : "+ cola.longitud);
		System.out.println("Obtener cabeza : "+cola.cabeza.elemento);
		System.out.println("Obtener cabeza : "+cola.ultimo.elemento);
	}
}
