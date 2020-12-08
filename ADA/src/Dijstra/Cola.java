package Dijstra;

public class Cola {

	Nodo cabeza;//esta es la xaveza
	Nodo ultimo;
	int longitud=0;
	//constructor
	public Cola(Nodo cabeza){
		this.cabeza = cabeza;
		ultimo = this.cabeza;
		longitud++;
	}
	public Cola(){
		cabeza = null;
		ultimo = null;
	}
	//encolar, nos encola una copia del nodo
	//pues cuando guardamos una referencia,
	//y despues la elimamos, entonces si ese
	//nodo esta en una lista enlazada, elimnara tambien los demas 
	//que le suceden a el, es por eso que la cola solo almacena colas
	public void encolar(Nodo nodo){
		Nodo nuevo = new Nodo(nodo.id, nodo.d);
		if(cabeza == null){
			cabeza = nuevo;
			ultimo = nuevo;
		}else{
			ultimo.siguiente = nuevo;
			ultimo = nuevo;
		}
		longitud++;
	}
	//eliminar, elimina completamente el nodo
	public Nodo eliminar(){
		if(cabeza != null){
			Nodo temp = cabeza;//este es el valor actual
			cabeza = cabeza.siguiente;//actualizamos la cabeza
			//hacemos que pierda las otras referecnias
			temp.siguiente = null;
			if(cabeza == null){
				ultimo = null;
			}
			//bajamos la longitud
			longitud--;
			return temp;//devobemos el eliminado
		}
		//si esta cavia la cabeza, entonces longitud es 0
		longitud = 0;
		return null;
	}
	//imprime esta cola
	public String toString(){
		String str = "";
		for(Nodo puntero = cabeza; puntero != null; puntero = puntero.siguiente){
			str += " ==> "+puntero ;
		}if(str.equals("")){
			return "esta vacio";
		}
		return str;
	}
	//probando si la cola esta bien
	public static void main(String[] args) {
		 Cola cola = new Cola();
		 System.out.println(cola.longitud);
		 
		 cola.encolar(new Nodo(1,1));
		 System.out.println(cola.longitud);
		 
		 cola.encolar( new Nodo(1,2));
		 System.out.println(cola.longitud);
		 
		 cola.encolar(new Nodo(1,3));
		 System.out.println(cola.longitud);
		 
		 Nodo m = cola.eliminar();
		 System.out.println(m);
		 
		 System.out.println(cola.longitud);
		 m = cola.eliminar();
		 System.out.println(m);
		 
		 System.out.println(cola.longitud);
		 
		 m = cola.eliminar();
		 System.out.println(m);	
		 
		 System.out.println(cola.longitud);
		 System.out.println(cola.longitud); 
	}
}






