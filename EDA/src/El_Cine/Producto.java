package El_Cine;

import java.text.DecimalFormat;


public class Producto extends Nodo {
    
    private int cantidad;
    private double precio;
    public static int cant = 0;
 
    /**
     * Constructor por defecto
     * @param cantidad
     * @param precio
     */
    public Producto(int cantidad, double precio){
    	super(new String(""));
    	this.cantidad=cantidad;
        this.precio=precio;
    }
    public void tes(){
		
	}
    /**
     * Devuelve la cantidad de productos
     * @return Cantidad de producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Devuelve el precio
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve el precio final que tiene un producto
     * @return precio final
     */
    public double precioFinal(){
        
        //Formateamos el precio final por problemas de precision
        DecimalFormat df=new DecimalFormat("#,##");
        return Double.parseDouble(df.format(this.precio * this.cantidad));
    }
    public String toString(){
    	cant++; 
    	return "producto "+(cant) + " ==> (   "+cantidad+" ,       "+precio+") ==> "+precioFinal()+" \n";
    }
    
}
