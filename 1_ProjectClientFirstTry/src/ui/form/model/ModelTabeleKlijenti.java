/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.model;

import domain.Klijent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class ModelTabeleKlijenti  extends AbstractTableModel{

     String kolone[]={"ID","IME","PREZIME","PREDUZEĆE","MATIČNI BROJ"};
     List<Klijent> klijenti = new ArrayList<>();

    public ModelTabeleKlijenti(List<Klijent> klijenti) {
        this.klijenti=klijenti;
    }
    
  
    
    @Override
    public int getRowCount() {
       return klijenti.size();
    }

    @Override
    public int getColumnCount() {
       return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      
        Klijent k = klijenti.get(rowIndex);
        
        switch(columnIndex){
            
            case 0:
                return k.getId();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getPreduzece();
                
            case 4:
                return k.getMaticni_broj();
            default:
                return "N/A";
            
            
            
        }
        
        
        
        
    }

    @Override
    public String getColumnName(int column) {


        return kolone[column];

    }

    public List<Klijent> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(List<Klijent> klijenti) {
        this.klijenti = klijenti;
    }
    
    
    
}
