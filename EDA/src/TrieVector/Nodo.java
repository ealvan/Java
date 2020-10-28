package TrieVector;

public class Nodo {
	Nodo[] hijos;
	public Nodo(int alfabeto){
		hijos =  new Nodo[alfabeto+1];//por el enofword
	}	
	
	public boolean esHoja(){
		for(int i = 0; i< this.hijos.length; i++){
			if(this.hijos[i] != null){
				return false;
			}
		}
		return true;
	}
	
}
