package Algoritm_Married;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
	//generaremos arrays de 1 hasta 100 elementos
	
		//Generando el array que es aleatorio
		String[] list = {"A","C","M","P","B"};
		String[] list1 = {"M","C","A","P","B"};
		
		//ordenando por insertionSort la lista
		//list = insertionSort(list);
		//ahora lo mas importante, es hacer que sea 
		//el peor caso del insertionSort
		//(el peor es cuando esta ordenado al reves)
		//reverse(list);
		//ahora podemos tener menos latencia
		
		sortStrings(list);
		
		selectSort(list1);
		System.out.print(Arrays.toString(list));
		//obteniendo el tiempo
		 System.out.print(Arrays.toString(list1));
	
}
public static void sort(int arr[]) { 
	        int n = arr.length; 
	        for (int i = 1; i < n; ++i) { 
	            int key = arr[i]; 
	            int j = i - 1; 
	  
	            /* Move elements of arr[0..i-1], that are 
	               smaller than key, to one position ahead 
	               of their current position */
	            while (j >= 0 && key > arr[j]  ) { 
	                arr[j + 1] = arr[j]; 
	                j = j - 1; 
	            } 
	            arr[j + 1] = key; 
	        } 
	    } 	
public static void sortStrings(String arr[]) { 
    int n = arr.length; 
    for (int i = 1; i < n; ++i) { 
        String key = arr[i]; 
        int j = i - 1; 

        /* Move elements of arr[0..i-1], that are 
           smaller than key, to one position ahead 
           of their current position */
        while (j >= 0 && key.compareTo(arr[j]) > 0 ) { 
            arr[j + 1] = arr[j]; 
            j = j - 1; 
        } 
        arr[j + 1] = key; 
    } 
}

public static void selectSort(String arr[]) 
{ 
    int n = arr.length; 

    // One by one move boundary of unsorted subarray 
    for (int i = 0; i < n-1; i++) 
    { 
        // Find the minimum element in unsorted array 
        int min_idx = i; 
        for (int j = i+1; j < n; j++) 
            if (arr[j].compareTo(arr[min_idx]) > 0) 
                min_idx = j; 

        String temp = arr[min_idx]; 
        arr[min_idx] = arr[i]; 
        arr[i] = temp; 
    } 
}  
//***********************************
public static void selectionSort(int arr[]) {
	int min_idx=0;
	
	for (int i  = 0; i < arr.length -1; i++) {
		for(int j = i+1; j < arr.length -1; j++) {
			if(arr[j] < arr[min_idx]) {
				min_idx= j;
			}
			int aux = arr[min_idx];
			arr[min_idx] = arr[i]; 
			arr[i] = aux;
		}
	}
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
