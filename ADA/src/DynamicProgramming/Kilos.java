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
			return Integer.MAX_VALUE;
		}
		int q = Integer.MAX_VALUE;
		

		for(int j = 0; j < S.length; j++) {
			q = Math.min(q, count(S, S[j] + n, f, i) );
		}
		return q;
	}

	public static void main(String[] args) {		
		int[] k = {1 , 3 , 5 , 7};
		int n = 18;
		int m = count(k,0,n,0);
		System.out.println(m);
	}
}


 