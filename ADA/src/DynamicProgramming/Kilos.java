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
	public static void main(String[] args) {		
		int[] k = {1, 3, 4 };
		int n = 10;
		int m = contar(k,n);
		System.out.println(m);
	}
}


 