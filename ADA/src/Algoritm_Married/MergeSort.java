package Algoritm_Married;

 
public class MergeSort {

	public static void main(String[] args) {
		//esta sera la lista
		int[] list;
		//declaramos el inicio y el final del algoritmo
		long start, fin ;
		//ahora vamos a generar las listas e imprimir el tiempo
		for(int i = 1; i < 100; i++) {
			//generar las listas
			list  = generate(i);
			//aplicar el mergeSort
			//list = mergeSort(list);
			//ahora ponerlo al reves, que es el peor caso
			//reverse(list);
			//ahora vamos a empezar el reloj
			start = System.nanoTime();
			//ahora es donde mediremos verdaderamente el algoritmo
			list = mergeSort(list);
			//ahora capturamos el tiempo
			fin = System.nanoTime() - start;
			//Y lo imprimimos
			System.out.println(fin);
		}
	}
public static void reverse(int[] list) {
	int [] list_ = new int[list.length];
	int i = 0;
	for(Integer key: list) {
		list[i]= key;
		i++;
	}
	list = list_;
	
}
public static void print_(int[] list) {
	String str = "";
	for(int i = 0; i < list.length; i++) {
		str += list[i]+" ";
	}
	System.out.println(str);
}
//el mergeSort recibe un array , el cual se ordenara partiendolo y ordenandolo
public static int[] mergeSort(int arr[]) {
	//si el array esta en su minima expresion
	//(un solo elemento) que es el caso base
	if(arr.length <= 1) {
		//returnamos
		return arr;
	}
	//ahora para lograr llegar a su minima expresion debemos partirlos
	//la primera mitad a la izq
	int izq[] = new int[arr.length/2];
	//la segunda mitad a la derecha
	int dere[] = new int[arr.length-arr.length/2];
	//esta lista nos dara la lista ordenada, cada vez que retorne
	int  _result_[] = new int[izq.length+dere.length];
	//ahora vamos a llenar las listas "izq" y la lista "der"
	//hallamos la mitad
	int mitad = arr.length/2;
	
	//llenando la lista hasta mitad - 1
	//0 .... mitad - 1
	for(int i = 0; i < mitad; i++) {
		izq[i] = arr[i];
	}
	//mitad ...... arr.length
	for(int i = mitad; i < arr.length; i++) {
		dere[i - mitad] = arr[i];
	}
	//ahora que ya partimos la lista podemos partirlas de nuevo
	//hasta llegar el caso base, que es 1 elemento
	izq = mergeSort(izq);
	dere = mergeSort(dere);
	//el siguiente codigo se leera desde que se active el "return arr"
	//cuando se active el caso mas simple es de dos array, y cada uno 
	//con un solo elemento
	//es por eso que cuando se active el siguiente if, valdra para cualquier array
	//que al menos tenga un elemento
	if (izq[izq.length - 1 ] <= dere[0]) {
 		//ahora cuando la condicion se cumpla significa que los dos array
		//estan ordenados entre si, significa que solo queda juntarlos 
		//en el array result
		for(int i = 0; i < _result_.length; i++) {
			if(i < izq.length) {
				_result_[i] = izq[i];
			}else {
				_result_[i] = dere[i-mitad];
			}
		}
		//lo retornamos
		return _result_;
	}
	//pero si es que esto no se cumple significa que no estan ordenados entre si
	//por lo que necesitamos ordenarlos y UNIRLOS
	_result_ = union(izq,dere);
	return _result_;
}
//este metodo recibe dos array desordenados entre si
//los ordena, y despues los une en un array y lo retorna
public static int[] union(int izq[],int dere[]) {
	//preparamos un array para recibir la union ordenada de los dos array
	int[] result=new int[dere.length+izq.length];
	//este i, iterara sobre result
	int i = 0;
	//ahora este bucle se seguira ejecutando, hasta que uno o los dos
	//esten arrays esten vacios
	while(izq.length > 0 && dere.length > 0) {
		//comparamos cada primer elemento de las dos listas
		//si el 1er elemento de la lista "izq" es menor
 		if( izq[0] <= dere[0] ) {
			//ahora lo agregamos el elemento en "result"
			result[i] = izq[0];
			//y ahora lo eliminamos del  1er elemento
			izq = restar(izq);
		}else{
			//de los contrario el 1er elemento de la lista "dere"
			//es mayor, entonces lo agregamos
			result[i] = dere[0];
			//ahora lo elminamos
			dere = restar(dere);
		}
 		//aumentamos i, para que no sobreescriva el array result
		i++;
	}
	//despues cuando se corte el bucle
	//puede que el array "izq" tenga elementos aun
	if(izq.length > 0) {
		//entonces solo queda agregarlos a la lista result
		result = agregar(izq,result);
	}
	//o el array "dere" tenga elementos
	if(dere.length > 0) {
		//entonces agregaomns los elemento restantes a la lista result
		result = agregar(dere,result);
	}
	//y finalmente lo devolvemos ya ordenado y unido
	return result;
}
//este metodo elimina el primer elemento de la lista
public static int[] restar(int [] list) {
	int []_list_ = new int[list.length-1];
	for(int i = 1; i < list.length; i++) {
		_list_[i-1] = list[i];  
	}
	//retornamos la lista
	return _list_;
}
//este metodo agregar, agrega la lista "lista_min" a la lista "result" 
public static int[] agregar(int list_min[], int result[] ) {
	int i= 0;
	//primero obtenemos desde que indice
	//esta vacio
	for(; i < result.length; i++) {
		if(result[i] == 0) {
			break;
		}
	}
	//y luego lo llenamos
	for(int j = i; j < result.length; j++ ) {
		result[j] = list_min[j-i]; 
	}
	//y lo retornamos
	return result;
}
public static int[] generate(int num) {
	int[] list = new int[num];
	for(int i = 0; i < list.length; i++) {
		list[i] = num - i;	
	}
	return list;
}
}
