package modell;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mosoda {
    private Ruha[] ruhak;
    private int ruhaDb;
    private boolean mukodik;

    public Mosoda() {
        this(5);
    }

    public Mosoda(int db) {
        ruhaDb = 0;
        ruhak = new Ruha[db];
        mukodik = true;
    }
    
    public void bevesz(Ruha ruha){
        if(mukodik==true){
            if(ruhaDb < ruhak.length){
                ruhak[ruhaDb++] = ruha;
            }else{
                System.out.println("A mosoda megtelt!");
            }
        }else{
            hibauzenet();
        }
    }
    
    public void mos(){
        if(mukodik==true){
            for (Ruha ruha : ruhak) {
                if(ruha != null){
                    ruha.setTiszta(true);
                   // ruha.intenzCsokk();
                   if(ruha instanceof Ing){
                       ((Ing)ruha).setSzinIntenz(0.97);              
                   }
                   if(ruha instanceof Pulover){
                       ((Pulover)ruha).setMeret();              
                   }
                }
            }
        }else{
                hibauzenet();
            }
    }
    
    public void kimeloMosas(){
        if(mukodik==true){
            for (Ruha ruha : ruhak) {
                if(ruha != null){
                    ruha.setTiszta(true);
                   // ruha.intenzCsokk();
                   if(ruha instanceof Ing){
                       ((Ing)ruha).setSzinIntenz(0.985);              
                   }
                }
            }
        }else{
                hibauzenet();
            }
    }
    
    public Ruha kiad(String tulNeve){
        if(mukodik==true){
            int i = 0;
            while(ruhak[i] == null || i < ruhaDb && !(ruhak[i].getTulNev().equals(tulNeve))){
                i++;
            }
            if(i < ruhaDb){
                Ruha ruha = this.ruhak[i];

                System.out.println(String.format("Kiadva %s ruhája!", tulNeve));
                ruhak[i] = null;
                return ruha;
            }else{
                System.out.println("Nincs ilyen ruha a mosodában!");
            }
        } else {
                hibauzenet();        
        }
        return null;
    }

    public String[] getRuhakLeirasa() {
        String[] ruhak = new String[this.ruhak.length];
        for (int i = 0; i < ruhaDb; i++) {
            Ruha r = this.ruhak[i];
            if(r != null){
                ruhak[i] = r.getTulNev() + " ruhája ";
                ruhak[i] += r.isTiszta() ? "tiszta" : "koszos";
                ruhak[i] += r.toString();
                
            }
        }
        return ruhak;
    }
    
    public Ruha[] mosodaLeeg() {
        //System.out.println("A mosoda leégett!");
        for (int i = 0; i < this.ruhak.length; i++) {
            Ruha r = this.ruhak[i];
            if(r != null){
               // System.out.println(String.format("%s ruhája elégett!", r.getTulNev()));
                this.ruhak[i] = null;
            }
        }
        return this.ruhak;
    }
    
    /* egy veszélyes getter: 
     - referenciát adunk a belső adattagra, 
     - így az setteré válik
    */
    public Ruha[] getRuhakAmiEgySetter() {
        return ruhak;
    }
    
    /* lehetne a ruhaDb-ra is getter */
    
    /* egy korrekt getter:
     - egy módosíthatalan listát adunk vissza
     - nem fedjük fel a belső adatreprezentációt, 
       annak változása eetén nem kell módosítai a getter típusát
    */
    public List<Ruha> getRuhak(){
        List<Ruha> ruhakListaja = Arrays.asList(ruhak);
        return Collections.unmodifiableList(ruhakListaja);
    }

    private void hibauzenet() {
        System.out.println("A mosoda nem működik!");    
    }
}
