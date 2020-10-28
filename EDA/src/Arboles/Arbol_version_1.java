package Arboles;

public class Arbol_version_1 {
	private int elemento;
	private Arbol_version_1 left;
	private Arbol_version_1 right;
	private Arbol_version_1 padre;
	public boolean esta_vacio(){
		return elemento == 0;
	}
	public boolean es_hoja(){
		return elemento != 0 && left == null && right == null;
	}
	private void insertar_con_padre(int elemento, Arbol_version_1 padre){
		if(this.elemento == 0){//esta vacia
			this.elemento = elemento;
			this.padre = padre;
		}else{
			 if(this.elemento == elemento){
					throw new RuntimeException("es un elemento duplicado");
				}else if(this.elemento < elemento){
					if(right == null){
						right = new Arbol_version_1();
					}
					right.insertar_con_padre(elemento,this);
				}else if(this.elemento > elemento){
					if(left == null){
						left = new 	Arbol_version_1();
					}
					left.insertar_con_padre(elemento,this);
				}
		}
	}
	public void insertar(int elemento){
		this.insertar_con_padre(elemento,null);
	}
	public boolean existe(int elemento){
		if(this.elemento == 0){
			return false;
		}else if(this.elemento == elemento){
			return true;
		}else if(this.elemento > elemento && left != null){
			return left.existe(elemento);
		}else if(this.elemento < elemento && right != null){
			return right.existe(elemento);
		}else{
			return false;
		}
	}
	public int obtener(int elemento){
		if(this.elemento == 0){
			return 0;
		}else if(this.elemento == elemento){
			return elemento;
		}else if(this.elemento > elemento && left != null){
			return left.obtener(elemento);
		}else if(this.elemento < elemento && right != null){
			return right.obtener(elemento);
		}else{
			return 0;
		}
	}
	/*
	 * public String preorden(){
		String str = "";
		str += this.elemento;
		if(left != null)str += left.preorden() +" ";
		if(right != null)str += right.preorden()+ " ";
		return str;
	}
	 * */
	public void preorden(){
		System.out.print(elemento);
		if(left != null){
			left.preorden();
		}
		if(right != null){
			right.preorden();
		}
	}
	public void inorden(){
		if(left != null){
			left.inorden();
		}
		System.out.print(elemento);
		if(right != null){
			right.inorden();
		}
	}
	public void postorden(){
		if(left != null){
			left.postorden();
		}
		if(right != null){
			right.postorden();
		}
		System.out.print(elemento);
	}
	private Arbol_version_1 minimo(){
		if(left != null && !left.esta_vacio()){
			return left.minimo();
		}else{
			return this;
		}
	}
	public void eliminar_elem(int elemento){
		if(left != null && right != null){
			// tiene dos hijos 
			/*Arbol_version_1 arbol_minimo = this.left;
			Arbol_version_1 padre_actual = this.padre;
			this.padre.elemento = arbol_minimo.elemento;
			this.padre.left = null;*/
			Arbol_version_1 minimo = minimo();
			this.elemento = minimo.elemento;
			this.eliminar(minimo.elemento);
			
			
		}else if(left != null || right != null){
			// tiene un hijo
			Arbol_version_1 arbol;
			if(left != null){
				arbol = left;
			}else{
				arbol = right;
			}
			this.elemento = arbol.elemento;
			this.left = arbol.left;
			this.right = arbol.right;
			
		}else{
			// es hoja
			if(padre != null){
				if(padre.left == this) padre.left = null;
				if(padre.right == this) padre.right = null;
				padre = null;
			}
			this.elemento = 0;
		}
	}
	public void eliminar(int elemento){
		if(this.elemento == 0){
			throw new RuntimeException("estoy vacio por dentro");
		}else{
			if(this.elemento == elemento){
				//eliminare el elemento
				eliminar_elem(elemento);
			}else if(this.elemento < elemento && right != null){
				right.eliminar(elemento);
			}else if(this.elemento > elemento && left != null){
				left.eliminar(elemento);
			}
		}
	}
	public static void main(String[] args) {
		Arbol_version_1 tree = new Arbol_version_1();
		tree.insertar(5);
		tree.insertar(6);
		tree.insertar(4);
		tree.insertar(3);
		tree.insertar(7);
		System.out.println(tree.obtener(7)+" --> "+tree.existe(7));
		System.out.println(tree.obtener(3)+" --> "+tree.existe(3));
		System.out.println(tree.obtener(4)+" --> "+tree.existe(4));
		System.out.println(tree.obtener(6)+" --> "+tree.existe(6));
		System.out.println(tree.obtener(1)+" --> "+tree.existe(1));
 		tree.preorden();
		System.out.println();
		tree.inorden();
		System.out.println();
		tree.postorden();
	}
}