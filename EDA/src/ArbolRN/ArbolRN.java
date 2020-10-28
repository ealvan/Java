package ArbolRN;



public class ArbolRN {

	NodoRN raiz;
	
	public NodoRN buscar(String info){
		NodoRN puntero = raiz;
		if(raiz != null){
			while(!puntero.info.equals(info)){
				if(puntero.info.compareTo(info) > 0){
					puntero = puntero.izquierdo;
					//puntero = buscar(puntero.izquierdo.info);
				}else if( puntero.info.compareTo(info) < 0){
					puntero = puntero.derecho;
					//puntero = buscar(puntero.derecho.info);
				}
				if(puntero == null){
					break;
				}
			}
		}
		return puntero;
	}
	public void insert(String info) {
		// Ordinary Binary Search Insertion
		NodoRN nodo = new NodoRN(null);
		nodo.padre = null;
		nodo.info = info;
		nodo.izquierdo = null;
		nodo.derecho = null;
		nodo.color = "rojo"; // new node must be red
		
		NodoRN y = null;//y sera padre
		NodoRN x = this.raiz;

		while (x != null) {
			y = x;//ahora este sera el anterior de x, osea el padre
			if (nodo.info.compareTo(x.info) < 0) {
				x = x.izquierdo;
			} else {
				x = x.derecho;
			}
		}

		
		nodo.padre = y;//haciendolo explicito
		if (y == null) {//si seguimos en la raiz
			raiz = nodo;//en este momento es rojo
		} else if (nodo.info.compareTo(y.info) < 0) {
			y.izquierdo = nodo;
		} else {
			y.derecho = nodo;
		}

		// if new node is a root node, simply return
		if (nodo.padre == null){
			nodo.color = "rojo";
			return;
		}

		// if the grandparent is null, simply return
		if (nodo.padre.padre == null) {
			return;
		}

		
		//arreglar_insert(nodo);
	}
	private void arreglar_insert(NodoRN k){
		NodoRN u;
		while (k.padre.color.equals("rojo")) {
			if (k.padre == k.padre.padre.derecho) {
				u = k.padre.padre.izquierdo; // tio
				if (u.color.equals("negro")) {
					// case 3.1
					u.color = "rojo";
					k.padre.color = "rojo";
					k.padre.padre.color = "negro";
					k = k.padre.padre;
				} else {
					if (k == k.padre.izquierdo) {
						// case 3.2.2
						k = k.padre;
						rotar_derecha(k);
					}
					// case 3.2.1
					k.padre.color = "rojo";
					k.padre.padre.color = "negro";
					rotar_izquierda(k.padre.padre);
				}
			} else {
				u = k.padre.padre.derecho; // uncle

				if (u.color.equals("negro")) {
					// mirror case 3.1
					u.color = "rojo";
					k.padre.color = "rojo";
					k.padre.padre.color = "negro";
					k = k.padre.padre;	
				} else {
					if (k == k.padre.derecho) {
						// mirror case 3.2.2
						k = k.padre;
						rotar_izquierda(k);
					}
					// mirror case 3.2.1
					k.padre.color = "rojo";
					k.padre.padre.color = "negro";
					rotar_derecha(k.padre.padre);
				}
			}
			if (k == raiz) {
				break;
			}
		}
		raiz.color = "rojo";
	}
	
	public void rotar_izquierda(NodoRN x) {
		NodoRN y = x.derecho;
		x.derecho = y.izquierdo;
		if (y.izquierdo != null) {
			y.izquierdo.padre = x;
		}
		y.padre = x.padre;
		if (x.padre == null) {
			this.raiz = y;
		} else if (x == x.padre.izquierdo) {
			x.padre.izquierdo = y;
		} else {
			x.padre.derecho = y;
		}
		y.izquierdo = x;
		x.padre = y;
	}

	
	public void rotar_derecha(NodoRN x) {
		NodoRN y = x.izquierdo;
		x.izquierdo = y.derecho;
		if (y.derecho!= null) {
			y.derecho.padre = x;
		}
		y.padre = x.padre;
		if (x.padre == null) {
			this.raiz = y;
		} else if (x == x.padre.derecho) {
			x.padre.derecho = y;
		} else {
			x.padre.derecho = y;
		}
		y.derecho = x;
		x.padre = y;
	}
	public void inorden(NodoRN raiz){
		if(raiz != null){
			inorden(raiz.izquierdo);
			System.out.print(raiz.info+" ");
			inorden(raiz.derecho);
		}
	}
public static void main(String[] args){
	ArbolRN m = new ArbolRN();
	m.insert("7");
	m.insert("8");
	m.insert("3");
	m.insert("1");
	m.insert("6");
	m.insert("9");
	m.inorden(m.raiz);
}
}
