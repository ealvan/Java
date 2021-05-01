package Codes;

//CODIGO 2
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class C2 {
	private static final int V = 5; 
	
	int minimo(int key[], Boolean S[]){ 
		int min = Integer.MAX_VALUE, min_index =  - 1; 
		
		for (int v = 0; v < V; v++){ 
			if (S[v] == false && key[v] < min){ 
				min = key[v]; 
				min_index = v; 
			} 
		}
		return min_index; 
	} 
	
	
	void print(int padre[], int grafo[][]){ 
		System.out.println("E    \tW     "); 
		for (int i = 1; i < V; i++){
			System.out.println(padre[i] + "  -  " + i + "\t" + grafo[i][padre[i]]); 
		}
	} 
	
	void algoritmo2(int grafo[][]) {
		// este guardara los nodos padre del indice respectivo
		// si el indice es v, entonces padres[v] = u
		//entonces el padre de v, es u
		int padre[] = new int[V]; 
		int key[] = new int[V]; 
		// representa a los nodos ya visitados de acuerdo al indice
		Boolean S[] = new Boolean[V]; 
		//incializamos los nodos, con Integer.max_value
		for (int i = 0; i < V; i++) { 
			key[i] = Integer.MAX_VALUE; 
			S[i] = false; //como no visitados
		} 
		//este sera el vertice "0" con el que se inicia el MST
		key[0] = 0;
		
		padre[0] =  - 1;
		
		for (int count = 0; count < V  -  1; count++) { 
			//primero agarramos los el vertice con el minimo peso hacia el vertice
			// de inicio
			int u = minimo(key, S); 
			S[u] = true; 
			//ahora recorremos los indices adyacentes al indice "u"
			for (int v = 0; v < V; v++){
				// Ahora los evaluamos
				// si es cero la arista, significa que es cero, osea no cuenta
				// si el vertice adyacente "v" es falso, signifia que aun no se ha visitado
				// luego si cumple todas estas condiciones, vemos esas aristas adyacentes
				// que cumplen las condiciones anteriores, entonces ...
				if (grafo[u][v] != 0 && S[v] == false && grafo[u][v] < key[v]) { 
					// hacemos que el padre de v, sea u
					padre[v] = u; 
					//luego asignamos, a la que hasta ahora es la arista minima
					key[v] = grafo[u][v]; 
				} 
			}
		} 
		// luego retornamos el peso minimo con sus nodos
		print(padre, grafo); 
	} 
	
	public static void main(String[] args) 
	{ 
		C2 t = new C2(); 
		int grafo[][] = new int[][] { 
			{ 0, 2, 0, 6, 0 }, 
			{ 2, 0, 3, 8, 5 }, 
			{ 0, 3, 0, 0, 7 }, 
			{ 6, 8, 0, 0, 9 }, 
			{ 0, 5, 7, 9, 0 } }; 
		
		
		t.algoritmo2(grafo); 
	} 
}