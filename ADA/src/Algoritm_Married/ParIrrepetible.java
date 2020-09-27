package Algoritm_Married;

import java.util.ArrayList;

public class ParIrrepetible {

	public static void main(String[] args) {
	//algoritmo del par de numeros de cinco cifras tal que al dividirlos nos devuelve un numero exacto entre 2 y 62
	//primero vamos a crear una lista que almacenara los pares de numeros.
	//int aa = 00101;
	//System.out.println(aa);
	//boolean n = esIrrepetible1(1326);
	//System.out.println(n);
	ArrayList<Integer> lista = new ArrayList<Integer>();
	//encontramos los pares que cumplen la condicion
	encontrarPares(lista);
	//y luego los imprmimos
	String str = "";
	//recorremos el array ....
	for(int m = 0; m < lista.size()-1; m += 2) {
		str += lista.get(m+1)+"	"+lista.get(m)+" = "+(double)(lista.get(m+1)/lista.get(m)) +"\n";
	}
	//mostramos en consola
	System.out.print(str);
	
	
	
	}

	
	// esta funcion hace el trabajo de encontrar pares
	// y los almacena en la lista si cumple la condicion
	public static void encontrarPares(ArrayList<Integer> lista) {
		int otro;
		//primero vamos a recorrer los numero que tenemos de cinco cifras
		for(int num = 1009; num <= 98765; num++) {
			//si es irrepetible, entonces podemos seguir
			if(esIrrepetible1(num)) {
				// ahora vamos a ver que numero le calza para que de un numero entre [2, 62]
				for(int i = 2; i <= 79; i++) {
					//probamos con todos los numeros,multiplicandolos
					otro = num*i;
					//vemos si el numero no pasa del limite establecido y si es irrepetible
					if(otro <= 98765 && esIrrepetible1(otro)) {
						//entonces lo almacenamos
						almacenar(num,otro,lista);
					}else {
						//de lo contrario entonces, puede que su pareja este por debajo de èl
						double _otro_ = (double)num/i;
						// si es un numero exacto y no baje del limite establecido y irrepetible entonces 
						if(esExacto(_otro_) && _otro_ >= 1009 && esIrrepetible1((int) _otro_) ) {
							//lo almacenamos
							almacenar((int)_otro_,num,lista);
						}
					}
				}
			}
		}
	}

	//este metodo no devuelve si el nuemro es irrepetible
		//es decir si algun digito se repite mas de una vez
		public static boolean esIrrepetible1(int num) {
			String num_;
			// primero lo convertimos a string para manipular el numero
			num_ = String.valueOf(num);
			// la mayor parte del tiempo nos encontraremos
			//con numeros como 99abc/88abc/77abc/66abc y  asi sucesivamente
			if(num_.charAt(0) == num_.charAt(1)) {
				return false;
			}
			//pero cuando los digitos son de 0...4
			//debemos rellenarlos con ceros
			//ES MUY IMPORTANTE,PORQUE SINO CONTARIA
			//ESTOS NUMEROS(01230,02310)
			if(num_.length() < 5) {
				int ceros = 5 - num_.length();
				String _ceros_ = "";
				for(int k = 0  ; k < ceros; k++) {
					_ceros_ += "0";
				}
				num_ = _ceros_+num_;
			}
			//recorremos entre los digitos
			for(int i = 0; i < num_.length(); i++) {
				//recuperamos digitos uno por uno
				char uno = num_.charAt(i);
				//vemos si el digito se repite mas de una vez
				for(int j = i+1; j < num_.length();j++) {
					//si es que se usa el diigto mas de una vez
					if(uno == num_.charAt(j)) {
						//entonces no es un numero Irrepetible
						return  false;
					}
				}
			}
			//pero si no encontramos un digito usado mas de una vez
			//entonces si es Irrepetible
			return true;
			
		}
	//este metodo almacena en una "lista" los numeros
	public static void almacenar(int uno,int otro,ArrayList<Integer> lista) {
		lista.add(uno);
		lista.add(otro);
	}
	//este metodo nos dice si el numero es exacto o no
	public static boolean esExacto(double num) {
		//vemos si termina en ".0", pues eso indica que es exacto.
		String num_ = String.valueOf(num);
		return num_.endsWith(".0");
	}
}
