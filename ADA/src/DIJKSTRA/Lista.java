package DIJKSTRA;



public class Lista {

	Nodo cabeza;
	int longitud = 0;
	
	public Lista(Nodo cabeza){
		this.cabeza = cabeza;
		longitud++;
	}
	public Lista(){
		cabeza = null;
	}
	//este metodo inserta en la lista en lazada al ultimo
	public void insertar(String user, int id){
		Nodo nodo = new Nodo(user,id);
		if(cabeza == null){
			cabeza = nodo;
		}else{
			Nodo puntero = cabeza;
			//recorremos hasta no enconrtar un nodo
			while(puntero.siguiente != null){
				puntero = puntero.siguiente;
			}
			//ponemos la referencia al nodo
			puntero.siguiente = nodo;
			longitud++;
		}
	}
	 
	//este tambien nos inserta, solo que un nodo entero 
	public void insertar(Nodo nodo){
		if(cabeza == null){
			cabeza = nodo;
		}else{
			Nodo puntero = cabeza;
			while(puntero.siguiente != null){
				puntero = puntero.siguiente;
			}
			puntero.siguiente = nodo;
			longitud++;
		}
		
	}
	//nos da el nodo de acuerdo a su id  
	public Nodo obtener(int id){
		if( cabeza == null){
			return null;
		}else{
				//buscamos el anterior a N osea N-1
			Nodo puntero = cabeza;
			//iteramos hasta que una de estas dos condiciones no se cumpal
			while(puntero != null && puntero.id != id){ 
				// y la ultima vuelta sera cuando  N == N
				//o cuando se desborde
				puntero = puntero.siguiente;
			}
			//si se desborda
			if(puntero == null){
				return null;
			}else{
				//si no se desborda, y ademas el id es igual
				if(puntero.id == id){//comprobando que es N
					return puntero;//sacando el elemento
				}
			}
			//en cualquier otro caso 
			return null;
		}
	}
	//nos imprime la lista en lazada
	public String imprimir(){
		String str = "";
		for(Nodo puntero = cabeza; puntero != null; puntero = puntero.siguiente){
			str += " ==> "+puntero ;
		}
		return str;
	}

	public static void main(String[] args) {
		//probando si funcion correctamente
		Lista l = new Lista(null);
		l.insertar("carlos",1);
		l.insertar("jose",2);
		l.insertar("pepe",3);
		l.insertar("miguel",4);
		Nodo m = l.obtener(1);
		System.out.println(m);
		System.out.print(l.imprimir());
	}
}
