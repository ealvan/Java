package DIJKSTRA;

public class Edge {

	int source;
	int destination;
	int weight;
	
	public Edge(int id_s,int id_d, int w) {
		source = id_s;
		destination = id_d;
		weight = w;
	}
	
	public int getW(int s, int d) {
		return weight;
	}
	
}
