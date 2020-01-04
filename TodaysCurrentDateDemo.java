import java.util.*; 

/**
 * Simple Method to get current date by
 * Day Month Date Year,  as a String
 * Eduardo Estrada "Wed Dec 25 2019"
 */ 
public class TodaysCurrentDateDemo {  
    public static void main(String[] args){  
        TodaysCurrentDateDemo dateDemo = new TodaysCurrentDateDemo();
        try {
            System.out.println(dateDemo.displayTodaysDate());
        } catch (Exception  e) {}//  end trycatch
    }// end main()  
    
    /**
     * Returns a String of todays date in the format
     * Day Month date YYYY ie.."Wed Dec 25 2019"
     */
    public String displayTodaysDate() throws Exception {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        String stringDate = date.toString();
        String todaysDate = stringDate.substring(0, 10); // Wed Dec 25
        return todaysDate + " " + calendar.get(Calendar.YEAR); // Wed Dec 25 2019
    }// end displayTodaysDate()
} 