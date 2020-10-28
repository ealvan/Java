package Generacidad;
import java.util.*;
public class Main_lista_estatica {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Lista_v2 list = new Lista_v2();
		//agregamos todo lo que herede de object(creo que la mayoria o todo)
		//cada vez que agregamos objetos, nunca verificamos que tipo es, pues todo lo toma como Object
		//cuando imprimimos, se llama al toString sobreescrito de cada clase, asi que no casteamos nada
		for(int i = 0; i < 100; i++){
			int aleat = (int) Math.floor( Math.random()*5);// [0,1>
			switch(aleat){
			case 0: list.agregar(new Date()); break;
			case 1: list.agregar(new Integer(aleat)); break;
			case 2: list.agregar(new Double(aleat/2.0)); break;
			case 3: list.agregar(new String("aleat_string")); break;
			case 4: list.agregar(new Exception()); break;
			}
		}
		System.out.println("lA CANTIDAD ES: "+ list.getCantidad_llena());//100
	 
		list.eliminar_por_indice(0);
		list.eliminar_por_indice(50);
		
		System.out.println("lA CANTIDAD ES: "+ list.getCantidad_llena());//98
		 
		list.agregar(new Date());//se agregan siempre al final
		list.agregar(new Date());
		
		System.out.println("lA CANTIDAD ES: "+ list.getCantidad_llena());//100
		
		list.mostrar();
		
		System.out.println(list.mostrar_clase(list.mostrar_elemento(9)) );
		//todos los elementos heredan de object, entonces no puedo manipular los datos
		// sl menos que los castee en su clase, aun no se me ocurre como castear automaticamente
		
		System.out.println(list.mostrar_clase(9) );
		System.out.println(list.mostrar_clase(8) );
		System.out.println(list.mostrar_clase(7) );
		System.out.println(list.mostrar_clase(6) );
		System.out.println(list.mostrar_clase(5) );
		System.out.println(list.mostrar_clase(55) );
		list.agregar(new Date());//POR QUE SOBREPASA EL LIMITE,lanza un mensaje
		list.agregar(new Date());//POR QUE SOBREPASA EL LIMITE, lanza un mensaje
		
	}
}
