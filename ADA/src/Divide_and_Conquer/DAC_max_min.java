package Divide_and_Conquer;

public class DAC_max_min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1,2,3,4,5,6,7,8,9,12,32,43,54,65};
		boolean max = binary_search_random(list,0,list.length-1,32);
		System.out.println(max);
	}

	
//list,first_element,last_element,key_search
public static boolean binary_search_random(int list[], int b, int f, int key) {
	int middle;
	if(b > f) {
		return false;
	}
	middle = (int) Math.random()*(f-b+1)+b;
	//middle = (b + (int)(Math.random() % (f-b+1)));
	if(list[middle] == key) {
		return true;
	}else {
		if(list[middle] > key) {
			return binary_search(list,b,middle-1,key);
		}else {
			return binary_search(list,middle+1,f,key);
		}
	}
	
	
	
}
	
public static boolean binary_search(int[] list, int b, int f,int key) {
		int middle;
		if(b > f) {
			return false;
		}
		middle = (f+b)/2;
		if(list[middle] == key) {
			return true;
		}else {
			if(list[middle] > key) {
				return binary_search(list,b,middle-1,key);
			}else {
				return binary_search(list,middle+1,f,key);
			}
		}
		
	}
	
	public static int DAC_max(int[] list, int index, int last) {
		int max;
		if(index >= last-2) {
			if(list[index] > list[index + 1]) {
				return list[index];
			}else {
				return list[index + 1];
			}
		}
		max = DAC_max(list,index + 1, last);
		if(list[index] > max) {
			return list[index];
		}else {
			return max;
		}
	}
	
	public static int DAC_min(int[] list, int index, int length) {
		int min;
		if(index == length - 2) {
			if(list[index] > list[index + 1]) {
				return list[index + 1];
			}else {
				return list[index];
			}
		}
		min = DAC_min(list, index + 1, length);
		if(list[index] < min) {
			return list[index];
		}else {
			return min;
		}
	}
	public static int DAC_min_reverse(int list[], int index, int move) {
		
		if(index < list.length && move < list.length) {
			if(list[index] > list[move]) {
				return DAC_min_reverse(list,index+1,move);
			}else {
				return DAC_min_reverse(list,index,move+1);
			}
		}else {
			if(index < list.length) {
				return list[index];
			}else {
				return list[move];
			}
		}
		
	}
	public static int DAC_max_reverse(int list[], int index, int move) {
		if(index < list.length && move < list.length) {
			if(list[index] > list[move]) {
				return DAC_max_reverse(list,index,move+1);
			}else {				
				return DAC_max_reverse(list,index+1,move);
				
			}
		}else {
			if(index < list.length) {
				return list[index];
			}else {
				return list[move];
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
