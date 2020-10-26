package LupDescomposition;

 
public class Lup {

	public static void main(String[] args) {
		
		double arr[][] = {
				{ 2 ,0 ,2  , 0.6},
				{ 3 ,3 ,4  ,-2},
				{ 5 ,5 ,4  ,2},
				{ -1,-2,3.4,-1}
		};
		descomposition(arr);
		print(arr);

	}
public static void print(double[][] arr) {
	for(int i = 0; i < arr.length; i++) {
		for(int j = 0; j < arr[i].length; j++) {
			System.out.print(arr[i][j]+"   ");
		}
		System.out.println();
	}
}
public static void descomposition(double[][] arr) {
	//filas, el array es cuadrado
	double[] pi = new double[arr.length];
	
	for(int i = 0; i < pi.length;i++) {
		pi[i] = i;
	}
	int k_prima = 0;
	for(int k = 0; k < pi.length;k++) {
		double p =0;
		for(int i = k; i < pi.length; i++) {
			if(Math.abs(arr[i][k]) > p) {
				p = Math.abs(arr[i][k]);
				k_prima=i;//dudas
			}
		}
		if(p == 0) {
			throw new RuntimeException("no se puede dividir entre cero");
		}
		double aux = pi[k_prima];
		pi[k_prima] = pi[k];
		pi[k] = aux;
		
		for(int i = 0; i < pi.length; i++) {
			double aux_ = arr[k_prima][i];
			arr[k_prima][i] = arr[k][i];
			arr[k][i] = aux_;
		}
		for(int i = k+1; i < pi.length; i++) {
			arr[i][k] = arr[i][k]/arr[k][k];
			for(int j = k+1; j < pi.length; j++) {
				arr[i][j] = arr[i][j] - arr[i][k]*arr[k][j];
			}
		}
	}
}
	
}
