package arbol;

public class Arbol {
	 int id;
	 boolean es = false;
	 Arbol izq, der;
	 Arbol cabeza;
	 public Arbol(int id) {
		 this.id = id;
	 }
	 public String toString() {
		 return String.valueOf(id);
	 }
	 public Arbol insertar(Arbol nodo, int id, int p) {
		 if(nodo != null && id < p) {
			 nodo.izq = nodo.insertar(nodo.izq, id +1 , p  );
			 nodo.der = nodo.insertar(nodo.der, id +2, p );
			 return new Arbol(id);
		 }else {
			 
		 }
		return nodo;
	 }
	 public void preorden(Arbol nodo) {
		 if(nodo != null) {
			 System.out.println(nodo.izq);
			 System.out.println(nodo);
			 System.out.println(nodo.der);

		 }
	 }
	
	 public static void main(String[] args) {
		 Arbol uno = new Arbol(1);
		 uno.insertar(uno, 1 ,3);
		 uno.preorden(uno);
	 }
}

 