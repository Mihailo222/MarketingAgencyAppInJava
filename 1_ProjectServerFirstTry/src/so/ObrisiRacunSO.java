/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;


import domain.Racun;
import domain.StavkaRacuna;


/**
 *
 * @author Acer
 */
public class ObrisiRacunSO extends OpstaSO{

    public ObrisiRacunSO() throws Exception {
        super();
    }
    
    
    
   private Racun dbRacun;

    public Racun getRacun() {
        return dbRacun;
    }

  
    
    @Override
    protected void executeOperation(Object racun) throws Exception {
       
    //    dbbr.izbrisiSamoStavke((Racun)racun, new StavkaRacuna()); //brise stavke
    //    dbbr.izbrisiSamoRacun(((Racun)racun).getId(), new Racun()); //brise stavke
        
     dbbr.deleteObject((Racun)racun, new StavkaRacuna());
     dbbr.deleteObject(((Racun)racun).getId(), new Racun());
    
    
       
    }
    
    
    
    
   @Override
    protected void validate(Object racun) throws Exception {
        if(racun ==null || !(racun instanceof Racun)) throw new Exception("Racun ne sme biti null");
  
    }
    
}
