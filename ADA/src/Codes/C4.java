package Codes;

import java.util.Arrays;

//CODIGO 4
class C4 { 
	static void Algoritmo4(int grafo[][], int V, int E, int src) { 
		int []dis = new int[V]; 
		//inicializa las distancias de todos los vertices a infinito
		for (int i = 0; i < V; i++){
			dis[i] = Integer.MAX_VALUE; 
		}
		dis[src] = 0; 
		//relaja todos los nodos, desde el vertice src hacia los demas
		for (int i = 0; i < V  -  1; i++){ 
			for (int j = 0; j < E; j++) { 
				if (dis[grafo[j][0]] + grafo[j][2] < dis[grafo[j][1]]){ 
					dis[grafo[j][1]] = dis[grafo[j][0]] + grafo[j][2]; 
				}
			} 
		} 
		//comprbar si hay ciclos negativos
		for (int i = 0; i < E; i++) { 
			int x = grafo[i][0]; 
			int y = grafo[i][1]; 
			int weight = grafo[i][2]; 
			if (dis[x] != Integer.MAX_VALUE && dis[x] + weight < dis[y]) 
			System.out.println("Se detecto posible conflicto"); 
		} 
		
		System.out.println("Resultado :"); 
		for (int i = 0; i < V; i++){
			System.out.println(i + "\t\t" + dis[i]); 
		}
	} 
	public static void prim(int[][] graf) {
		for(int i =0; i < graf.length; i++) 
			System.out.println(Arrays.toString(graf[i])+",");
	}
	public static void main(String[] args){ 
		int V = 5;
		int E = 8;
		int grafo[][] = { 
				{0, 1, -4},
				{0, 2, 4},
				{1, 2, 3},
				{1, 3, 2},
				{1, 4, 2},
				{3, 2, 5},
				{3, 1, 1},
				{4, 3, -3},
			
		}; 
		prim(grafo);
		Algoritmo4(grafo, V, E, 0); 
	} 
} 
