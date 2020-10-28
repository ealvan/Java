package Arboles;

public class Arbol{
	
	private String elemento;//es comparable
	
	private Arbol izquierdo;
	private Arbol derecho;
	
	public boolean estaVacio(){
		return this == null;
	}
	public boolean esHoja(){
		return (elemento != null) & (izquierdo == null) & (derecho == null);
	}
	public void insertar(String elemento){
		if(this.elemento == null){
			this.elemento = elemento;
		}else{
			if(this.elemento.equals(elemento)){
				//no se va a poder por que este arbol es de busqueda

			}else{
				if(elemento.compareTo(this.elemento) > 0){
					if(derecho == null){
						derecho = new Arbol();
					}
					derecho.insertar(elemento);
				}else{
					if(izquierdo == null){
						izquierdo = new Arbol();
					}
					izquierdo.insertar(elemento);
				}
			}	
		}
		
	}
	public boolean existe(String elemento){
		if( this == null){
			return false;
		}else{
			if(this.elemento.equals(elemento)){
				return true;
			}else if(elemento.compareTo(this.elemento) > 0 && derecho != null){
						return derecho.existe(elemento);
			}else if(elemento.compareTo(this.elemento) < 0 && izquierdo != null){
						return izquierdo.existe(elemento);
			}else{
					return false;
			}
		}
	}
	public String obtener(String elemento){
		if( this.elemento != null){
			if(elemento.equals(this.elemento)){
				return elemento;
			}else if(elemento.compareTo(this.elemento) > 0 && derecho != null){
				return derecho.obtener(elemento);
			}else if( izquierdo != null){
				return izquierdo.obtener(elemento);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	public void inorden(){
		if(this.elemento != null){
			if(izquierdo != null){
				izquierdo.inorden();
			}
			System.out.print(this.elemento);
			if(derecho != null){
				derecho.inorden();
			}
		}
	}
	public void preorden(){
		if(this.elemento != null){
			System.out.print(elemento);
			if(izquierdo != null){
				izquierdo.preorden();
			}
			if(derecho != null){
				derecho.preorden();
			}		
		}
	}
	public void postorden(){
		if(this.elemento != null){
			
			if(izquierdo != null){
				izquierdo.postorden();
			}
			if(derecho != null){
				derecho.postorden();
			}
			System.out.print(elemento);
		}
	}	
	public void eliminar(String elemento){
		if(this.elemento != null){
			if( this.elemento.equals(elemento)){
				//eliminaremos
			}else if(elemento.compareTo(this.elemento) > 0 && derecho != null){
				derecho.eliminar(elemento);
			}else if(elemento.compareTo(this.elemento) < 0 && izquierdo != null){
				izquierdo.eliminar(elemento);
			}
		}else{
			//esta vacio, no se puede
		}
	}
	
	
	public static void main(String[] args) {
		Arbol tree = new Arbol();
		tree.insertar("uno");
		tree.insertar("dos");
		tree.insertar("tres");
		tree.insertar("cuatro");
		tree.insertar("cinco");
		tree.insertar("seis");
		tree.postorden();
		System.out.println();
		tree.inorden();
		System.out.println();
		tree.preorden();
		System.out.println();
		System.out.println(tree.obtener("siete"));
	}

}
