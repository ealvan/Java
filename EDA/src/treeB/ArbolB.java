package treeB;
public class ArbolB {

  private int T;

  public class Nodo {
    int numClaves;
    int clave[] = new int[2 * T - 1];//el max numero de Claves
    Nodo hijo[] = new Nodo[2 * T];//max numero de hijos
    boolean hoja = true; // es hoja

    //esta posicion nos retorna la posicion de la clave, si no lo encuentra
    //nos retorna -1
    public int posicion(int clave) {
      for (int i = 0; i < this.numClaves; i++) {
        if (this.clave[i] == clave) {
          return i;
        }
      }
      return -1;
    };
  }
  //constructor
  public ArbolB(int t) {
    T = t;// es el grado
    raiz = new Nodo();//creando la raiz
    raiz.numClaves = 0;//sin claves aun
    raiz.hoja = true;//es hoja al inicio
  }

  Nodo raiz;

  private void insercion_ordenada(Nodo x, int pivote, Nodo y) {
    Nodo nuevo = new Nodo();
    nuevo.hoja = y.hoja;
    nuevo.numClaves = T - 1;//el nuevo tendra el minimo numero de claves
    //ahora trasladaremos las claves al nuevo nodo
    for (int j = 0; j < T - 1; j++) {
      nuevo.clave[j] = y.clave[j + T];
    }
    
    if (!y.hoja) {
    //si no es hoja, significa que tiene hijos, asi que
    // trasladamos los hijos tambien
      for (int j = 0; j < T; j++) {
    	//ya no de T - 1, sino T, pues los posicion(hijo)  = posicion(clave) +1
        nuevo.hijo[j] = y.hijo[j + T];
      }
    }
    y.numClaves = T - 1;//ahora hacemos que "y" tenga el minimo nro de claves
    //para hallar el pivote
    for (int j = x.numClaves; j >= pivote + 1; j--) {
      x.hijo[j + 1] = x.hijo[j];
    }
    //el pivote es el numClave
    //pivote +1 seria el hijo derecho
    
    x.hijo[pivote + 1] = nuevo;
    //ahora trasladamos todas las claves una posicion
    for (int j = x.numClaves - 1; j >= pivote; j--) {
      x.clave[j + 1] = x.clave[j];
    }
    //ahora insertamos, pues debemos llenar el hueco
    x.clave[pivote] = y.clave[T - 1];
    //como ya insertamos, aumentamos el nro de claves
    x.numClaves = x.numClaves + 1;
  }

  // este metodo inserta la clave como tal
  public void insertar(int clave) {
    Nodo r = raiz;//creando referencia a la raiz
    //si el numero de claves es igual al maximo de claves
    //debemos dividir
    if (r.numClaves == 2 * T - 1) {
      //creando un nuevo nodo para que sea la nueva raiz
      Nodo s = new Nodo();
      //no sera hoja pues sera nuestra nueva raiz
      s.hoja = false;
      //por el momento esta vacia
      s.numClaves = 0;
      //ahora hacemos el hijo izquierdo nuestra raiz
      s.hijo[0] = r;
      //actualizando la raiz
      raiz = s;
      //ahora el derecho
      insercion_ordenada(s, 0, r);
      
      insertar_(s, clave);
    } else {
    //si hay espacio todavia
      insertar_(r, clave);
    }
  }

  // Este metodo me inserta la clave en un nodo
  private void insertar_(Nodo nodo, int valor) {

    if (nodo.hoja) {// es hoja, solo insertamos
    	//vamos a mover desde el numero claves hasta el inicio del array
    	//osea 0
      int i = nodo.numClaves-1;//es -1, por que moveremos posiciones
      while(i >= 0 && nodo.clave[i] > valor){
    	 nodo.clave[i+1] = nodo.clave[i];
    	  i--;
      }
      //ahora que dejamos un hueco, i estara en la posicion anterior
      // a donde se debe insertar el valor
      //insertamos el valor en la posicion 
      nodo.clave[i + 1] = valor;
      //aumentamos el numero de claves despues de insertar
      nodo.numClaves++;
    } else {
    	//si no es hoja, recorremos con recursividad 
    	//hasta llegar un nodo hoja
    	int i = nodo.numClaves-1;//vamos a encontrar el pivote
    	//si encontramos el pivote donde el valor sea mayor a la clave 
    	//en ese instante, la posicion sera la posicion antepenultima
    	//del hijo derecho
    	//empezamos del antepenultimo(claves-1) al primero(0)
    	while(i >= 0 && nodo.clave[i] > valor){
      	  i--;
        }
    //por eso le subimos uno mas, para que sea el hijo derecho
      i++;
      Nodo derecho = nodo.hijo[i];
      //ahora si vemos que el hijo esta lleno(2*T-1 max de claves)
      if (derecho.numClaves == 2 * T - 1) {
    	 //insertamos de forma ordenada, en la posicion
    	  //del hijo derecho
        insercion_ordenada(nodo, i, derecho);
        if (valor > nodo.clave[i]) {
          i++;
        }
      }
      insertar_(nodo.hijo[i], valor);
    }
  }

  public void imprimir() {
    imprimir(raiz);
  }

  // Imprimir arbol
  private void imprimir(Nodo x) {
    if(x == null){
    	System.out.print("No se puede imprimir, es null");
    }else{
    	for (int i = 0; i < x.numClaves; i++) {
    	    System.out.print(x.clave[i] + "; ");
    	}
    	System.out.println();
        if (!x.hoja) {
    	    for (int i = 0; i < x.numClaves + 1; i++) {
    	        imprimir(x.hijo[i]);//imprimimos cada hijo
    	    }
        }
    } 
  }
  public static void main(String[] args) {
    ArbolB b = new ArbolB(3);
    b.insertar(1);
    b.insertar(2);
    b.insertar(4);
    b.insertar(3);
    b.insertar(5);
    b.insertar(10);
    b.insertar(8);
    b.imprimir();
  }
}