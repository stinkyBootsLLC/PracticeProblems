import java.util.*; 

public class TestParser {
    // not sure why i made this? has no purpose yet
    // the rules here are - every character in the will be seperated
    // and put into the proper list 
    // alpha chars, mumbers and special characters.
    // the only character that will NOT be parsed is the @ symbol
    // numbers will become integers
    
    // seperates the input string into three different ArrayLists
    public void testParser(String input){
        // declare the lists
        ArrayList<Number> numbers = new ArrayList<>();
        ArrayList<String> alphaChars = new ArrayList<>();
        ArrayList<String> specialChars = new ArrayList<>();
        // declare the tokenizer
        StringTokenizer tokens; 
        // this string will have a delimiter @
        String deliminatedString = "";
        // remove blanks and add @ delimiter 
        String replaceBlanks = input.replaceAll(" ", "@");
        // debug
        System.out.println(replaceBlanks);
        
        // here we are going  to add the @ between every character
        for (int i = 0; i < input.length(); i++){
            deliminatedString += replaceBlanks.charAt(i) + "@";
        }// end for
        // debug
        System.out.println(deliminatedString);
        // now build the tokenizer
        tokens = new StringTokenizer(deliminatedString, "@");
        // loop thru the tokenizer
        while (tokens.hasMoreTokens()) {
            // put the token into temp string
            // if you dont do this it will cause problems
            String temp = tokens.nextToken();
            if (temp.matches("[a-zA-Z]")) {
                 alphaChars.add(temp);
            } else if (temp.matches("[0-9]")){
                numbers.add(Integer.parseInt(temp));
            } else if (temp.matches("[^a-zA-Z0-9:]")){
                specialChars.add(temp);
            } else {
                // do nothing yet 
                // look more into this algorythim
                
            }
        }// end while   
        
        // debug to check the lists
        System.out.println(numbers);
        System.out.println(alphaChars);
        System.out.println(specialChars);
        
    }// end testParser()
    // test the method
    public static void main(String args[]) {
        TestClass test = new TestClass();
        String allCharsOnKeyBoard = "1234567890-=!@#$%^&*()_+qwertyuiop[]\';lkjhgfdsazxcvbnm,./?><MNBVCXZASDFGHJKL:\"|}{POIUYTREWQ";
        test.testParser(allCharsOnKeyBoard);
    }// end main()
}// end class