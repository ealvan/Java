package Algoritm_Married;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
	//generaremos arrays de 1 hasta 100 elementos
	
		//Generando el array que es aleatorio
		int[] list = {1,3,4,5,2};
		//ordenando por insertionSort la lista
		//list = insertionSort(list);
		//ahora lo mas importante, es hacer que sea 
		//el peor caso del insertionSort
		//(el peor es cuando esta ordenado al reves)
		//reverse(list);
		//ahora podemos tener menos latencia
		
		list = insertionSort(list);
		//obteniendo el tiempo
		 print_(list);
	
}
//el metodo insertionSort lo que hace es ordenar una lista
//intercambiando los elementos que no cumplan con el orden establecido
public static int[] insertionSort(int[] list) {
	
	int index;

	for(int i = list.length-1; i > 1 ; i--) {
		
		index = list[i];
		
		for(int j = i; j > 0 ; j--) {
			
			if(index < list[j]) {
				
				int aux = list[j];
				list[j] = list[i];
				list[i] = aux;
			}
		}
	}
	return list;
}
public static int[] insertionSort_(int[] list) {
	
	int index;

	for(int i = list.length-1; i > 0 ; i--) {
		
		index = list[i];
		
		for(int j = i; j > 1 ; j--) {
			
			if(index < list[j]) {
				
				int aux = list[i];
				list[i] = list[j];
				list[j] = aux;
			}
		}
	}
	return list;
}
//recibe una lista y la convierte en una lista al reves
public static void reverse(int[] list) {
	//creando una lista con el mismo #elelemntos
	int [] list_ = new int[list.length];
	int i = 0;
	for(Integer key: list) {
		list[i]= key;
		i++;
	}
	list = list_;
	
}
//esta imprime una lista
public static void print_(int[] list) {
	String str = "";
	for(int i = 0; i < list.length; i++) {
		str += list[i]+" ";
	}
	System.out.println(str);
}
//este metodo dado un "num" de elementos nos devuelve una lista 
//con "num" elementos de la lista
public static int[] generate(int num) {
	//lista con el numero de elementos
	int[] list = new int[num];
	//creando elemento por elemento para la lista
	for(int i = 0; i < list.length; i++) {
		//(el numero aleatorio esta entre [1,num])
		list[i] = num - i ;	
	}
	//retornamos la lista
	return list;
}

}
