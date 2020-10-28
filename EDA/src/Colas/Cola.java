package Colas;

public class Cola {

	Nodo cabeza;
	Nodo ultimo;
	/*public Cola(Nodo cabeza){
		this.cabeza = cabeza;
	}*/
	
	//meter algo al final de una cola
	public void encolar(Object elemento){
		Nodo al_final = new Nodo(elemento);
		if(cabeza == null){
			cabeza = al_final;
			//ultimo = al_final;
		}else{
			ultimo.siguiente = al_final;
			//ultimo = al_final;
		}
		ultimo = al_final;
	}
	
	public void eliminar(){
		if(cabeza != null){
			Nodo temp = cabeza;
			cabeza = cabeza.siguiente;
			temp.siguiente = null;
			if( cabeza == null){
				ultimo = null;
			}
		}else{
			System.out.print("Esta vacia !!!");
		}
		
	}
	
	public Object consultar(){
		if( cabeza == null){
			return null;
		}else{
			return cabeza.elemento;
		}
	}
	
	public boolean esta_vacio(){
		return cabeza == ultimo;
	}
	
	public Object despachar(){
		Object consultado = this.consultar();
		this.eliminar();
		return consultado;
	}
	public String toString(){
		String str="" ;
		Nodo puntero = cabeza;
		int index = 0 ;
		while(puntero != null){
			str += "Object ==>" + puntero.elemento.toString()+"  ";
			puntero = puntero.siguiente;
		}
		return str;
	}

	
	public static void main(String[] args) {
		Nodo cabeza = new Nodo(new String("hola"));
		Cola mi_cola = new Cola();
		//mi_cola.eliminar();//aqui elimina a su cabeza
		//mi_cola.eliminar();// aqui se dacuenta que ya no hay cola
		mi_cola.encolar(new String("aaaaa"));//este seria mi cabeza
		mi_cola.encolar(new String("hola papu"));//este esta al final
		mi_cola.encolar(new String("hola papa"));//este esta al final
		mi_cola.encolar(new String("hola papi"));//este esta al final
		mi_cola.encolar(new String("hola papo"));//este esta al final
		Object despachado = mi_cola.despachar();
		//System.out.print(mi_cola.consultar()+"    " );
		//System.out.print(mi_cola.despachar());
		System.out.println(mi_cola);
		String m = (String)despachado;
		System.out.print(m.substring(0,2));
		

	}

}
