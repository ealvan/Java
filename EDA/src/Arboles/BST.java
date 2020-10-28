package Arboles;

public class BST<T extends Comparable> extends ArbolBinario {
	
	public BST(){
		super();
	}
	public Nodo buscar(T dato){
		if(raiz == null){
			return null;
		}else{
			return localizar(raiz,dato);
		}
	}
	protected Nodo localizar(Nodo inicial, T dato){
		if(inicial == null){
			return null;
		}else if(((Comparable) inicial.valorNodo()).compareTo(dato) == 0){
			return inicial;
		}else if(((Comparable) inicial.valorNodo()).compareTo(dato) < 0 && inicial.derecho() != null){
			return localizar(inicial.derecho(),dato);
		}else if(((Comparable) inicial.valorNodo()).compareTo(dato) > 0 && inicial.izquierdo() != null){
			return localizar(inicial.izquierdo(),dato);
		}else{
			return null;
		}
	}
	public Nodo buscarIterativo(T se_busca){
		boolean encontrado = false;
		Nodo nodo = raiz;
		while(!encontrado && nodo != null){
			if(((Comparable) nodo.valorNodo()).compareTo(se_busca) == 0){
				return nodo;
			}else if(((Comparable) nodo.valorNodo()).compareTo(se_busca) < 0){
				nodo = nodo.derecho();
			}else{
				nodo = nodo.izquierdo();
			}
		}
		return nodo;
	}
	public void insertar(T dato){
		raiz = insertar(raiz,dato);
	}
	protected Nodo insertar(Nodo inicial, T data){
		if(inicial == null){
			inicial = new Nodo(data);
		}else if( ((Comparable)inicial.valorNodo()).compareTo(data) > 0){
			Nodo left =  insertar(inicial.izquierdo(),data);
			inicial.ramaIzquierda(left);
		}else if(((Comparable)inicial.valorNodo()).compareTo(data) < 0){
			Nodo right = insertar(inicial.derecho(),data);
			inicial.ramaDerecha(right);
		}else{
			throw new RuntimeException("valor duplicado !!");
		}
		return inicial;
	}
	/*
	 * //localizar el nodo
	private Nodo eliminar(T data){
		Nodo eliminar_este = this.buscar(data);
		if(eliminar_este.derecho() != null && eliminar_este.izquierdo() != null){
			//tiene dos hojas
			
		}else if(eliminar_este.izquierdo() == null || eliminar_este.derecho() == null){
			//tiene un hijo puede que sea derecho o izquierdo
			
			
		}else{
			//no tiene hijos
			
		}
	}
	 * 
	 * */
	protected Nodo eliminar(Nodo inicial, T dato){
		if(inicial == null){
			throw new RuntimeException("Esta vacio el arbol");
		}else if( ((Comparable) inicial.valorNodo()).compareTo(dato) < 0){
			Nodo right = eliminar(inicial.derecho(), dato);
			inicial.ramaDerecha(right);
		}else if( ((Comparable) inicial.valorNodo()).compareTo(dato) > 0 ){
			Nodo left = eliminar(inicial.derecho(),dato);
			inicial.ramaIzquierda(left);
		}else{
			Nodo encontrado;
			encontrado = inicial;
			if( encontrado.derecho() == null){
				inicial = encontrado.izquierdo();
			}else if( encontrado.izquierdo() == null ){
				inicial = encontrado.derecho();
			}else{
				encontrado = reemplazar(encontrado);
			}
			encontrado = null;
		}
		return inicial;
	}
	public 	Nodo reemplazar(Nodo act){
		Nodo a,presente;
		presente = act;
		a = act.izquierdo();
		while( a.derecho() != null){
			presente = a;
			a = a.derecho();
		}
		act.cambiarValor(a.valorNodo());
		if(presente == act){
			presente.ramaIzquierda(a.izquierdo());
		}else{
			presente.ramaDerecha(a.izquierdo());
		}
		return a;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST m = new BST();
		m.insertar("raiz");m.insertar("raiz1");m.insertar("raiz2");
		m.preorden(m.raizArbol());
		
	}

}













