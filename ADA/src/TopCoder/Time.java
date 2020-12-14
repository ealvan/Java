package TopCoder;

public class Time {
	
	public String whatTime(int seconds) {
		int s = seconds%60;
		int rest = seconds-s;
		int m = (rest/60)%60;
		int h = (seconds -m*60-s)/3600;
		return h+":"+m+":"+s;
		
	}

	public static void main(String[] args) {
		
		Time m = new Time();
		String str = m.whatTime(86399);
		System.out.print(str);
	}

}
