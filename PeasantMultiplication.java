import java.util.Arrays;

// An even older and arguably simpler algorithm, which does not rely on place-value 
// notation, is sometimes called Russian peasant multiplication, Ethiopian peasant 
// multiplication, or just peasant multiplication

/**
 * multiplication algorithm
 */ 
public class PeasantMultiplication {
    
    public static int peasantMultiplyLoop(int x, int y){
        int product = 0;
        while (x > 0){
            // if x is odd 
            if ( x % 2 != 0 ){
                product = product + y;
            }
            x =x/2;
            y = y + y;
        }
        return product;
    }// end peasantMultiplyLoop()    
    
    public static int peasantMultiplyRecursive(int x, int y){
        int product = 0;
        if(x == 0){
            return 0 ;
        } 
        int x1 = x/2;
        int y1 = y + y;
        product = peasantMultiplyRecursive(x1, y1);
        // if x is odd 
        if ( x % 2 != 0 ){
            product = product + y;
        } 
        return product;
    }// end peasantMultiplyRecursive()   
    
    public static void main(String args[]) {
        int x, y;
        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);
        System.out.println(peasantMultiplyRecursive(x,y));
        System.out.println(peasantMultiplyLoop(x,y));
    }// end main() 
}// end class

// Input x=123 y=456

// x   |   y     |  prod
// ____________________
// 123   +456 =    456
// 61    +912 =    1368
// 30    1824
// 15   +3648 =    5016
// 7    +7296 =    12312
// 3    +14592 =   26904
// 1    +29184 =   56088