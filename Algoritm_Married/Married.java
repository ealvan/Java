package Algoritm_Married;

public class Married {

	int N;
	String menPref[][];
	String womanPref[][];
	String mens[];
	String womans[];
	String womanParnert[];
	boolean menEngaged[];
	int engagedCount;
	
	public Married(String mens[],String womans[], String menP[][], String womPref[][] ) {
		N = mens.length;//<--
		menPref = menP;
		womanPref = womPref;
		this.mens = mens;
		this.womans = womans;
		womanParnert = new String[N];
		menEngaged = new boolean[N];
		engagedCount = 0;
		emparejar();
	}
	private void emparejar() {
		while(engagedCount < N) {
			int free;
			for (free = 0; free < N; free++) {
				if(!menEngaged[free]) {
					break;
				}
			}
			for (int i = 0; i < N && !menEngaged[free]; i++) {
				int index = womanIndex(menPref[free][i]);
				if(womanParnert[index] == null) {
					womanParnert[index] = mens[free];
					menEngaged[free] = true;
					engagedCount++;
				}else {
					String currentParnert = womanParnert[index];
					if(morePreference(mens[free],currentParnert, index)) {
						womanParnert[index] = mens[free];
						menEngaged[free] = true;
						menEngaged[menIndex(currentParnert)] = false;
					}
				}
			}
		}
		printMarried();
	}
	public boolean morePreference(String newPartnert, String currentParnert, int index ) {
		for(int i = 0; i < N; i++) {
			if(womanPref[index][i].equals(newPartnert)) {
				return true;
			}
			if (womanPref[index][i].equals(currentParnert)){
				return false;
			}
		}
		return false;
	}
	
	
	private int womanIndex(String str) {
		for(int i = 0; i < N; i++) {
			if(womans[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
	private int menIndex(String str) {
		for(int i = 0; i < N; i++) {
			if(mens[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
	public void printMarried(){
		String str = "";
		for(int i = 0; i < N; i++) {
			str += womans[i]+"	"+womanParnert[i] + "\n";
		}
		System.out.print(str);
		
	}
	
	
	
	
	public static void main(String[] args) {
		
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

        Married gs = new Married(m, w, mp, wp); 
	}

}
