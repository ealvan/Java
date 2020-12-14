package TopCoder;

public class DivideLoot {


	public String verify(int N, int[] loot) {
		int mean = sum(loot)/N;
		delete(mean,loot);
		for(int i =0; i < loot.length; i++) {
			if(loot[i] != 0) {
				int rest = mean - loot[i];
				int ind = buscar(rest,loot);
				if(ind != -1) {
					loot[ind] = 0;
					loot[i] =0;
				}else {
					return "impossible";
				}	
			}
		}
		for(int j = 0; j < loot.length; j++) {
			if(loot[j] != 0) {
				return "impossible";
			}
		}
		return "possible";
	}
	public int sum(int l[]) {
		int s =0;
		for(int i =0; i < l.length; i++) {
			s+=l[i];
		}
		return s;
	}
	public void delete(int mean, int[]l) {
		for(int i =0 ; i < l.length; i++) {
			if(mean == l[i]) {
				l[i] = 0;
			}
		}
	}
	public int buscar(int e, int[]l) {
		for(int i =0 ; i < l.length; i++) {
			if(l[i] == e) {
				return i;
			}
		}
		return -1;
	}
}
