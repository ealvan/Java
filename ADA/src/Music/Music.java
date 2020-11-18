package Music;

import java.util.Arrays;

public class Music {

	//es para imprimir la lista
	public static void print_(String[] list) {
		String str = "";
		for(int i = 0; i < list.length; i++) {
			if(i % 6 == 0) {
				str+="\n";
			}
			str += list[i]+" ";
		}
		System.out.println(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int m = "1.mp4".compareTo("10.mp4");
		//String music[] = {"1.mp4","2.mp4","4.mp4","3.mp4","5.mp4"};
		
		
		String[] list = generate(109);
		list = mergeSort(list);		
		print_(list);

	}
	//genera la lista ordenada numericamente
	public static String[] generate(int n) {
		String[] list = new String[n];
		for(int i =0; i < n;i++) {
			int a = i+1;
			list[i] = a +".mp4";
		}
		return list;
	}
	public static String[] mergeSort(String arr[]) {
		
		if(arr.length <= 1) {
			
			return arr;
		}
		
		String izq[] = new String[arr.length/2];
		
		String dere[] = new String[arr.length-arr.length/2];
		
		String  _result_[] = new String[izq.length+dere.length];
	
		int mitad = arr.length/2;
		
		//llenando la lista hasta mitad - 1
		//0 .... mitad - 1
		for(int i = 0; i < mitad; i++) {
			izq[i] = arr[i];
		}
		//mitad ...... arr.length
		for(int i = mitad; i < arr.length; i++) {
			dere[i - mitad] = arr[i];
		}
	
		izq = mergeSort(izq);
		dere = mergeSort(dere);
	
		if (izq[izq.length - 1 ].compareTo(dere[0]) < 0) {
	 		
			for(int i = 0; i < _result_.length; i++) {
				if(i < izq.length) {
					_result_[i] = izq[i];
				}else {
					_result_[i] = dere[i-mitad];
				}
			}
			
			return _result_;
		}
		//pero si es que esto no se cumple significa que no estan ordenados entre si
		//por lo que necesitamos ordenarlos y UNIRLOS
		_result_ = union(izq,dere);
		return _result_;
	}
	//este metodo recibe dos array desordenados entre si
	//los ordena, y despues los une en un array y lo retorna
	public static String[] union(String izq[],String dere[]) {
		
		String[] result=new String[dere.length+izq.length];
		
		int i = 0;
		
		while(izq.length > 0 && dere.length > 0) {
			
	 		if( izq[0].compareTo(dere[0]) < 0) {
				
				result[i] = izq[0];
				
				izq = restar(izq);
			}else{
				
				result[i] = dere[0];
				
				dere = restar(dere);
			}
	 		
			i++;
		}
		
		if(izq.length > 0) {
			
			result = agregar(izq,result);
		}
		
		if(dere.length > 0) {
			
			result = agregar(dere,result);
		}
		return result;
	}
	
	public static String[] restar(String [] list) {
		String []_list_ = new String[list.length-1];
		for(int i = 1; i < list.length; i++) {
			_list_[i-1] = list[i];  
		}
	
		return _list_;
	}
 
	public static String[] agregar(String list_min[], String result[] ) {
		int i= 0;
		
		for(; i < result.length; i++) {
			if(result[i] == null) {
				break;
			}
		}
		
		for(int j = i; j < result.length; j++ ) {
			result[j] = list_min[j-i]; 
		}
		
		return result;
	}
}
