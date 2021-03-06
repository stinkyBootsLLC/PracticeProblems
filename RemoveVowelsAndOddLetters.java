import java.util.*;
/**
 * Progam to take an input string
 * remove all vowels and remove all odd indexed letters
 * Created 12/22/2019
 * @author Eduardo Estrada
 */
public class RemoveVowelsAndOddLetters {
    /**
     * Returns a String that has removed all vowels and odd letters from the input String. 
     * @param  input String
     * @return outPut - String
     */ 
    public String removeUnWantedChars(String input){
        // make all lower case
        String inputToLower = input.toLowerCase();
        // remove all the vowels
        String inputMinusVowels = inputToLower.replaceAll("[aeiou]", "");
        // declare the output to return
        String outPut = "";
        // loop thru the string
        for(int i=0; i < inputMinusVowels.length(); i++){
            // every char will be at an index
            /*
                0 1 2 3 4 5
                s t r i n g
            */
            char c = inputMinusVowels.charAt(i);
            // remainder of the index + 1
            int evenIndex = (i % 2) + 1;
            /*
                this will shift the string from 0
                index 0 needs to be 1 (which is odd)
                1 2 3 4 5 6
                s t r i n g
            */
            if(evenIndex == 2){
                // the index is an even number
                // add to the final output
                outPut += c;
            }
            // else do nothing
        }// end for(int i=0; i < minusVowels.length(); i++)
        return outPut;
    }// end removeUnWantedChars()
    
    public static void main(String args[]) {
        // test the algo
        RemoveVowelsAndOddLetters test = new RemoveVowelsAndOddLetters();
        String[] elements = {"whatAweirdString", "tobyhaha", "noValueADDED", "windowLicker"};
        for (String s: elements) {
        System.out.println(test.removeUnWantedChars(s));
        // calculated output:
        // hwdtn
        // bh
        // vdd   
        // nwcr
        }// end for
    }// end main
}// end class
