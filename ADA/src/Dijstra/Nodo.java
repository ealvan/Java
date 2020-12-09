package Dijstra;

import java.util.Comparator;

class Nodo implements Comparator<Nodo> { 
	//aqui se guarda su indentificador
    int id; 
    //su peso, desde el id_src, hacia este nodo
    int d;
    //esto es para la lista enlazada
    Nodo siguiente;
    //constructor vacio
    //lo necesitamos para inicializar la priorityQueue
    public Nodo() { }   
   //esto copia los datos de los nodos
    public Nodo(Nodo m ) {
    	this.id = m.id;
    	this.d = m.d;
    }
    //esto es un constructor para crear nodos
    public Nodo(int node, int d) { 
        this.id = node; 
        this.d = d; 
    } 
    //esto es el toString
    public String toString() {
    	return this.id+"";
    }
    //esto nos sirve para que el la cola de prioridad
    //nos devuelva de acuerdo al peso minimo, el objeto
    // caundo usemos priorityQueue,remove() devuelve el minimo
    public int compare(Nodo nodo1, Nodo nodo2){ 
        if (nodo1.d < nodo2.d) 
            return -1; 
        if (nodo1.d > nodo2.d) 
            return 1; 
        return 0; 
    } 
    //lo que hace es decirnos si el id, que se le paso esta en algun objeto
    //de la lista visitados
    //busqueda lineal
    public static boolean contains(Nodo visitados[],int id) {
		for(int i =0 ; i< visitados.length; i++) {
			if(visitados[i] != null)
			if(id == visitados[i].id) {
				return true;
			}
		}
		return false;
	}  
}