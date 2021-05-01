package Codes;
import java.util.*; 

class C1 {  
	static int N = 4;  
	
	static boolean wmChoose(int ranking[][], int w, int m, int m1) {  
		for (int i = 0; i < N; i++) {  
			if (ranking[w][i] == m1) {  
				return true;  
			}
			if (ranking[w][i] == m) {
				return false;  
			}
		} 
		return false; 
	}  
	//el tiempo es de O(n ^2), por los dos bucles
	static void Algoritmo1(int ranking[][]) {  
		int salida[] = new int[N];  
		boolean mLibre[] = new boolean[N];  
		
		Arrays.fill(salida,-1);  
		int count = N;  
		
		while (count > 0){  
			int m;  
			// obtenemos el indice de la mujer que no esta casada
			for (m = 0; m < N; m++){  
				if (mLibre[m] == false){
					break;
				}
			}
			//ahora vamos a iterar por su lista de prioridad de esa mujer
			//con indice llamado "vacio"
			for (int i = 0; i < N && mLibre[m] == false; i++) {  
				//obtenemos el indice del hombre de acuerdo a prioridad
				int w = ranking[m][i];  
				
				//si no tiene pareja el hombre
				if (salida[w  -  N] ==  - 1) {  
					//el hombre ya tiene pareja, que es la mujer con index "vacio"
					salida[w  -  N] = m;  
					//marcamos como casada la mujer
					mLibre[m] = true;  
					count-- ;  
				} else {  
					//si no esta casado el hombre
					//vamos a buscar cual le conviene al hombre
					//si la actual o la nueva pretendiente			
					int m1 = salida[w  -  N];	  
					if (wmChoose(ranking, w, m, m1) == false){  
						salida[w  -  N] = m; 
						//y marcar a la nueva como comprometida
						mLibre[m] = true;  
						//entonces que se divorcien
						mLibre[m1] = false;  
					}  
				}
			}
		}
		// Pritn result
		System.out.println("W     M");  
		for (int i = 0; i < N; i++)  
		{ 
			System.out.print(" ");  
			System.out.println(i + N + "     " + salida[i]); 
		} 
	}  
	
	public static void main(String[] args) {  
		int ranking[][] = new int[][]{
			{7, 5, 6, 4},  
			{5, 4, 6, 7},  
			{4, 5, 6, 7},  
			{4, 5, 6, 7},  
			{0, 1, 2, 3},  
			{0, 1, 2, 3},  
			{0, 1, 2, 3},  
			{0, 1, 2, 3}};  
		Algoritmo1(ranking);  
	} 
}  