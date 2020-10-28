package Agenda;

public class Hijo extends Persona{

	private Padre mi_padre;
	public Hijo(String name, String apell , String eda){
		super(name,apell,eda);
	}
	public void setPadre(Padre father){
		mi_padre = father;
	}
	public Padre getPadre(){
		return mi_padre;
	}
	public String toString(){
		//return super.toString() + "mi padre es: "+"mi_padre.getNombre()"+" "+"mi_padre.getApellido()";
		return super.toString();
	}
	 
}
