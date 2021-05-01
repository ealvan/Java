package TopCoder;
import java.util.Arrays;



public class Piratas {



	public static void main(String[] args) {

		Piratas m = new Piratas();

		int[] cofre=  {40,1,42};

		int N = 2;

		String j= m.verify(N, cofre);

		System.out.print(j);

		//sale imposible la ultima

	}

	

	public String verify(int N, int[] botin) {

		Arrays.sort(botin);

		int left = botin.length  -N;

		int val[]= new int[N];

		for(int i = botin.length -1; i>= left; i--) {

			int pos = botin.length -1 -i;

			pos %= N;

			val[pos] += botin[i];

		}

		for(int i=left-1; i>= 0; i--) {

			int pos = left -1-i;

			pos = N -1-pos;

			val[pos] += botin[i] ;

		}

		for(int i =1; i<N;i++) {

			if(val[i-1] != val[i]) {

				return "imposible";

			}

		}

		return "posible";

	}

}