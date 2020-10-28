package EXCERCISE;

public class La_varilla {
 	 
	public static void main(String[] args) {
		int price [] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int mejor_precio = rodCut(price,3);
		System.out.println(mejor_precio);
	}
		// Esta es la function que obtiene el mayor costo que se puede obtener 
		//cortando la varilla
		// cuando la varilla de longitud i tiene un precio de price[i-1];
		public static int rodCut(int[] price, int n)
		{
			// caso base
			if (n == 0) {
				return 0;//cuando lo que queda de la varilla es 0 --> rodCut(n-n)
			}

			int maxValue = Integer.MIN_VALUE;

			// Partiendo la varilla uno por uno la varilla de  
			//  dos partes de longitud (1, n-1), (2, n-2), (3, n-3), ...., (n, n-n)
			for (int i = 1; i <= n; i++)
			{
				// la varilla de longitud i tiene un costo de price[i-1]
				int cost = price[i - 1] + rodCut(price, n - i);
				
				//evaluando el valor maximo
				if (cost > maxValue) {
					maxValue = cost;//actualizando maxValue
				}
			}
			return maxValue;//retornar el maximo costo.
		}
	}