package lista_enlazada_generica;

public class Lista<T extends Comparable> {

	Nodo<T> cabeza = null;
	int longitud = 0;
	public Lista(){}
	public Lista(Nodo<T> cabeza){
		this.cabeza = cabeza;
		this.longitud++;
	} 
	public Lista ordenar_lista(){
		//PRIMERO: hacemos una lista estatica en la que pasamos los elemento de la lista
		//enlazada
		//ya que resultaria dificil hacerla en la misma lista enlazada :(
		int i = 0;//iteramos la lista creada
		Nodo[] lista_ordenada = new Nodo[this.longitud];//creando esa lista 
		//con igual nuemro de elemento que la lista enlazada
		//iteramos .....
		for(Nodo puntero = cabeza; puntero != null; puntero = puntero.siguiente){
			//esto lo hago, porque el nodo es una direccion de menoria, por lo que
			//cuando solo pasaba el puntero
			//(lista_ordenada[i] = puntero)
			//en la lista, estaria alterando la lista enlazada
			//y cuando hago eso pasan cosas raras :(
			//pero si copiamos los nodos, no va a pasar nada pues son otras direcciones de
			//memoria :)  :
			Nodo m = new Nodo(puntero.elemento);//copiando
			lista_ordenada[i] = m;//poniendo el copiado
			i++;//iteramos ..
		}
		//ahora tenemos una lista llena de nodos copiados
		// voy a hacer el ordenamiento burbuja
		int n = this.longitud;
		// en la vuelta uno se comparan los elementos adyacentes,realizando elementos
		//andyacentes, el j con j+1 se comparan, al final ya tenemos al final el elemento mayor
		//en la vuelta 2, ya tenemos el antepenultimo en la posicion antepenultima 
		//los elementos deben tener implementado la clase Comparable, para poder compraralos
		//y deben ser del mismo tipo, por que no se puede comparar un double con u String
		for( int ii = 0; ii < n - 1; ii++ ){//es ii,por que ya utlice i en el anterior bucle
			for(int j = 0; j < n-ii-1; j++ ){
				if( ((Comparable) lista_ordenada[j].elemento).compareTo(lista_ordenada[j+1].elemento) > 0 ){
					//intercambiando  .... 
					Nodo temp = lista_ordenada[j];
					lista_ordenada[j] = lista_ordenada[j+1];
					lista_ordenada[j+1] = temp;
				}
			}
		}
		//creando una lista nueva
		Lista nueva_ordenada = new Lista(lista_ordenada[0]);//mi constructyor necesita 
		//un Nodo cabeza
		for(int k = 1; k < n; k++){//iteramos desde el item1, pues el 0 es la cabeza
			nueva_ordenada.insertar_alFinal( (T) (lista_ordenada[k].elemento));
			//insertar al final los elemento de la lista estatica
		}
		return nueva_ordenada; //devolvemos esta lista
	}
	
