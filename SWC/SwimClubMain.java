import java.util.*;
import java.io.*;

/**               << 1. semester pr�ve eksamen >> 
*
*                          | Projekt |
*                           
* Lavet af:            Sv�mmeklub Delfinen
* @Martin.Valhalla
* @Casper.ortismal
* @Christian.C-Strunge
* @Rasmus.RasmusSadurski
*/

public class SwimClubMain {
   public static void main(String[] args)throws Exception{
     
      int pass = 0;
      
      System.out.print("Velkommen til svoemmeklubben Delfinen. Indtast password:\n");
         while (pass != 1) {
         
            Scanner console = new Scanner(System.in);
            String input;
            input = console.next();
            
            switch(input) {
            
            case "Dolphin": 
            System.out.println("Korrekt password.\n");
            Thread.sleep(2000);
            login();
            break;
            
            default:
            System.out.println("Ugyldigt password. Proev igen");
            break;
            
            }
         
         }
           
      
   }
	
   /**
   * Denne metode opretter et objekt og laver et 
   * metodekald, hvor man kan v�lge hvilken slags ansat 
   * man er. 
   */
   
	public static void login()throws Exception{
      Ansat login = new Ansat();
		login.menu(); //valg af ansat
            
	}
}