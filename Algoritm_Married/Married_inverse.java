package Algoritm_Married;

public class Married_inverse {

	//los integrantes son el numero de parejas
	// si fueran 4 parejas este numero servira tanto para hombres
	//como mujeres
	int integrantes;
	//lista de nombres de los hombres
	String hombres[];
	//lista de nombres de las mujeres
	String mujeres[];
	//lista de prioridad de los hombres
	String h_pref[][];
	//lista de prioridad de las mujeres
	String m_pref[][];
	//almacenara el numero de parejas estables
	int nro_parejas;
	//guardara si una mujer esta casada o no
	boolean mujer_casada[];//por defecto todo false
	//tendra la lista de hombres emparejados 
	//segun el indice(que indica que mujer es)
	String hombre_pareja[];
	
	public Married_inverse(String homs[],String mujs[], String pref_m[][], String pref_h[][]) {
		hombres = homs;
		mujeres = mujs;
		h_pref = pref_h;
		m_pref = pref_m;
		
		nro_parejas = 0;
		
		integrantes = homs.length;
		mujer_casada = new boolean[integrantes]; 
		hombre_pareja = new String[integrantes];
		emparejar();
	}
	public void emparejar() {
		while(nro_parejas < integrantes) {
			int vacio;
			// obtenemos el indice de la mujer que no esta casada
			for(vacio = 0; vacio < integrantes; vacio++) {
				if(!mujer_casada[vacio]) {
					break;
				}
			}
			//ahora vamos a iterar por su lista de prioridad de esa mujer
			//con indice llamado "vacio"
			for(int i = 0; i < integrantes && !mujer_casada[vacio]; i++ ) {
				//obtenemos el indice del hombre de acuerdo a prioridad
				// es decir, del hombre 0 --> N hombres
				int indexH = indexHombre(m_pref[vacio][i]);
				//si no tiene pareja el hombre
				if(hombre_pareja[indexH] == null) {
					//el hombre ya tiene pareja, que es la mujer con index"vacio"
					hombre_pareja[indexH] = mujeres[vacio];
					//marcamos como casada la mujer
					mujer_casada[vacio] = true;
					//ahora ya tenemos una mujer
					nro_parejas++;
				}else {
					//si no esta casado el hombre
					//vamos a buscar cual le conviene al hombre 
					//si la actual o la nueva pretendiente
					//	obteniendo la actual pareja
					String actual = hombre_pareja[indexH];
					//si tiene mayor prioridad la nueva pretendiente
					if(prioridad(mujeres[vacio],actual,indexH)) {
						//entonces que se divorcien
						mujer_casada[indexMujer(actual)] = false;
						// y que se case con la nueva
						hombre_pareja[indexH] = mujeres[vacio];
						//y marcar a la nueva como comprometida
						mujer_casada[vacio] = true;
					}
				}
			}
		}
		
	}
	//imprime las parejas
	public void printMatrimonio() {
		String str = "";
		for(int i = 0; i < integrantes; i++) {
			str += hombres[i]+" --> "+hombre_pareja[i]+"\n";
		}
		System.out.print(str);
	}
	//el indice del Hombre con nombre "nombre"
	public int indexHombre(String nombre){
		for ( int i = 0; i < integrantes; i++) {
			if(hombres[i].equals(nombre)) {
				return i;
			}
		}
		return -1;
	}
	// decide cual es la prioridad del antigua y la nueva pretendiente
	// si la nueva tiene mas prioridad entonces podemos divorciarnos y casarnos
	// votamos True
	// pero si tiene menor prioridad a la actual entonces no cambiamos nada
	// votamos False
	public boolean prioridad(String nueva, String actual, int indexH) {
		int i = 0;
		while(i < integrantes) {
			
			//vemos si la nueva nos conviene 
			if(h_pref[indexH][i].equals(nueva)) {
				//si nos combiene, cambiamos de pareja
				return true;//
			}
			//vemos si la actual nos conviene todavia
			if(h_pref[indexH][i].equals(actual)) {
				//si nos combiene, no cambiamos de pareja
				return false;
			}
			
			//seguir con la siguiente a ver si es una de ellas
			i++;
		}
		
		return false;
	}
	//nos el indice de la mujer con nombre 
	public int indexMujer(String nombre) {
		for ( int i = 0; i < integrantes; i++) {
			if(mujeres[i].equals(nombre)) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		
		System.out.println("Matrimonios: ");
        
        String[] hombres = {"Diego", "Jorge", "Mateo", "Pedro"};
        String[][] pref_h = {{"Julia", "Laura", "Elena", "Paula"}, 
                         	{"Laura", "Paula", "Elena", "Julia"}, 
                         	{"Julia", "Elena", "Paula", "Laura"}, 
                         	{"Elena", "Laura", "Julia", "Paula"}};
        
        
        String[] mujeres = {"Elena", "Laura", "Julia", "Paula"};
 
                              
        String[][] pref_m = {{"Diego", "Mateo", "Jorge", "Pedro"}, 
                         	{"Mateo", "Pedro","Jorge",  "Diego"}, 
                         	{"Jorge", "Mateo", "Pedro", "Diego"},
                         	{"Pedro", "Jorge", "Diego", "Mateo"}};

        Married_inverse matrimonios = new Married_inverse(hombres, mujeres, pref_m,pref_h );
        matrimonios.printMatrimonio();
	}
}
