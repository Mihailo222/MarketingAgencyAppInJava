/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Zaposleni;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class VratiSveZaposleneSO extends OpstaSO{

    public VratiSveZaposleneSO() throws Exception {
    super();
    }
    
    
    

    private List<Zaposleni> zaposleni=new ArrayList<>();

    public List<Zaposleni> getZaposleni() {
        return zaposleni;
    }
    
    
    
    
    
    @Override
    protected void executeOperation(Object object) throws Exception {
       List<DomainObject> zaposleniObject=dbbr.getAllObjects((Zaposleni)object);
       
       for(DomainObject zapObj:zaposleniObject){
           zaposleni.add((Zaposleni)zapObj);
       }
       
    }

    @Override
    protected void validate(Object object) throws Exception {
        //nema sta od parametara da se validira
    }
    
}
