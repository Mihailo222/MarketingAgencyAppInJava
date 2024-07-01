/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import domain.Menadzer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Controller;
/**
 *
 * @author Acer
 */
public class StartServer extends Thread{
    
    ObradaKlijentskogZahteva okz;
    ServerSocket ssocket;
    Socket socket;
    boolean kraj = false;
    
    ArrayList<ObradaKlijentskogZahteva> clients = new ArrayList<>();
    

    public StartServer() {
      
    }

    
    
    

    
    
    
    @Override
    public void run() {
        
            
        try {
            ssocket = new ServerSocket(9001);
            System.out.println("Server radi.....");
          
         
       
            
            while(!kraj && !isInterrupted()){
                
                
                
                
                
                
                socket = ssocket.accept();
                System.out.println("Klijent se zakacio...");
                
                
                
                okz = new ObradaKlijentskogZahteva(socket, this);
                okz.start();
                clients.add(okz);
                
             
                
                
                
                
            }
            
            
        } catch (IOException ex) {
             Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
  public void zaustavi(){

           interrupt();
           kraj=true;


   System.out.println("Server je ugasen");
    }
    
    
  public void ugasiSve(){
      
      for(ObradaKlijentskogZahteva okz: clients){
          okz.zaustavi();
      }
      
      zaustavi();
      
      
  }
  
  
  
 
  
  public boolean isLoggedManager(Menadzer menadzer){
      
      for(ObradaKlijentskogZahteva okz: clients){
          if(okz.getMenadzer()!=null){
              if(menadzer.getUsername().equals(okz.getMenadzer().getUsername())  &&   
                      menadzer.getPassword().equals(okz.getMenadzer().getPassword()))
                  return true;
                  
                  
                  }
      }
      
      return false;
  }
  
  public boolean removeFromListOfClients(Menadzer menadzer){
      
       for(ObradaKlijentskogZahteva okz: clients){
          
              if(menadzer.getUsername().equals(okz.getMenadzer().getUsername())  &&   
                      menadzer.getPassword().equals(okz.getMenadzer().getPassword())){
               
                  clients.remove(okz);
                  return true;
                  
              }
                  
                  
                  
      }
      
      return false;
      
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

    public ArrayList<ObradaKlijentskogZahteva> getClients() {
        return clients;
    }
   
    
}
