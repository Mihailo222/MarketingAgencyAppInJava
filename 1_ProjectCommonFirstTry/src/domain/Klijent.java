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
public class Klijent extends DomainObject implements Serializable{
    
    private int id;
    private String ime;
    private String prezime;
    private String preduzece;
    private String maticni_broj;

    public Klijent() {
    }

    public Klijent(int id, String ime, String prezime, String preduzece, String maticni_broj) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.preduzece = preduzece;
        this.maticni_broj = maticni_broj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(String preduzece) {
        this.preduzece = preduzece;
    }

    public String getMaticni_broj() {
        return maticni_broj;
    }

    public void setMaticni_broj(String maticni_broj) {
        this.maticni_broj = maticni_broj;
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
        final Klijent other = (Klijent) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.preduzece, other.preduzece)) {
            return false;
        }
        return Objects.equals(this.maticni_broj, other.maticni_broj);
    }

    @Override
    public String toString() {
        return  id + ", " + ime + ", " + prezime + ", " + preduzece + ", " + maticni_broj;
    }

    @Override
    public String getTableName() {
        return "klijent";
    }

    @Override
    public String getColumnsForInsert() {
        return "ime, prezime, preduzece, maticni_broj";
    }

    @Override
    public String getParamsForInsert() {
         return "(?,?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, Object object) throws SQLException {
        Klijent klijent=(Klijent)object;
        statement.setString(1, klijent.getIme());
        statement.setString(2, klijent.getPrezime());
        statement.setString(3, klijent.getPreduzece());
        statement.setString(4, klijent.getMaticni_broj());
    }

    
       public void setKlijentID(int klijentID) {
        this.id = klijentID;
    }
    
    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
         setKlijentID(primaryKey);
         System.out.println("Klijent je dobio ID: " + primaryKey);
    }

    @Override
    public String getConditionForSelect() {
  
      return " preduzece=? ";
    }

    @Override
    public void setParamsForSelectCondition(PreparedStatement statement, DomainObject domainObject, String kriterijum) throws SQLException {
       statement.setString(1, kriterijum);
    }

    @Override
    public String getConditionForDelete(String selectCondition) {
      switch(selectCondition){
          case "id":
              return "id=?";
          default:
              return "n/a";
      }
    }

    @Override
    public void setParamsForDeleteCondition(PreparedStatement statement, Object object) throws SQLException {
       statement.setInt(1, ((Klijent)object).getId());
    }

    @Override
    public String getConditionForUpdate(String selectCondition) {
        return "id=?";
    }

    @Override
    public void setParamsForUpdateCondition(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        
        Klijent klijent = (Klijent)domainObject;
        
        statement.setString(1, klijent.getIme());
        statement.setString(2, klijent.getPrezime());
        statement.setString(3, klijent.getPreduzece());
        statement.setString(4, klijent.getMaticni_broj());
        statement.setInt(5, klijent.getId());
        
    }

    @Override
    public String getParamsForUpdate(String param) {
       switch(param){
           case "ime":
               return "ime=?, ";
           case "prezime":
               return "prezime=?, ";
           case "preduzece":
               return "preduzece=?, ";
           case "maticni_broj":
               return "maticni_broj=? ";
           default:
               return "n/a";

       }
    }

    @Override
    public List<DomainObject> getListOfAllObjects(ResultSet resultSet) {
       
        
        
         List<DomainObject> klijenti = new ArrayList<>();
        
        
        try {
           
            
            while(resultSet.next()){
        
                Klijent klijent = new Klijent();
                klijent.setId(resultSet.getInt("id"));
                klijent.setIme(resultSet.getString("ime"));
                klijent.setPrezime(resultSet.getString("prezime"));
                klijent.setPreduzece(resultSet.getString("preduzece"));
                klijent.setMaticni_broj(resultSet.getString("maticni_broj"));
                
                klijenti.add(klijent);
     
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        return klijenti;
  
        
    }

    @Override
    public String returnTableNameForJoin() {


        return "k";

    }

    @Override
    public String returnTableNameForJoinWithCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForJoin(PreparedStatement statement,  Object kriterijum) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForInsertWithCondition(PreparedStatement statement, DomainObject domainObject, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
  


    
    
    
}
