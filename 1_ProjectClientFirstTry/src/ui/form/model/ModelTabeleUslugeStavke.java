/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.model;

import domain.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class ModelTabeleUslugeStavke  extends AbstractTableModel{

    String kolone[]={"NAZIV","OPIS","CENA"};
    List<StavkaRacuna> stavke=new ArrayList<>();

    public ModelTabeleUslugeStavke(List<StavkaRacuna> stavke) {
    this.stavke=stavke;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }
    
    
    
    
    
    @Override
    public int getRowCount() {
       return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna stavka = stavke.get(rowIndex);
        
        
        switch(columnIndex){
            
            case 0:
                return stavka.getUsluga().getNaziv();
            case 1:
                return stavka.getUsluga().getOpis();
            case 2:
                return stavka.getUsluga().getCena();
            default:
                return "N/A";
                
            
            
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
    
    
    
}
