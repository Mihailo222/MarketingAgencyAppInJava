/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import static communication.Operation.AZURIRAJ_KLIJENTA;
import static communication.Operation.KREIRAJ_KLIJENTA;
import static communication.Operation.KREIRAJ_PORUDZBINU;
import static communication.Operation.LOG_IN;
import static communication.Operation.OBRISI_KLIJENTA;
import static communication.Operation.OBRISI_RACUN;
import static communication.Operation.SACUVAJ_RACUN;
import static communication.Operation.VRATI_KLIJENTE_PREDUZECA;
import static communication.Operation.VRATI_PORUDZBINE_FILTER;
import static communication.Operation.VRATI_RACUNE;
import static communication.Operation.VRATI_RACUNE_FILTER;
import static communication.Operation.VRATI_SVE_KLIJENTE;
import static communication.Operation.VRATI_SVE_PORUDZBINE;
import static communication.Operation.VRATI_SVE_STAVKE_RACUNA;
import static communication.Operation.VRATI_SVE_USLUGE;
import static communication.Operation.VRATI_SVE_ZAPOSLENE;
import communication.Reciever;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Klijent;
import domain.Menadzer;
import domain.Porudzbina;
import domain.Racun;

import java.net.Socket;

import logic.Controller;

/**
 *
 * @author Acer
 */
public class ObradaKlijentskogZahteva extends Thread{
    
    private Menadzer menadzer;
    
     private Sender sender;
     private Reciever reciever; 
      private StartServer server;   
    
    private Controller controller;

    public Menadzer getMenadzer() {
        return menadzer;
    }
    
    
    
    
    private Socket socket;
    boolean kraj = false;

    public ObradaKlijentskogZahteva(Socket socket, StartServer server) {
          this.socket = socket;
          this.server=server;
         this.controller=new Controller();
    }

    @Override
    public void run() {
        
                 
     
                  
            while(!kraj && !isInterrupted()){
       
                  sender=new Sender(socket);
                  reciever=new Reciever(socket);
                
                
                try{
                 Request request=(Request) reciever.recieve();
                 Response response = new Response();
                
                 
                try{ 
                switch(request.getOperation()){
                    
                    case LOG_IN:
                        
                        
                        Menadzer user = (Menadzer) request.getArgument(); //bilo
                        
                        
                        if(!server.isLoggedManager(user)){
                            Menadzer newMenadzer = (Menadzer) controller.login(user);
                            response.setResult(controller.login(user)); //vraca usera, bilo
                            this.menadzer=newMenadzer;
                        }else{
                            throw new Exception("User je uveliko ulogovan");
                        }
                        
                        
                        
                        
                        
                           
                          
                        
                    break;
                    
                    
                    case KREIRAJ_KLIJENTA:
                        Klijent klijent = (Klijent) request.getArgument();
                        controller.kreirajKlijenta(klijent);
                        response.setResult(klijent);
                    break;
                    
                    case VRATI_SVE_ZAPOSLENE:
                       
                        response.setResult(controller.getAllZaposleni());
                    break;
                    
                    case KREIRAJ_PORUDZBINU:
                      
                        Porudzbina porudzbina = (Porudzbina) request.getArgument();
                        controller.kreirajPorudzbinu(porudzbina);
                        response.setResult(porudzbina);
                    break;
                    
                     case VRATI_SVE_KLIJENTE:
                       
                        response.setResult(controller.getAllKlijenti());
                    break;
                    
                     case VRATI_KLIJENTE_PREDUZECA:
                         
                      
                         String StringPred = (String) request.getArgument();
                         
                       
                        response.setResult( controller.getKlijentiFilter(StringPred));
                    break;
                    
                    
                     case AZURIRAJ_KLIJENTA:
                           Klijent klijentZaAzuriranje = (Klijent) request.getArgument();
                        controller.azurirajKlijenta(klijentZaAzuriranje);
                        response.setResult(klijentZaAzuriranje);
                    break;
                    
                    
                     case OBRISI_KLIJENTA:
                          Klijent klijentZaBrisanje = (Klijent) request.getArgument();
                        controller.izbrisiKlijenta(klijentZaBrisanje);
                        response.setResult(klijentZaBrisanje);
                    break;
                    
                    
                    
                     case VRATI_SVE_PORUDZBINE:
                             response.setResult(controller.getAllPorudzbine());
                    
                    break;
                    
                     case VRATI_PORUDZBINE_FILTER:
                         
                      int idP = (Integer) request.getArgument();
                         
                       
                        response.setResult( controller.getPorudzbineFilter(idP));
                    break;
                    
                    
                    
                  
                    
                     case VRATI_SVE_USLUGE:
                          response.setResult(controller.getAllUsluge());
                    break;
                    
                    case SACUVAJ_RACUN:
                          Racun racun = (Racun) request.getArgument();
                        controller.kreirajRacun(racun);
                        response.setResult(racun);
                       
                    break;
                    case VRATI_RACUNE:
                       
                          response.setResult(controller.getAllRacuni());
                          break;
                          
                    case VRATI_RACUNE_FILTER:
                         String imePrez = (String) request.getArgument();
                          response.setResult(controller.getRacuniFIlter(imePrez));
                        break;
                        
                        
                    case OBRISI_RACUN:
                        Racun racunZaBrisanje = (Racun)request.getArgument();
                        controller.izbrisiRacun(racunZaBrisanje);
                        response.setResult(racunZaBrisanje);
                    break;
                    
                    case VRATI_SVE_STAVKE_RACUNA:
                          Racun izabraniRacun = (Racun) request.getArgument();
                          response.setResult(controller.getStavkeRacuna(izabraniRacun));
                        break;
                        
                        
                    case LOGOUT:
                        Menadzer logoutMenadzer = (Menadzer)request.getArgument();
                        boolean signal = server.removeFromListOfClients(logoutMenadzer);
                        response.setResult(signal);
                         break;
                    
                    
                    
                    
                    
            
                    
                }
                }catch(Exception e){
                    e.printStackTrace();
                    response.setException(e);
                }
                
              
                sender.send(response);
                
            }catch(Exception ex){
                   ex.printStackTrace();
            }
                
           
                    
                    }
            
            
  
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    public void zaustavi(){
      
        interrupt();
        kraj = true;
        
        System.out.println("Klijent je ugasen");
        
        
    } 
}
