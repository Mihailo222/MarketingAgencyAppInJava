/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;


import domain.DomainObject;
import domain.Klijent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class VratiSveKlijenteSO  extends OpstaSO{

    public VratiSveKlijenteSO() throws Exception {
        super();
    }
  
    
    
    
    
private List<Klijent> klijenti=new ArrayList<>();
    
    
    
    
    public List<Klijent> getKlijenti() {
        return klijenti;
    }
    
    
    
    
    
    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> klijentiObj=dbbr.getAllObjects((Klijent)object);
     
        for(DomainObject dom:klijentiObj){
            klijenti.add((Klijent)dom);
        }
        
        
  
    }

    @Override
    protected void validate(Object object) throws Exception {
        //nema sta od parametara da se validira
    }
}
