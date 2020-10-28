package Generacidad;
import java.lang.reflect.Array;
import java.util.*;
public class Lista_v2<T> {

	 
	private T lista[];
	private int cantidad = 100;
	private int index = 0;
	
	/*
	 * public Lista_v2(int cantidad){
		this.cantidad = cantidad;//actulizando cantidad
		//lista = (T[]) new Object[this.cantidad];// creando la lista de objetos y castenadola a tipo T
		final T[] lista = (T[]) Array.newInstance( T , 100);
		//este constructor hace una clase generica de un solo tipo de objeto
		//es una clase generica, pero solo guardaria un tipo de dato
	}
	 * */
	public Lista_v2(Class<T> c , int cantidad){
		@SuppressWarnings("unchecked")
		final T[] lista = (T[]) Array.newInstance(c, cantidad);
        this.lista = lista;
	}
	
	public Lista_v2(){
		
		lista = (T[]) new Object[this.cantidad];
		//esto hace que se cree una lista de la clase Object
		//porque vamos a agregar objetos(double,integer, string, exception)
		//pero necesitamos castear la lista(Objeto), a una lista generica
		// al momento de devolver un objeto, no sera necesario el casteo, ya que todo
		//elemento de la lista sera de tipo T
		// otra manera para devolver seria
		//return (T) lista[index], utilizaria esto si no cateariamos toda la lista.
	}
	//INSERTAR UN ELEMENTO 
	public void agregar(T elemento){
		try{
			lista[index] = elemento;//si se pasa de el numero de elementos, botaraIndexOfBoundsException
			index++;
		}catch(Exception e){
			System.err.println("No se puede agregar :(");
		}
	}
	
	//RETORNAR EL INDICE DE UN ELEMENTO
	public T mostrar_elemento(int n){
		if( n >= lista.length || n < 0){
			return null;//no encuentra nada
		}else{			
			return lista[n];//es de tipo T, asi que no necesita casteo
			
		}
	}
	
	// ESTE METODO DEVUELVE LA CANTIDAD DE ELEMENTOS LLENOS HASTA AHORA,
	// HAY 100 ELEMENTOS SI O SI, PERO LA CANTIDAD UTILIZADA ES DISTINTA A VECES
	// ESTE NOS DA LA CANTIDA DE ELEMENTOS UTILIZADOS DE LA LISTA
	public int getCantidad_llena(){
		return index;
	}
	
	//ELIMINAR POR INDICE, algunos de los comentarios son de varios intentos fallidos,
	//que no salieron muy bien, pero no los borro, porque me hace saber en que fallo el codigo.
	public void eliminar_por_indice(int n){
		if(n >= this.cantidad || n < 0 ){
			System.err.println("El item "+n+" no existe :(.");
		}else{
			this.cantidad--;//siempre que eliminamos restamos
			index--;
		    if(n == 0){
		    	for(int i = 0; i < lista.length-1; i++){
		    		
		    		lista[i] = lista[i+1];
		    		//como ya sabemos que debemos eliminar el 0, actualizamos
		    		//lista[0] = lista[1]
		    		//lista[1] = lista[2]
		    		// .....
		    		//lista[n-2] = lista[n-1](n es el nummero de elementos de la lista)
		    		// el utlimo elemento(lista[lista.length] no se actualizara) debe borrarse
		    		//la unica manera que encontre fue ponerle null, para no eliminar la posicion
		    	}
		    	
		    	//T lista_cortada[] =  Arrays.copyOfRange(lista, 0, lista.length);
		    	//lista = lista_cortada;
		    	
		    	lista[lista.length-1] = null;
		    	//return lista[0];
		    }else{
		    	int j = n;
		    	
		    	for( ; j < lista.length-1; j++ ){
		    		lista[j] = lista[j+1];	
		    	}
		    	//ahora eliminamos el indice n actualizando
		    	//lista[j] = lista[j+1]
		    	//T lista_cortada_d[] =  Arrays.copyOfRange(lista, 0, lista.length);		    
		    	
		    	//lista = lista_cortada_d;
		    	lista[lista.length-1] = null;
				//return lista[n];
				/*
				 * 
				 * T lista_atras[] = Arrays.copyOfRange(lista,0, n);//de 0 a n-1 
			    
				T lista_delante[] = Arrays.copyOfRange(lista, n+1, lista.length);
				 * int cant;
				
					for( cant = 0;  cant < lista_atras.length; cant++ ){
					     lista[cant] = lista_atras[cant];
					}
					
				cant--;
				
					for( int i = 0;  i < lista_atras.length; i++ ){
						 lista[cant] = lista_atras[i];
						 cant++;
					} 
				 * */	
		    }
		    	
		}
	}
	
	//MOSTRAR LA LISTA DE TODOS LOS ELEMENTOS
	public void mostrar(){
		for(int i = 0; i < lista.length; i++){
			if(lista[i] != null){
				System.out.print("Item "+i+" ==> "+ lista[i].toString()+ "\n");
			}
		}
		/*String str = "";
		for(int i = 0; i < lista.length-1; i++){
			str += "Item "+i+" ==> "+ lista[i].toString()+ "\n";
		}
		return str;*/
	}
	//NOS MUESTRA LA CLASE A LA QUE PERTENECE EL ELEMENTO COMO PARAMETRO
	public Object mostrar_clase(T elemento){
		
		return elemento.getClass();//nos muestra a que clase pertenece, cuando lo retorne
		//botara un toString sobreescrito de ese objeto.
		
		/*
		 * for(int i = 0; i < lista.length; i++){
			if(lista[i] != null)
			System.out.println("La clase del elemento en la posicion "+ i+" es: "+ lista[i].getClass());
		}
		 * */
	}
	
	//IGUAL QUE EL DE ARRIBA, PERO POR INDICE DE LA LISTA
	public Object mostrar_clase(int n){
		if( n >= lista.length || n < 0){
			return null;
		}else{
			
			return lista[n].getClass();
		}
	}
	
	//NOS MUESTRA LA CANTIDAD DE ELEMENTOS QUE SE PUEDEN ALMACENAR, PERO NO LO HACE
	//COMO DEBERIA, :(
	public int getCantidad() {
		return this.cantidad;
	}
	
}
