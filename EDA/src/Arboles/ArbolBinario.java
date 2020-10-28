package Arboles;

public class ArbolBinario<T> {

	protected Nodo<T> raiz;
	
	public ArbolBinario(){
		raiz = null;
	}
	public ArbolBinario(Nodo nodo){
		raiz = nodo;
	}
	public Nodo raizArbol(){
		return raiz;
	}
	public boolean esVacio(){
		return raiz == null;
	}
	public static void preorden(Nodo root){
		if(root != null){
			root.visitar();
			preorden(root.derecho());
			preorden(root.izquierdo());
		}
	}
	public static void postorden(Nodo root){
		if(root != null){
			postorden(root.izquierdo());
			postorden(root.derecho());
			root.visitar();
		}
	}
	public static void inorden(Nodo root){
		if(root != null){
			inorden(root.izquierdo());
			root.visitar();
			inorden(root.derecho());
		}
	}
	public static int numNodos(Nodo root){
		if(root == null){
			return 0;
		}else{
			return 1 + numNodos(root.izquierdo())+numNodos(root.derecho());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
