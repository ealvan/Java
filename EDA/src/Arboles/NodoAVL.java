package Arboles;


public class NodoAVL<T> extends Nodo<T>{
	int fe;
	public NodoAVL(T valor){
		super(valor);
		fe = 0;
	}
	public NodoAVL(T valor, NodoAVL ramaIzdo, NodoAVL ramaDcho){
		super ( valor,ramaIzdo, ramaDcho);
		fe = 0;
	}

}






