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
   public static void main(String[] args){
      
      login();
      
   
   }
	
   /**
   *
   * Denne metode opretter et objekt og laver et 
   * metodekald, hvor man kan v�lge hvilken slags ansat 
   * man er. 
   */
   
	public static void login() {
      Ansat login = new Ansat();
		login.menu(); //valg af ansat
            
	}

	public static void filer() {
		
	}

}