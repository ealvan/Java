package EXCERCISE;

public class divide_and_conquer {
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9};
		int indice = busqueda_binary(arr,0,8,4);
		System.out.println("busqueda binaria");
		System.out.println(indice);
		int no_ordenado[] ={9,8,7,6,5,4,2,3,1};
		System.out.println("ORDENACION ASCENDENTE");
		ordenar_ascent(no_ordenado,0,no_ordenado.length-1);
		String list = "";
		for(int entero : no_ordenado){
			list += entero;
		}
		System.out.println(list);
		System.out.println("ORDENACION DESCENDENTE");
		int no_sorting[] = {1,2,3,4,5,6,8,7,9};
		ordenar_descent(no_sorting,0,no_sorting.length-1);
		list="";
		for(int i =0; i<no_sorting.length;i++){
			list+= no_sorting[i];
		}
		System.out.println(list);
		System.out.println("FIBONACCI !!");
		list = "";
		for(int i = 0; i <= 33;i++){
			list += i +" --> "+ fibonacii(i) + "\n";
		}
		System.out.println(list);
		
	}
	public static int busqueda_binary(int arr[],int start , int end , int x){
		
		if(arr.length==0){
			return -1;
		}
		int m = (start+end)/2;
		if(start == end){
			if(arr[start] == x){
				return m;
			}else{
				return -1;
			}
		}else{
			// start ***********m*******x***** end
			//                   m+1****x***** end
			// start ****x****m-1
			if(arr[m]==x){
				return m;
			}else{
				if(arr[m] < x){
					return busqueda_binary(arr,m+1,end,x);
				}else{
					return busqueda_binary(arr,start,m-1,x);
				}
			}	
		}
	}
	public static void ordenar_ascent(int arr[],int start , int end){
		if(arr.length == 0){
			return;
		}
		int m = (start +end)/2;
		int pivote = arr[m];
		int init = start;
		int fin =  end;
		while( fin >= init){
			while(pivote > arr[init]){
				init++;
			}
			while(pivote < arr[fin]){
				fin--;
			}
			if(init <= fin){
				//intercambiar 
				int aux = arr[init];
				arr[init]= arr[fin];
				arr[fin] = aux;
				init++;
				fin--;
			}
		}
		if(start < fin){
			ordenar_ascent(arr,start,fin);
		}
		if(init > end){
			ordenar_ascent(arr,init,end);
		}
	}
	public static void ordenar_descent(int arr[],int start , int end){
		if(arr.length == 0){
			return;
		}
		int m = (start +end)/2;
		int pivote = arr[m];
		int init = start;
		int fin =  end;
		while( fin >= init){
			while(pivote < arr[init]){
				init++;
			}
			while(pivote > arr[fin]){
				fin--;
			}
			if(init <= fin){
				//intercambiar 
				int aux = arr[init];
				arr[init]= arr[fin];
				arr[fin] = aux;
				init++;
				fin--;
			}
		}
		if(start > fin){
			ordenar_ascent(arr,start,fin);
		}
		if(init < end){
			ordenar_ascent(arr,init,end);
		}
	}
	public static int fibonacii(int n){
		if(n==0){
			return 0;
		}else{
			if(n==1){
				return 1;
			}else{
				return fibonacii(n-1)+fibonacii(n-2);
			}
		}
	}
}
