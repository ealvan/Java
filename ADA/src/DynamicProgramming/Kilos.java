package DynamicProgramming;

public class Kilos {
	public static int contar(int[]k, int n) {
		if(n == 0) {
			return 1;
		}
		if(n < 0) {
			return 0;
		}
		int q = 0;
		for(int i = k.length-1; i >=0 ; i--) {
			q += Math.max(q, contar(k, n - k[i]));
		}
		return q;		
	}
	public static int count(int S[], int n, int f, int i){
		if(n == f) {
			return i;
		}else if (n < f) {
			i++;
		}else {
			return 1000;
		}
		int q = Integer.MAX_VALUE;
		int aux = Integer.MAX_VALUE;

		for(int j = 0; j < S.length; j++) {
			q = S[j] + n;
			q = Math.min(aux, count(S,q,f,i));
			aux = q;
		}
		return q;
	}

	public static void main(String[] args) {		
		int[] k = {1, 2,3,4,5,6,7,8,9};
		int n = 2;
		int m = count(k,0,n,0);
		System.out.println(m);
	}
}


 