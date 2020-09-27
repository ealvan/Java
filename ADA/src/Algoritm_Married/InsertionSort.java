package Algoritm_Married;


public class InsertionSort {

	public static void main(String[] args) {
	for(int i = 1 ; i < 4501; i++) {
		int[] list = generate(i);
		list = insertionSort(list);
		reverse(list);
		long start = System.nanoTime();
		list = insertionSort(list);
		long time = System.nanoTime() - start;
		System.out.println(time);
	}
	
	}
public static int[] insertionSort(int[] list) {
	int index;
	for(int i = 1; i < list.length; i++) {
		index = list[i];
		for(int j = 0; j < i; j++) {
			if(index < list[j]) {
				int aux = list[i];
				list[i] = list[j];
				list[j] = aux;
			}
		}
	}
	return list;
}
public static void reverse(int[] list) {
	int [] list_ = new int[list.length];
	int i = 0;
	for(Integer key: list) {
		list[i]= key;
		i++;
	}
	list = list_;
	
}
public static void print_(int[] list) {
	String str = "";
	for(int i = 0; i < list.length; i++) {
		str += list[i]+" ";
	}
	System.out.println(str);
}
public static int[] generate(int num) {
	int[] list = new int[num];
	for(int i = 0; i < list.length; i++) {
		list[i] = (int)(Math.random()*num + 1);	
	}
	return list;
}
}
