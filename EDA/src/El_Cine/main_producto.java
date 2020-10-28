package El_Cine;

public class main_producto {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cola<Producto> mi_cola = new Cola<Producto>(new Nodo(null));
		
		int productos = generaNumeroAleatorio(1,8);
		double la_cuenta = encolar_productos(mi_cola, productos );
		
		System.out.println("Cantidad: " + productos);
		
		String str = "*****************cantidad******precio*****total";
		System.out.println(str);
		
		System.out.println(imprime_boleta(mi_cola));
		
		System.out.println("Precio Total: "+la_cuenta);
		
		System.out.println("Precio Total: "+Producto.cant);
		
		System.out.println();
		
	}
	public static double encolar_productos(Cola mi_cola, int n){
		int cant=0;
		double precio=0;
		double sum =0;
		
		for(int i = 0; i < n; i++){
			cant = generaNumeroAleatorio(1, 10);
			precio = generaNumeroRealAleatorio(1.0, 20.2); 
			
			Producto m = new Producto(cant, precio);
			
			mi_cola.encolar(m);
			
			sum+=precio;
			
		}
		return sum;
	}
	
	public static String imprime_boleta(Cola cola){
		String str = "";
		
		for(Nodo puntero = cola.cabeza; puntero != null; puntero = puntero.siguiente){
			if(puntero.item != null)
			str += puntero.item.toString();
		}	
		return str;
	}   
	/**
     * Genera un numero aleatorio entre dos numeros.
     * Entre el minimo y el maximo incluidos
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return Número entre minimo y maximo
     */ 
    public static int generaNumeroAleatorio(int minimo, int maximo){
        int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
     
    /**
     * Genera un numero aleatorio entre dos numeros reales.
     * Entre el minimo y el maximo incluidos
     * Devuelve un numero con dos decimales.
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return Número entre minimo y maximo
     */
    public static double generaNumeroRealAleatorio(double minimo, double maximo){
        double num=Math.rint(Math.floor(Math.random()*(minimo-((maximo*100)+1))+((maximo*100)+1)))/100;
        return num;
    }
}
