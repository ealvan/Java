package Generacidad;
import java.util.*;
public class Mi_main {
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ArrayList<String> listam = new ArrayList<String>();	 
		/*lista.add(new String("hoal"));
		lista.add(new Integer(2));
		lista.add(new Date());
		System.out.println(lista);*/
		Lista mi_lista = new Lista();
		mi_lista.agregar(new String("un string"));//0
		mi_lista.agregar( new Date());
		mi_lista.agregar(new Integer(12));
		mi_lista.agregar(new int[2]);
		System.out.print(mi_lista +"\n ****************\n");
		mi_lista.eliminar_porIndice(0);
		System.out.print(mi_lista);
		System.out.println(" >>>> " + mi_lista.devolver_indice("un string"));
		System.out.print(mi_lista.mostrarClase(mi_lista.devolver_por_indice(1)));
	}
}