	public void inserta_alPrincipio(T elemento){
		Nodo<T> nodo_inicio = new Nodo<T>(elemento);
		nodo_inicio.siguiente = cabeza;
		cabeza = nodo_inicio;
		this.longitud++;
	}
	public void insertar_alFinal(T elemento){
		Nodo<T> al_final = new Nodo<T>(elemento);
		if(cabeza == null){//LA cabeza esta vacia :)
			cabeza = al_final;
		}else{
			Nodo puntero = cabeza;//agarramos un puntero, que recorrera la lista
			while(puntero.siguiente != null){//cuando encontremos el untilmo elemento
				puntero = puntero.siguiente;
			}
			//si o si existe el ultimo elemento
			puntero.siguiente = al_final;
		}
		this.longitud++;//aumentar longitud
	}
	public Nodo eliminar_cabeza(){
		if(cabeza == null){//esta vacia
			//System.err.println("no hay nada en la lista");
			return null;
		}else{
			Nodo<T> temp = cabeza;//almacenamos la cabeza en un nodo temporal
			cabeza = cabeza.siguiente;//actualizamos la cabeza
			temp.siguiente = null;//hacemos que ya no haiga la anterior cabeza enlazada
			this.longitud--;//cumplimos en eliminar con exito, asi que disminuimos
			return temp;
		}
		
	}
	public void eliminar_final(){
		if(cabeza == null){//lista vacia
			System.out.println("No hay nada en la lista");
		}else{
			//para eliminar el ultimo, necesitamos saber el antepenultimo
			//pero si no existe el antepoenultimo, es decir que solo tenga un elemento
			if(longitud == 1){
				cabeza = null;//eliminamos el ultimo
			}else{
				Nodo<T> puntero = cabeza;
				// caja --> caja --> null
				// para eliminar el ultimo elemento de una lista se necesita conocer
				// el antepenultimo
				while(puntero.siguiente.siguiente != null){
					puntero = puntero.siguiente;
				}
				// caja --> caja --> null
				// caja --> null
				// actualizando el ultimo
				puntero.siguiente = null;
			}
			// bajando el numero de items
			this.longitud--;
		}
	}
	public void eliminar_por_indice(int n){
		
		if(cabeza == null){
			//esta vacia
			System.err.println("esta vacia");
		}else{
			if( n >= this.longitud || n < 0){
				//si el n no esta en los indices permitidos, no hacemos nada
				System.err.println("no existe este indice");
			}else{
				Nodo puntero = cabeza;
				int index = 0;//ese index hara de indice, para encpntrar un elemento
							  //y para eliminar el N, necesitamos el N-1
				while(puntero != null && index < (n-1)){
					//el index llega hasta el anterior del elemento N,osea N-1
					puntero = puntero.siguiente;
					index++;
				}
				// hay dos condiciones en el while, puede que llegue al final y 
				// no encontrar el N-1
				// O puede que encuentre el N-1, antes de que se acabe la lista
				if(index == (n-1)){//esta condicion me asegura que si se encontro
					Nodo temp = puntero.siguiente;//almacenamos el nodo N
					//ahora actualizamos en nodo N
					puntero.siguiente = puntero.siguiente.siguiente;
					// el valor almacenado le quitamos su enlace, para que no 
					// haiga elementos sueltos por alli
					temp.siguiente = null;
					//disminuimos la longitud
					this.longitud--;
				}else{
					//significa que se cumplio el puntero != null
					//por lo que llego al final de la lista y no se encontro tal indice
					System.err.print("no existe el item");
				}
			}
		}
	}
	public boolean eliminar_objeto(T elemento){
		boolean encontrar = false;//asumimos que aun no se encontro
		Nodo puntero = cabeza;//agarramos la cabeza, y la iteramos en la lista
		Nodo anterior = null;//nos dira el anterior inmediato del puntero
		//Mientras no llegamos al final de la lista y no se haiga encontrado la lista
		while(puntero != null && !(encontrar)){
			//si no se ha encontrado
			if(!encontrar){
				//pasamos al siguiente nodo
				puntero = puntero.siguiente;
				//pero este presente puntero lo almacenamos
				//, por que puede que a la siguiente sea el encontrado
				anterior = puntero;
			}
		}
		
		if(encontrar){//se ha encontrado if(encontrado) y aun no se termino la lista
			if(puntero == cabeza){//si el puntero aun esta en la cabeza
				Nodo temp = puntero;//almacenamos el nodo original que ocupa la cabeza
				puntero = puntero.siguiente;//actualizamos la cabeza
				temp.siguiente = null;//desenlazamos el elemento original
			}else{
				Nodo temp = anterior.siguiente;//el anterior nos sirve para actualizar
				// y hacer un puente entre el anterior y el posterior del elemento eliminado
			    anterior.siguiente = puntero.siguiente;
			    temp.siguiente = null;//descenlazamos el original
			}
			this.longitud--;//disminuimos la cantidad
		}
		puntero = null;//eliminamos el puntero
		return encontrar;//nos informa si se logro eliminar(TRUE) o no se pudo(FALSE)
	}
	///////////////////////////////////////////////////////////////////////
	public boolean estaVacia(){
		return cabeza == null;
	}
	
