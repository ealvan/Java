package El_Cine;

/**
 * @author DiscoDurodeRoer
 */
public class Persona extends Producto{
    
    private int edad;
    private int ticket;
    /**
     * Constructor por defecto
     * @param edad
     */ 
    
 
    
    
    public Persona(int edad, int tick){
    	super(12,2);
        this.edad=edad;
        ticket = tick;
    }
    public int getTicket(){
    	return ticket;
    }

    /**
     * Devuelve la edad
     * @return Edad acutal
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Modifica la edad
     * @param edad Valor edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String toString(){
    	return "edad : "+edad + " ticket: "+ ticket;
    }
    
}