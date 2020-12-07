package TopCoder;

import java.util.Arrays;

public class FakeReportData {

	
	public static int[] generate(int N, int D) {
		if(D==1) {
			int[] m = new int[N];
			for(int i = 1; i < N; i++) {
				m[i-1] = i;
			}
			return m;
		}else {
			int[] ff = new int[N];
			int k = 0;
			for(int j = 0; j <N; j++) {
				String str = "";
				for(int i = 0; i < D; i++) {
					str+=aleat();
				}
				ff[k] = Integer.valueOf(str);
				k++;
			}
			if(!first(ff) && !last(ff)) {
				return ff;
			}else {
				return generate(N,D);
			}
		}
		
	}
	private static boolean first(int[] n) {
		boolean es = false;
		for(int i = 0; i < n.length; i++ ) {
			int m = Integer.valueOf(String.valueOf(n[i]).charAt(0));
			for(int j = 0; j < n.length; j++) {
				if(m == Integer.valueOf(String.valueOf(n[j]).charAt(0))) {
					es = false;
				}else {
					es = true;
				}
			}
		}
		return es;
	}
	private static boolean last(int[] n) {
		boolean es = false;
		for(int i = 0; i < n.length; i++ ) {
			String  str = String.valueOf(n[i]);
			int m = Integer.valueOf(str.charAt(str.length()-1));
			for(int j = 0; j < n.length; j++) {
				String str1 = String.valueOf(n[j]);
				if(m == Integer.valueOf(str1.charAt(str1.length()-1))) {
					es = false;
				}else {
					es = true;
				}
			}
		}
		return es;
	}
	private static int aleat() {
		return (int)Math.floor(Math.random()*9+1);
	}
	

}
