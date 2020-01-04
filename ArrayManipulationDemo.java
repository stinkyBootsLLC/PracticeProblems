import java.util.*;

// Given an array A of size N, your task is to do some operations, i.e., 
// search an element, insert an element, and delete an element by completing 
// the functions. Also, all functions should return a boolean value.



/**
 * Demo class to search an element, insert an element, and delete an element from an array.
 * @author Eduardo Estrada
 * @version 1.0
 */
public class ArrayManipulationDemo {
    
    /**
     * Returns a boolean, if the VALUE has been found in the input array
     * @param anArray int[]
     * @param value int
     * @return boolean
     */
    public static boolean searchAnElement(int[] anArray,int value){
        // clone org array
        int clonedArray[] = anArray.clone();
        // binary search only works ON SORTED arrays
        Arrays.sort(clonedArray);
        int found = Arrays.binarySearch(clonedArray, value);
        // values < than 0 are NOT found
        if(found >= 0){
            return true;
        }
        return false;
    }// end searchAnElement()

    /**
     * Returns true or false if the input value has been inserted into the input array.
     * @param oldArray int[] array
     * @param value - to insert (int)
     * @param pos - index of the new value (int)
     * @return boolean
     */
    public static boolean insertAnElement(int[] oldArray, int value, int pos){
        // org array size
        int arraySize = oldArray.length;
        // create the new array
        int[] newArray = new int[arraySize + 1];
        // insert the new value @ input position
        for (int i = 0; i < arraySize + 1; i++) {
            if (i < pos)
            newArray[i] = oldArray[i];
            else if (i == pos)
            newArray[i] = value;
            else
            newArray[i] = oldArray[i - 1];
        }// end for arraySize
        // has the new value been inserted?
        return searchAnElement(newArray,value);
    }// end insertAnElement()
    
    
    /**
     * Returns true or false if the input value has been deleted from the input array.
     * @param org_array int[] array
     * @param deleteValue - int - value to delete
     * @return boolean
     */
    public static boolean deleteAnElement(int[] org_array,int deleteValue){
        // size of the org array 
        int arraySize = org_array.length;
        // create the new final array , with size - 1
        // Create another array of size one less
        int[] newArray = new int[arraySize - 1];
        // clone the org array
        int clonedArray[] = org_array.clone(); 
        // the array MUST be sorted to find the delete VALUE index
        Arrays.sort(clonedArray);
        // first find the INDEX of the delete value
        int indexToDelete = Arrays.binarySearch(clonedArray, deleteValue);
        // check if the index to delete excists
        if(indexToDelete >= 0){
            // copy the SORTED CLONED ARRAY into the new array
            // The java.lang.System.arraycopy() method copies an array from 
            // the specified source array, beginning at the specified position, 
            // to the specified position of the destination array.
            /*
                src − This is the source array.
                srcPos − This is the starting position in the source array.
                dest − This is the destination array.
                destPos − This is the starting position in the destination data.
                length − This is the number of array elements to be copied
                
                public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
                
                [0, 1, 2, 4, 6]
                
                indexToDelete = 3
                
                [0, 1, 2, 6]
    
            */
            // Copy the elements from starting till index 
            // from original array to the other array 
            System.arraycopy(clonedArray, 0, newArray, 0, indexToDelete); 
            // Copy the elements from index + 1 till end 
            // from original array to the other array 
            System.arraycopy(clonedArray, indexToDelete + 1, newArray, indexToDelete, clonedArray.length - indexToDelete - 1);
            // has the value been deleted?
            return !searchAnElement(newArray,deleteValue); 
        }
        
        return false;
    }// end deleteAnElement()

    public static void main(String args[]) {
        // Input Format:
        // The first line of input consists of T, the number of test cases. T testcases follow. 
        // Each testcase contains 3 lines of input. The first line of every test case consists 
        // of an integer N, denotes the number of elements in an array. The second line of 
        // every test cases consists of N spaced integers Ai. The third line of every test case 
        // consists of four integers X, Y, Yi and Z, denoting the elements for the search operation, 
        // insert operation, insert operation element index and delete operation respectively.
        // Test case input 
        int T = 1;
        int N = 5;
        int[] theArray = {2, 4 ,1 ,0 ,6};
        int x = 1;
        int y = 2;
        int yi = 2;
        int z = 0;
        
        
        System.out.println("Original Array => " + Arrays.toString(theArray));
        // search
        System.out.println("is the value " + x + " in the array? => " + searchAnElement(theArray,x));
        // insert
        System.out.println("has the value " + y + " been successfully inserted into the array? => " + insertAnElement(theArray,y,yi));
        // delete
        System.out.println("has the value " + z + " been successfully deleted from the array? => " + deleteAnElement(theArray,z));
        
    }// end main
   
   
   
}// end class