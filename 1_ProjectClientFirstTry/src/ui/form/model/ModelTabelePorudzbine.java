/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.model;

import domain.Porudzbina;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.w3c.dom.views.AbstractView;

/**
 *
 * @author Acer
 */
public class ModelTabelePorudzbine extends AbstractTableModel{

    String kolone[]={"ID","OPIS","DATUM","ZAPOSLENI","KLIJENT"};
    List<Porudzbina> porudzbine = new ArrayList<>();

    public ModelTabelePorudzbine(List<Porudzbina> porudzbine) {
    this.porudzbine=porudzbine;
    }
    
    
    
    
    
    
    @Override
    public int getRowCount() {
       return porudzbine.size();
    }

    @Override
    public int getColumnCount() {
       return kolone.length;
       
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      
        Porudzbina p=porudzbine.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return p.getId();
            case 1:
                if(p.getOpis().length()<=20)
                return p.getOpis();
                else
                return p.getOpis().substring(0, 19)+"...";
            case 2:
                return p.getDatum();
            case 3:
                return p.getZaposleni().toString();
            case 4:
                return p.getKlijent().toString();
            default:
                return "N/A";
          
        }
        
        
        
        
        
        
    }

    @Override
    public String getColumnName(int column) {
       return kolone[column];
    }

    public List<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(List<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }
    
    
    
    
    
    
    
    
    
    
}
