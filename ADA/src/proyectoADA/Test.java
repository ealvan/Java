package proyectoADA;

import java.util.Arrays;

public class Test {

	public static int[][] gen(int n) {
		int list[][] = new int [n][14];
		for(int i =0; i< list[0].length; i++) {
			list[0][i] = i;
		}
		for(int i = 1; i < n; i++ ) {
			
			list[i] = generateOne(); 
		}
		return list;
	}
	public static int[] generateOne() {
		int[] list = new int[14];
		for(int i =0; i< list.length; i++) {
			list[i] = i;
		}
		int ramindex = (int)Math.floor(Math.random()*15);
		for(int i = 0; i < list.length; i++) {
			if(ramindex > 0 && ramindex < 14) {
				int aux = list[i];
				list[i] = list[ramindex];
				list[ramindex] = aux;
			}
		}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] road1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13};
		int l[][] = gen(100);
		for(int i = 0; i < 100; i++ ) {
			System.out.println(Arrays.toString(l[i]));
		}
	
		
	}

}
