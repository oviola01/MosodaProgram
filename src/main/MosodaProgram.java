package main;

import modell.Ing;
import modell.Mosoda;
import modell.Pulover;
import modell.Ruha;
import modell.RuhaMeret;

public class MosodaProgram {

    private Mosoda mosoda;

    public static void main(String[] args) {
        new MosodaProgram();
    }
    
    public MosodaProgram() {
        mosoda = new Mosoda(4);
        
        //Ruha ruhaPeter = new Ruha("Péter");
        //ha külső referenciánk van, akkor a tömbbön kívül is elérjük, és az nem jó!
        //emiatt hozzuk létre úgy, hogy az objektumpéldányt a meghívott metódus paramétereként hozzuk létre
        
        mosoda.bevesz(new Ing("Péter"));
        mosoda.bevesz(new Pulover("Pál", RuhaMeret.tini));
        mosoda.bevesz(new Ing("Petra"));
        mosoda.bevesz(new Pulover("Piroska"));
        
        System.out.println("--- mosás ELŐTT:");
        mosodaRuhaitKiir();
        
        System.out.println("--- mosás UTÁN:");
        mosoda.mos();
        mosodaRuhaitKiir();
        
        System.out.println("--- Pál és Petra kivette ruháit");
        //Pulover ruhaPal = mosoda.kiad("Pál");
        mosoda.kiad("Petra");
        System.out.println("--- A mosodában MARADT ruhák:");
        mosodaRuhaitKiir();
        mosoda.mosodaLeeg();
        mosodaRuhaitKiir();
        
    }
    
    private void mosodaRuhaitKiir() {
        for (String ruha : mosoda.getRuhakLeirasa()) {
            if(ruha != null){
                System.out.println(ruha);
            }
        }
    }
    
}
