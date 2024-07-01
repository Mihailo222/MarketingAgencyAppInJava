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
public class VratiRacuneFilter extends OpstaSO{

    public VratiRacuneFilter() throws Exception {
        super();
    }
    
    
    
    
     private List<Racun> racuni=new ArrayList<>();

    public List<Racun> getRacuni() {
        return racuni;
    }
    
    
    
    
    
    @Override
    protected void executeOperation(Object imeKlijenta) throws Exception {
        
      //  racuni=dbbr.getRacuniFilter((String) imeKlijenta, new Racun());
    
     List<DomainObject> racuniObj=dbbr.getObjectsWithConditionJoin((String)imeKlijenta, new Racun());
    
     
     for(DomainObject domObj:racuniObj){
         racuni.add((Racun)domObj);
     }
     
    
    }

    @Override
    protected void validate(Object imeKlijenta) throws Exception {
        
        if(imeKlijenta==null ||   !(imeKlijenta instanceof String)) throw new Exception("Neodgovarajući unos.");
        
    }
}
