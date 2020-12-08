package Dijstra;
import java.util.*;
 
public class Grafo {
	int dist[];
	Nodo visited[];
	PriorityQueue<Nodo> pqueue;
	int vertices;
	Lista[] ady;
	
	public Grafo(int v) {
		vertices = v;
		this.dist = new int[v];
		this.visited = new Nodo[v];
		ady = new Lista[v];
		pqueue = new PriorityQueue<Nodo>(v,new Nodo()); 
	}
	
	public void dijstra(Lista[] list_ady, int id_src) {
		
		initializeSingleSource(id_src);
		pqueue.add(new Nodo(id_src, 0));
		int k =0;
		while(this.sizeVisited() != vertices) {
			Nodo u = pqueue.remove();
			visited[k] = u;
			//graphAdy(u.id);
			int d = -1; 
			Nodo isAdy = ady[u.id].cabeza.siguiente;
			while(isAdy != null) {	
				if(!Nodo.contains(visited,isAdy.id)) {
					d = isAdy.cost; 
                	relax(u.id, isAdy.id, d);
                	pqueue.add(new Nodo(isAdy.id,dist[isAdy.id]));
				}
			isAdy = isAdy.siguiente;
		}
			k++;
		}
	}
	
	public void bfs(int id) {
		boolean[] visitado = new boolean[vertices];
		Cola cola = new Cola();
		visitado[id] = true;
		Nodo nodo_s = ady[id].cabeza;
		cola.encolar(nodo_s);
		
		while(cola.longitud != 0) {
			Nodo m = cola.eliminar();
			System.out.println(m.id+" "+m.cost);
			Nodo puntero = ady[m.id].cabeza;
			while(puntero != null) {
				if(!visitado[puntero.id]) {
					visitado[puntero.id]  = true;
					cola.encolar(puntero);
				}
				puntero = puntero.siguiente;
			}
		}
		
	}
	
	public int sizeVisited() {
		int k =0;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] != null) {
				k++;
			}
		}
		return k;
	}
	
	public void initializeSingleSource(int src_id) {
		for(int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src_id] = 0;
	}
	public void graphAdy(int id) {
		int d = -1; 
	    //int new_d = -1;
		Nodo isAdy = ady[id].cabeza.siguiente;
		while(isAdy != null) {	
			if(!Nodo.contains(visited,isAdy.id)) {
				d = isAdy.cost; 
                relax(id, isAdy.id, d);
                pqueue.add(new Nodo(isAdy.id,dist[isAdy.id]));
			}
			isAdy = isAdy.siguiente;
		}
	}
	public void relax(int u_id, int v_id, int d) {
		
		if( dist[v_id] > dist[u_id] + d ) {
			dist[v_id] = dist[u_id] + d;
		}
		
	}
	
	public void insertarElement(int id, int cost) {
		Nodo m = new Nodo(id,cost);
		this.ady[id] = new Lista(m);
	}
	public void relacion(int id_s, int id_d) {
		Nodo m = this.ady[id_d].cabeza;
		Nodo n = new Nodo(m);
		this.ady[id_s].insertar(n);
	}
	
	public static void main(String[] args) {
		Grafo gf = new Grafo(4);
		gf.insertarElement(0,0);
		gf.insertarElement(1,3);
		gf.insertarElement(2,2);
		gf.insertarElement(3,1);
		
		gf.relacion(0, 1);
		gf.relacion(1, 2);
		gf.relacion(2, 3);
		gf.relacion(0, 3);
		
		gf.dijstra(gf.ady, 0);
		gf.bfs(0);
		System.out.println("****************************************");
		for(int i = 0; i < gf.dist.length; i++) {
			System.out.println(0 + " \t\t " + i + " \t\t "  + gf.dist[i]);
		}
	}
}
