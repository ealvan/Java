package listas_enlazadas;

public class Libro {

	String nombre;
	String autor;
	String isbn;
	public Libro(String n,String a,String isbn){
		nombre=n;
		autor = a;
		this.isbn = isbn;
	}
	public String toString(){
		return "Nombre : "+this.nombre + " autor: "+this.autor + " isbn: "+this.isbn;
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
