package Generacidad;
import java.util.*;
public class Lista<T> {
  //private ArrayList<T> lista = new ArrayList<T>(100);
  private ArrayList lista = new ArrayList();
  private int longitud = 0;
 
  public void agregar(T elemento){
	  lista.add(elemento);
	  longitud++;
  }
  public T devolver_por_indice(int n){
	  if( n >= lista.size() || n < 0 ){
		  return null;
	  }else{
		  return (T)lista.get(n);
	  }
  }
  public int devolver_indice(T elemento ){
	  for (int i =0; i < lista.size(); i++){
		  if( Lista.son_iguales(lista.get(i) , elemento ) ){
			return i;
		  }
	  }
	  return -1;
  }
  public T eliminar_porIndice(int n){
	  if(n >= lista.size() || n < 0){
		  return null;
	  }else{
		  longitud--;
		  return (T) lista.remove(n);
	  }  
  }
  public String toString(){
	  String str = "";
	  for(int i = 0; i < lista.size(); i++){
		  str += "item "+i+" ==> "+lista.get(i).toString() +"\n";
	  }
	  return str;
  }
  public static <T> boolean son_iguales(T elemento , T element){
	  return elemento.toString() == element.toString();
  }
  
  public Object mostrarClase(T element){
	  return element.getClass();
  }
  
  
  
}
