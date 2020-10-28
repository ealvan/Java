package ArbolRN;

public class NodoRN {
	NodoRN izquierdo;
	NodoRN derecho;
	NodoRN padre;
	String info;
	String color;
	public NodoRN(String dato){
		info = dato;
		izquierdo = null;
		derecho  = null;
		padre = null;
		color = "rojo";
	}
}
