package hash_folding;
//este es el metodo de plegado
//basicamente trata de dada una claves
//agrupamos los caracteres de la clave, segun la cantidad 
//de agrupacion, elegimos el valor del 
//tamaño del grupo en función del tamaño de nuestra matriz
public class Hash {
	
	public int funcion_hash(String input){
		//lo convertimos a array  de caracteres
		char[] chars = input.toCharArray();
		//lo convertimos a codigo ascci los caracteres
		int[] asciis = to_ascii(chars);
		// agrupamos de dos en dos
		String[] concat_numbers = concat_numbers_off(asciis);
		int total=0;
		//los hacemos int cada elemento y los sumamos
		for(int i = 0; i < concat_numbers.length; i++){
			 total += Integer.parseInt(concat_numbers[i]);
		}
		//retornamos el codigo hash
		//es 10(por que es mas facil verificar, solo se sumaria los ulimos digitos
		// y despues sacarle el modulo 10)
		return total%10;
	}
	//lounico que hace es tranformas una lista de caracteres
	//nos devuelve una lista de enteros que representan 
	//el codigo ascii, de cada caracter
	public int[] to_ascii(char[] chars){
		int[] asciis = new int[chars.length];
		for(int i = 0; i < chars.length; i++){
			asciis[i] = (int)(chars[i]);
		}
		return asciis;
	}
	public String[] concat_numbers_off(int[] ascii){
		//indicamos si es par o no
		int n = ascii.length % 2;
		//lo pasamos al metodo copiar
		//este metodo copia si es par, y si no nos devuelve el mismo
		int[]agrupa_future = copiar(ascii,n);
		//System.out.print(agrupa_future.length);
		//este metodo nos devuelve una arreglo de strings
		//ya agrupado todo
		return concat_numbers(agrupa_future);
	}

	//este metodo recibe la lista con los caracteres ya 
	//trandomados a ascii, y un n, que indica si es par o impar
	public int[] copiar(int[] ascii,int n){
		//haremos una copia de la lista ascii, si es que 
		//no es impar
		int[] copia;
		//si es impar
		if(n == 1){
			//creamos la lista
			copia = new int[ascii.length+1];
		}else{
			//de lo contrario, no tenemos nada que hacer(es par)
			return ascii;
		}
		//ahora si es una lista impar
		int i=0;
		//copiamos toda la lista ascii
		for( ; i < ascii.length; i++){
			copia[i] = ascii[i];
		}
		//el ultimo caracter quedara vacio, y por default es u0000
		//aqui lo hacemos explicitamente para entender mejor
		copia[i] = '\u0000';
		//retornamos la copia
		return copia;
	}
	//este metodo lo que haces es concatenar, o tamvien llamado 
	//agrupar,por defecto se asume que el arreglo es de longitud par
	public String[] concat_numbers(int[] asciis){
		//hacemos una lista con la mitad de longitud(es par)
		String[] agrupado = new String[asciis.length/2];
		//ahora esta parte es por que queremos asegurarnos
		//de que la lista enviada tiene el caracter por default que es 'u000'
		//ese ultimo caracter indica que antes la lista fue de longitud impar
		int ultimo = asciis[asciis.length-1];
		//este iterador, va a iterar solo sobre la lista String[]agrupado
		int j =0;
		//este es un for que itera sobre la lista ascii
		//el "i" va de dos en dos, para no concatenar dos veces
		//un mismo caracter
		for(int i = 0;i <= asciis.length - 1 ;){
			//aqui agrupamos, de dos en dos, la lista ascii
			//hasta que no halla mas elementos
			String item = Integer.toString(asciis[i] ) + Integer.toString(asciis[i+1]);
			agrupado[j] = item;
			i++;//estariamos con un caracter duplicado en el item
			i++;//ya no repetira el mismo caracter
			j++;//iterando sobre "agrupado"
		}
		
		imprimir(asciis);
		//despues del for, sabemos que el caracter por default al final
		//se concatenaria como cero(es decir):
		// "1" + 'u000' = "1"+"0" = "10"
		//por lo que debemos eliminar ese caracter ultimo, pues afecta al hashing
		//si es ltimo lo eliminamos
		if(ultimo == 0)
		agrupado[agrupado.length-1] = agrupado[agrupado.length-1].substring(0,agrupado[agrupado.length-1].length()-1);
		imprimir(agrupado);
		//retornamos el agrupado modificado
		return agrupado;
	}
	
	
	//este metodo imprime una lsita de enteros
	public void imprimir(int[] asciis){
		for(int i = 0; i < asciis.length; i++){
			System.out.print((char)(asciis[i])+">-<"+asciis[i]+" ; ");
		}
	}
	//este metodo una lista de string
	public void imprimir(String[] asciis){
		System.out.println( );
		for(int i = 0; i < asciis.length; i++){
			System.out.print("	"+asciis[i]+" ; ");
		}
		System.out.println( );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hash m = new Hash();
		int n = m.funcion_hash("mariposa");
		//el ultimo caracter, es "u000", el que se almacena por default
		//en los caracteres.
		System.out.println("Codigo hash : "+ n);
		
	}

}
