package Dijstra;

import java.util.Comparator;

class Nodo implements Comparator<Nodo> { 
    public int id; 
    public int d;
    Nodo siguiente;
    public Nodo() { } //empty constructor 
   
    public Nodo(Nodo m ) {
    	this.id = m.id;
    	this.d = m.d;
    }
    public Nodo(int node, int cost) { 
        this.id = node; 
        this.d = cost; 
    } 
    public String toString() {
    	return this.id+"";
    }
    public int compare(Nodo node1, Nodo node2) 
    { 
        if (node1.d < node2.d) 
            return -1; 
        if (node1.d > node2.d) 
            return 1; 
        return 0; 
    } 
    public static boolean contains(Nodo visited[],int id) {
		for(int i =0 ; i< visited.length; i++) {
			if(visited[i] != null)
			if(id == visited[i].id) {
				return true;
			}
		}
		return false;
	}
    
}