package El_Cine;
import java.util.*;
public class Main {
 
	public static void main(String[] args) {
		Nodo<Persona> cabeza = new Nodo<Persona>(new Persona(0 , 0));
		
		Cola<Persona> cola = new Cola<Persona>(cabeza);
		int num_people = generaNumeroAleatorio(0,50);
		int recaudado = encolar_personas(cola, num_people );
		
		System.out.println(" Hnumeor de personas: "+ num_people);
		System.out.println("Recaudado :" + recaudado);
		//System.out.println(cola);
		int sum=0;
		for(Nodo puntero = cola.cabeza; puntero != null; puntero = puntero.siguiente){
			Persona a = (Persona) puntero.item;
			sum += a.getTicket();
		}
		System.out.println(sum+" >>> ");
		
		
		/*************************************/
	 
		 
		 int [] vector = {3, 5, -2, 1};

		 System.out.println(recursive(vector, 3));

	}
	
	
	public static int recursive (int[] vector, int j){ 
		if (j > 0) { 
			int aux = 0; 
			for(int i = 0; i < j; i++) { aux += vector[i]; 
			}
		return aux - recursive(vector, j-1) + recursive (vector, j-2); 
	}
	else 
	return 0; 
	}
	
	
	
	
	
	
	
	
	
	
	public static int generaNumeroAleatorio(int minimo, int maximo){
        int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
	public static int encolar_personas(Cola<Persona> cola, int n){
		int costo = 1;
		int suma = 0;
		for( int i = 0; i < n; i++){
			int edad = generaNumeroAleatorio( 5 , 60);
			if( edad >= 18){
				costo = 35;
			}else if( edad >= 11){
				costo = 25;
			}else if( edad >= 5){
				costo = 1;
			}
			
			cola.encolar(new Persona(edad, costo));
			suma+=costo;
		}
		return suma;
		
	}
	
}	
