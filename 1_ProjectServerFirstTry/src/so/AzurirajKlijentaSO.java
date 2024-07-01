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
public class AzurirajKlijentaSO extends OpstaSO{

    public AzurirajKlijentaSO() throws Exception {
        super();
    }
    
 
    
    
    
    
    
     private Klijent dbKlijent;

    public Klijent getKlijent() {
        return dbKlijent;
    }

  
    
    @Override
    protected void executeOperation(Object klijent) throws Exception {
        dbbr.updateObject((Klijent)klijent);
       
    }
    
    
    
    

    @Override
    protected void validate(Object klijent) throws Exception {

        if(klijent==null ||  !(klijent instanceof Klijent) ) throw new Exception("Neodgovarajući klijent.");
         if(((Klijent)klijent).getIme().isEmpty() ||  ((Klijent)klijent).getMaticni_broj().isEmpty()   ||   ((Klijent)klijent).getPrezime().isEmpty()   ||   ((Klijent)klijent).getPreduzece().isEmpty())
             throw new Exception("Nepotpuni podaci za unos!");
    }
}
