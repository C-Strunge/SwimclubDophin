import java.util.*;
import java.io.*;

/**
*
* @Martin.Valhalla
* @Casper.ortismal
*/

public class Traener extends Ansat {

	/**
   * beskrivelse her
   */
	public int subMenu()throws Exception{
		Scanner console = new Scanner(System.in);
      int menu = -1;
      while (menu != 0){
         traenerMenu();
         
         super.testConsoleInput(console);               
         
         switch(this.menu){
            case 1: printDisciplin(); break; //tilf�j switch
            case 2: printKandidater(); break; //tilf�j switch
            case 3: printListe(); break; //printe fra konkurrencesv�mmere fil
            case 4: registrerStaevne(console); break; //tilf�jer navn + st�vne til fil
            case 0: 
               this.menu = -1; //for at den ikke ogs� hopper ud af ansats menu
               super.menu(); //menu hos ansat
               break;
            default: 
               System.out.println("Tast venligst et nummer der er fremvist");
               subMenu();
         }
         break;
      }
      return 0;            
	}
   
   public void traenerMenu(){
      System.out.println("Tast 1 for disciplinliste med tilknyttede medlemmer");
      System.out.println("Tast 2 for top 5 liste over disciplin"); //�ndres
      System.out.println("Tast 3 for liste over konkurrencesvoemmere");
      System.out.println("Tast 4 for at registrere deltagelse i st�vne");
      System.out.println("Tast 0 for at gaa tilbage\n<=="); 
   }
   
   /**
   * Beskrivelse her
   */
   
	public void printDisciplin(){
		System.out.println("<==|_Kom_ind_|==>");
      //switch
	}
   
   /**
   * Beskrivelse her
   */
   
   public void printKandidater(){
      System.out.println("<==|_Kom_ind_|==>");
      //switch
   }

   /**
   * Beskrivelse her
   */  
    
   public void printListe()throws Exception{
      System.out.println("<==|_Kom_ind_|==>");
      subMenu();
   }
   
   //Beskrivelse
   
   public void registrerStaevne(Scanner console)throws Exception{
      System.out.println("Indtast fornavn");
      super.setFornavn(console.next());
      System.out.println("Indtast efternavn");
      super.setEfternavn(console.next());
      System.out.println("Indtast staevnenavn");
      super.setStaevneNavn(console.next());
      System.out.println("Indtast bedste staevnetid");
      super.setStaevneTid(console.nextDouble());
      System.out.println("Indtast placering");
      super.setPlacering(console.nextInt());
      
      //valg af disciplin
      Formand refMetode = new Formand();
      refMetode.vaelgDisciplin(console);
      
      saveToFile(refMetode);
      
      subMenu();
   }
   
   /**
   * Den laver et metodekald p� vaelgDisciplin i formand klasse
   * og sammenligner Disciplin.
   * Udf�re den p�g�lende case for disciplinen.
   */
   
   public void saveToFile(Formand refMetode)throws Exception{
      switch(refMetode.getDisciplin()){
         case "Crawl":
            Crawl save = new Crawl(super.getFornavn(),super.getEfternavn(), super.getStaevneNavn(), super.getStaevneTid(), super.getPlacering(), refMetode.getDisciplin());
            break;
         default:
            break;
      }
   }
   
   /**
   * L�ser fra fil ... Tilf�j n�r metode er f�rdig 
   * Ikke f�rdig
   */
   public void transferToList(String fileName)throws Exception{
      Scanner oldFile = new Scanner(new File(fileName));
      
      while(oldFile.hasNextLine()){
         this.count++;
         if(oldFile.nextLine() == null)
            break;
      } 
      
      System.out.println(this.count);
      
      
      String medlemmer[][] = new String[this.count][5];
      
      //skal initialisere ny scanner fordi f�r k�rt et while loop til at counte
      //s� den skal have initialiseret en ny scanner til samme fil.
      Scanner oF = new Scanner(new File(fileName));
      while(oF.hasNext()){
         for(int i = 0; i < this.count; i++){
            for(int j = 0; j < 5; j++){
               String item = oF.next();
               medlemmer[i][j] = item;
            } 
         }
         break;
      }
      for(int i = 0; i < this.count; i++){
         
      }
   }
}