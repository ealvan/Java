package DIJKSTRA;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Grafo {
	PriorityQueue<Nodo> pqueue;
	//grafo de amigos en comun 
	int vertices;//gurada el numero de nodos
	//que tendra este grafo
	//esto es una lista, con todos los nodos
	//aqui se guardara las relaciones del grafo
	Lista[] directorio;
	ArrayList<Edge> aristas = new ArrayList<Edge>();
	
	//este es un construxtor que nos indica
	//el numero de vertices del grafo
	
	public Grafo(int vertices){
		this.vertices = vertices;
		directorio = new Lista[this.vertices];
		 pqueue = new PriorityQueue<Nodo>(vertices);
		//incializamos la lista de listas enlazaadas
	}
	//este metodo instancia a un usuario, con una lista del directorio
	public void insertarUsuario(String user,int id){
		Nodo temp = new Nodo(user,id);//necesitamos el id, y el string
		//como siempre se empiueza de cero, hacemos que sea uno menos
		//asi si el id = 1, entonces posicion = 0
		//esto esta acomodado, pues como el data set es de 1 a 100
		//siempre guardaremos en la zabeza los datos del usuario
		directorio[id-1] = new Lista(temp);
	}
	 //este metodo agrega una relacion, unidireccional
	public void relacion(int vertice_id, int xvertice_id,int w){
		//obtiene la cabeza del directorio con el id 
		Nodo otro = directorio[xvertice_id - 1].cabeza;
		Edge ar = new Edge(vertice_id, xvertice_id,w);
		aristas.add(ar);
		//ahora un nuevo,nodo, esto lo hago pues si guardo la
		//referencia, cuando insertemos mas en una lista hara que en la otra
		//tambien se haga, pues la referencia solo es un alias(me tomo tiempo entenderlo :()
		//y cuando hagas una insercion en una lista se ara tambien en la otra
		Nodo m = new Nodo(otro);//por eso esto
		directorio[vertice_id - 1].insertar(m);//insertamos el nodo
	}
	//este es el metodo printlevel
	//lo que hace es imprimir por niveles, de acuerdo a un id de usuario
	//si es level = 1, imprime los amigos y el usuario
	//si es level = 2, entonces imprime los amigos + amigos de amigos + el usuario
	//si es tres, se hara assta los amigos de los amigos de amigos
	public void printLevel(int id, int level){
		//opbteniendo las repeticiones que se deben hacer
		int repeticiones = level_off(id,level);
		//ahora solo lo ponemos en este metodo 
		//que imprime dea acuerdo a niveles
		traversal(id, repeticiones);
	}
	//este metodo nos da el nuemro de repeticiones
	//de cuantas veces es necesario imprimir 
	//hasta que lleguemos a cierto nivel
	private int level_off(int id,int level){
		//este size, nos dara el nuemro de repeticiones
		int size = 0;
		//aqui estara una lista de booleans
		//por defecto el false, cuando se crea
		boolean[] visitado = new boolean[vertices];
		//este metodo cambia las lista visitado a true
		//de acuerdo al level
		Nlevel(id,level,0,visitado);
		//como es un objeto, lo unico que hacemos es ver que 
		//cambios hubo en los true
		for(int i = 0; i < visitado.length; i++){
			if(visitado[i] == true){
				size+=1;
			}
		}
		return size;
	}
	//el traversal hace la impresion de acuerdo a un nivel
	//si es level = 1, imprime los amigos directos
	//el numero de repeticiones se define de acuerdo a un nivel
	private void traversal(int id,int p){
		//hacemos una lista de booleans, de acuerdo al numero de vertices
		boolean[] visitado = new boolean[vertices];
		Cola cola = new Cola();
		int ini = 0;
		//marcamos como visitado esa direccion
		visitado[id-1] = true;
		//ontenemos el nodo cabeza de esa direccion
		Nodo nodo_s = directorio[id-1].cabeza;
		cola.encolar(nodo_s);//y lo encolamos en una pila
		
		while(cola.longitud != 0 && ini < p){
			Nodo m = cola.eliminar();//la eliminamos
			System.out.print(m.id+" "+m+"\n");//la imprimimos
			//e iteramos sobre sus hijos
			Nodo puntero = directorio[m.id - 1].cabeza;
			while(puntero != null){	
				if(!visitado[puntero.id - 1]){
					//si no ha sido visitado uno de sus hijos
					//entonces los visitamos
					visitado[puntero.id - 1] = true;
					//y los encolamos en la cola
					cola.encolar(puntero);
				}
				//iteramos al siguiente hijo
				puntero = puntero.siguiente;
					  
			}
			//imcrementamos esto
			ini++;
		}
	}
	
 
	//este metodo nos regresa implicitamente el numero de veces que tenemos que repetir el 
	//para que sea considerado
	//el id, nos dice desde que nos se inicia
	//el level, nos dice hasta que nivel debemos llegar
	//el actual, nos dice, en que llamada actual estamos 
	private void Nlevel(int id, int level, int actual, boolean[] visitado){
		//primero marcamos como visitado, el nodo inicial
		visitado[id -1 ] = true;
		//este es nuestro caso base
		if(actual == level){
			return;
		}else{
			actual++;
		}
		//entonces iteramos en los nodos de la lista
		//identificada con el id
		Nodo puntero = directorio[id-1].cabeza;
		while(puntero != null){
			
			Nodo temp = puntero;
			if(!visitado[temp.id - 1]){
				//si no ha sido vistado, lo vistamos a la siguiente llamada
					Nlevel(temp.id, level,actual,visitado);
			}
			//seguimos con el siguiente
			puntero = puntero.siguiente;
		}
	}
	public  int obtener(int s, int d) {
		for(int i = 0; i < aristas.size(); i++) {
			if(aristas.get(i).source == s && aristas.get(i).destination == d) {
				return aristas.get(i).weight;
			}
		}
		return -2;
	}

	public void singleSourceInitialize(Lista[] directorio, Nodo source) {
		for(int id = 0; id < directorio.length; id++) {
			directorio[id].cabeza.d = Integer.MAX_VALUE;
			directorio[id].cabeza.pi = -1;
		}
		directorio[source.id-1].cabeza.d = 0;
	}
	
	public void relax(int id_u, int id_v) {
		if(directorio[id_v-1].cabeza.d > directorio[id_u-1].cabeza.d + obtener(id_u,id_v)) {
			directorio[id_v-1].cabeza.d = directorio[id_u-1].cabeza.d + obtener(id_u,id_v);
			directorio[id_v-1].cabeza.pi = id_u;
		}
	}
	public void copy(Lista[]directorio,PriorityQueue<Nodo> pqueue ) {
		for(int i = 0; i < directorio.length; i++) {
			Nodo s = directorio[i].cabeza;
			Nodo m = new Nodo(s);
			pqueue.add(m);
		}
	}
	public PriorityQueue<Nodo> update(Lista[]directorio, int id) {
		PriorityQueue<Nodo> pqueue1 = new PriorityQueue<Nodo>();
		for(int i = 0; i < directorio.length; i++) {
			if(id-1 != i) {
				Nodo s = directorio[i].cabeza;
				Nodo m = new Nodo(s);
				pqueue1.add(m);
			}
		}
		return pqueue1;
	}
	
	public PriorityQueue<Nodo> dijkstra() {
		Nodo source = directorio[0].cabeza;
		singleSourceInitialize(directorio,source);
		ArrayList<Nodo> S = new ArrayList<Nodo>();
		copy(directorio,pqueue);
		while(pqueue.size() != 0) {
			Nodo u = pqueue.poll();
			S.add(u);
			Nodo cte = directorio[u.id-1].cabeza;
			Nodo rltv = cte.siguiente;
			while(rltv != null){
				relax(cte.id,rltv.id);
				rltv = rltv.siguiente;
			}
			pqueue = update(directorio, u.id);
		}
		return pqueue;
	}
	public void printS(PriorityQueue<Nodo> pq) {
		for(Nodo key: pq) {
			System.out.println(key);
		}
	}
	
	public static void main(String[] args) {
		Grafo gr = new Grafo(3);
		gr.insertarUsuario("uno", 1);
		gr.insertarUsuario("dos", 2);
		gr.insertarUsuario("tres", 3);
		gr.relacion(1, 2, 2);
		gr.relacion(1, 3, 3);
		gr.printS(gr.dijkstra());
		
/*
 * 		gr.insertarUsuario("pablo", 1);
		gr.insertarUsuario("carlos", 2);
		gr.insertarUsuario("pepe", 3);
		gr.insertarUsuario("juan", 4);
		gr.insertarUsuario("luis", 5);
		gr.insertarUsuario("popis", 6);
		
		gr.relacion(1, 2);
		gr.relacion(1, 3);
		gr.relacion(2, 4);
		gr.relacion(2, 5);
		gr.relacion(2, 1);
		gr.relacion(3, 1);
		gr.relacion(3, 5);
		gr.relacion(4, 2);
		gr.relacion(4, 5);
		gr.relacion(4, 6);
		gr.relacion(5, 2);
		gr.relacion(5, 3);
		gr.relacion(5, 4);
		gr.relacion(5, 6);
		gr.relacion(6, 4);
		gr.relacion(6, 5);
		gr.printLevel(1, 3);
 * 
 * */
	}
}
