// Go to Window Menu > Preferences > General > Appearance > Colors and Fonts
// then go to Java > Java Editor Text Font > Edit
package listas_enlazadas;


public class Lista {

	Nodo cabeza = null;
	
	public Lista(Nodo nodo){
		cabeza = nodo;
	}
	public void insertar_principio(Libro b){
		Nodo principio = new Nodo(b);
		principio.siguiente=cabeza;
		cabeza = principio;
	}
	public void insertar_al_final(Libro b){
		Nodo puntero = cabeza;
		Nodo al_final = new Nodo(b);
		
		while(puntero.siguiente != null){
			puntero = puntero.siguiente;
		}
		
		puntero.siguiente = al_final;
		al_final.siguiente = null;
	}
	public void insertar_despues(int n, Libro b){
		
		Nodo puntero = cabeza;
		Nodo temporal;
		Nodo en_medio = new Nodo(b);
		if( cabeza == null ){
			cabeza = en_medio;
			en_medio.siguiente = null;
		}else{
			int index = 0; 
			
			while(puntero.siguiente != null && index != n ){
				puntero = puntero.siguiente;
				index++;
			}
			
			//temporal = puntero.siguiente;
			//puntero.siguiente = en_medio;
			//en_medio.siguiente = temporal;
			
			en_medio.siguiente = puntero.siguiente;
			puntero.siguiente = en_medio;
		}
	
	}
		
	public Libro obtener_libro(int n){
		if(cabeza == null){
			return null;
		}else{
			Nodo puntero = cabeza;
			int index = 0;
			while(puntero.siguiente != null && index < n){
				puntero = puntero.siguiente;
				index++;
			}
			//quien llega primero el puntero.siguiente == null o index==n
			//si llega primero puntero.siguiente
			if(index != n){
				return null;
			}else{ //llego primero el index == n
				return  puntero.elemento;
			}
			
		}	
	}
	public int contar(){
		
		if(cabeza == null){
			return 0;
		}else{
			Nodo puntero = cabeza;
			int index = 0;
			while( puntero.siguiente != null  ){
				puntero = puntero.siguiente;
				index++;
			}
			return index;
		}
	}
	public void eliminar_primero(){
		if(cabeza != null){
			Nodo temporal = cabeza;
			cabeza = cabeza.siguiente;
			temporal.siguiente = null;
			//eliminar el temporal
		}
	}
	public boolean esta_vacia(){
		return cabeza == null;
	}
	public void eliminar_final(){
		if(cabeza != null){
			if(cabeza.siguiente == null){
				cabeza = null;
			}else{
				Nodo puntero = cabeza;
				while(puntero.siguiente.siguiente != null){
					puntero = puntero.siguiente;
				}
				Nodo temp = puntero.siguiente;
				puntero.siguiente = null;
				//eliminar temp
			}
		}
	}
	public void eliminarLibro(int n){
		if(cabeza != null){
			if( n == 0 ){
				Nodo temp = cabeza;
				cabeza = cabeza.siguiente;
				temp.siguiente = null;
				
			}else if( n < contar() ){
				Nodo puntero = cabeza;
				int index = 0;
				while( puntero.siguiente != null && index < n-1 ){
					puntero = puntero.siguiente;
					index++;
				}
				if(index == n-1){
					Nodo temp = puntero.siguiente;
					puntero.siguiente = puntero.siguiente.siguiente;
					// eliminar temp
					temp.siguiente = null;
				}else{
					//no podemos eliminar 
				}
			}
		}
		
	}
	public String mostrar(){
		String str= "";
		int i = 0;
		for(Nodo puntero = cabeza; puntero != null; puntero= puntero.siguiente){
			str += "Item "+i+" ==> " + puntero.elemento.toString()+"\n"; 
			i++;
		}
		return str;
	}
	
		
	 
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
