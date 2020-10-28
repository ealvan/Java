package ArbolAVL;


public class ArbolAVL<T extends Comparable> {

	Nodo raiz;
	public ArbolAVL(){	}
	
	//buscar
	public T buscar(Nodo raiz,T elemento){
		if(raiz.elemento == null){
			return null;
		}else if(raiz.elemento.compareTo(elemento) >  0 && raiz.izquierdo != null){
			return buscar(raiz.izquierdo, elemento);
		}else if(raiz.elemento.compareTo(elemento) < 0 && raiz.derecho != null){
			return buscar(raiz.derecho, elemento);
		}else{
			return (T)raiz.elemento;
		}
	}
	//obtener factor de equilibrio
	public int obtenerFE(Nodo nodo){
		if(nodo != null){
			return nodo.fe;
		}else{
			return -1;
		}
	}
	//rotacion simple izquierda
	public Nodo rotacion_izquierda(Nodo nodo){
		
		Nodo auxiliar = nodo.izquierdo;
		nodo.izquierdo = auxiliar.derecho;
		auxiliar.derecho = nodo;
		nodo.fe = Math.max(obtenerFE(nodo.izquierdo), obtenerFE(nodo.derecho))+1;
		auxiliar.fe = Math.max(obtenerFE(auxiliar.izquierdo), obtenerFE(auxiliar.derecho))+1;
		return auxiliar;
	}
	public Nodo rotacion_derecha(Nodo nodo){
		Nodo auxiliar = nodo.derecho;
		nodo.derecho = auxiliar.izquierdo;
		auxiliar.izquierdo = nodo;
		nodo.fe = Math.max(obtenerFE(nodo.izquierdo), obtenerFE(nodo.derecho))+1;
		auxiliar.fe = Math.max(obtenerFE(auxiliar.izquierdo), obtenerFE(auxiliar.derecho))+1;
		return auxiliar;
	}
	public Nodo rotacion_doble_izquierda(Nodo nodo){
		Nodo auxiliar;
		nodo.izquierdo = rotacion_derecha(nodo.izquierdo);
		auxiliar = rotacion_izquierda(nodo);
		return auxiliar;
	}
	public Nodo rotacion_doble_derecha(Nodo nodo){
		Nodo auxiliar;
		nodo.derecho = rotacion_izquierda(nodo.derecho);
		auxiliar = rotacion_derecha(nodo);
		return auxiliar;
	}
	
	public Nodo insertarAVL(Nodo nuevo, Nodo subar){
		Nodo nuevo_padre = subar;
		if(nuevo.elemento.compareTo(subar.elemento) < 0 ){
			if(subar.izquierdo == null){
				subar.izquierdo = nuevo;
			}else{
				subar.izquierdo = insertarAVL(nuevo,subar.izquierdo);
				if((obtenerFE(subar.izquierdo) - obtenerFE(subar.derecho)) == 2) {
					if(nuevo.elemento.compareTo(subar.izquierdo) < 0){
						nuevo_padre = rotacion_izquierda(subar);
					}else{
						nuevo_padre = rotacion_doble_derecha(subar);
					}
				}
			}
		}else if(nuevo.elemento.compareTo(subar.elemento) > 0){
			if(subar.derecho == null){
				subar.derecho = nuevo;
			}else{
				subar.derecho = insertarAVL(nuevo, subar.derecho);
				if((obtenerFE(subar.derecho)-obtenerFE(subar.izquierdo)) == 2){
					if(nuevo.elemento.compareTo(subar.derecho.elemento) > 0){
						nuevo_padre = rotacion_derecha(subar);
					}else{
						nuevo_padre = rotacion_doble_derecha(subar);
					}
				}
			}
		}else{
			System.out.println("Nodo duplicado");
		}
		//actualizando la altura
		if((subar.izquierdo == null) && (subar.derecho != null)){
			subar.fe = subar.derecho.fe +1 ;
		}else if((subar.derecho)== null && (subar.izquierdo) != null){
			subar.fe = subar.izquierdo.fe +1;
		}else{
			subar.fe = Math.max(obtenerFE(subar.izquierdo), obtenerFE(subar.derecho))+1;
		}
		return nuevo_padre;
	}
	//metodo para insertar
	public void insertar(T d){
		Nodo nuevo = new Nodo(d);
		if(raiz == null){
			raiz = nuevo;
		}else{
			raiz = insertarAVL(nuevo,raiz);
		}
	}
	//recorridos
	public static void preorden(Nodo root){
		if(root != null){
			root.visitar();
			preorden(root.izquierdo);
			preorden(root.derecho);
			
		}
	}
	public static void postorden(Nodo root){
		if(root != null){
			postorden(root.izquierdo);
			postorden(root.derecho);
			root.visitar();
		}
	}
	public static void inorden(Nodo root){
		if(root != null){
			inorden(root.izquierdo);
			root.visitar();
			inorden(root.derecho);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolAVL<Integer> arbol = new ArbolAVL<Integer>();
		arbol.insertar(10);
		arbol.insertar(5);
		arbol.insertar(13);
		arbol.insertar(1);
		arbol.insertar(6);
		arbol.insertar(17);
		arbol.insertar(16);
		arbol.preorden(arbol.raiz);
	}

}
