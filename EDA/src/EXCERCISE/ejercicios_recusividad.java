package EXCERCISE;


public class ejercicios_recusividad {
	public static void main(String[] args) {
		//EL HANOII ESTA EN HANOII.JAVA
	System.out.println("REVERSION !!");
	System.out.println(revertir("123456789",8));
	System.out.println("FACTORIAL !!");
	System.out.println(factorial(5));
	int lista[] = {1,2,3,4,5,6};
	System.out.println("SUMAR LISTA !!");
	System.out.println(sumar_lista(lista,lista.length-1) );
	}
	 // Print n in base 10, recursively.
	 // Precondition: n >= 0.
	 public static void printDecimal( long n ){
		 if( n >= 10 )
			printDecimal( n / 10 );
		 	System.out.print( (char) ('0' + ( n % 10 ) ) );
	 }
	 public static String revertir(String str , int n){
		 // n = str.length(9) -1	 
 
		 if( n == 0){ 
			 return String.valueOf(str.charAt(0));
		 }else{
			return String.valueOf(str.charAt(n) ) + revertir(str, n-1);
		 }
		 // THIRD RULE : " YOU GOTTA BELIEVE!! :)"
	 }
	
	 
	 
	 public static int sumar_lista(int lista[],int n){
		 // n = lista.length - 1;
		 if(n == 0){
			 return lista[0];
			 //FIRST RULE : "CASE BASIS !! :) "
		 }else{
			 return lista[n] + sumar_lista(lista,n-1);
		 }
		 
	 }

	 
	 public static int factorial(int n){
		 if(n == 0){
			 return 1;
		 }else{
			 return n * factorial(n-1);
		 }
	 }
	 public int sumarRecursiva(int numero) {
		 if (numero == 1) {
		 return 1;
		 } else {
		 return numero + sumarRecursiva(numero - 1);
		 }
	 }
	 
}
