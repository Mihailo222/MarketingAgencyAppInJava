/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;


import domain.DomainObject;
import domain.Racun;
import domain.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class VratiStavkeFilterSO extends OpstaSO{

    public VratiStavkeFilterSO() throws Exception {
        super();
    }
    
    
    
    
        private List<StavkaRacuna> stavke=new ArrayList<>();

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }
    
    
    
    
    
    @Override
    protected void executeOperation(Object racun) throws Exception {
      //  stavke=dbbr.getAllStavke((Racun) racun, new StavkaRacuna());
        List<DomainObject> stavkeObj=dbbr.getObjectsWithConditionJoin(((Racun)racun).getId(), new StavkaRacuna());
    
    
    
        for(DomainObject domObj:stavkeObj){
            stavke.add((StavkaRacuna)domObj);
        }
    
    
    
    }

    @Override
    protected void validate(Object racun) throws Exception {
        
        if(racun==null ||   !(racun instanceof Racun)) throw new Exception("Neodgovarajući racun.");
        
}
}