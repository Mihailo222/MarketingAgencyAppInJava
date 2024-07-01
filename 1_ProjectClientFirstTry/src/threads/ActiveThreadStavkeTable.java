/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import ui.form.FrmKreirajRacun;
import ui.form.model.ModelTabeleUslugeStavke;
import uicontroller.Controller;

/**
 *
 * @author Acer
 */
public class ActiveThreadStavkeTable  extends Thread{
    
    FrmKreirajRacun fkr;

    public ActiveThreadStavkeTable(FrmKreirajRacun fkr) {
        this.fkr=fkr;
    }

    @Override
    public void run() {
       while(true){
           
         ModelTabeleUslugeStavke mts;
           try {
               mts = new ModelTabeleUslugeStavke(Controller.getInstance().getStavke());
                fkr.getjTableStavke().setModel(mts);
                String ukupno=String.valueOf(Controller.getInstance().getUkupnaCena());
                fkr.getjTextFieldUkupno().setText(ukupno);
                
                
                
           } catch (Exception ex) {
               Logger.getLogger(ActiveThreadStavkeTable.class.getName()).log(Level.SEVERE, null, ex);
           }
       
           
           
           
           try {
               Thread.sleep(3000);
           } catch (InterruptedException ex) {
               Logger.getLogger(ActiveThreadStavkeTable.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
       }
    }
    
    
    
    
    
    
    
}
