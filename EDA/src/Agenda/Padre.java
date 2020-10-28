package Agenda;

public class Padre extends Persona {
	
	private Hijo mi_hijo = new Hijo("notengo todavia","no tengo todavia","no tengo todavia");
	public Padre(String name, String apell , String eda){
		super(name,apell,eda);
	}
	public void setHijo(Hijo child){
		mi_hijo.setApellido(child.getApellido());
		mi_hijo.setNombre(child.getNombre());
		mi_hijo.setEdad(child.getEdad());
		//confio en esto
	}
	public Hijo getHijo(){
		return mi_hijo;
	}
	public String toString(){
		return super.toString() + "  mi hijo es: "+mi_hijo.getNombre()+ " "+mi_hijo.getApellido();
	}

}
