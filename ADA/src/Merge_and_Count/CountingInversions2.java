package Merge_and_Count;
import java.util.Arrays; 
public class CountingInversions2 {
	  
	
	    // Function to count the number of inversions 
	    // during the merge process 
	    private static int mergeAndCount(Ciudad[] arr,  
	                                int l, int m, int r) 
	    { 
	  
	        // Left subarray 
	        Ciudad[] left = Arrays.copyOfRange(arr, l, m + 1); 
	  
	        // Right subarray 
	        Ciudad[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
	  
	        int i = 0, j = 0, k = l, swaps = 0; 
	  
	        while (i < left.length && j < right.length)  
	        { 
	            if (left[i].id <= right[j].id) 
	                arr[k++] = left[i++]; 
	            else { 
	                arr[k++] = right[j++]; 
	                swaps += (m + 1) - (l + i); 
	            } 
	        } 
	        return swaps; 
	    } 
	  
	    // Merge sort function 
	    private static int mergeSortAndCount(Ciudad[] arr,  
	                                        int l, int r) 
	    { 
	  
	        // Keeps track of the inversion count at a 
	        // particular node of the recursion tree 
	        int count = 0; 
	  
	        if (l < r) { 
	            int m = (l + r) / 2; 
	  
	            // Total inversion count = left subarray count 
	            // + right subarray count + merge count 
	  
	            // Left subarray count 
	            count += mergeSortAndCount(arr, l, m); 
	  
	            // Right subarray count 
	            count += mergeSortAndCount(arr, m + 1, r); 
	  
	            // Merge count 
	            count += mergeAndCount(arr, l, m, r); 
	        } 
	  
	        return count; 
	    } 
	  
	    // Driver code 
	    public static void main(String[] args) 
	    { 
	    	
	    	Ciudad[] ruta_off = {
					new Ciudad("Lima",1),new Ciudad("Arequipa",2),
					new Ciudad("Junin",3),new Ciudad("Puno",4),
					new Ciudad("Cuzco",5),
					};
			Ciudad[] ruta_new = {
					new Ciudad("Arequipa",1),new Ciudad("Lima",20),
					new Ciudad("Junin",6),new Ciudad("Puno",4),
					new Ciudad("Cuzco",5),
				};
			
			
			Turista t1 = new Turista("Carlos","Peru",ruta_new);
	    	
	        int[] arr = { 1, 20, 6, 4, 5 }; 
	        System.out.println(mergeSortAndCount(t1.ruta, 0, t1.ruta.length - 1)); 
	    } 
	
} 
	  
	// This code is contributed by Pradip Basak
	

