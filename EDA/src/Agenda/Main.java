package Agenda;

import java.util.*;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		boolean primera = true;
		ArrayList<Persona> agenda = new ArrayList<Persona>();
		String nombre,apellido,edad;
		while( true){
			 
			System.out.println("Ingrese nombre: ");
			nombre = sc.next();
			
			System.out.println("Ingrese apellido: ");
			apellido = sc.next();
			
			System.out.println("Ingrese edad :");
			edad = sc.next();
			
			//agenda.add(new Persona(nombre,apellido,edad));
			
			System.out.print("es usted padre?(S/N):");
			String patern = sc.next(); 
			
			if(patern.equals("S")){
				//TIENE HIJOS !!
				//System.out.print("antes de crear padre");
				Padre father = new Padre(nombre,apellido,edad);
				//System.out.print("despues de crear padre");
				agenda.add(father);
				//System.out.print("ya se agrego una persona");
				//listamos a todos
			
				imprimirAgenda(agenda);
				
				System.out.println();
				System.out.println("Esta aqui su hijo?(S/N)");
				String there_child = sc.next();
				if(there_child.equals("N")){
					//INGRESANDO DATOS DEL HIJO !!
					System.out.println("Ingrese nombre: ");
					String nombre1 = sc.next();
					System.out.print("Ingrese su apellido ");
					String apell1 = sc.next();
					System.out.println("Ingrese edad :");
					String edad1 = sc.next();
					Hijo child = new Hijo(nombre1,apell1,edad1);
					agenda.add(child);
					father.setHijo(child);
				
				}else{
					//ESTA AQUI SU HIJO !!
					System.out.print("Indique en que numero esta :");
					int num = sc.nextInt();
					Persona per = (Persona) agenda.get(num);
				
					father.setHijo(new Hijo(per.getNombre(),per.getApellido(),per.getEdad() ));
					//hij.setPadre(father);
				}
			}else{
				//NO TIENE HIJOS !!
				Persona p = new Persona(nombre,apellido,edad); 
				agenda.add(p);
			}
			imprimirAgenda(agenda);
			System.out.println("Su registro de realizo con exito :)");
			System.out.print("Desea agregar a un amigo mas ? (S/N) ");
			String decision = sc.next();
			if(decision.equals("N"))break;
		}
		
	}
	public static void imprimirAgenda(ArrayList<Persona> agenda){
		System.out.println("Listando a los de la agenda");
		String print="";
		for(int i = 0 ; i < agenda.size() ; i++){
			print += i + " ";
			print += agenda.get(i) + "\n";
		}
		System.out.print(print);
	}
	
}
