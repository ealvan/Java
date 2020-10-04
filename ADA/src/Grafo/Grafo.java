package Grafo;

public class Grafo {
	//grafo de amigos en comun 
	int vertices;//gurada el numero de nodos
	//que tendra este grafo
	//esto es una lista, con todos los nodos
	//aqui se guardara las relaciones del grafo
	Lista[] directorio;
	
	//este es un construxtor que nos indica
	//el numero de vertices del grafo
	
	public Grafo(int vertices){
		this.vertices = vertices;
		directorio = new Lista[this.vertices];
		//incializamos la lista de listas enlazaadas
	}
	//este metodo instancia a un nodo, con una lista del directorio
	//name : este parametro es el nombre del nodo
	//(tambien se puede entender como el contenido)
	//id : este es el identificador del nodo, para crear
	//su propia lista enlazada
	public void insertarNodo(String name,int id){
		Nodo temp = new Nodo(name,id);
		//como siempre se empiueza de cero, hacemos que sea uno menos
		//asi si el id = 1, entonces posicion = 0
		//esto esta acomodado, pues como el data set es de 1 a 100
		//siempre guardaremos en la zabeza los datos del usuario
		directorio[id-1] = new Lista(temp);
	}
	 //este metodo agrega una relacion, unidireccional
	public void relacion(int vertice_id, int xvertice_id){
		//obtiene la cabeza del directorio con el id 
		Nodo otro = directorio[xvertice_id - 1].cabeza;
		//ahora un nuevo,nodo, esto lo hago pues si guardo la
		//referencia, cuando insertemos mas en una lista hara que en la otra
		//tambien se haga, pues la referencia solo es un alias
		//y cuando hagas una insercion en una lista se hara tambien en la otra
		Nodo m = new Nodo(otro);//por eso esto
		directorio[vertice_id - 1].insertar(m);//insertamos el nodo
	}
	
	public void amplitud() {
		System.out.println("****Amplitud****");
		this.BFS(1);
	}
	//el BFS hace la impresion del grafo,conforme 
	//al orden de la cola
	private void BFS(int id){
		//hacemos una lista de booleans, de acuerdo al numero de vertices
		boolean[] visitado = new boolean[vertices];
		//creamos la cola
		Cola cola = new Cola();
		//marcamos como visitado esa direccion
		visitado[id-1] = true;
		//obtenemos el nodo cabeza de esa direccion
		Nodo nodo_s = directorio[id-1].cabeza;
		cola.encolar(nodo_s);//y lo encolamos
		//como tiene un elemento, significa que entrara en el bucle
		while(cola.longitud != 0 ){
			Nodo m = cola.eliminar();//eliminamos el nodo
			System.out.println("Id: "+m.id+" "+"Nombre: "+m);//lo imprimimos
			//e iteramos sobre sus hijos
			Nodo puntero = directorio[m.id - 1].cabeza;
			while(puntero != null){	
				//si no ha sido visitado uno de sus hijos
				if(!visitado[puntero.id - 1]){
					//entonces los visitamos
					visitado[puntero.id - 1] = true;
					//y los encolamos en la cola
					cola.encolar(puntero);
				}
				//iteramos al siguiente hijo
				puntero = puntero.siguiente;	  
			}
			
		}
	}
	//este metodo, es el metodo de profundidad, el cual
	//va recursivamente llamando el primero hijo del nodo anterior.
	//hasta que llegue un momento en que todos los nodos esten visitados
	//significando que ql array visitados, esta completo de trues
	//el array de visitados es un objeto, el cual solo recibe referencias y vambia
	//mientras es llamado el metodo recursivamente.
	private void DFSUtil(int id, boolean visitados[]) {
		//primero lo marcamos como true
		visitados[id - 1] = true;
		//lo imprimimos
		System.out.println("Id: "+id+" "+"Nombre: "+directorio[id - 1].cabeza);
		//y ahora vamos a por la lista enlazada, que contiene
		//a los nodos relacionados directos con este nodo.
		Nodo nodo = directorio[id - 1].cabeza;
		//recorremos la lista enlazada
		while(nodo != null) {
			//si un nodo, de la lista
			//no esta visitado
			if(!visitados[nodo.id-1]) {
				//vamos a ir a ese nodo
				DFSUtil(nodo.id,visitados);
			}
			//si el nodo actual ya esta visitado
			//entonces seguimos con el siguiente
			nodo = nodo.siguiente;
		}
	}
	//este metodo, es un metodo envoltorio 
	public void profundidad(int longitud) {
		//creamos el array, el cual esta llena de false's
		boolean visitado[] = new boolean[longitud];
		//empezamos por el nodo uno, pero se puede 
		//por cualquier nodo en realidad
		System.out.println("***Profundidad***");
		DFSUtil(1,visitado);
	}
	public static void main(String[] args) {
	}
}
