import java.util.*;

// Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) 
// one item at a time.
// The array elements are compared with each other sequentially and then arranged simultaneously 
// in some particular order.
public class InsertionSortDemo {
    /**
     * Returns a sorted int array
     */
    public static int[] insertionSort(int[] array){
        for (int j = 1; j < array.length; j++){
             /*storing current element whose left side is checked for its 
             correct position .*/
            // key = A[j];
            int key = array[j];
            // i = j - 1; 
            int i = j - 1;
            /* check whether the adjacent element in left side is greater or
            less than the current element. */
            // while ( i > 0 and A[i] > key )
            while ( i >= 0 && array[i] > key ){
                // moving the left side element to one position forward.
                // A[i + 1] = A[i];
                array[i + 1] = array[i];
                // i = i -1;
                i = i -1;
            }// end while
            // A[i + 1] = key;
            // moving current element to its  correct position.
            array[i + 1] = key;
        }// end for 
        return array;
    } // end method 

    
    /**
     * Main method 
     * Test insertionSort()
     */
    public static void main(String args[]) {
        int[] orgArray = new int[args.length];
        // create the array based on command line args
        for (int i = 0; i < args.length; i++){
            orgArray[i] = Integer.parseInt(args[i]);
        }// end for 
        // **************************************************************
        System.out.println("Unsorted Array = "+Arrays.toString(orgArray));
        System.out.println(System.currentTimeMillis());
        long start_time = System.nanoTime();
        System.out.println("Sorted Array = "+Arrays.toString(insertionSort(orgArray)));
        long end_time = System.nanoTime();
        double difference = (end_time - start_time) /  1e6;
        System.out.println("Time Complexity: O(n*2)");
        System.out.println("Time to finish => " + difference +" (ns)");
        System.out.println(System.currentTimeMillis());
    }// end main
}// end class