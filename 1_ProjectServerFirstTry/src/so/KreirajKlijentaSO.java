/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Klijent;

/**
 *
 * @author Acer
 */
public class KreirajKlijentaSO extends OpstaSO{

    public KreirajKlijentaSO() throws Exception {
        super();
    }


    
    
    
    
    @Override
    protected void executeOperation(Object klijent) throws Exception {
     //  dbbr.unesiKlijenta((Klijent)klijent);
        dbbr.insertObject((Klijent)klijent);
    }

    @Override
    protected void validate(Object klijent) throws Exception {
        if(klijent ==null || !(klijent instanceof Klijent)) throw new Exception("Klijent ne sme biti null");
        if( ((Klijent)klijent).getIme().isEmpty() ||  ((Klijent)klijent).getPrezime().isEmpty() || ((Klijent)klijent).getPreduzece().isEmpty() || ((Klijent)klijent).getMaticni_broj().isEmpty())
            throw new Exception("Neispravno popunjeni podaci o klijentu!Morate popuniti sva polja");
    }
    
}
