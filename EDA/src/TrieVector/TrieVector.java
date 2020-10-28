package TrieVector;

import java.util.ArrayList;


 

public class TrieVector {

	Nodo raiz;
	char eok;
	int alphabeto;
	public void prefijas(String prefijo){
		
		
		
	}
	public void imprimir(){
		ArrayList<String> lista = new ArrayList<String>();
		imprimir(raiz,"","",lista);

	}
	public void imprimir(Nodo raiz, String aux, String str,ArrayList<String> lista){
		str+=aux;
		for(int i = 0; i < 26; i++){
			if(raiz.hijos[i] != null){
				aux = ""+(char)(i+'a');
				imprimir(raiz.hijos[i],aux,str,lista);
			}
		}
		if(raiz.hijos[26] == raiz){
			System.out.println(str);
		}
	}
	
	public boolean empieza(String prefijo) {
        Nodo p = buscarNodo(prefijo);
        if(p==null){
            return false;
        }else{
            return true;
        }
    }
	
	public Nodo buscarNodo(String s){
        Nodo p = raiz;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            int index = c-'a';
            if(p.hijos[index]!=null){
                p = p.hijos[index];
            }else{
                return null;
            }
        }
        if(p==raiz)
            return null;
        return p;
    }
	
	
	
	
	public TrieVector(char eok, int cantAlfabet){
		this.eok = eok;
		this.alphabeto = cantAlfabet;
		raiz = new Nodo(this.alphabeto);
	}
	public int ubicar(char item){
		if(item == eok){
			return this.alphabeto;
		}
		return (item - 'a');
	}
	public void insertar(String str){
		str+=this.eok;
		Nodo puntero = raiz;
		int pos = -1;
		for(int i =0; i< str.length(); i++){
			pos = ubicar(str.charAt(i));
			if(puntero.hijos[pos] == null){
				if(pos == this.alphabeto){
					puntero.hijos[pos] = puntero;
				}else{
					puntero.hijos[pos] = new Nodo(this.alphabeto);
				}
			}
			puntero = puntero.hijos[pos];
		}
	}
	public boolean buscar(String str){
		Nodo puntero = raiz;
		int pos = -1;
		for(int i = 0; i< str.length(); i++){
			pos = ubicar(str.charAt(i));
			if(puntero.hijos[pos] == null){
				return false;
			}
			puntero = puntero.hijos[pos];
		}
		if(puntero.hijos[this.alphabeto] == puntero){
			return true;
		}
		return false;
	}
	
	
	 
}
