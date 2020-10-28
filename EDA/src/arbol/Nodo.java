package arbol;

public class Nodo {
	
	int id = 1;
	boolean es = false;
	Nodo izq;
	Nodo der;
	public Nodo(int id) {
		this.id=id;
	}
	public Nodo(int id, boolean es_) {
		this.id=id;
		es=es_;
	}
	public static void main(String[] args) {
		
	}
}
