/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Racun;
import domain.StavkaRacuna;
import domain.Usluga;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Acer
 */
public class KreirajRacunSO  extends OpstaSO{

    public KreirajRacunSO() throws Exception {
        super();
    }
    
    
    
    
    
    
    @Override
    protected void executeOperation(Object racun) throws Exception {
  
    
    //unos u tabelu racun
    dbbr.insertObject((Racun)racun);
    
    
    //vadi sve usluge iz baze
    List<DomainObject> objects = dbbr.getAllObjects(new Usluga());
    List<Usluga> uslugePostojece = new ArrayList<>();
    
    for(DomainObject o:objects){
        uslugePostojece.add((Usluga)o);
     //   System.out.println((Usluga)o);
        
    }
    
    List<StavkaRacuna> stavkeRacuna =  ((Racun)racun).getStavkeRacuna();
            List<Usluga> uslugeZaBazu=new ArrayList<>();
            for(StavkaRacuna stavka:stavkeRacuna){
                if(!uslugePostojece.contains(stavka.getUsluga()))
                    uslugeZaBazu.add(stavka.getUsluga());
                 
            }
    
        
           
           
           //unos novih usluga u bazu koje prethodno nisu postojale
            dbbr.insertMultipleObjects(uslugeZaBazu, new Usluga());
    
            
           for(StavkaRacuna stavka:stavkeRacuna){
             
           
            
    
            
            
            System.out.println(stavka);
           
             dbbr.insertObjectWithCondition((Racun)racun, stavka);
             
           }
            
    
    
    
    
    }

    @Override
    protected void validate(Object racun) throws Exception {
        if(racun ==null || !(racun instanceof Racun)) throw new Exception("Racun ne sme biti null");
        if( ((Racun)racun).getDatum()==null  ||       ((Racun)racun).getMenadzer()==null ||    ((Racun)racun).getPorudzbina()==null ||  ((Racun)racun).getStavkeRacuna()==null ||  ((Racun)racun).getUkupno()==0)
            throw new Exception("Neispravno popunjeni podaci o računu!Morate popuniti sva polja");
    }
}
