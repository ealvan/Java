package cola_generica;

public class Cola<T> {
	
	Nodo<T> cabeza;
	Nodo<T> ultimo;
	int longitud = 0;
	static int cantidad=0;
	public Cola( Nodo head ){
		cabeza = head;
		ultimo = cabeza;
		longitud++;
	}
	public Cola( Nodo cabeza, int cantidad ){
		this.cabeza = cabeza;
		this.cantidad = cantidad;
		ultimo = cabeza;
		this.longitud++;
	}
	
	public void encolar(T elemento){
		
		if( longitud < cantidad ){
		    
			Nodo<T> nuevo = new Nodo<T>(elemento);
			if( cabeza == null ){
				cabeza = nuevo;
				ultimo = nuevo;
			}else{
				ultimo.siguiente = nuevo;
				ultimo = nuevo;
			}
			longitud++;
		}else{
			System.err.print("hubo un error ...");
		}
	}
	public void eliminar(){
		if( cabeza != null){
			Nodo<T> temp = cabeza;
			cabeza = cabeza.siguiente;
			temp.siguiente = null;
			if( cabeza == null ){
				ultimo = null;
			}
		}
		longitud--;
	}
	public T obtener(){
		if( cabeza == null ){
			return null;
		}else{
			return cabeza.elemento;
		}
	}
	public String mostrar(){
		String str = "";
		int i = 0;
		for(Nodo puntero = cabeza; puntero != null; puntero = puntero.siguiente){
			str += "Item "+i+ " ==> "+ puntero.elemento+" ";
			i++;
		}
		return str;
	}
	
	public static void main(String[] args) {
		
		/*
		 * Cola colita = new Cola(new Nodo(new String("cabeza")));
		
		colita.encolar(new String("papu"));
		colita.encolar(new String("papo"));
		colita.encolar(new String("pape"));
		colita.encolar(new String("papi"));
		colita.encolar(new String("papa"));
		
		System.out.print(colita.mostrar());
		 * 
		 * */
		Cola<String> cola_statica = new Cola<String>(new Nodo("hola"), 10);
		cola_statica.encolar("hola1 ");
		cola_statica.encolar("hola2 ");
		cola_statica.encolar("hola3 ");
		cola_statica.encolar("hola4 ");
		cola_statica.encolar("hola5 ");
		cola_statica.encolar("hola6 ");
		cola_statica.encolar("hola7 ");
		cola_statica.encolar("hola8 ");//9
		cola_statica.encolar("hola9 ");
		
		cola_statica.encolar("hola___ ");
		System.out.println(cola_statica.mostrar());
		
	}
}
