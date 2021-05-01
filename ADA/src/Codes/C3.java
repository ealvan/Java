package Codes;
//CODIGO 3

import java.util.*; 
public class C3 { 
	private int d[]; 
	private Set<Integer> settled; 
	private PriorityQueue<Node> pq; 
	private int V;
	List<List<Node> > adj; 
	
	public C3(int V){ 
		this.V = V; 
		d = new int[V]; 
		settled = new HashSet<Integer>(); 
		pq = new PriorityQueue<Node>(V, new Node()); 
	} 
	// este es el algoritmo de distra
	public void algoritmo3(List<List<Node> > adj, int src){ 
		//la matriz de adyacencia se pone aqui
		this.adj = adj; 
		//luego se inicializan los nodos a infinito
		for (int i = 0; i < V; i++){ 
			d[i] = Integer.MAX_VALUE; 
		}
		//en la cola de prioridad se pone el nodo de inicio
		pq.add(new Node(src, 0)); 
		//su distancia seria de cero, pues es el mismo
		d[src] = 0;
		//luego , mientras todos los nodos no sean visitados,entonces
		while (settled.size() != V) {  
			//removemos el nodo con peso minimo
			int u = pq.remove().node; 
			//se agrega al set el nodo ya visitado
			settled.add(u); 
			// y vas a los vecinos y  relajas sus aristas
			vecino(u); 
		} 
	} 
	
	private void vecino(int u) { 
		int eDist =  - 1; 
		int nDist =  - 1; 
		
		for (int i = 0; i < adj.get(u).size(); i++) { 
			Node v = adj.get(u).get(i); 
			
			if (!settled.contains(v.node)) { 
				eDist = v.cost; 
				nDist = d[u] + eDist; 
				if (nDist < d[v.node]){ 
					d[v.node] = nDist; 
				}
				pq.add(new Node(v.node, d[v.node])); 
			} 
		} 
	} 
	
	public static void main(String arg[]) { 
		int V = 5; 
		int source = 0; 
		
		List<List<Node> > adj = new ArrayList<List<Node> >(); 
		
		for (int i = 0; i < V; i++) { 
			List<Node> item = new ArrayList<Node>(); 
			adj.add(item); 
		} 
		
		adj.get(0).add(new Node(1, 9)); 
		adj.get(0).add(new Node(2, 6)); 
		adj.get(0).add(new Node(3, 5)); 
		adj.get(0).add(new Node(4, 3)); 
		
		adj.get(2).add(new Node(1, 2)); 
		adj.get(2).add(new Node(3, 4)); 
		
		C3 dpq = new C3(V); 
		dpq.algoritmo3(adj, source); 
		
		System.out.println("La respuesta de :"); 
		for (int i = 0; i < dpq.d.length; i++) 
		System.out.println(source + "$  ->  " + i + " : " + dpq.d[i]); 
	} 
} 

class Node implements Comparator<Node> { 
	public int node; 
	public int cost; 
	
	public Node() { } 
	
	public Node(int node, int cost) { 
		this.node = node; 
		this.cost = cost; 
	} 
	
	@Override
	public int compare(Node node1, Node node2) { 
		if (node1.cost < node2.cost) 
		return  - 1; 
		if (node1.cost > node2.cost) 
		return 1; 
		return 0; 
	} 
} 