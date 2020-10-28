package listas_enlazadas;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Libro b = new Libro("titulo","autor","isbn");
		Nodo cabeza = new Nodo(b);
		Lista l = new Lista(cabeza);
		Libro a = new Libro("titulo","autor","isbn");
		Libro a1 = new Libro("titulo1","autor1","isbn1");
		Libro a2 = new Libro("titulo2","autor2","isbn2");
		Libro a3 = new Libro("titulo3","autor3","isbn3");
		l.insertar_principio(a);
		l.insertar_principio(a1);
		l.insertar_principio(a2);
		l.insertar_principio(a3);
		
		//l.eliminar_final();
		//l.eliminarLibro(3);
		
		System.out.print(l.mostrar());
	}

}
