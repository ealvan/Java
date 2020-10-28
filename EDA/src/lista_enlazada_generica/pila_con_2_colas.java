package lista_enlazada_generica;

public class pila_con_2_colas<T> {
	//PILA CON 2 COLAS:
	//iplementamos dos colas
	Cola<T> cola_left = new Cola<T>( );
	Cola<T> cola_right = new Cola<T>( );
	int longitud = 0;
	//este elemento eliminara la ultima cabeza de la pila
	//la cola left tendra los elemeentos que se eliminaran
	public T pop(){
		//si la cola left es esta vacia, pues no hay nada que eliminar
		if(cola_left.cabeza == null){
			return null; //esta vacia
		}else{
			longitud--;//disminuyendo
			//de los contrario si hay algo que eliminar
			return (T)cola_left.eliminar().elemento;	
		}
	}
	//este colocara un nuevo elemento encima de los demás
	public void push(T elemento){
		//vamos a encolar todos los datos a la cola de left
		//pero solo si esta vacia
		if(cola_left.cabeza == null){
			//encolando ...
			cola_left.encolar(elemento);
		}else{
			//pero si esta llena la cola left, pues vamos a pasar 
			//todos los elemento de la cola left a la cola right
			for(int i = cola_left.longitud; i > 0; i--){
				//pasando elementos ...
				cola_right.encolar((T)cola_left.eliminar().elemento);
			}
			//ahora podemos encolar el nuevo elemento, pues ya esta vacia la cola left
			cola_left.encolar(elemento);
			//ahora volvemos a meter todos los datos de la cola right a la cola left
			for(int i = cola_right.longitud; i > 0; i--){
				//pasando los elementos ...
				cola_left.encolar((T)cola_right.eliminar().elemento);
			}
			this.longitud++;
		}
	}
	public String mostrar(){
		//String str = "";
		return cola_left.mostrar() + "\n";
		
	}
	 
	public static void main(String[] args) {
	    //si se comporta como una pila ... :)
		pila_con_2_colas<String> pila = new pila_con_2_colas<String>();
		pila.push("c");
		pila.push("c1");
		pila.push("c2");
		pila.push("c3");
		pila.push("c4");
		pila.push("c5");
		System.out.print(pila.mostrar());
		System.out.println("Longitud: "+pila.longitud);
		System.out.println("Elemento eliminado : "+pila.pop());
		System.out.println("Elemento eliminado : "+pila.pop());
		System.out.print(pila.mostrar());
		System.out.println("Longitud: "+pila.longitud);
	}
}
