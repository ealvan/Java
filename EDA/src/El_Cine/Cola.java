package El_Cine;

public class Cola<T> {

	Nodo<T> cabeza;
	Nodo<T> ultimo;
	 
	public Cola( Nodo<T> head){
		this.cabeza = head;
		this.ultimo = head;
	}
	
	public void encolar( T item){
		Nodo<T> nodo = new Nodo<T>(item);
		if( cabeza == null ){
			cabeza = nodo;
			ultimo = nodo;
		}else{
			ultimo.siguiente = nodo;
			ultimo = nodo;
		}
	}
	public void eliminar(){
		
		if( cabeza != null){
			Nodo temp = cabeza;
			cabeza = cabeza.siguiente;
			temp.siguiente = null;
		}
	}
	
	public T consultar(){
		//PROCESAR
		if( cabeza == null){
			return null;
		}else{
			return cabeza.item;
		}
	}	
	public String toString(){
		String str = "";
		int i = 0;
		for(Nodo puntero = cabeza; puntero!= null; puntero = puntero.siguiente){
			str += "item "+i+" ==> "+puntero.item.toString()+"\n";
		}
		return str;
	}
	public static void main(String[] args) {
		
		

	}

}
