package Algoritm_Married;

public class linearSeach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//el caso promedio es n/2,
//el peor caso es n
//todos los algotimos podemos saber con cierta precion cuanto tardaran, 
//pero es bastante inutil pensar que todos los algoritmos son de O(1),
//solo porque siempre hay un limite computacional que lo dictamina asi.
//aqui lo que importa es el algoritmo en si, y sus optimizaciones, 
//no el limite natural de un algoritmo que son los limites difinidos por el lenguaje
public int linarSearch(int[]arr,int s) {
	for(int i = 0; i < arr.length; i++) {
		if(arr[i] == s) {
			return i;
		}
	}
	return -1;
}
}