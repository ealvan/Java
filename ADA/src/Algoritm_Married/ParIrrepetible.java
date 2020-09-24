package Algoritm_Married;

import java.util.ArrayList;

public class ParIrrepetible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList<Integer> lista = new ArrayList<Integer>();
	//double m = (double)8/3;
	//System.out.print(esExacto(m));
	//boolean es = esIrrepetible((int)m);
	//System.out.print(es);
	encontrarPares(lista);
	String str = "";
	int i = 0;
	for(int m = 0; m < lista.size()-1; m++) {
		str += lista.get(m+1)+"	"+lista.get(m)+" = "+(double)(lista.get(m+1)/lista.get(m)) +"\n";
		m++;
	}
	//for(Integer key : lista) {
	//	if(i % 2 == 0) {
	//		str += "\n";
	//	}
	//	str += key + "	";
		//	i++;
	//}
	System.out.print(str);
	}

	
	
	public static void encontrarPares(ArrayList<Integer> lista) {
		int otro;
		for(int num = 10000; num <= 99999; num++) {
			if(esIrrepetible(num)) {
				for(int i = 2; i <= 62; i++) {
					otro = num*i;
					if(otro <= 99999 && esIrrepetible(otro)) {
						almacenar(num,otro,lista);
					}else {
						double _otro_ = (double)num/i;
						if(esExacto(_otro_) && _otro_ >=10000 && esIrrepetible((int) _otro_) ) {
							almacenar((int)_otro_,num,lista);
						}
					}
				}
			}
		}
	}
	
	
	public static boolean esIrrepetible(int num) {
		String num_ = String.valueOf(num);
		for(int i = 0; i < num_.length(); i++) {
			char uno = num_.charAt(i);
			for(int j = i+1; j < num_.length();j++) {
				if(uno == num_.charAt(j)) {
					return  false;
				}
			}
		}
		return true;
		
	}
	public static void almacenar(int uno,int otro,ArrayList<Integer> lista) {
		lista.add(uno);
		lista.add(otro);
	}
	public static boolean esExacto(double num) {
		String num_ = String.valueOf(num);
		return num_.endsWith(".0");
	}
	
	
	
	
	
	
	
	
	
}
