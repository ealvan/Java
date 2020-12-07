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
			graphAdy(u.id);
			k++;
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
	    int new_d = -1;
		Nodo isAdy = ady[id].cabeza.siguiente;
		while(isAdy != null) {
			
			if(!Nodo.contains(visited,isAdy.id)) {
				d = isAdy.cost; 
                new_d = dist[id] + d;
                if(dist[isAdy.id] > new_d) {
                	dist[isAdy.id] = new_d;
                }
                pqueue.add(new Nodo(isAdy.id,dist[isAdy.id]));
			}
			isAdy = isAdy.siguiente;
		}
	}
	
	
	
	public static void main(String[] args) {
		Grafo gf = new Grafo(3);
		gf.ady[0] = new Lista(new Nodo(0,0));
		gf.ady[0].insertar(new Nodo(1,3));
		gf.ady[0].insertar(new Nodo(2,2));
		gf.ady[1] = new Lista(new Nodo(1,0));
		gf.ady[2] = new Lista(new Nodo(2,0));
		
		gf.dijstra(gf.ady, 0);
		
		for(int i = 0; i < gf.dist.length; i++) {
			System.out.println(0 + " \t\t " + i + " \t\t "  + gf.dist[i]);
		}
				
		

	}

}
