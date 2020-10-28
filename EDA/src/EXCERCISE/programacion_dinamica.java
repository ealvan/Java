package EXCERCISE;

public class programacion_dinamica {

	/**
	 * ANALISIS DE FIBONACII, OPIMIZACION CON PROGRAMACION DINAMICA.
	 */
	public static void main(String[] args) {
			String print="";
		int []lista =   fibonacii(12);
		for(int i =0 ; i< lista.length; i++){
			print += lista[i] + "\n";
		}
		System.out.print(print);
	}
	public static int[] fibonacii(int n){
		int tabla[]= new int[n+1];
		for(int i =0 ; i<=n; i++){
			tabla[i] = i;
		}
		tabla[0] = 0;
		tabla[1] = 1;
		for(int i = 2; i <= n; i++){
			tabla[i] = tabla[i-1]+tabla[i-2];
		}
		return tabla;
	}
	public static int fibonacii_original(int n){
		if(n==0){
			return 0;
		}else{
			if(n==1){
				return 1;
			}else{
				return fibonacii_original(n-1)+fibonacii_original(n-2);
			}
		}
	}
}
