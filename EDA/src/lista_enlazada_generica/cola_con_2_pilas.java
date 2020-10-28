package lista_enlazada_generica;

public class cola_con_2_pilas<T> {
	Nodo cabeza;//es nuesta cabeza de la cola
	//COLA CON 2 PÍLAS:
	//una cola se puede iimplementar con dos pila
	//LA PRIMERA PILA -pila izquierda:
	//la primera pila recibira nuestros datos, y los almacenara
	//LA SEGUNDA PILA -pila derecha:
	//la segunda pila soportara nuestros datos de la primera pila,
	//voltearemos todos los datos de la primera pila a la segunda pila
	
	//voltearemos los datos de la pila izquierda a la pila derecha, es asi
	//como  el ultimo de la pila izquierda va a ser el primero en la pila derecha
	//pila izquierda
	//1 --> 2 --> 3 --> 4
	//pila derecha
	//4 --> 3 --> 2 --> 1
	Pila<T> pila_left = new Pila<T>();
	Pila<T> pila_right = new Pila<T>();
	int longitud = 0;//cantidad de elementos
	public cola_con_2_pilas(Nodo cabeza) {
		this.cabeza = cabeza;//este sera el primer elemento
		pila_left.push((T)cabeza.elemento);//la almacenamos en la pila izquierda
		longitud++;//aumentamos la longitud
	}
	//es encolar pero al final de la cola, es decir meterlos en la pila izquierda
	//caja1 --> null
	//caja2 --> caja1 --> null-
	//caja3 --> caja2 --> caja1 --> null-
	//caja4 --> caja3 --> caja2 --> caja1 --> null
	
	public void encolar(T elemento){
		//Nodo nuevo = new Nodo(elemento);
		pila_left.push(elemento);//metemos los datos
		longitud++;	//aumentamos la longitud
	}
	//esto elimina la cabeza
	public T eliminar(){
		this.longitud--;//elimamos el elemento
		//si la pila derecha esta vacia, podemos vvolcar todos los datos de
		//la pila izquierda a la pila derecha
		if( pila_right.cabeza == null ){
			//volcando los datos de la pila izqwuierda a la derecha
			Pila.voltear_pila(pila_left, pila_right);
			//ahora si la pila izquierda esta vacia , no volcaria nada de
			//elementos a la pila derecha, si que la pila derecha estaria vacia
			if(pila_right.cabeza != null){//si no esta vacia podemos eliminar 
				return (T)pila_right.pop().elemento;//retornando los elementos
			}else{
				return null;//si esta vacia no podemos eliminar nada
			}
		}else{
			return (T)pila_right.pop().elemento;
			//si esta llena la pila derecha, no es necesario volcar los datos, pues
			//aun esta llena, asi que podemos eliminar todavia
		}
	}
	
	public 	String mostrar(){
		//para mostrar una pila necesitamos tener todos los datos 
		//en la pila derecha, para poder mostrarlos
		//porque puede pasar que la pila izquierda aun tenga datos, asi que 
		//nos aseguramos con el emtodo voltear pila
		Pila.voltear_pila(pila_left, pila_right);
		//puede que aun este vacia, pues puede ocurrir que 
		//la pila_izquierda y la pila derecha esten vacias
		//por eso lo comprobamos
		if(pila_right.cabeza == null){
			return "esta_vacia";
		}
		return pila_right.mostrar();//si esta llena podemos mostrarla
	}
	public static void main(String[] args) {
		
		cola_con_2_pilas<String> cola = new cola_con_2_pilas<String>(new Nodo("cabeza"));
		cola.encolar("cabeza1");
		cola.encolar("cabeza2");
		cola.encolar("cabeza3");
		//vamos a mostrar la pila left y despues la pila right
		//la pila left
		System.out.print("Pila left : "+cola.pila_left.mostrar());
		//la pila right es la que muestra a la pila left, pero volteada
		System.out.print("Pila right: "+cola.mostrar());

		//eliminando elementos ...
		System.out.println("Elemento eliminado: " + cola.eliminar());
		System.out.print(cola.mostrar());
		System.out.println("Eliminado eliminado: " + cola.eliminar());
		System.out.print(cola.mostrar());
		System.out.println("Eliminado eliminado: " + cola.eliminar());
		System.out.print(cola.mostrar());
		System.out.println("Eliminado eliminado: " + cola.eliminar());
		System.out.print(cola.mostrar());
		
		///ya se acabo la lista, por lo que nos deberia retornar null
		System.out.println("Eliminado(se acabo la cola): " + cola.eliminar());
		System.out.print(cola.mostrar());
	}
}
