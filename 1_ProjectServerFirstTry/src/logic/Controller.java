/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.DomainObject;
import domain.Klijent;
import domain.Menadzer;
import domain.Porudzbina;
import domain.Racun;
import domain.StavkaRacuna;
import domain.Usluga;
import domain.Zaposleni;

import java.util.List;

import so.OpstaSO;
import so.AzurirajKlijentaSO;
import so.KreirajKlijentaSO;
import so.KreirajPorudzbinuSO;
import so.KreirajRacunSO;
import so.LoginSO;
import so.ObrisiKlijentaSO;
import so.ObrisiRacunSO;
import so.VratiRacuneFilter;
import so.VratiStavkeFilterSO;
import so.VratiSveKlijenteFilterSO;
import so.VratiSveKlijenteSO;
import so.VratiSvePorudzbineFilterSO;
import so.VratiSvePorudzbineSO;
import so.VratiSveRacuneSO;
import so.VratiSveUslugeSO;
import so.VratiSveZaposleneSO;

/**
 *
 * @author Acer
 */
public class Controller {

   


    
    
    
    public  Controller(){

    }
    
    
    
    public Menadzer login(Menadzer user) throws Exception {

  
        OpstaSO so = new LoginSO();
        so.execute(user);
        return ((LoginSO)so).getMenadzer();
      
   
    }

    public void kreirajKlijenta(Klijent klijent) throws Exception {


       OpstaSO so= new KreirajKlijentaSO();
       so.execute(klijent);
      
       
       
       
       
    }

    public List<Zaposleni> getAllZaposleni() throws Exception {
   
        VratiSveZaposleneSO vratiZaposleneSO = new VratiSveZaposleneSO();
        vratiZaposleneSO.execute(new Zaposleni());
        return vratiZaposleneSO.getZaposleni();
        
        

    }

    public void kreirajPorudzbinu(Porudzbina porudzbina) throws  Exception {





       OpstaSO so= new KreirajPorudzbinuSO();
       so.execute(porudzbina);
      



    }

    public List<Klijent> getAllKlijenti() throws Exception {
   
     
        OpstaSO so = new VratiSveKlijenteSO();
        so.execute(new Klijent());
        return ((VratiSveKlijenteSO)so).getKlijenti();
     
     
     
     
     
     
    }

    public List<Klijent> getKlijentiFilter(String StringPred) throws Exception {

    
       OpstaSO so = new VratiSveKlijenteFilterSO();
        so.execute(StringPred);
        return ((VratiSveKlijenteFilterSO)so).getKlijenti();
     
     
     
     
     
     
     
     
     
    }

    public void azurirajKlijenta(Klijent klijentZaAzuriranje) throws Exception {
       
        OpstaSO so = new AzurirajKlijentaSO();
        so.execute(klijentZaAzuriranje);
        
        
 
         
         
         
         
         
    }

    public void izbrisiKlijenta(Klijent klijentZaBrisanje) throws Exception {
   
     
     
        OpstaSO so = new ObrisiKlijentaSO();
        so.execute(klijentZaBrisanje);
        
        
 
     
     
     
    }

    public List<DomainObject> getAllPorudzbine() throws Exception {
    
           
     OpstaSO so = new VratiSvePorudzbineSO();

        so.execute(new Object());
        return ((VratiSvePorudzbineSO)so).getPorudzbine();
        
        
    }

    public List<DomainObject> getPorudzbineFilter(int idP) throws Exception {

       OpstaSO so = new VratiSvePorudzbineFilterSO();
        so.execute(idP);
        return ((VratiSvePorudzbineFilterSO)so).getPorudzbine();
    
      
    }

  

    public List<Usluga> getAllUsluge() throws Exception {
  
        
          VratiSveUslugeSO so = new VratiSveUslugeSO();
        so.execute(new Usluga());
        return so.getUsluge();
     
     
     
        
        
        
        
        
        
        
        
        
        
        
    }

    public void kreirajRacun(Racun racun) throws Exception {




       OpstaSO so= new KreirajRacunSO();
       so.execute(racun);





    }

    public List<Racun> getAllRacuni() throws Exception {
  
      
        OpstaSO so = new VratiSveRacuneSO();
        so.execute(new Racun());
        return ((VratiSveRacuneSO)so).getRacuni();
      
      
      
    }

    public List<Racun> getRacuniFIlter(String imePrez) throws Exception {

      
         OpstaSO so = new VratiRacuneFilter();
        so.execute(imePrez);
        return ((VratiRacuneFilter)so).getRacuni();
      
      
      
      
      
      
      
    }

    public void izbrisiRacun(Racun racunZaBrisanje) throws Exception {

   
           
        OpstaSO so = new ObrisiRacunSO();
        so.execute(racunZaBrisanje);
        
        
        
        
        
        
        
        
        
        
    }

    public List<StavkaRacuna> getStavkeRacuna(Racun izabraniRacun) throws Exception {
        OpstaSO so = new VratiStavkeFilterSO();
        so.execute(izabraniRacun);
        return ((VratiStavkeFilterSO)so).getStavke();
    }


    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   

