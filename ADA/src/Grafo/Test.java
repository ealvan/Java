package Grafo;
public class Test {

	public static void main(String[] args) {
		//son 14 vertices en el grafo
		Grafo gr = new Grafo(14);
		
		//insetando nodos
		gr.insertarNodo("1", 1 );
		gr.insertarNodo("2", 2 );
		gr.insertarNodo("3", 3 );
		gr.insertarNodo("4", 4 );
		gr.insertarNodo("5", 5 );
		gr.insertarNodo("6", 6 );
		gr.insertarNodo("7", 7 );
		gr.insertarNodo("8", 8 );
		gr.insertarNodo("9", 9 );
		gr.insertarNodo("10", 10 );
		gr.insertarNodo("13", 11 );
		gr.insertarNodo("15",  12);
		gr.insertarNodo("21",  13);
		gr.insertarNodo("23",  14);
		//****************************
		//agregando relaciones a los nodos
		gr.relacion(1, 2);
		gr.relacion(1, 3);
		gr.relacion(1, 4);
		gr.relacion(1, 5);

		gr.relacion(2, 1);
		gr.relacion(2, 10);
		gr.relacion(2, 11);

		gr.relacion(3, 1);
		gr.relacion(3, 13);

		gr.relacion(4, 1);
		gr.relacion(4, 12);

		gr.relacion(5, 1);
		gr.relacion(5, 14);
		gr.relacion(5, 8);

		gr.relacion(10, 2);

		gr.relacion(11, 2);

		gr.relacion(13, 3);
		gr.relacion(13, 6);
		gr.relacion(13, 7);
		gr.relacion(13, 9);

		gr.relacion(12, 4);

		gr.relacion(14, 5);

		gr.relacion(8, 5);

		gr.relacion(6, 13);

		gr.relacion(7, 13);

		gr.relacion(9, 13);
		
		gr.profundidad(gr.vertices);
		gr.amplitud();
	}
}
