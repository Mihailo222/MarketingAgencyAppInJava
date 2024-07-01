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
public class VratiSvePorudzbineSO extends OpstaSO{

    public VratiSvePorudzbineSO() throws Exception {
    super();
    }
    
    
    
    
       private List<DomainObject> porudzbine;

    public List<DomainObject> getPorudzbine() {
        return porudzbine;
    }
    
    
    
    
    
    @Override
    protected void executeOperation(Object object) throws Exception {
      Porudzbina p = new Porudzbina();
       // porudzbine=dbbr.getAllPorudzbine(p);
         porudzbine=dbbr.getAllObjectsWithJoin(p);
    }

    @Override
    protected void validate(Object object) throws Exception {
        //nema sta od parametara da se validira
    }
}
