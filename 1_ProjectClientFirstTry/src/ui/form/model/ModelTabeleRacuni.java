/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.model;

import domain.Racun;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.w3c.dom.views.AbstractView;

/**
 *
 * @author Acer
 */
public class ModelTabeleRacuni extends AbstractTableModel{

    String kolone[]={"DATUM","KLIJENT","PORUDŽBINA","UKUPNO"};
    List<Racun> racuni=new ArrayList<>();

    public ModelTabeleRacuni(List<Racun> racuni) {
        this.racuni=racuni;
    }

    public List<Racun> getRacuni() {
        return racuni;
    }

    public void setRacuni(List<Racun> racuni) {
        this.racuni = racuni;
    }
    
    
    @Override
    public int getRowCount() {
        return racuni.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun r=racuni.get(rowIndex);
        
        switch(columnIndex){
            
         
            case 0:
                return r.getDatum();
            case 1:
                return r.getPorudzbina().getKlijent();
            case 2:
                return r.getPorudzbina().getOpis();
            case 3:
                return r.getUkupno();
            default:
                return "N/A";
            
            
            
            
            
            
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
    
    
    
    
    
    
    
}
