package Algoritm_Married;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
	//generaremos arrays de 1 hasta 100 elementos
	for(int i = 1 ; i < 100; i++) {
		//Generando el array que es aleatorio
		int[] list = generate(i);
		//ordenando por insertionSort la lista
		//list = insertionSort(list);
		//ahora lo mas importante, es hacer que sea 
		//el peor caso del insertionSort
		//(el peor es cuando esta ordenado al reves)
		//reverse(list);
		//ahora podemos tener menos latencia
		long start = System.nanoTime();
		list = insertionSort(list);
		//obteniendo el tiempo
		long time = System.nanoTime() - start;
		//imprimir el tiempo
		System.out.println(time);
	}
}
//el metodo insertionSort lo que hace es ordenar una lista
//intercambiando los elementos que no cumplan con el orden establecido
public static int[] insertionSort(int[] list) {
	
	int index;
	//recorremos desde el 1 hasta n-1(n el es #elementos)
	for(int i = 1; i < list.length; i++) {
		//obteniendo el indice presente
		index = list[i];
		//ahora vamos a ver si alguno no cumple con el orden
		//todos los elementos desde 0 hasta i-1
		for(int j = 0; j < i; j++) {
			//si uno es mayor que el index
			if(index < list[j]) {
				//lo intercambiamos en su lugar
				int aux = list[i];
				list[i] = list[j];
				list[j] = aux;
			}
		}
	}
	//retornamos la lista
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
