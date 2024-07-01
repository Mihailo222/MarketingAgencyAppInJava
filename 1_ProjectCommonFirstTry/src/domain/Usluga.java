/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Usluga extends  DomainObject implements Serializable{
    private int id;
    private String naziv;
    private String opis;
    private Double cena;

    public Usluga() {
    }

    public Usluga(int id, String naziv, String opis, Double cena) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usluga other = (Usluga) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        return Objects.equals(this.cena, other.cena);
    }

    @Override
    public String toString() {
        return  id + ", " + naziv + ", " + opis + ", " + cena ;
    }

    @Override
    public String getTableName() {
        return " usluga ";
    }

    @Override
    public String getColumnsForInsert() {
       return "opis, naziv, cena";
    }

    @Override
    public String getParamsForInsert() {
      return "(?, ?, ?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, Object object) throws SQLException {
         Usluga usluga=(Usluga)object;
        statement.setString(1, usluga.getOpis());
        
        statement.setString(2, usluga.getNaziv());
        
         statement.setDouble(3, usluga.getCena());
    }

    
    
      public void setUslugaID(int uslugaID) {
        this.id = uslugaID;
    }
      
    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setUslugaID(primaryKey);
    }

    @Override
    public String getConditionForSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSelectCondition(PreparedStatement statement, DomainObject domainObject, String kriterijum) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getConditionForDelete(String selectCondition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForDeleteCondition(PreparedStatement statement,  Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getConditionForUpdate(String selectCondition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForUpdateCondition(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForUpdate(String param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getListOfAllObjects(ResultSet resultSet) {
     
        
       List<DomainObject> usluge = new ArrayList<>(); 
        
        
        
                try {
           
            
            while(resultSet.next()){
        
                 Usluga u=new Usluga();
                u.setId(resultSet.getInt("id"));
                u.setNaziv(resultSet.getString("naziv"));
                u.setOpis(resultSet.getString("opis"));
                u.setCena(resultSet.getDouble("cena"));
                usluge.add(u);
     
                
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Usluga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
  
        
        
        
        return usluge;
        
    }

    @Override
    public String returnTableNameForJoin() {
        return "u";
    }

    @Override
    public String returnTableNameForJoinWithCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForJoin(PreparedStatement statement, Object kriterijum) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForInsertWithCondition(PreparedStatement statement, DomainObject domainObject, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
 
    
    
    
}
