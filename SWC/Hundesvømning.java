import.java.util.*;
import.java.io.*;

public class Hundesv�mning extends Medlem {

   public Crawl(String fornavn, String efternavn, String staevneNavn, double staevneTid, int placering, String disciplin)throws Exception{
      super.setFornavn(fornavn);
      super.setEfternavn(efternavn);
      super.setStaevneNavn(staevneNavn);
      super.setStaevneTid(staevneTid);
      super.setPlacering(placering);
      super.setDisciplin(disciplin);
      
      //gemmer til fil
      super.saveIt("hundesvoemning.txt");
   }
   
   @Override   
   public String toString(){
      return super.getFornavn()+" "+super.getEfternavn()+" "+super.getStaevneNavn()+" "
               +super.getDisciplin()+" "+super.getStaevneTid()+" "+super.getPlacering();
   }
}