	public String mostrar(){
		String str= "";
		int i = 0;
		for(Nodo puntero = cabeza; puntero != null; puntero= puntero.siguiente){
			str += "Item "+i+" ==> " + puntero.elemento.toString()+"  "; 
			i++;
		}
		return str;
	}
	public T obtener_item(int n){
		 
		if( cabeza == null){//esta vacia
			System.err.print(" esta vacia");
			return null;
		}else{
			//si se desborda no hacemos nada
			if(n >= this.longitud || n < 0){ 
				System.err.print(" no existe ese item\n");
				return null;
			}else{
				//buscamos el anterior a N osea N-1
				Nodo puntero = cabeza;
				int index = 0;
				while(puntero != null && index < n){//al final llegara N-1 < N 
					// y la ultima vuelta sera cuando  N > N
					puntero = puntero.siguiente;
					index++;
				}
				//por lo que index al final llega a ser N
				if(index == n){//comprobando que es N
					return (T) puntero.elemento;//sacando el elemento
				}else{
					return null;//y si no se encontro entonces retorna null
				}
			}
			
		}
	}
	public boolean esta_en_la_lista(T elemento){
		
		if(cabeza == null){
			return false;//no hay elementos
		}else{
			Nodo puntero = cabeza;//iteramos con la cabeza
			//mientras la lista no llegue al final y no se haiga encontrado el elemento
			while(puntero != null && !(puntero.elemento.equals(elemento))){
				//iteramos
				puntero = puntero.siguiente;
			}
			//hay dos condiciones en el while,siginifica que pudo acabarse la lista
			//o se encontro la lista
			//si no se acabo la lista significa que se ha encontrado
			if(puntero != null){
				return true;//se encontro
			}
			return false;//no se encontro
			//return puntero != null//para ser mas concisos
		}
	}
	public void actualizar_valor_de_un_nodo(T original, T modificado){
		if(cabeza != null){
			//si la lista no esta vacia, vamos a iterar con un puntero
			Nodo puntero = cabeza;
			//Mientras no se termine la lista y no se encuentre el elemento,entonces
			while(puntero != null && !(puntero.elemento.equals(original))){
				puntero = puntero.siguiente;//seguir iterando
			}
			//dos condiciones, si una no se cumple la otra si o si se cumplio
			//entonces comprobamos el caso en el que el caso desfavorable no se cumple
			if( puntero != null ){
				//if(puntero.elemento.equals(original), aunque es largo, por eso no
				//pongo, y creo seria menos eficiente
				puntero.elemento = modificado;//modificando el puntero
			}else{
				//no se va a poder pues puntero == null,es decir llego al final de la lista 
			}
		}
	}
	
	public int getLongitud(){
		return this.longitud;
	}
	
	public static void main(String[] args) {
		Lista m = new Lista(new Nodo(new String("cabeza")));
		
		m.inserta_alPrincipio(new String("noooooo"));	
		m.inserta_alPrincipio(new String("siiiiii"));	
		m.inserta_alPrincipio(new Double(12.33));
		
		System.out.println("Mostrando esta lista");
		System.out.println(m.mostrar());
		
		System.out.println("mostrando longitud de la lista : "+m.longitud);
		System.out.println();
		 
		m.eliminar_por_indice(3);
		System.out.println("Se elimino el elemento 3 ");
		System.out.println();
		System.out.println("Mostrando esta lista");
		System.out.println(m.mostrar());
		System.out.println("mostrando longitud de la lista: "+m.getLongitud());

		System.out.println("Obteniendo el elemento numero 2 : "+m.obtener_item(2));
		System.out.println();
		System.out.println("obteniendo el elemento numero 3(aunque ya se elimino)...");		
		System.out.println(m.eliminar_objeto(m.obtener_item(3)));
		 
		
		System.out.println("Mostrando esta lista");
		 
		System.out.println(m.mostrar());
		
		System.out.println("Mostrar longitud: "+m.getLongitud());
		System.out.println();
		System.out.println("Comprobando si en la lista esta el numero 12.33 : " + m.esta_en_la_lista( new Double(12.33)));
		System.out.println("Comprobando si en la lista esta el string siiiii : " + m.esta_en_la_lista( new String("siiiiii")));
		System.out.println("Actualizando valor de un nodo de la lista: ");
		
		System.out.println("**********************************\n"+m.mostrar());
		m.actualizar_valor_de_un_nodo("noooooo","hola amigos no tengo");
		
		System.out.println(m.mostrar()+"\n**********************************");
		
		Lista<Integer> lista_ord = new Lista<Integer>(new Nodo(new Integer(0)));
		lista_ord.insertar_alFinal(new Integer(2));
		lista_ord.insertar_alFinal(new Integer(4));
		lista_ord.insertar_alFinal(new Integer(1));
		lista_ord.insertar_alFinal(new Integer(22));
		lista_ord.insertar_alFinal(new Integer(0));
	    
		//Ordenando la lista de enteros ...
		Lista orden = lista_ord.ordenar_lista();
		
		
		System.out.println("lista original: \n"+lista_ord.mostrar()+" longitud_total: "+lista_ord.longitud);
 		System.out.println("lista ordenada: \n"+orden.mostrar()+" longitud_total: "+orden.longitud);
	}
}
