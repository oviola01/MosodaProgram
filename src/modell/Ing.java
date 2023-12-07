/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell;

/**
 *
 * @author OlajosViola(SZF_E_20
 */
public class Ing extends Ruha{
    private double szinIntenz;
    
    public Ing(String tulNev) {
        super(tulNev);
        this.szinIntenz=100;
    }

    public double getSzinIntenz() {
        return this.szinIntenz; //itt nem muszáj elé a this
    }

    public void setSzinIntenz(double mertek) {
        this.szinIntenz = this.szinIntenz*mertek;
    }
    
    
    
    /*
    @Override
    public int intenzCsokk(){
        if(this.szinIntenz-3>0){
            this.szinIntenz=this.szinIntenz-3;
        }else{
            this.szinIntenz=0;
        }
        return this.szinIntenz;
    }*/

    @Override
    public String toString() {
        return "Ing{" + "szinIntenz=" + szinIntenz + '}';
    }
    
    
}
