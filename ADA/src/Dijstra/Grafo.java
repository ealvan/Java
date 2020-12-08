package Dijstra;
import java.util.*;
import FibonnaciHeap.FibonacciHeap;
public class Grafo {
	
	int dist[]; 	 //distancias del id_source, hacia los demas
	Nodo visitados[];//Aqui se gaurdan los nodos ya visitados[] 
	PriorityQueue<Nodo> minQueue; // esta es la estructura que se usara para el Dijkstra
	int vertices; //numero de vertices
	Lista[] ady;  //lista de adyacencia, aqui se guarda la listas enlazadas
	
	//numero de vertices : v
	public Grafo(int v) {
		vertices = v;
		//hacemos un array con el tamaño v
		this.dist = new int[v];
		this.visitados = new Nodo[v];
		//incializamos la lista
		ady = new Lista[v];
		//inicializamos el priorityQueue
		minQueue = new PriorityQueue<Nodo>(v,new Nodo()); 
	}
	//algortimo disjktra
	public void dijstra_queue( int id_src) {
		//aqui se inicializan los atributo "d"
		initializeSingleSource(id_src);
		//aqui colocamos primero al nodo con id_src
		minQueue.add(new Nodo(id_src, 0));
		//este k servira pra iterar en los "visitados"
		int k =0;
		while(this.sizeVisited() != vertices) {
			//removemos el nodo minimo y lo recuperamos
			Nodo u = minQueue.remove();//por defecto, vota el nodo minimo
			//lo agregamos en los visitados
			visitados[k] = u;
			int d = -1; 
			//este es el nodo recuperado de la lista de adyacencia del nodo "u.id"
			//se itera desde este nodo
			Nodo isAdy = ady[u.id].cabeza.siguiente;
			while(isAdy != null) {	
				//si no esta en los visitados el nodo adyacente
				if(!Nodo.contains(visitados,isAdy.id)) {
					d = isAdy.d; 
					//entonces lo relajamos
                	relax(u.id, isAdy.id, d);
                	//agregamos al minQueue este nodo
                	minQueue.add(new Nodo(isAdy.id,dist[isAdy.id]));
				}
				//iteramos al siguiente nodo
				isAdy = isAdy.siguiente;
			}
			//incrementamos el k
			k++;
		}
	}
	public void dijstra_heap(int id_src) {
		FibonacciHeap<Nodo> heap = new FibonacciHeap<Nodo>();
		//aqui se inicializan los atributo "d"
		initializeSingleSource(id_src);
		//aqui colocamos primero al nodo con id_src
		heap.enqueue(new Nodo(id_src,0), 0);
		//minQueue.add(new Nodo(id_src, 0));
		//este k servira pra iterar en los "visitados"
		int k =0;
		while(this.sizeVisited() != vertices) {
			//removemos el nodo minimo y lo recuperamos
			
			//Nodo u = minQueue.remove();//por defecto, vota el nodo minimo
			Nodo u = heap.dequeueMin().getValue();
			//lo agregamos en los visitados
			visitados[k] = u;
			int d = -1; 
			//este es el nodo recuperado de la lista de adyacencia del nodo "u.id"
			//se itera desde este nodo
			Nodo isAdy = ady[u.id].cabeza.siguiente;
			while(isAdy != null) {	
				//si no esta en los visitados el nodo adyacente
				if(!Nodo.contains(visitados,isAdy.id)) {
					d = isAdy.d; 
					//entonces lo relajamos
		            relax(u.id, isAdy.id, d);
		           //agregamos al minQueue este nodo
		            //minQueue.add(new Nodo(isAdy.id,dist[isAdy.id]));
		            heap.enqueue(new Nodo(isAdy.id,dist[isAdy.id]), dist[isAdy.id]);
				}
			//iteramos al siguiente nodo
			isAdy = isAdy.siguiente;
			}
			//incrementamos el k
			k++;
		}		
	}
	//bfs algorithm
	//recibe el nodo con id
	
	public void bfs(int id) {
		//hacemos un array con nodos visitados
		boolean[] visitado = new boolean[vertices];
		//creamos una cola normal
		Cola cola = new Cola();
		//hacemos que este visitado el nodo con "id"
		visitado[id] = true;
		//y encolamos el nodo con "id"
		Nodo nodo_s = ady[id].cabeza;
		cola.encolar(nodo_s);
		while(cola.longitud != 0) {
			//eliminamos el nodo cabeza de la cola
			Nodo m = cola.eliminar();
			//lo imprimimos, para ver su recorrido
			System.out.println("Nodo: "+m.id);
			//hacemos una referencia al objeto
			Nodo puntero = ady[m.id].cabeza;
			//e iteramos sobre su lista de adyacencia
			while(puntero != null) {
				//si no ha sido visitado
				if(!visitado[puntero.id]) {
					//lo visitamos
					visitado[puntero.id]  = true;
					//y los encolamos
					cola.encolar(puntero);
				}
				//seguimos al siguiente nodo
				puntero = puntero.siguiente;
			}
		}
	}
	//lo que hace es ver cuantos elementos hay en la lista
	//sin que sean null
	public int sizeVisited() {
		int k = 0;
		for(int i = 0; i < visitados.length; i++) {
			//si es diferente a null, lo agregamos
			if(visitados[i] != null) {
				k++;
			}
		}
		//reotrnamos
		return k;
	}
	//esta es la fase de inicializar las distancias a inifinito
	//poner la distancia a cero
	public void initializeSingleSource(int src_id) {
		for(int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src_id] = 0;
	}
	//este es el metodo de relajar
	// hace que se actualicen los pesos desde un vertice "u", hacia un vertice "v"
	public void relax(int u_id, int v_id, int d) {
		// si es mayor(infinito > menor),
		if( dist[v_id] > dist[u_id] + d ) {
			// entonceslo actualizamos
			dist[v_id] = dist[u_id] + d;
		}
	}
	//este metodo nos ayuda a insrtar un nodo
	public void insertarElement(int id, int cost) {
		//se crea un nodo, y luego se
		// le pone en la cabeza de su lista de adyacencia
		Nodo m = new Nodo(id,cost);
		this.ady[id] = new Lista(m);//en la cabeza
	}
	//añadimos una relacion entre dos nodos
	public void relacion(int id_s, int id_d, int w) {
		//sacamos la referencia de la cabeza de la lsita enlazada
		//Nodo m = this.ady[id_d].cabeza;
		//le hacemos una copia
		Nodo n = new Nodo(id_d,w);
		//y luego se le insertar la copia
		//para que no se guarden las misma referencias
		this.ady[id_s].insertar(n);
	}
	//main
	public static void main(String[] args) {
		Grafo gf = new Grafo(5);
		gf.insertarElement(0,0);
		gf.insertarElement(1,0);
		gf.insertarElement(2,0);
		gf.insertarElement(3,0);
		gf.insertarElement(4,0);
		
		gf.relacion(0, 1, 5);
		gf.relacion(0, 2, 10);
		gf.relacion(1, 2, 3);
		gf.relacion(1, 4, 2);
		gf.relacion(1, 3, 9);
		gf.relacion(2, 1, 2);
		gf.relacion(2, 3, 1);
		gf.relacion(3, 4, 4);
		gf.relacion(4, 3, 6);
		gf.relacion(4, 0, 7);
		gf.dijstra_heap(0);
		gf.bfs(0);
		System.out.println("*****************");
		for(int i = 0; i < gf.dist.length; i++) {
			System.out.println(0 + "    " + i + "    "  + gf.dist[i]);
		}
	}
}
