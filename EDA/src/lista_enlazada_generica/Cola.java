package lista_enlazada_generica;
public class Cola<T> {
	
	Nodo<T> cabeza;//aqui esta su cabeza
	Nodo<T> ultimo;//es el ultimo en la cola
	int longitud = 0;//para la longitud
	int cantidad=Integer.MAX_VALUE;//es para que la condicion longitud > cantidad
	//se cumpla, pues quedaria con valor default cero, nunca se cumpliria esa condicion
	public Cola(){}//es un constructor default, lo utilizare en ejercicios adicionales
	public Cola( Nodo head ){
		cabeza = head;//actulizamos cabeza
		ultimo = cabeza;//como es el primero, la cabeza y cola es la misma
		longitud++;//agregamos un elemento
	}
	//Constructro de Pila Estatica
	public Cola( Nodo cabeza, int cantidad ){
		this.cabeza = cabeza;//agregamos cabeza
		this.cantidad = cantidad;//actualizamos cantidad
		ultimo = cabeza;//como es el primero, la cabeza y cola es la mismo
		this.longitud++;//agregamos un elemento
	}
	//encolar significa que se hace al final de la cola
	public void encolar(T elemento){
		
		if( longitud < cantidad ){//comproobamos que no se pase de elementos
		 
			Nodo<T> nuevo = new Nodo<T>(elemento);//empaquetamos
			if( cabeza == null ){//si es el primero en insertar
				//entonces el ultimo en la cola y la cabeza son iguales
				cabeza = nuevo;
				ultimo = nuevo;
			}else{
				//delo contrario se agrega al final
				ultimo.siguiente = nuevo;//actualixamos el siguiente de ultimo
				//anterior mente valia null
				ultimo = nuevo;//sahora el ultimo es el nuevo
				//caja --> caja --> null
				//caja --> caja --> caja --> null
			}
			longitud++;
		}else{
			//System.err.print("hubo un error ...");
			//se paso de elementos
		}
	}
	//eliminar elimina el primero en la cola, es decir, la cabeza
	public Nodo eliminar(){
		if( cabeza != null){//si no esta vacia
			Nodo<T> temp = cabeza;//almacenamos la cabeza actual
			cabeza = cabeza.siguiente;//actualiamos la cabeza
			temp.siguiente = null;//desenlazamos la cabeza anterior
			//si solo tuviera un elemento
			//caja -->  null
			//null     ===> nos quedaria la lista vacia
			if( cabeza == null ){//por lo que ahora cabeza y ultimo son null
				ultimo = null;
			}
			longitud--;//disminuyendo cantidad
			return temp;//retornamos el elemento eliminado
		}
		//longitud--;//esto no se cumpliria, pues la cola esta vacia
		return null;//no hay nada
		
	}
	//nos da la cabeza actual
	public T obtener(){
		if( cabeza == null ){ //esta vacia
			return null;//no hay nada
		}else{
			return cabeza.elemento;//retornamos el elemento de la cabeza
		}
	}
	public String mostrar(){
		String str = "";
		int i = 0;
		//recorriendo con un puntero
		for(Nodo puntero = cabeza; puntero != null; puntero = puntero.siguiente){
			str += "Item "+i+ " ==> "+ puntero.elemento+" ";
			i++;
		}
		return str;
	}
 	
	public static void main(String[] args) {
		//esta es una cola dinamica
		Cola colita = new Cola(new Nodo(new String("cabeza")));
		
		colita.encolar(new String("papu"));
		colita.encolar(new String("papo"));
		colita.encolar(new String("pape"));
		colita.encolar(new String("papi"));
		colita.encolar(new String("papa"));
		
		System.out.println("Mostrando cola dinamica: "+colita.mostrar());
		 
		Cola<String> cola_statica = new Cola<String>(new Nodo("hola"), 5);//1
		cola_statica.encolar("hola1 ");//2
		cola_statica.encolar("hola2 ");//3
		cola_statica.encolar("hola3 ");//4
		cola_statica.encolar("hola4 ");//5
		
		cola_statica.encolar("hola___ ");//no lo debe admitir, no lo imprime
		System.out.println("Mostrar cola estatica: "+cola_statica.mostrar());//mostrando la cola
		
		//eliminando elementos
		System.out.println("Longitud: " + cola_statica.longitud);
		System.out.println("Obteniendo cabeza: "+cola_statica.obtener());
		System.out.println("Elemento eliminado: "+cola_statica.eliminar().elemento);
		System.out.println("Elemento eliminado: "+cola_statica.eliminar().elemento);
		System.out.println("Longitud: " + cola_statica.longitud);
		System.out.println("Mostrar cola: "+cola_statica.mostrar());
		System.out.print("Obteniendo cabeza: "+cola_statica.obtener());
	}

}