package DynamicProgramming;

public class Hamburguesa {
	
	public static int count(int S[], int n, int f, int i){
		//cuando la cantidad actual sea igual  alpedido final
		if(n == f) {
			return i;
		}else if (n < f) {
			i++;
		}else {
			return Integer.MAX_VALUE;
		}
		int q = Integer.MAX_VALUE;
		for(int j = 0; j < S.length; j++) {
			q = Math.min(q, count(S, S[j] + n, f, i) );
		}
		return q;
	}
	public static int burguers(int[] tiempos, int acum, int t, int i) {
		if(acum == t) {
			return i;
		}else if(acum < t){
			i++;
		}else {
			return Integer.MIN_VALUE;
		}
		int q = Integer.MIN_VALUE;
		
		q = Math.max(q, burguers(tiempos,acum+tiempos[0],t,i));
		q = Math.max(q, burguers(tiempos,acum+tiempos[1],t,i));
		return q;
	}
	public static int nro(int m, int n, int t) {
		int[] tiempos = {m,n};
		int j =  burguers(tiempos,0,t,0);
		if(j == Integer.MIN_VALUE) {
			j=-1;
		}
		return j;
	}

	public static void main(String[] args) {
		int nums = nro(3,5,54);
		System.out.println(nums);
		nums = nro(3, 5, 55);
		System.out.println(nums);
		nums = nro(2, 7, 17 );
		System.out.println(nums);
		nums = nro(2, 7, 18);
		System.out.println(nums);
	}

}
