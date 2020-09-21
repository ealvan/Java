package Algoritm_Married;

public class selectionSort {

	public static void main(String[] args) {
		int[] array = {1,4,3,5,2,61,4,2,52};
		selectionSort(array);
	}
 	
public static void selectionSort(int[] arr) {
	int i = 0;
	//el bucle se hace hasta el indice n-1, pues des el n-1 hasta n, bucaremos el 
	//menor valor y retornaremos el indice
	//si hicieramos  hasta el n no abria nada que buscar pues seria de n hata n, 
	//osea el menor valor si os i es el de indice n
	while(i < arr.length-1) {
		
		int indexM = giveMinor(arr,i);
		//todos los elementos de i hasta n-1 son mayores o iguales al elemnto arr[indexM]
		//invariant loop is { k in  i...n-1 | arr[k] >= arr[indexM] }
		int aux = arr[indexM];
		arr[indexM] = arr[i];
		arr[i] = aux;
		i++;
	}
	for (int j = 0; j< arr.length; j++) {
		System.out.print(arr[j]+" ");
	}
			
		
}
public static int giveMinor(int []arr, int i) {
	int menor  = arr[i];
	for(int j = i; j < arr.length; j++ ) {
		if (menor > arr[j]) {
			menor = arr[j];
		}
	}
	for(int j = i; j < arr.length; j++) {
		if(menor == arr[j]) {
			return j;
		}
	}
	return -1;
}

}
