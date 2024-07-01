/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Porudzbina;
import java.util.List;

/**
 *
 * @author Acer
 */
public class VratiSvePorudzbineFilterSO extends OpstaSO{  

    public VratiSvePorudzbineFilterSO() throws Exception {
        super();
    }
    
    
    
    
    
    
        private List<DomainObject> porudzbine;

    public List<DomainObject> getPorudzbine() {
        return porudzbine;
    }
    
    
    
    
    
    @Override
    protected void executeOperation(Object idPor) throws Exception {
     //   porudzbine=dbbr.getProudzbineFilter((Integer) idPor, new Porudzbina()); 
    
    
        porudzbine = dbbr.getObjectsWithConditionJoin((Integer)idPor, new Porudzbina());
    
    
    }

    @Override
    protected void validate(Object idPor) throws Exception {
        
        if(idPor=="" ||   !(idPor instanceof Integer)) throw new Exception("Neodgovarajući ID.");
        
    }
}
