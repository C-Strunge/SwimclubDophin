import java.util.*; // for Scanner
import java.io.*; // for PrintStream


public class Kasserer extends Ansat {
   
   protected int counter = 0; //brugt i redigerKontingent
   
   public Kasserer(){}
   
   public Kasserer(String fornavn, String efternavn, String restance){
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setRestance(restance);   
   }
   
   public Kasserer(String fornavn, String efternavn, int alder, String medlemsskab){
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setAlder(alder);
      setMedlemsskab(medlemsskab);
   }
   
   public Kasserer(String fornavn, String efternavn, int alder, String medlemsskab, String disciplin, double tid, String dato){ 
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setAlder(alder);
      setMedlemsskab(medlemsskab);
      setDisciplin(disciplin);
      setTid(tid);
      setDato(dato);
   }
   
	public void subMenu()throws Exception {
		Scanner console = new Scanner(System.in);
      int menu = -1;
      
      while(menu != 0){
         subMenuInfo();
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               visRestance();
               menu = 0;
               break;
            case 2:
               betalingsstatus();
               menu = 0;
               break;
            case 3:
               redigerKontigent(console);
               menu = 0;   
               break;
            case 4:
               kontingentPris(console);
               menu = 0;
               break;
            case 0: 
               this.menu = -1; //for at den ikke ogs� hopper ud af ansats menu
               super.menu(); //menu hos ansat
               break;
            default: 
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST\n");
               subMenu();
         }
         break; //for kun at komme ud af dette loop
      }
	}
   
   public void subMenuInfo(){
      System.out.printf("%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n", "PRINT RESTANCELISTE", 
            "TRYK 1", "PRINT BETALINGSSTATUS", "TRYK 2", "REDIGER BETALING","TAST 3","KONTINGENTPRIS FOR MEDLEM","TAST 4", "RETURNER", "TAST 0");
   }

   
   /**
   * Beskrivelse her
   */
   public void betalingsstatus() throws Exception {
      Scanner status = new Scanner(new File("visRestance.txt"));
         System.out.printf("%-10s%-15s%-10s\n", "FORNAVN", "EFTERNAVN", "STATUS");
         System.out.printf("---------------------------------\n");
            List<Kasserer> vis = new ArrayList<>();
            while(status.hasNextLine()){ 
               String line = status.nextLine();
               Scanner token = new Scanner(line);
               
               String navn = token.next();
               setFornavn(navn);
               
               String enavn = token.next();
               setEfternavn(enavn);
               
               String rest = token.next();
               setRestance(rest); 
               
               System.out.printf("%-10s%-15s%-10s", getFornavn(),getEfternavn(),getRestance());
               System.out.println(); 
            }
            System.out.println(); 
            subMenu();
   }
  
   /**
   * Beskrivelse her
   */
   
   public void visRestance() throws Exception{
      Scanner RestanceKonti = new Scanner(new File("visRestance.txt"));
         System.out.printf("%-12s%-15s%-10s\n", "FORNAVN", "EFTERNAVN", "STATUS");
            System.out.printf("-----------------------------------\n");
            List<Kasserer> vis = new ArrayList<>();
            
            while(RestanceKonti.hasNextLine()){
               String line = RestanceKonti.nextLine();
               Scanner token = new Scanner(line);
               
               String navn = token.next();
               setFornavn(navn);
               
               String enavn = token.next();
               setEfternavn(enavn);
               
               String rest = token.next();
               setRestance(rest);
               
               if(rest.equals("Restance")){
                 
               System.out.printf("%-12s%-15s%-10s", getFornavn(),getEfternavn(),getRestance());
               System.out.println(); 
            } 
         
      Kasserer kas = new Kasserer(getFornavn(),getEfternavn(),getRestance());
      vis.add(kas);
           
      } 
      System.out.println();
      subMenu(); 
   }
   
   @Override
   public String toString() {
      return " ";
   }
   
   public int count(String fileName)throws Exception{
      Scanner scanFil = new Scanner(new File(fileName));  
      //Printf s� det ser p�nt og formateret ud 
      while(scanFil.hasNextLine()){
         this.counter++;
         System.out.println(this.counter + " " + scanFil.nextLine());
      }
      return this.counter;
   }
   
   public void redigerKontigent(Scanner console)throws Exception{
      Scanner scanRest = new Scanner(new File("visRestance.txt")); 
      String fileName = "visRestance.txt";
      count(fileName);
      String redigerRestance[][] = new String[this.counter][3];
      
      while(scanRest.hasNext()){
         for(int i = 0; i < this.counter; i++){
            for(int j = 0; j < 3; j++){
               String item = scanRest.next();
               redigerRestance[i][j] = item;
            }
         }
      }
      int dummy = 0;
      while(dummy == 0){
         System.out.println("\nTAST NUMMER PAA MEDLEM DU OENSKER AT OPDATERE BETALING PAA");
         int num = console.nextInt(); //Check vaerdi?
         
         while (dummy == 0) {
            if (num <= 0 || num > this.counter) {
               System.out.println("\nTAST NUMMER PAA MEDLEM DU OENSKER AT OPDATERE BETALING PAA");
               num = console.nextInt(); //Check vaerdi?
            }
            else if (num > 0 && num <= this.counter){
                  dummy = 1;
            }
         }
         System.out.println("HAR MEDLEMMET BETALT TAST 1\nMANGLER MEDLEMMET AT BETALE TAST 2");
         String input = console.next();
         if(input.equals("1")){
            setRestance("Betalt");
            redigerRestance[num-1][2] = getRestance();
            dummy = 1;
         }else if(input.equals("2")){
            setRestance("Restance");
            redigerRestance[num-1][2] = getRestance();
            dummy = 1; 
         }else { 
            System.out.println("UGYLDIGT INPUT\nTAST VENLIGST ET TAL DER ER FREMVIST"); 
            this.counter = 0;
            redigerKontigent(console);
         }    
      }
      
      //Overskriver plads i eksisterende fil
      PrintStream addChange = new PrintStream(new File("visRestance.txt"));
      for(int i = 0; i < this.counter; i++){
         addChange.println(redigerRestance[i][0] + " " + redigerRestance[i][1] + " " 
            + redigerRestance[i][2]);
      }
      //clean up
      scanRest.close();
      this.counter = 0;
      
      System.out.println("...MEDLEMMETS BETALING ER NU BLEVET OPDATERET...\n");
      int dummy2 = 0;
      while(dummy2 == 0){
         System.out.println("FOR AT OPDATERE ENDNU ET MEDLEMS BETALING TAST 1\nRETUNER TAST 0");
         String fort = console.next();
         if(fort.equals("1")){
            redigerKontigent(console);
            dummy2 = 1;
         }else if(fort.equals("0")){
            subMenu();
            dummy2 = 1;
         }else{  
            System.out.println("UGYLDIGT INPUT\nTAST VENLIGST ET TAL DER ER FREMVIST"); 
         }
      }
   }
   
   public void kontingentPris(Scanner console)throws Exception{
      Scanner scK = new Scanner(new File("konkurrenceSvoemmere.txt"));
      Scanner scM = new Scanner(new File("motionister.txt"));
      ArrayList<Kasserer> konkurrence = new ArrayList<>();
      ArrayList<Kasserer> motionist = new ArrayList<>();
      
      System.out.println("TAST 1 FOR MOTIONIST MEDLEM\nTAST 2 FOR KONKURRENCE MEDLEM");
      String num = console.next();
      
      if(num.equals("1")){
         String fileName = "motionister.txt";
         count(fileName);
         
         while(scM.hasNextLine()){
               String line = scM.nextLine();
               Scanner token = new Scanner(line);
               
               String fornavn = token.next();
               setFornavn(fornavn);
               
               String efternavn = token.next();
               setEfternavn(efternavn);
               
               int alder = token.nextInt();
               setAlder(alder);
               
               String medlemsskab = token.next();
               setMedlemsskab(medlemsskab);
               
               Kasserer kas = new Kasserer(fornavn, efternavn, alder, medlemsskab);
               motionist.add(kas);
         }

         int dummy = 0;
         while(dummy == 0){
            System.out.println("\nTAST NUMMER PAA MEDLEM DU OENSKER AT SE KONTINGENTPRIS PAA");
            int number = console.nextInt(); //Check vaerdi?
            
            while (dummy == 0) {
               if (number <= 0 || number > this.counter) {
                  System.out.println("\nTAST NUMMER PAA MEDLEM DU OENSKER AT SE KONTINGENTPRIS PAA");
                  number = console.nextInt(); //Check vaerdi?
               }
               else if (number > 0 && number <= this.counter){
                  dummy = 1;
               }
            }
            
            if(motionist.get(number-1).getMedlemsskab().equals("Passiv")){
               Passiv pas = new Passiv();
               System.out.println(motionist.get(number-1).getFornavn() + " " + motionist.get(number-1).getEfternavn()+" "+motionist.get(number-1).getMedlemsskab()+" "+pas.getPris()+"kr.");
            }else if(motionist.get(number-1).getAlder() < 18){
               Junior ju = new Junior();
               System.out.println(motionist.get(number-1).getFornavn() + " " + motionist.get(number-1).getEfternavn()+" "+motionist.get(number-1).getMedlemsskab()+" "+ju.getPris()+"kr.");
            } 
            //else if alder             
         }    
               
         //System.out.println("hej");
      }else if(num.equals("2")){
         String fileName = "konkurrenceSvoemmere.txt";
         count(fileName);
         System.out.println("hej1");
      }else{
         System.out.println("UGYLDIGT INPUT\nTAST VENLIGST ET TAL DER ER FREMVIST");
         kontingentPris(console); 
      }
      this.counter = 0;
      System.out.println();
      subMenu();
   }
}