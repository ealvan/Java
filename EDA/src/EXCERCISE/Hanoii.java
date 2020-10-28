package EXCERCISE;
import java.util.*;
public class Hanoii {
    public static void main(String[] args) {
    	//los numeros son al lado de 3A --> 3C, ES EL disco de menor a mayor
    	//3A --> 3C  :  quiere decir el disco 3 de la cilumna A se va a ir a la columna C!!
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Numero de discos: ");
        n = sc.nextInt();
        Hanoi(n,"A","B","C");  //1:origen  2:auxiliar 3:destino
        System.out.println("Cantidad de movimientos : "+(Math.pow(2,n)-1));
    }
public static void Hanoi(int n, String origen,  String auxiliar, String destino){
  if(n==1)
	  
	  System.out.println("°° : " + (n)+" " + origen + " --> " + (n)+" "+ destino);
 
  else{
  
	 Hanoi(n-1, origen, destino, auxiliar);
  
	 System.out.println("°° : "+(n)+ origen + " --> " + (n) +destino);
     
	 Hanoi(n-1, auxiliar, origen, destino);
  }
 
  
  //F(N) = 2F(N-1) + 1  ---> (2 a la n) -1
  
 }
}