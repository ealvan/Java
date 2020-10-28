package LupDescomposition;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Lup {

	public static void main(String[] args) {
		//matriz original, la cual se hara la descomposicion
		double arr[][] = {
				{ 2 ,0 ,2  , 0.6},
				{ 3 ,3 ,4  ,-2},
				{ 5 ,5 ,4  ,2},
				{ -1,-2,3.4,-1}
		};
		//esta es la matriz de permutacion 
		double matriz_permutacion[][] = {
				{0,0,1,0},
				{1,0,0,0},
				{0,0,0,1},
				{0,1,0,0}
		};
		//descomposition(arr);
		System.out.println("*********Matriz Original*******");
		print(arr);
		//descomponemos la matriz original en "L" y "U"
		descomposition(arr);
		double[][][] m = cortar(arr);
		//Matriz U, superior
		System.out.println("*********Matriz Superior \"U\" *******");
		print(m[0]);
		//Matriz L, inferior
		System.out.println("*********Matriz Inferior \"L\" *******");
		print(m[1]);
		//Multiplicacion de L*U
		System.out.println("*********Matriz LU*******");
		double[][]result = multiplicar(m[1],m[0]);
		print(result);
		//Multiplicacion de P*A
		System.out.println("***********Matriz PA****************");
		print(multiplicar(arr,matriz_permutacion));	
	}
//imprime la matriz
public static void print(double[][] arr) {
	for(int i = 0; i < arr.length; i++) {
		for(int j = 0; j < arr[i].length; j++) {
			System.out.print(redondear(arr[i][j],1)+"   ");
		}
		System.out.println();
	}
}
//redondearm redondea los decimale que son continuos(ejm: 3,444445)
private static double redondear(double valor, int decim) {
	//si los lugares son <0 entonces lanzamos una exception
    if (decim < 0) throw new IllegalArgumentException();
    // luego creamos un Bigdecimal que recibe el valor
    BigDecimal bd = new BigDecimal(Double.toString(valor));
    //luego lo formatea a un decimal
    bd = bd.setScale(decim, RoundingMode.HALF_UP);
    //luego lo devuelve
    return bd.doubleValue();
}
//cortar, recibe una matriz, y nos devuelve
//La matriz inferior y la Matriz superior que conforma la matriz original
public static double[][][] cortar(double[][] arr) {
	//creamos los onjetos que contendran las dos matrices
	double[][] superior = new double[arr.length][arr[0].length];
	double[][] inferior = new double[arr.length][arr[0].length];
	//Empezamos por la matriz superior
	for(int i = 0; i < arr.length; i++) {
		//ahora se recorrera de esta manera
		//0 1 2
		//  1 2
		//    2
		for(int j = i ; j < arr.length; j++) {
			// luego se asigna
			superior[i][j] = arr[i][j];
		}		
	}
	//Cortamos la matriz inferior
	for(int k = 0; k < arr.length; k++) {
		//ahora recorremos la otra parte
		for(int j = 0; j <= k; j++) {
			//si es una posicion de la diagonal principal
			if(j == k) {
				//entonces es 1
				inferior[k][j] = 1;
			}else
			//en otro caso, lo copiamos a la nueva matriz
			inferior[k][j] = arr[k][j];
		}
	}
	//ahora los empaquetamos las matrices
	double[][][] m = {superior,inferior};
	//las devolvemos
	return m;
}
// esto multiplica las matrices A y B
public static double[][] multiplicar(double[][] A, double[][] B){
	// ahora creamos result que almacena el resultado
	double[][] result = new double[A.length][B.length];
	// ahora recorremos la matriz A o B, son de igaul tamaño
	for(int i = 0; i < A.length; i++) {
		//ahora recorremos las columnas
		for(int j = 0; j < A.length; j++) {
			//este sera el inidce que controla la multiplicacion
			for(int k =0; k < B.length; k++) {
				//almacena en el indice, la suma de la fila*columna 
				result[i][j] += A[i][k]*B[k][j];
			}				
		}
	}
	//retornar la matriz
	return result;
}
//esto transforma la matriz "arr" en las matriz 
//que luego la cortaremos en la matriz L y U 
public static void descomposition(double[][] arr) {
	//filas, el array es cuadrado
	double[] pi = new double[arr.length];
	//primero hacemos un indicador que va de [0,1,2,3,...,n]
	for(int i = 0; i < pi.length;i++) {
		pi[i] = i;
	}
	//hacemos un K_prima,
	int k_prima = 0;
	//vamos a recorrer la columna debajo del pivote
	//ejm:
	//0 0
	//1 0 
	//2 0 
	//3 0 
	for(int k = 0; k < pi.length;k++) {
		// que nos servira para 
		//encontrar el valor ams grande dentro de las columnas
		double p =0;
		for(int i = k; i < pi.length; i++) {
			//verificamos con esto que obtenemos el mayor
			//pivote
			if(Math.abs(arr[i][k]) > p) {
				//actualizqamos p, hasta obtener el mayor pivote
				p = Math.abs(arr[i][k]);
				//se almacena el indice de la fila i,
				//donde se encontro el pivote
				k_prima=i;
			}
		}
		//si hacemos todo este proceso, y aun asi el p es 0
		//significa que p nunca se actualizo,
		//o que todas los valores fueron cero
		if(p == 0) {
			//lanzamos una exception
			throw new RuntimeException("no se puede dividir entre cero");
		}
		//ahora empezamos a cambiar el indice que almacena
		//en que fila se encuentra el pivote
		double aux = pi[k_prima];
		pi[k_prima] = pi[k];
		pi[k] = aux;
		//si el pivote estuviera en la 1, entonces:
		//indicadores:  0 1 2 3
		//pivote	 : 	1 0 2 3
		//ahora que sabemos el indicador de fila del pivote
		//lo unico que hacemos es utilizarlo, para cambiar la 
		//fila completa que contiene el pivote
		for(int i = 0; i < pi.length; i++) {
			double aux_ = arr[k_prima][i];
			arr[k_prima][i] = arr[k][i];
			arr[k][i] = aux_;
		}
		//ahora que ya movimos la fila completa, entonces
		//hacemos las operaciones
		//el index "i" es igual a "k+1", porque tenemos que comenzar
		//en la siguiente columna para obtener los valores a partir de alli
		for(int i = k+1; i < pi.length; i++) {
			//primero obtenemos su division entre
			//(todos los valores abajo del pivote)/(pivote)
			arr[i][k] = arr[i][k]/arr[k][k];
			//ahora restamos los valores de adentro, A(adentro)
			// P _ _ _
			// _ A A A
			// _ A A A
			// _ A A A
			for(int j = k+1; j < pi.length; j++) {
				// empezamos k+1, para adelantar la fila en el que
				//estamos actualmente
				arr[i][j] = arr[i][j] - arr[i][k]*arr[k][j];
			}
		}
	}
}
}
