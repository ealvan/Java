package Algoritm_Married;

public class Married_inverse {

	int N;
	
	String mens[];
	String womans[];
	String menPref[][];
	String womanPref[][];
	
	int engagedCount;
	
	boolean womanEngaged[];
	String menPartnert[];
	
	public Married_inverse(String ms[],String ws[], String menP[][], String womanP[][]) {
		mens = ms;
		womans = ws;
		menPref = menP;
		womanPref = womanP;
		
		engagedCount = 0;
		
		N = ms.length;
		womanEngaged = new boolean[N]; 
		menPartnert = new String[N];
		emparejar();
	}
	public void emparejar() {
		while(engagedCount < N) {
			int free;
			for(free = 0; free < N; free++) {
				if(!womanEngaged[free]) {
					break;
				}
			}
			for(int i = 0; i < N && !womanEngaged[free]; i++ ) {
				int indexM = menIndex(womanPref[free][i]);
				if(menPartnert[indexM] == null) {
					menPartnert[indexM] = womans[free];
					womanEngaged[free] = true;
					engagedCount++;
				}else {
					String currentPartnert = menPartnert[indexM];
					if(morePreference(womans[free],currentPartnert,indexM)) {
						menPartnert[indexM] = womans[free];
						womanEngaged[free] = true;
						womanEngaged[womanIndex(currentPartnert)] = false;
					}
				}
			}
		}
		printMarried();
	}
	public void printMarried() {
		String str = "";
		for(int i = 0; i < N; i++) {
			str += menPartnert[i]+"	"+mens[i]+"\n";
		}
		System.out.print(str);
	}
	
	public int menIndex(String str){
		for ( int i = 0; i < N; i++) {
			if(mens[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
	public int womanIndex(String str) {
		for ( int i = 0; i < N; i++) {
			if(womans[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
	public boolean morePreference(String newParnert, String currentPartnert, int indexW) {
		for(int i = 0; i < N; i++) {
			if(menPref[indexW][i].equals(newParnert)) {
				return true;
			}
			if(menPref[indexW][i].equals(currentPartnert)) {
				return false;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Gale Shapley Marriage Algorithm\n");
        /** list of men **/
        String[] m = {"M1", "M2", "M3", "M4", "M5"};
        /** list of women **/
        String[] w = {"W1", "W2", "W3", "W4", "W5"};
 
        /** men preference **/
        String[][] mp = {{"W5", "W2", "W3", "W4", "W1"}, 
                         {"W2", "W5", "W1", "W3", "W4"}, 
                         {"W4", "W3", "W2", "W1", "W5"}, 
                         {"W1", "W2", "W3", "W4", "W5"},
                         {"W5", "W2", "W3", "W4", "W1"}};
        /** women preference **/                      
        String[][] wp = {{"M5", "M3", "M4", "M1", "M2"}, 
                         {"M1", "M2", "M3", "M5", "M4"}, 
                         {"M4", "M5", "M3", "M2", "M1"},
                         {"M5", "M2", "M1", "M4", "M3"}, 
                         {"M2", "M1", "M4", "M3", "M5"}};

        Married_inverse gs = new Married_inverse(m, w, mp, wp);
		
		
		
	}

}
