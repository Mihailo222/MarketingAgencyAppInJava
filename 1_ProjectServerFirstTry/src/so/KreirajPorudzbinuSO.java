/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Porudzbina;

/**
 *
 * @author Acer
 */
public class KreirajPorudzbinuSO  extends OpstaSO{

    public KreirajPorudzbinuSO() throws Exception {
        super();
    }

    
    
    
    
     @Override
    protected void executeOperation(Object porudzbina) throws Exception {
     //  dbbr.unesiPorudzbinu((Porudzbina)porudzbina);
     dbbr.insertObject((Porudzbina)porudzbina);
    }

    @Override
    protected void validate(Object porudzbina) throws Exception {
        if(porudzbina ==null || !(porudzbina instanceof Porudzbina)) throw new Exception("Porudžbina ne sme biti null");
        if( ((Porudzbina)porudzbina).getDatum().equals(null) ||  ((Porudzbina)porudzbina).getOpis().isEmpty() || ((Porudzbina)porudzbina).getKlijent().equals(null) || ((Porudzbina)porudzbina).getZaposleni().equals(null))
            throw new Exception("Neispravno popunjeni podaci o porudžbini!Morate popuniti sva polja");
    }
    
}
