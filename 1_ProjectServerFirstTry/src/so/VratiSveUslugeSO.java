/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Usluga;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Acer
 */
public class VratiSveUslugeSO  extends OpstaSO{

    public VratiSveUslugeSO() throws Exception {
    super();
    }
    
    
    
    
     private List<Usluga> usluge=new ArrayList<>();

    public List<Usluga> getUsluge() {
        return usluge;
    }
    
    
    
    
    
    @Override
    protected void executeOperation(Object object) throws Exception {
       List<DomainObject> uslugeObj=dbbr.getAllObjects((Usluga)object);
       
       for(DomainObject uslDO:uslugeObj){
           usluge.add((Usluga)uslDO);
       }
       
       
    }

    @Override
    protected void validate(Object object) throws Exception {
        //nema sta od parametara da se validira
    }
}
