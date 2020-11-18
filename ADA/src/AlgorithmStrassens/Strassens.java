package AlgorithmStrassens;

public class Strassens {
	//algoritmo Strassens,implementacion
	
	//este metodo es la parte principal
	//del algoritmo strassens
	public int[][] multiplicar(int[][]A, int[][]B){
		//primero, debemos tener en cuenta, que las dos matrices deben 
		//obligatoriamente cuadradas y de igual tamaño 
		
		//tomamos primero su "n"
		int n = A.length;
		//creamos la matriz cuadrada que almacenara el resultado
		//con la misma cantidad de filas y columnas
		int result[][] = new int[n][n];
		
		//el caso base es 1, aunque tambien podria ser dos
		//para que sea dos, tendriamos que implementar 
		//la multiplcacion para una matriz 2x2
		//ponemos "n==1", porque segun la teoria, tambien
		//es factible hacerlo hasta la minima matriz, la cual es 1x1
		if(n == 1) {
			result[0][0] = A[0][0] * B[0][0];
		}else {
			//ahora calculamos los "S's" a partir 
			//de las matrices calculadas
			//esta vez NO cortamos las matrices originales y
			//y luego las operamos.
			//el metodo es apartir de los indices. es decir
			//solo gastamos memoria para almacenar los "S's"
			//pero no para cortar las matrices originales(seria mas memoria)
			int[][] S1 = fase4(B);
			int[][] S2 = fase1(A);
			int[][] S3 = fase2(A);
			int[][] S4 = fase6(B);
			int[][] S5 = fase3(A);
			int[][] S6 = fase3(B);
			int[][] S7 = fase4(A);
			int[][] S8 = fase2(B);
			int[][] S9 = fase5(A);
			int[][] S10 = fase1(B);
			//aqui cortamos las partes que nos pide el algoritmo
			//para poder proseguir
			int[][] A11 = cortar11(A);
			int[][] A22 = cortar22(A);			
			int[][] B11 = cortar11(B);
			int[][] B22 = cortar22(B);
			//ahora calculamos recursivamente las siguientes multiplicaciones
			//segun el algoritmo
			int[][] P1 = multiplicar(A11,S1);
			int[][] P2 = multiplicar(S2,B22);
			int[][] P3 = multiplicar(S3,B11);
			int[][] P4 = multiplicar(A22,S4);
			int[][] P5 = multiplicar(S5,S6);
			int[][] P6 = multiplicar(S7,S8);
			int[][] P7 = multiplicar(S9,S10);
			
			//despues sacamos las partes principales de la matriz de salida
			int[][] C11 = restar(sumar(sumar(P5,P4),P6),P2);
			int[][] C12 = sumar(P1,P2);
			int[][] C21 = sumar(P3,P4);
			int[][] C22 = restar(restar(sumar(P5,P1),P3),P7);
			
			//los unimos en la matriz resul, creada al principio
			result = result(C11, C12, C21, C22);
			
		}
		//y siempre retornamos, yasea caso base o el recursivo
		return result;
	}
	//este es el metodo que une las partes pricipales de la matriz
	//se llama recursivamente en el metodo "multiplicar"
	public int[][] result(int[][]C11,int[][]C12, int[][]C21,int[][]C22){
		
		//recordemos que las partes son de tamaño n/2*n/2		
		int n = C11.length; //este seria el n/2
		//por eso para armar la matriz result, necesitamos de n*2x*n*2
		int[][] result = new int[n*2][n*2];
		
		//primero vamos por la primera parte C11
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				result[i][j] = C11[i][j];
			}
		}
		//vamos por la primera parte C12
		for(int i = 0; i < n; i++) {
			for(int j = n; j < n*2; j++) {
				result[i][j] = C12[i][j-n];
			}
		}
		//vamos por la primera parte C21
		for(int i = n; i < n*2; i++) {
			for(int j = 0; j < n; j++) {
				result[i][j] = C21[i-n][j];
			}
		}
		//vamos por la primera parte C22
		for(int i = n; i < n*2; i++) {
			for(int j = n; j < n*2; j++) {
				result[i][j] = C22[i-n][j-n];
			}
		}
		
		//lo retornamos
		return result;
	}
	
	
	//los metodos fase1, fase2, fase3, fase4, fase5, fase6
	//son para hallar los S1,S2,S3,S4,S5,S6....S10
	//son solo 6 fases, porque de la S1,...,S10 se repiten tanto
	//las mismas fases para las dos matrices originales,
	//solo hay una fase que es disitinta a la matriz B
	
	//  A11 + A12 <-->  B11 + B12
	public int[][] fase1(int[][] A){
		int n = A.length;
		int[][] result = new int[n/2][n/2];
		for(int i = 0; i < n/2; i++ ) {
			for(int j = 0; j < n/2; j++) {
				result[i][j] = A[i][j] + A[i][j+n/2];
			}
		}
		return result;
	}
	// A21 + A22 <-->  B21 + B22
	public int[][] fase2(int[][]A){
		int n = A.length;
		int[][] result = new int[n/2][n/2];
		for(int i = n/2; i < n; i++) {
			for(int j = 0; j < n/2; j++) {
				result[i-n/2][j] = A[i][j] + A[i][j+n/2];
			}
		}
		return result;
	}
	 
	// A11 + A22  <-->  B11 + B22
	public int[][] fase3(int[][] A){
		int n = A.length;
		int[][] result = new int[n/2][n/2];
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				result[i][j] = A[i][j] + A[i+n/2][j+n/2];
			}
		}
		return result;
	}
	// A12 - A22  <-->  B12 - B22
	public int[][] fase4(int[][] A){
		int n = A.length;
		int[][] result = new int[n/2][n/2];
		for(int i = 0; i < n/2; i++) {
			for(int j = n/2; j < n; j++) {
				result[i][j-n/2] = A[i][j] - A[i+n/2][j];
			}
		}
		return result;
	}
	// A11 - A21  <--> B11 - B21
	public int[][] fase5(int[][] A){
		int n = A.length;
		int[][] result = new int[n/2][n/2];
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				result[i][j] = A[i][j] - A[i + n/2][j];
			}
		}
		return result;
	}
	// B21 - B11  <--> este es la fase que solo se utiliza en la matriz B
	public int[][] fase6(int[][] B){
		int n = B.length;
		int[][] result = new int[n/2][n/2];
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				result[i][j] = B[i + n/2][j] - B[i][j];
			}
		}
		return result;
	}
	
	
	// Cortar A11  <--> Cortar B11
	public int[][] cortar11(int[][] A){
		int n = A.length;
		int[][] result = new int[n/2][n/2];
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				result[i][j] = A[i][j];
			}
		}
		return result;
	}
	// Cortar A22  <-->  Cortar B22
	public int[][] cortar22(int[][] A){
		int n = A.length;
		int[][] result = new int[n/2][n/2];
		for(int i = n/2; i < n; i++) {
			for(int j = n/2; j < n; j++) {
				result[i-n/2][j-n/2] = A[i][j];
			}
		}
		return result;
	}
	// sum matrixsss
	//se suman matriz de manera normal
	public int[][] sumar(int A[][],int B[][]){
		int n = A.length;
		int[][] result = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				result[i][j] = A[i][j] + B[i][j];
			}
		}
		return result;
	}
	// restar matrixsss
	//se restan matriz de manera normal
	public int[][] restar(int A[][],int B[][]){
		int n = A.length;
		int[][] result = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				result[i][j] = A[i][j] - B[i][j];
			}
		}
		return result;
	}
	//imprime las matrices
	public static void print(int A[][]){
		int n = A.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	//crea matrices cuadradas de tamaño especificado,
	//y rango de balores especificado 
	public static int[][] randomMatrix(int n,int a , int b) {
		int[][] matrix = new int[n][n];
		for(int i = 0; i < n; i++ ) {
			for(int j = 0 ; j < n; j++) {
				//tomamos los valores 
				matrix[i][j] = (int)(Math.random()*(b-a)+a);
			}
		}
		return matrix;
	}
	//este es el multiplicar clasico que toma O(n^3)
	public static int[][] clasicoMultiplicar(int[][]A, int[][]B){
		int n = A.length;
		int[][] result = new int[n][n];
		for(int i = 0; i < n;i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n;k++) {
					result[i][j] += A[i][k]*B[k][j]; 
				}
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Strassens r = new Strassens();
		for(int i = 1; i <= 1024; i*=2 ) {
			int[][] m1 = randomMatrix(i,1,1);
			int[][] m2 = randomMatrix(i,1,1);
			
			long start = System.nanoTime();		
			int[][] result = clasicoMultiplicar(m1, m2);			
			long time =  System.nanoTime()	 - start;
			
			long start1 =  System.nanoTime();	
			result = r.multiplicar(m1, m2);
			long time1 =  System.nanoTime() - start1;
			System.out.println(time1 + "     "+ time );
		}
		
	}

}




















