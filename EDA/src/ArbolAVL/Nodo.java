package ArbolAVL;

public class Nodo<T extends Comparable> {
	T elemento;
	Nodo izquierdo;
	Nodo derecho;
	int fe = 0;//factor de equilibrio
	public Nodo(){
		elemento = null;
		izquierdo = null;
		derecho = null;
	}
	public Nodo(T valor){
		elemento = valor;
		izquierdo = null;
		derecho = null;
	}
	public void visitar(){
		System.out.print(elemento + ", ");
	}
	public static void main(String[] args) {


	}

}
