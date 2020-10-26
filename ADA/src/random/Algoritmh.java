package random;

public class Algoritmh {

	public static void main(String[] args) {
	for(int i = 0; i < 22; i++) {
		int n = n6(i);
		System.out.println(i+"	"+n+ "	"+Math.sqrt(n));
	}
	}
	
public static int n6(int n) {
	int num = 0;
	for(int i = 0; i < n; i++) 
		for(int j = 0; j < n; j++) 
			for(int k = i; k < n;  k++) 
				for(int l = j; l < n; l++) 
					for(int a = i; a <= k; a++) 
						for(int b = j ; b <= l; b++) {
							num++;
						}		
	return num;
}
	public static int n5(int k) {
		int num = 0;
		for(int a = 0; a < k - 5; a++) 
			for(int b = a+1; b < k-4; b++)
				for(int c = b+1; c < k-3; c++)
					for(int d = c+1; d < k-2; d++)
						for(int e = d+1; e < k-1; e++)
							for(int f = e +1; f < k; f++) {
								num++;
							}
		return num;
	}
}
