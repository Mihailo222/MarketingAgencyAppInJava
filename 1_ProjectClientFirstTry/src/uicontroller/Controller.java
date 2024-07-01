/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uicontroller;

import communication.Operation;

import communication.Reciever;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Klijent;
import domain.Menadzer;
import domain.Porudzbina;
import domain.Racun;
import domain.StavkaRacuna;
import domain.Usluga;
import domain.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Acer
 */
public class Controller {
    Socket socket;
    Sender sender;
    Reciever reciever;
    
    private static Controller instance;
    private  List<StavkaRacuna> stavke = new ArrayList<>();
    private double ukupnaCena=0;

    
    
    
    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }
    
    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    
    private Controller() throws IOException{
        
        socket=new Socket("127.0.0.1", 9001);
        sender=new Sender(socket);
        reciever=new Reciever(socket);
    }
    
    public static Controller getInstance() throws Exception{
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }

    public Menadzer login(Menadzer user) throws Exception {
        
        Request request = new Request(Operation.LOG_IN, user);
       
       System.out.println("KLIJENT POSLAO OVO: "+user.getUsername()+user.getPassword());
        sender.send(request);
        Response response = (Response) reciever.recieve();

        if(response.getException()==null){
            return (Menadzer) response.getResult();
        }else{
            throw response.getException();
        }

    }

    public void kreirajKlijenta(Klijent klijent) throws Exception {

        
  
        Request request = new Request(Operation.KREIRAJ_KLIJENTA, klijent);
       
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

        if(response.getException()==null){
             klijent.setId(((Klijent)response.getResult()).getId()); //vraca mi klijenta
        }else{
            throw response.getException();
        }


    }

    public List<Zaposleni> getZaposleni() throws Exception {

         Request request = new Request(Operation.VRATI_SVE_ZAPOSLENE,null);
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

       
        

        if(response.getException()==null){
           return (List<Zaposleni>)response.getResult();
        }else{
            throw response.getException();
        }






    }

    public void kreirajPorudzbinu(Porudzbina porudzbina) throws Exception {



     Request request = new Request(Operation.KREIRAJ_PORUDZBINU, porudzbina);
       
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

        if(response.getException()==null){
             porudzbina.setId(((Porudzbina)response.getResult()).getId()); 
        }else{
            throw response.getException();
        }







    }

    public List<Klijent> getKlijenti() throws Exception {
        
        
        
        
         Request request = new Request(Operation.VRATI_SVE_KLIJENTE,null);
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

       
        

        if(response.getException()==null){
           return (List<Klijent>)response.getResult();
        }else{
            throw response.getException();
        }






    }

    public List<Klijent> getKlijentiFilter(String StringPred) throws Exception {

     
        
        Request request = new Request(Operation.VRATI_KLIJENTE_PREDUZECA,StringPred);
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

       
        

        if(response.getException()==null){
           return (List<Klijent>)response.getResult();
        }else{
            throw response.getException();
        }







    }

    public void azurirajKlijenta(Klijent klijent) throws Exception {
         Request request = new Request(Operation.AZURIRAJ_KLIJENTA, klijent);
       
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

        if(response.getException()==null){
              System.out.println("Klijent je azuriran.");
        }else{
            throw response.getException();
        }
    }

    public void izbrisijKlijenta(Klijent klijent) throws Exception {
         Request request = new Request(Operation.OBRISI_KLIJENTA, klijent);
       
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

        if(response.getException()==null){
              System.out.println("Klijent je obrisan.");
        }else{
            throw response.getException();
        }
    }

    public List<Porudzbina> getPorudzbine() throws Exception {
         
        
         Request request = new Request(Operation.VRATI_SVE_PORUDZBINE,null);
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

       
        

        if(response.getException()==null){
           return (List<Porudzbina>)response.getResult();
        }else{
            throw response.getException();
        }




    }

    public List<Porudzbina> getPorudzbineFilter(int idP) throws Exception {
         Request request = new Request(Operation.VRATI_PORUDZBINE_FILTER, idP);
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

       
        

        if(response.getException()==null){
           return (List<Porudzbina>)response.getResult();
        }else{
            throw response.getException();
        }


    }

 

    public List<Usluga> getUsluge() throws Exception {
        
         Request request = new Request(Operation.VRATI_SVE_USLUGE,null);
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

       
        

        if(response.getException()==null){
           return (List<Usluga>)response.getResult();
        }else{
            throw response.getException();
        }

    }

    public void dodajStavkuUListuStavki(Usluga usluga) {
        StavkaRacuna stavka = new StavkaRacuna();
        stavka.setUsluga(usluga);
        //stavke nemaju id i nemaju racun
        stavke.add(stavka);
        ukupnaCena=ukupnaCena+usluga.getCena();
    }

    public void obrisiStavkuIzListe(StavkaRacuna stavkaZaBrisanje) {
        stavke.remove(stavkaZaBrisanje);
        ukupnaCena=ukupnaCena-stavkaZaBrisanje.getUsluga().getCena();
    }

    public void kreirajRacun(Racun racun) throws Exception {
       
        Request request = new Request(Operation.SACUVAJ_RACUN, racun);
       
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

        if(response.getException()==null){
             racun.setId(((Racun)response.getResult()).getId()); //vraca mi racun
        }else{
            throw response.getException();
        }
    }

    public List<Racun> getRacuni() throws Exception {

        
         Request request = new Request(Operation.VRATI_RACUNE,null);
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

       
        

        if(response.getException()==null){
           return (List<Racun>)response.getResult();
        }else{
            throw response.getException();
        }


    
    
    
    }

    public List<Racun> getRacuniFilter(String imePrezime) throws Exception {
        Request request = new Request(Operation.VRATI_RACUNE_FILTER, imePrezime);
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

       
        

        if(response.getException()==null){
           return (List<Racun>)response.getResult();
        }else{
            throw response.getException();
        }
    }

    public void izbrisiRacun(Racun racunZaBrisanje) throws Exception {
         Request request = new Request(Operation.OBRISI_RACUN,racunZaBrisanje);
       
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

        if(response.getException()==null){
              System.out.println("Racun je obrisana.");
        }else{
            throw response.getException();
        }
    }

    public List<StavkaRacuna> vratiStavkeRacuna(Racun izabraniRacun) throws Exception {
        Request request = new Request(Operation.VRATI_SVE_STAVKE_RACUNA,izabraniRacun);
       
        sender.send(request);
        Response response = (Response) reciever.recieve();

       
        

        if(response.getException()==null){
           return (List<StavkaRacuna>)response.getResult();
        }else{
            throw response.getException();
        }
    }

    public boolean logout(Menadzer user) throws Exception {
     
    
        Request request = new Request(Operation.LOGOUT, user);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        
        if(response.getException()==null){
            return  ((Boolean)response.getResult()).booleanValue();
        }else{
            throw new Exception();
        }
        
        
        
    }


    
    
    
    
    
    
    
    
}
