package lista_enlazada_generica;

public class Pila_h<T extends Comparable> extends Lista {

	int longitud = 0;//cantidad de elementos
	
	//constructor implementado con la clase Lista
	public Pila_h(Nodo cabeza){
		super(cabeza);
	}
	//inserta al principio
	public void push(T elemento){
		super.inserta_alPrincipio(elemento);
		//ahora la cabeza sera el elemento
	}
	//elimina la cabeza, pues en una pila es LIFO(el ultimo 
	//entrar es el ultimo en salir)
	public Nodo pop(T elemento){
		return super.eliminar_cabeza();//elimina la cabeza, y nos la devuelve
	}
	public String mostrar(){
		return super.mostrar();//implementa el metodo mostrar
	}
	
	public static void main(String[] args) {
		Pila<String> pila = new Pila<String>(new Nodo("cabeza"));
		pila.push("cabeza1");
		pila.push("cabeza2");
		pila.push("cabeza3");
		pila.push("cabeza4");
		pila.push("cabeza5");
		System.out.print("Mostrar pila : "+pila.mostrar());
		System.out.println("Longitud: "+pila.longitud);
		System.out.println("ELemento eliminado : "+pila.pop().elemento);
		System.out.println("ELemento eliminado : "+pila.pop().elemento);
		System.out.println("ELemento eliminado : "+pila.pop().elemento);
		System.out.print("Mostrar pila : "+pila.mostrar());
		System.out.println("Longitud: "+pila.longitud);
	}
}
