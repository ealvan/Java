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
	public static int count_f1(int[] S, int n , int i, int[] r) {
		if(r[i] != 10) {
			return r[i];
		}
		
		if(n == 0) {
			return i;
		}else if(n > 0) {
			i++;
		}else {
			return Integer.MAX_VALUE;
		}
		int q = Integer.MAX_VALUE;
		for(int m = 0; m < S.length; m++) {
			q = Math.min(q, count_f1(S, n -S[m], i, r));
		}
		r[i-1] = q;
		return q;
	}
	public static void main(String[] args) {		
		int[] k = {1 , 3 , 4};
		int n = 10;
		int r[] = {10, 10, 10, 10, 10,10,10,10,10,10,10};
		//int m = count(k,0,n,0);
		int m = count_f1(k,n,0,r);
		
		System.out.println(m);
	}
}

