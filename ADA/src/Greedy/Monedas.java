package Greedy;

import java.util.Arrays;

public class Monedas {
	public static int maxCoins(int[] monedas) {
		//si la cantidad de monedas es cero
		if(monedas.length  == 0) 
			//retornamos cero
			return 0;
		//el amximo siempre estara en el ultimo elemento
		int max = monedas[monedas.length-1];
		int k = 2;
		//restamos con el penultimo
		max = max - monedas[monedas.length-2];
		//recorremos la lista de monedas
		for(int i = monedas.length-3; i >= 0; i--) {
			//si aun hay monedas para poder comprar
			if(monedas[i] < max ) {
				//las compramos y disminuimos nuestro dinero("max")
				max = max - monedas[i];// retirar X - Y
				//aumenrtamos el nro de monedas compradas
				k++;
			}
		}
		//retornamos k
		return k;
		
	}	
	public static void main(String[] args) {
		int[] list1 = {1, 2, 4, 8, 16, 32};
		int[] list = { 1 ,3 ,6 ,8 ,15 ,20};
		String str = list1.length+ 
				"\n"+Arrays.toString(list1)+
				"\n"+list.length+
				"\n"+Arrays.toString(list);
		System.out.println("Entradas: \n"+str);
		int m = maxCoins(list1);
		System.out.println("Salidas:");
		System.out.println(m);
		m = maxCoins(list);
		System.out.print(m);
	}
}
