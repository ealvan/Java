package hash_folding;

//Método de la mitad del cuadrado
// basicamente trata de dado un entero, darle 
// elevarlo al cuadrado, y sacar la mitad de los numeros de ese cuadrado
//pero hacerlo desde el centro y no de los costados
// asi ,  se hace un codigo hash pseudo aleatorio
public class HashSquare {

	public int funcion_hash(int input){
		//suponemos que es de logitud 1000 la el arreglo
		//para ver mas facil el modulo(seria solo 
		//las tres ultimas casillas su 
		// el modulo)
		return Integer.valueOf(maximo(input))%1000;
	}
	
	//este metodo nos da hasta que punto
	//es factible hacer la iteracion de elevar al cuadrado
	// sacarle la mitad central, y  hacerlo una y otra vez
	//el parametro input es el trabajaremos
	public String maximo(int input){
		//primero hacemos una variable auxiliar
		//que nos servira para partir el input
		// a la mitad
		String input_str = Integer.toString(input);
		//iteramos siete veces, pues considero
		// que ya a la cuarta o quinta, ya habra sobrepasado el Integer.max_Value.
		// y sino, pues igual tendremos algo muy aletorio y grande
		for(int i = 0; i < 7; i++ ){
			//aqui comprobamos siempre
			//que no sobrepase la cantidad de digitos que tiene el integer.max_value
			//por que sino se haran negativo
			//lo multiplicamos por dos pues, casi siempre, al elevar al cuadrado
			//la cantidad de digitos se duplica o a mas.
			if(String.valueOf(input).length()*2 > String.valueOf(Integer.MAX_VALUE ).length() )
				return input_str;
			System.out.println("mitad : "+input);
			//elevamos al cuadrado y lo actualizamos
			input = input*input;
			//convertimos a string, para luego partirlo mas tarde
			input_str = Integer.toString(input);
			System.out.println("cuadrado: "+input);
			//aqui sacamos la mitad central
			input = Integer.valueOf(mitad(input_str));
			//a la siguiente vuelta comprobara si lo "elevariamos" al cuadrado
			//sobrepasaria el numero Integer.max_value
			//y como no podemos elevar al cuadrado(pues corremos el riesgo que nos
			//salga negativo(ya sobrepaso el max_value), trabajamos con los digitos)
			
		}
		return input_str;
	}
	// Este metodo dado un String,que representa un numero
	// nos devuelve la mitad central del string
	public String mitad(String input){
		// si el input es mayor a 4, podemos
		// sacar la mitad, si es menor,solo lo devolvemos
		
		if(input.length() > 4){
			//ahora vemos si el input tiene una cantidad de digitos
			// impar o par
			int n = input.length()%2;
			String resultado = "";
			//si es par, no habra tanto pobrema
			if( n == 0){
				//sacamos de los extremos
				resultado = input.substring(1,input.length() -1);
			}else{
				//si es impar, tenemos que ver 
				//cual es la mitad del numero de digitos
				//el math.ceil lo hace a "piso" y no a "techo"
				int size = (int) Math.ceil(input.length()/2);
				//por eso para que sea techo
				//sumamos uno
				size = size + 1;
				//ahora sacamos desde el caracter 1
				//hasta el size(es size+1, por que no 
				//considera el ultimo caracter)
				resultado = input.substring(1,size+1);
			}
			//retornamos si es menor a 4
			return resultado;
		}
		return input;
	}
	
	
	
	public static void main(String[] args) {
		HashSquare m = new HashSquare();
		int mit = m.funcion_hash(444);
		System.out.print("Codigo hash: "+mit);
	}
}
