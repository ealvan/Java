package TopCoder;

public class BinaryCode {
	
	public String[] decode(String message) {
		String[] r = new String[2];
		r[0] = decode1(message,0);
		r[1] = decode1(message,1);
		return r;
	}
	public String  decode1(String message,int cas) {
		
		int[] p = new int[message.length()];
		int init = cas;
		p[0] = cas;
		p[1] = Integer.parseInt(String.valueOf(message.charAt(0))) - init;
		if(!(p[1] == 0 || p[1] == 1)) {
			return "NONE";
		} 
		int i = 1;
		for(i = 1; i <= message.length()-2; i++) {
			int sum = p[i]+p[i-1];
			int r = Integer.parseInt(String.valueOf(message.charAt(i))) - sum;
			if(r == 0 || r==1) {
				p[i+1] = r;
			}else {
				return"NONE";
			}	
		}
		int fin = Integer.parseInt(String.valueOf(message.charAt(i)))-(p[p.length-1]+p[p.length-2]);
		if( fin !=0) {
			return "NONE";
		} 
		String str = "";
		for( int j = 0; j < p.length;j++) {
			str+=p[j];
		}
		return str;
	}
	
	public static void main(String[] args) {
		BinaryCode m = new BinaryCode();
		String str = m.decode1("12221112222221112221111111112221111", 1);
		System.out.print(str);
	}
}
