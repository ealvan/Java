package FibonnaciHeap;
public class FH<T extends Comparable> {

	int nro_nodos = 0;
	Nodo<T> min = null;
	
	public void insercion(T dato){
		Nodo<T> nuevo = new Nodo(dato);
		nuevo.padre  = null;
		nuevo.hijo = null;
		nuevo.izquierdo = nuevo;
		nuevo.derecho = nuevo;
		if( min != null){
			min.izquierdo.derecho = nuevo;
			nuevo.derecho = min;
			nuevo.izquierdo = min.izquierdo;
			min.izquierdo = nuevo;
			if(min.dato.compareTo(dato) > 0){
				min = nuevo;
			}
			
		}else{
			min = nuevo;
		}
		nro_nodos ++;
	}
	void enlazar(Nodo<T> ptr2, Nodo<T> ptr1) 
	{ 
	    (ptr2.izquierdo).derecho = ptr2.derecho; 
	    ptr2.derecho.izquierdo = ptr2.izquierdo; 
	    if (ptr1.derecho == ptr1) 
	    	min = ptr1; 
	    ptr2.izquierdo = ptr2; 
	    ptr2.derecho = ptr2; 
	    ptr2.padre = ptr1; 
	    if (ptr1.hijo == null) 
	        ptr1.hijo = ptr2; 
	    ptr2.derecho = ptr1.hijo; 
	    ptr2.izquierdo = ptr1.hijo.izquierdo; 
	    ((ptr1.hijo).izquierdo).derecho = ptr2; 
	    (ptr1.hijo).izquierdo = ptr2; 
	    if (ptr2.dato.compareTo(ptr1.hijo.dato) < 0) 
	        ptr1.hijo = ptr2; 
	    ptr1.grado++; 
	} 
	public void consolidar(){
		int temp1;
		float temp2 = (float) Math.round(((Math.log(nro_nodos)) / (Math.log(2))));
		int temp3 = (int)temp2;
		Nodo[] arr = new Nodo[temp3+1];
		for (int i = 0; i <= temp3; i++) 
	        arr[i] = null;
		Nodo ptr1 = min;
		Nodo ptr2;
		Nodo ptr3;
		Nodo ptr4 = ptr1;
		do{
			ptr4 = ptr4.derecho; 
	        temp1 = ptr1.grado; 
	        while(arr[temp1] != null){
	        	ptr2 = arr[temp1];
	        	if(((Comparable) ptr1.dato).compareTo(ptr2.dato) > 0){
	        		ptr3 = ptr1; 
	                ptr1 = ptr2; 
	                ptr2 = ptr3;
	        	}
	        	if(ptr2 == min){
	        		min = ptr1;
	        	}
	        	enlazar(ptr2, ptr1);
	        	if (ptr1.derecho == ptr1) 
	                min = ptr1; 
	            arr[temp1] = null; 
	            temp1++;
	        }
	        arr[temp1] = ptr1; 
	        ptr1 = ptr1.derecho;
	        
		}while(ptr1 != min);
		min = null;
		for (int j = 0; j <= temp3; j++) { 
	        if (arr[j] != null) { 
	            arr[j].izquierdo = arr[j]; 
	            arr[j].derecho = arr[j]; 
	            if (min != null) { 
	                (min.izquierdo).derecho = arr[j]; 
	                arr[j].derecho = min; 
	                arr[j].izquierdo = min.izquierdo; 
	                min.izquierdo = arr[j]; 
	                if (((Comparable) arr[j].dato).compareTo(min.dato) < 0 ) 
	                    min = arr[j]; 
	            } 
	            else { 
	                min = arr[j]; 
	            } 
	            if (min == null) 
	                min = arr[j]; 
	            else if (((Comparable) arr[j].dato).compareTo(min.dato) < 0) 
	                min = arr[j]; 
	        } 
	    } 
	}
	void eliminar_min() 
	{ 
	    if (min == null) 
	        throw new RuntimeException("el arbol esta vacio"); 
	    else { 
	        Nodo temp = min; 
	        Nodo pntr; 
	        pntr = temp; 
	        Nodo x = null; 
	        if (temp.hijo != null) { 
	  
	            x = temp.hijo; 
	            do { 
	                pntr = x.derecho; 
	                (min.izquierdo).derecho = x; 
	                x.derecho = min; 
	                x.izquierdo = min.izquierdo; 
	                min.izquierdo = x; 
	                if (((Comparable) x.dato).compareTo(min.dato) < 0) 
	                    min = x; 
	                x.padre = null; 
	                x = pntr; 
	            } while (pntr != temp.hijo); 
	        } 
	        (temp.izquierdo).derecho = temp.derecho; 
	        (temp.derecho).izquierdo = temp.izquierdo; 
	        min = temp.derecho; 
	        if (temp == temp.derecho && temp.hijo == null) 
	            min = null; 
	        else { 
	            min = temp.derecho; 
	            consolidar(); 
	        } 
	        nro_nodos--; 
	    }
	} 
	void mostrar() 
	{ 
	    Nodo ptr = min; 
	    if (ptr == null) 
	        System.out.print("esta vacio");
	    else { 
	    	System.out.println("los nodos raiz son: ");
	        do { 
	            System.out.print(ptr.dato); 
	            ptr = ptr.derecho; 
	            if (ptr != min) { 
	                System.out.print("-->"); 
	            } 
	        } while (ptr != min && ptr.derecho != null); 
	        System.out.println();
	        System.out.println("El numero de nodos es "+nro_nodos);
	    } 
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FH<Integer> heap = new FH();
		heap.insercion(45);
		heap.insercion(22);
		heap.insercion(77);
		heap.mostrar();
		heap.eliminar_min();
		heap.mostrar();
		//System.out.println("El hijo: "+ heap.min.hijo.dato);
		
	}
}
