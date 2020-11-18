package Music;

public class Cubo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String t = "↑↓↑↓";
		String k = "↑↓";
		String m = cubo(t, k);
		System.out.print(m);
		
	}
	public static String cubo(String t, String k) {
		int count = 0;
		double maxS = t.length()*0.6;
		if(t.length() == k.length()) {
			for(int i = 0; i < t.length(); i++ ) {
				if(t.charAt(i)==k.charAt(i)) {
					count++;
				}
			}
			if(count >= maxS) {
				return "Suerte";
			}else {
				return "NO";
			}
		}else {
			if(t.length() > k.length()) {
				int n = t.length() - k.length();
				if(n >= maxS) return "NO";
				else {
					cubo(  t.substring(0,k.length())  ,k);
				}
			}else {
				int m = k.length() -t.length();
				if(m >= maxS) {//>=
					return "NO";
				}else {
					cubo(t, k.substring(0,t.length()));
				}
			}
		}
		return "no";
	}
}
