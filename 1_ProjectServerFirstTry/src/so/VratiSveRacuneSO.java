/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Racun;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class VratiSveRacuneSO  extends OpstaSO{

    public VratiSveRacuneSO() throws Exception {
    super();
    }
    
    
    
    
     private List<Racun> racuni=new ArrayList<>();

    public List<Racun> getRacuni() {
        return racuni;
    }
    
    
    
    
    
    @Override
    protected void executeOperation(Object object) throws Exception {
      //  racuni=dbbr.getAllRacuni((Racun)object);
      List<DomainObject> racuniObj=dbbr.getAllObjectsWithJoin((Racun)object);
      
      for(DomainObject domObj : racuniObj){
          racuni.add((Racun)domObj);
      }
      
      
      
    }

    @Override
    protected void validate(Object object) throws Exception {
        //nema sta od parametara da se validira
    }
}
