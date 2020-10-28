package Algoritm_Married;

	import java.util.*;
	/*********************************************
	 * NODE CLASS
	 *********************************************/
	class Node{
		public int numero; //enumeracion
		public boolean estado; //T F
		public boolean hoja; //T F
		public ArrayList<Node> _hijos; //N-hijos
		public int nivel; //
		
		Node(){
			numero = 0;
			estado = false;
			hoja = false;
			nivel = -1;
			
			_hijos = new ArrayList<Node>();
			_hijos.ensureCapacity(2);
		}
	}

	public class Tnode {

		static Node _root;
		static int _limite;
		static int _nhijos;
		static int _contador; //enumerar nodos
		static ArrayList<Node> _cont;
		
		/*********************************************
		 * CREAR ARBOL
		 *********************************************/	
		static void crear_arbol(int profundidad) {
			_nhijos = 2;
			_contador = 0;
			_limite = profundidad;
			
			//root
			_root = new Node();
			_root.nivel = 1;
			_root.numero = _contador;
			
			if(_root.nivel < _limite) {
				_root = anadirNodo(_root);
			}
		}
		
		static Node anadirNodo(Node nodo) {
			if(_limite > nodo.nivel) {
				
				for(int i = 0 ; i < _nhijos ; i++) {
					Node hnodo = new Node();
					hnodo.nivel = nodo.nivel+1;
					hnodo = anadirNodo(hnodo);
					
					nodo._hijos.add(hnodo);
				}
			}else {
				nodo.hoja = true;
			}
			return nodo;
		}
		
		/*********************************************
		 * ENUMERAR
		 *********************************************/	
		static void numerar() {
			_cont = new ArrayList<Node>();
			_cont.add(_root);
			
			while(_cont.size() > 0) {
				_contador++;
				//Node n = _cont.get(0);
				//n.numero = _contador;
				Node n = _cont.remove(0);
				n.numero = _contador;
				for(int i = 0 ; i < n._hijos.size() ; i++) {
					_cont.add(n._hijos.get(i));
				}
			}
		}
		
		/*********************************************
		 * SIMULACION
		 *********************************************/
		
		static int _ultimo;
		static Node getUltimoNodo(Node n) {		
			if(n.hoja) {
				_ultimo = n.numero;
				return n;
			}
			else
			{
				if(n.estado) //derecho
				{
					//System.out.println("DER" );
					Node t = n._hijos.get(1);
					t = getUltimoNodo(t);
					
					n._hijos.remove(1);
					n._hijos.add(t);
				}
				else // izquierdo
				{
					//System.out.println("IZQ" );
					Node t = n._hijos.get(0);
					t = getUltimoNodo(t);
					
					Node t1 = n._hijos.get(1);
					n._hijos.clear();;
					n._hijos.add(t);
					n._hijos.add(t1);
				}
			}
			
			n.estado = !n.estado;
			return n;
		}
		
		static void print(Node n) {
			System.out.println(n.estado);
			
			for(int i=0;i<n._hijos.size();i++) {
				print(n._hijos.get(i));
			}
		}
		
		
		public static void main(String []args) {
			int d = 2;
			int N = 4;
			
			crear_arbol(d);
			numerar();
			//System.out.println(_contador);
			
			for(int i=0;i<N;i++) {
				_root = getUltimoNodo(_root);
				//System.out.println(" " + i + " " + _ultimo);
				
				//print(_root);

			}
			System.out.println(_ultimo);
		}
	}


	
