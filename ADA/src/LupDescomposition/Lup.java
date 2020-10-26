package LupDescomposition;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lup {

	public static void main(String[] args) {
		
		double arr[][] = {
				{ 2 ,0 ,2  , 0.6},
				{ 3 ,3 ,4  ,-2},
				{ 5 ,5 ,4  ,2},
				{ -1,-2,3.4,-1}
		};
		double matriz_permutacion[][] = {
				{0,0,1,0},
				{1,0,0,0},
				{0,0,0,1},
				{0,1,0,0}
		};
		//descomposition(arr);
		System.out.println("*********Matriz Original*******");
		print(arr);
		descomposition(arr);
		double[][][] m = cortar(arr);
		
		System.out.println("*********Matriz Superior \"U\" *******");
		print(m[0]);
		
		System.out.println("*********Matriz Inferior \"L\" *******");
		print(m[1]);
		
		System.out.println("*********Matriz LU*******");
		double[][]result = multiplicar(m[1],m[0]);
		print(result);
		System.out.println("***********Matriz PA****************");
		print(multiplicar(arr,matriz_permutacion));
		
	}

public static void print(double[][] arr) {
	for(int i = 0; i < arr.length; i++) {
		for(int j = 0; j < arr[i].length; j++) {
			System.out.print(round(arr[i][j],1)+"   ");
		}
		System.out.println();
	}
	//System.out.println("***************");
}
private static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
 
    BigDecimal bd = new BigDecimal(Double.toString(value));
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
public static double[][][] cortar(double[][] arr) {
	
	double[][] superior = new double[arr.length][arr[0].length];
	double[][] inferior = new double[arr.length][arr[0].length];
	for(int i = 0; i < arr.length; i++) {
		for(int j= i ; j < arr.length; j++) {
			superior[i][j] = arr[i][j];
		}		
	}
	for(int k = 0; k < arr.length; k++) {
		for(int j = 0; j <= k; j++) {
			if(j==k) {
				inferior[k][j] = 1;
			}else
			inferior[k][j] = arr[k][j];
		}
	}
	double[][][] m = {superior,inferior};
	return m;
}
public static double[][] multiplicar(double[][] A, double[][] B){
	double[][] result = new double[A.length][B.length];
	for(int i = 0; i < A.length; i++) {
		for(int j = 0; j < A.length; j++) {
			
			for(int k =0; k < B.length; k++) {
				result[i][j] += A[i][k]*B[k][j];
			}				
		}
	}
	return result;
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
