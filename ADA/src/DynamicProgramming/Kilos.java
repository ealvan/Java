package DynamicProgramming;

import java.util.Arrays;

public class Kilos {

	//S: son los paquetes de los kilos que tiene la tiende
	//n: es la cantidad actual que tiene en la compra(0 al inicio)
	//f: es la cantidad final, el pedido final del cliente
	//i: es la cantidad de paquetes llevados hasta un momento(0 al inicio)
	public static int count(int S[], int n, int f, int i){
		//cuando la cantidad actual sea igual  alpedido final
		if(n == f) {
			//entonces retornamos la cantidad de paquetes usados
			return i;
		}else if (n < f) {
			//si todavia nollegamos al final
			//incrementamos un paquete mas
			i++;
		}else {
			//pero si n > f, entonces nos pasamos del pedido final f
			//entonces ponemos un valor maximo(f+1, porque 
			//si solo hay paquetes de un kilo es la cantidad maxima
			//de paquetes que se puede usar)
			return f+1;
		}
		//maxima cantidad de quetes que se puede hacer
		int q = f+1;
		for(int j = 0; j < S.length; j++) {
			// es ahora cuando vemos todas las combinaciones de paquetes
			//{1,2} y n = 3
			//0 + 1 = 1 
			//0 + 2 = 2 
			//1 + 1 = 2
			//1 + 2 = 3 
			//2 + 1 = 3 
			//2 + 2 = 4
			q = Math.min(q, count(S, S[j] + n, f, i) );
		}
		return q;
	}
	//S: son los paquetes de los kilos que tiene la tiende
	//n: es la cantidad final del pedido del cliente
	//i: cantidad de paquetes pasados minimo
	public static int count_f1(int[] S, int n , int i, int[] r) {
		if(n >= 0 && r[n] == i  ) {
			return r[n];
		}
		//si el n es 0, significa que ya se completo
		//el numero de bolsas que cumplen ese peso
		if(n == 0) {
			//retornamos el nro de paquetes utilizados
			return i;
		}else if(n > 0) {
			//si aun falta completar, aunmentamos un paquete mas
			i++;
		}else {
			//si ya es  negativo, entonces nos psamos del numero de paquete
			//por lo que no debe contar este caso
			return Integer.MAX_VALUE;
		}
		//
		int q = Integer.MAX_VALUE;
		for(int m = 0; m < S.length; m++) {
			//ahora lo hacemos hacia adelante
			//restamos de la cantidad de kilos posible de 
			//la lista
			//n - S[0]
			//n - S[1]
			//.....
			//y elegimos el menor nrp de paquetes
			q = Math.min(q, count_f1(S, n - S[m], i,r));
		}
		r[n] = q;
		return q;
	}
	public static int[] generate(int n) {
		int r[] = new int[n+2];
		for(int i = 0; i <r.length; i++) {
			r[i] = Integer.MAX_VALUE;
		}
		return r;
	}
	public static void main(String[] args) {		
		int[] k ={ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 };
		int n = 360;
		int[] r = generate(360);
		
		System.out.println("Input: ");
		System.out.println(Arrays.toString(k));
		System.out.println(n);
		System.out.println("Output: ");		
		int m = count_f1(k,n,0,r);
		//int m1 = count(k,0,n,0);
		//System.out.println("aux:  "+Arrays.toString(r));
		System.out.println("hacia adelante: "+m);
		//System.out.println("hacia atras   : "+m1);
	}
}

