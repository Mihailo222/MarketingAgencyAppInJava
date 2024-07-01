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
public class VratiSveKlijenteFilterSO  extends OpstaSO{

    public VratiSveKlijenteFilterSO() throws Exception {
        super();
    }
    
    
    
    
    
       private List<Klijent> klijenti=new ArrayList<>();

    public List<Klijent> getKlijenti() {
        return klijenti;
    }
    
    
    
    
    
    @Override
    protected void executeOperation(Object nazivKompanije) throws Exception {
      
    
      List<DomainObject> klijentiObj=dbbr.getAllObjectsWithSelectCondition((String)nazivKompanije, new Klijent());
      
      for(DomainObject domObj:klijentiObj){
        klijenti.add((Klijent)domObj);
    }
      
      
      
    
    }

    @Override
    protected void validate(Object nazivKompanije) throws Exception {
        
        if(nazivKompanije==null ||   !(nazivKompanije instanceof String)) throw new Exception("Neodgovarajući naziv.");
        
    }
}
