package lista_enlazada_generica;

public class Pila<T> extends Lista  {

	//el nodo cabeza esta en la clase Lista(lista enlazada)
	int longitud = 0;// es la longitud actual de cada arreglo
	int cantidad = Integer.MAX_VALUE;//esto es por que hice varios constructores
	//en los demas metodos se comprobara si longitud > cantidad , entonces botame error
	//asi que si cantidad es definida por default seria cero, pero necesitamos darle un 
	//espacio dinamico a esta pila
	public Pila(Nodo cabeza) {//con el nodo cabeza
		super(cabeza);//heredando el constructor
		this.longitud++;//se agrego un elemento
	}
	public Pila(){super();}//sin el nodo cabeza
	
	
	public Pila(Nodo cabeza, int cant){//aqui definimos la pila con cabeza, y cantidad
		//definida
		super(cabeza);//heredando el constructor nuevamente
		this.cantidad = cant;//ahora sera una cantidad definida
		this.longitud++;//se agrego un elemento
	}
	public void push( T elemento){//poniendo un "plato"
		if( longitud < cantidad){//si aun no sobrepaso la cantidad entonces podemos 
			//agregar mas elementos
			Nodo nuevo = new Nodo(elemento);//empaquetamos nuestro elemento
			if(cabeza == null){//si esta vacia
				cabeza = nuevo;//entonces sera nuestra nueva cabeza
			}else{
				nuevo.siguiente = cabeza;//actualizando la cabeza
				cabeza = nuevo;//ahora esta sera nuestra nueva cabeza
			}
			this.longitud++;
		}else{
			//System.err.print("No se pudo :(");
		}
	}
	public Nodo pop(){
		if(cabeza == null){
			// no hay nada
			return null;
		}else{
			Nodo temp = cabeza;//almacenamos el valor en la referencia temp
			cabeza = cabeza.siguiente;//la actualizamos , porque borramos
			temp.siguiente = null;//quitamos su enlace, con la pila
			this.longitud--;
			return  temp ;//retornamos el elemento eliminado
			//caja --> null   hacemos pop()
			//null entonces la pila esta vacia
		}
	}
	public String mostrar(){
		String str = "";
		int i = 0;
		//solo recorremos con un puntero, solo para imprimir,
		for(Nodo puntero = cabeza; puntero != null;puntero = puntero.siguiente ){
			str += "Item " +i+ " ==> "+puntero.elemento.toString()+" ";
			i++;
		}
		str+="\n";//agregando salto de linea
		return str;
	}
	public static void voltear_pila(Pila izq, Pila dere){
		//este metodo servira para la tarea de Cola con dos pilas
		//la idea se desarrollara mas adelante ...
		int cantidad = izq.longitud;//tenemos que saber cuantos "platos" son
		for(int i = 0; i < cantidad; i++){//recorriendo la pila
			if(izq.cabeza!=null){//mientras la pila no se quede con elementos
				//retornamos el ultimo que se elimina de 
				//la pila izquierda
				Nodo transporte =  izq.pop();
				//y metemos el nodo eliminado en la pila derecha
				dere.push(transporte.elemento);
			}
			
		}
	}
	public static void main(String[] args) {
		//probando la clase pila
		//hacemos una pila con strings, para probar los metodos
		 Pila<String> pila = new Pila<String>(new Nodo("cabeza"));
		 pila.push("c1");
		 pila.push("c2");
		 pila.push("c3");
		 pila.push("c4");
		 pila.push("c5");
		 //ahora mostraremos la pila
		 System.out.print("Mostrando pila: "+pila.mostrar());
		 //probando ahora el constructor de Pila Statica
		 Pila<String> pila_statica = new Pila<String>(new Nodo("c"),6);//1
		 pila_statica.push("c1");//2
		 pila_statica.push("c2");//3
		 pila_statica.push("c3");//4
		 pila_statica.push("c4");//5
		 pila_statica.push("c5");//6 --> hasta aqui seria el limite
		 pila_statica.push("ccc___ccc");//---> este no sera admitido
		 System.out.print("Mostrando Pila Estatica: "+pila_statica.mostrar());//mostrando
		 System.out.println("Longitud : "+ pila_statica.longitud);//deberia botarme 10
	
		 //borrando elementos ...
		 
		 System.out.println("Elemento eliminado : "+pila_statica.pop().elemento);
		 System.out.println("Elemento eliminado : "+pila_statica.pop().elemento);
		 System.out.println("Longitud : "+ pila_statica.longitud);
	}	 
}
