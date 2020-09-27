package Algoritm_Married;

 
public class MergeSort {

	public static void main(String[] args) {
		
		//long start = System.currentTimeMillis();
		//int[] list = {1,2,0,0,0};
		//int[] min = {-1,4,3};
		//int[] list1 = {1};
		//list1 = rest(list1);
		//print_(list1);
		//System.out.print(list1.length);
		//list = append(min,list);
		//min = mergeSort(min);
		//long fin = System.currentTimeMillis() - start;
		//System.out.println(fin);
		//print_(min);
		
		int[] list;
		long start, fin ;
		for(int i = 1; i < 10000; i++) {
			list  = generate(i);
			list = mergeSort(list);
			reverse(list);
			start = System.nanoTime();
			list = mergeSort(list);
			fin = System.nanoTime() - start;
			System.out.println(fin);
		}
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
public static int[] mergeSort(int arr[]) {
	if(arr.length <= 1) {
		return arr;
	}
	int left[] = new int[arr.length/2];
	int right[] = new int[arr.length-arr.length/2];
	int  _result_[] = new int[left.length+right.length];
	
	int middle = arr.length/2;
	//0 ..to.. middle - 1
	for(int i = 0; i < middle; i++) {
		left[i] = arr[i];
	}
	for(int i = middle; i < arr.length; i++) {
		right[i - middle] = arr[i];
	}
	left = mergeSort(left);
	right = mergeSort(right);
	if (left[left.length - 1 ] <= right[0]) {
		//int  _result_[] = new int[left.length+right.length];
		for(int i = 0; i < _result_.length; i++) {
			if(i < left.length) {
				_result_[i] = left[i];
			}else {
				_result_[i] = right[i-middle];
			}
		}
		return _result_;
	}
	_result_ = merge(left,right);
	return _result_;
}
public static int[] merge(int left[],int right[]) {
	int[] result=new int[right.length+left.length];

	int i = 0;
	
	while(left.length > 0 && right.length > 0) {
		if( left[0] <= right[0] ) {
			result[i] = left[0];
			left = rest(left);
		}else{
			result[i] = right[0];
			right = rest(right);
		}
		i++;
	}
	if(left.length > 0) {
		result = append(left,result);
	}
	if(right.length > 0) {
		result = append(right,result);
	}
	return result;
}
public static int[] rest(int [] list) {
	int []_list_ = new int[list.length-1];
	for(int i = 1; i < list.length; i++) {
		_list_[i-1] = list[i];  
	}
	return _list_;
}
public static int[] append(int list_min[], int result[] ) {
	int i= 0;
	for(; i < result.length; i++) {
		if(result[i] == 0) {
			break;
		}
	}
	for(int j = i; j < result.length; j++ ) {
		result[j] = list_min[j-i]; 
	}
	
	return result;
}
public static int[] generate(int num) {
	int[] list = new int[num];
	for(int i = 0; i < list.length; i++) {
		list[i] = (int)(Math.random()*num + 1);	
	}
	return list;
}


	
}
