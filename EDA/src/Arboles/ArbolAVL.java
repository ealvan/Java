package Arboles;
public class ArbolAVL<T extends Comparable> {
	NodoAVL raiz;
	public ArbolAVL(){
	 raiz = null;//empezando con un arbol vacio
	}
	public NodoAVL raizArbol (){
		return raiz;//para retornar la raiz
	}
	//Este metodo es una rotacion simple, pero hay cuatro casos de rotacion
	//la mas simple es de de izquierdad - izquierda y derecha - derecha
	//las mas complicadas son las mistas, en la que debes hacer izquierda - derecha
	// y derecha izquierda
	//este metodo solo hace de izquierda a izquierda
	private NodoAVL rotacionII(NodoAVL n, NodoAVL n1){
		//el nodo n, es nuestra raiz
		//el nodo n1 es el hijo izquierdo de nuestra raiz
	
		n.ramaIzquierda(n1.derecho());//n.izquierdo = n1.derecho;
		n1.ramaDerecha(n);// n1.derecha = n;
		raiz = n1;//enlazamos la raiz a nuestro n1, pues al principio
		//nuestra raiz es n y no n1, le debemos indicar eso a nuestra clase ArbolAVL
		if(n1.fe == -1){		
			n.fe = 0;
			n1.fe = 0;
		}else{
			//de lo contrario si no es -1 el factor de equilibrio, siginifica que al
			//rotar nuestro factor de equilibrio cambio a -1, pues no entodos los casos
			//los hijos no tienen hijos mas alla
			
			n.fe = -1;
			n1.fe = 1;
		}
		return n1;//retornamos la raiz nueva
	}
	//este es el simetrico, del izquierda - izquierda, y solo intercambie
	private NodoAVL rotacionDD(NodoAVL n, NodoAVL n1){
		//igual que el anterior el n es la raiz
		//y n1 es la rama derecha de n(raiz)
		n.ramaDerecha(n1.izquierdo());//n.derecha = n1.izquierdo
		n1.ramaIzquierda(n);//n1.izquierdo = n
		raiz = n1;//despues de la rotacion, nosotros tenemos que actualizar la raiz que este
		//en ese momento, pues anteriormente la raiz era n y no n1
		if(n1.fe == +1){//si en el anterior se compara n1.fe = +1, ahora es lo contrario
			//el simetrico,se cumple
			n.fe = 0;//esta equilibrado
			n1.fe = 0;//esta equilibrado
		}else{
			n.fe = 1;//esta equilibraco
			n1.fe = -1;//esta quilibrado
		}
		return n1;//retornamos la raiz nueva
	}
	private NodoAVL rotacionID(NodoAVL n, NodoAVL n1){
		//La rotacion izquierda-derecha tiene mas que solo rotar de izquierda a derecha
		//esta rotacion debe tener en cuenta los tres nodos invlocrados
		//la raiz como n
		//n1 como hijo izquierdo
		//n2 como hijo derecho de n1
		
		NodoAVL n2;
		n2 = (NodoAVL) n1.derecho();
		n.ramaIzquierda(n2.derecho());
		n2.ramaDerecha(n);
		n1.ramaDerecha(n2.izquierdo());
		n2.ramaIzquierda(n1);
		//al igual que el otro, solo que despues siempre va quedar en +1 o -1
			if (n2.fe == +1)
			 	n1.fe = -1;
			else
				n1.fe = 0;
			if (n2.fe == -1)
				n.fe = 1;
			else
				n.fe = 0;
		n2.fe = 0;
		raiz = n2;
		return n2;
	}
	private NodoAVL rotacionDI(NodoAVL n, NodoAVL n1){
		//La rotacion derecha-izquierda tiene mas que solo rotar de izquierda a derecha
		//esta rotacion debe tener en cuenta los tres nodos invlocrados
		//la raiz como n
		//n1 como hijo derecho
		//n2 como hijo izquierdo de n1
		NodoAVL n2;
		n2 = (NodoAVL) n1.izquierdo();
		n.ramaDerecha(n2.izquierdo());
		n2.ramaIzquierda(n);
		n1.ramaIzquierda(n2.derecho());
		n2.ramaDerecha(n1);
		raiz = n2;
		//al igual que el otro, es su simetrico
		if (n2.fe == +1)
			n.fe = -1;
			else
			n.fe = 0;
			if (n2.fe == -1)
			 n1.fe = 1;
			else
			 n1.fe = 0;
		n2.fe = 0;
		return n2;
	}
	public void insertar(T valor){
		Logical h = new Logical(false);
		raiz = insertarAVL(raiz, valor, h);
		this.inorden(raiz);
		System.out.println();
	}
	//este metodo balancea el arbol y decide cuando es momento de equilibrar
	private NodoAVL insertarAVL(NodoAVL raiz, T dato, Logical h){
		NodoAVL n1;
		if(raiz == null){//esta vacia
			raiz = new NodoAVL(dato);
			h.setLogical(true);
		}else if(dato.compareTo(raiz.valorNodo()) < 0){//es menor dato, tiramos por
			//el izquierdo
			Nodo iz = insertarAVL((NodoAVL)raiz.izquierdo(), dato, h);
			raiz.ramaIzquierda(iz);
			if(h.booleanValue()){
				switch(raiz.fe){
				case 1:
					 raiz.fe = 0;
					 h.setLogical(false);
					 break;
				case 0:
					raiz.fe = -1;
					 break;
				case -1:
					n1 = (NodoAVL)raiz.izquierdo();
					if(n1.fe == -1){
						raiz = rotacionII(raiz, n1);
					}else{
						raiz = rotacionID(raiz, n1);
					}
					h.setLogical(false);
				}
			}
			
		}else if( dato.compareTo(raiz.valorNodo()) > 0){//es mayor el dato, tiramos por
			//el derecho
			NodoAVL dr = insertarAVL((NodoAVL)raiz.derecho(), dato, h);
			raiz.ramaDerecha(dr);
			if(h.booleanValue()){
				switch(raiz.fe){
				case 1:
					n1 = (NodoAVL) raiz.derecho();
					if(n1.fe == 1){//si se cumple que el fe de la raiz entonces hacemos 
						//la derecha derecha
						raiz = rotacionDD(raiz ,n1);
					}else{
						//y si no la derecha izquierda 
						raiz = rotacionDI(raiz, n1);
					}
					h.setLogical(false);//cambiamos esto para que ya no venga por aqui
					break;
				case 0:
					raiz.fe = 1;
					break;
				case -1:
					raiz.fe = 0;
					h.setLogical(false);
				}
			}
		}else{
			throw new RuntimeException("No puede haber claves repetidas " );
		}
		return raiz;
	}
	public void inorden(NodoAVL raiz){
		if(raiz!=null){//imprimimos dato con fe y cada vez qe inserte se llamara a este
			//pues esta adentro de la funcion  insertar
			inorden((NodoAVL)raiz.izquierdo);
			System.out.print(" "+raiz.dato + " => "+ raiz.fe);
			inorden((NodoAVL)raiz.derecho);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolAVL tree = new ArbolAVL();
		tree.insertar(50);
		tree.insertar(25);
		tree.insertar(60);
		tree.insertar(12);
		tree.insertar(35);
		tree.insertar(45);
		System.out.println(tree.raiz.dato);
		tree.inorden(tree.raiz);
		
	}
}
