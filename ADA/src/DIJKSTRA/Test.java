package DIJKSTRA;
import java.io.File; 
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Iterator;
public class Test {

	public static void main(String[] args) {
		Grafo grf = new Grafo(100);
		try{
			String fileName = "C:/Users/Toshiba/Desktop/codigo_user.txt";
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int i = 1;
			while((line = br.readLine()) != null){
			    if(i < 10){
			    	line = line.substring(2,line.length());
			    }else if(i < 100){
			    	line = line.substring(3,line.length());
			    }else{
			    	line = line.substring(4,line.length());
			    }
			    grf.insertarUsuario(line, i);
			    i++;
			}
			fr.close();
		}catch(Exception e){
			System.out.print("no encontro el archivo1");
		} 
		try{
			
			String fileName = "C:/Users/Toshiba/Desktop/relacion.txt";
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			String c1 = "";
			String c2 = "";
		
			int c1_i =0;
			int c2_i =0;
			while((line = br.readLine()) != null){
				c1 = line.substring(0,line.indexOf('$'));
				c1_i = Integer.valueOf(c1);
				c2 = line.substring(line.indexOf('$')+1,line.length()); 
				c2_i = Integer.valueOf(c2);
			   grf.relacion(c1_i, c2_i,1);
			   grf.relacion(c2_i, c1_i,1);
			    
			}
			fr.close();
		}catch(Exception e){
			System.out.print("no encontro el archivo2");
		}
		System.out.println("****PRIMER NIVEL*****");
		grf.printLevel(100, 1);
		System.out.println("****SEGUNDO NIVEL*****");
		grf.printLevel(100,2 );
		System.out.println("****TERCER NIVEL*****");
		grf.printLevel(100, 3);
		System.out.println("****CUARTO NIVEL*****");
		grf.printLevel(100, 4);
		System.out.println("****QUINTO NIVEL*****");
		grf.printLevel(100, 5);
		System.out.println("****SEXTO NIVEL*****");
		grf.printLevel(100, 6);
		
	}

}
