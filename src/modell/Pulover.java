/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell;

/**
 *
 * @author OlajosViola(SZF_E_20
 */
public class Pulover extends Ruha{
    
    private RuhaMeret meret;
    //enumként érdemes létrehozni!
    
    public Pulover(String tulNev) {
        super(tulNev);
        this.meret=RuhaMeret.felnőtt;
    }
    
    public Pulover(String tulNev, RuhaMeret meret) {
        super(tulNev);
        this.meret=meret;
    }
    
    public RuhaMeret getMeret() {
        return meret;
    }

    public void setMeret() {
      /*  switch(this.meret) {
            case felnőtt:
              this.meret=RuhaMeret.tini;
              break;
            case tini:
              this.meret=RuhaMeret.gyerek;
              break;
            case gyerek:
              this.meret=RuhaMeret.bébi;
              break;
          }*/
        if(meret!=RuhaMeret.bébi){
              meret=RuhaMeret.values()[meret.ordinal()-1];
          }
    }
    
    @Override
    public String toString() {
        return "Ing{" + "Ruha mérete=" + meret + '}';
    }
    
}
