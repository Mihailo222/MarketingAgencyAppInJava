/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Porudzbina extends DomainObject implements Serializable{
    
    private int id;
    private String opis;
    private Date datum;
    private Zaposleni zaposleni;
    private Klijent klijent;

    public Porudzbina() {
    }

    public Porudzbina(int id, String opis, Date datum, Zaposleni zaposleni, Klijent klijent) {
        this.id = id;
        this.opis = opis;
        this.datum = datum;
        this.zaposleni = zaposleni;
        this.klijent = klijent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
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
        final Porudzbina other = (Porudzbina) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.zaposleni, other.zaposleni)) {
            return false;
        }
        return Objects.equals(this.klijent, other.klijent);
    }

    @Override
    public String toString() {
        return  id + ", " + opis + ", " + datum + ", " + zaposleni + ", " + klijent;
    }

    @Override
    public String getTableName() {
       return "porudzbina";
    }

    @Override
    public String getColumnsForInsert() {
        return "opis, datum , zaposleni_id, klijent_id";
    }

    @Override
    public String getParamsForInsert() {
         return "(?,?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, Object object) throws SQLException {
         Porudzbina porudzbina=(Porudzbina)object;
        statement.setString(1, porudzbina.getOpis());
        java.sql.Date datumUTIL = new java.sql.Date(porudzbina.getDatum().getTime());
        statement.setDate(2,  datumUTIL);
        statement.setInt(3, porudzbina.getZaposleni().getId());
        statement.setInt(4, porudzbina.getKlijent().getId());
    }

       public void setPorudzbinaID(int porudzbinaID) {
        this.id = porudzbinaID;
    }
    
    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setPorudzbinaID(primaryKey);
         System.out.println("Porudzbina je dobila ID: " + primaryKey);
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


       switch(selectCondition){
           case "id":
               return "id=?";
           default:
               return "n/a";
             
       }

    }

    @Override
    public void setParamsForDeleteCondition(PreparedStatement statement,  Object object) throws SQLException {
       statement.setInt(1, ((Porudzbina)object).getId());
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
    public List<DomainObject> getListOfAllObjects(ResultSet resultSet)  {
       
        List<DomainObject> porudzbine = new ArrayList<>();
        
        
         
        
        try {
           
            
            while(resultSet.next()){
                
                
                //lista klijenata
                int idK=resultSet.getInt("k.id");
                String imeK=resultSet.getString("k.ime");
                String prezK=resultSet.getString("k.prezime");
                String preduzeceK=resultSet.getString("k.preduzece");
                String maticniBrK=resultSet.getString("k.maticni_broj");
                
                Klijent k=new Klijent(idK, imeK, prezK, preduzeceK, maticniBrK);



                //lista zaposlenih
                int idZ=resultSet.getInt("z.id");
                String imeZ=resultSet.getString("z.ime");
                String prezZ=resultSet.getString("z.prezime");
                String odeljZ=resultSet.getString("z.odeljenje");
                String zvanjeZ=resultSet.getString("z.zvanje");
                
                Zaposleni z=new Zaposleni(idZ, imeZ, prezZ, Odeljenje.valueOf(odeljZ), Zvanje.valueOf(zvanjeZ));
                
                //vrati za datog zaposlenog i klijenta datu porudzbinu
                int id=resultSet.getInt("p.id");
                String opis=resultSet.getString("p.opis");
                java.sql.Date datumSQL=resultSet.getDate("p.datum");
                
                java.util.Date datumUtil=new java.util.Date(datumSQL.getTime());
                
                Porudzbina por=new Porudzbina(id, opis, datumUtil, z, k);

                
                
                
                porudzbine.add(por);
 
            }
            
    
            return porudzbine;

            
        } catch (SQLException ex) {
           Logger.getLogger(Porudzbina.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        
        
        
        
        return null;
        
        
        
        
        
    }

    @Override
    public String returnTableNameForJoin() {
        return " p join zaposleni z ON z.id=p.zaposleni_id JOIN klijent k ON k.id=p.klijent_id ";
    }

    @Override
    public String returnTableNameForJoinWithCondition() {
      return " p join zaposleni z ON z.id=p.zaposleni_id JOIN klijent k ON k.id=p.klijent_id WHERE p.id=?";
    }

    @Override
    public void setParamsForJoin(PreparedStatement statement,  Object kriterijum) {
        try {
            statement.setInt(1, (int) kriterijum);
        } catch (SQLException ex) {
            Logger.getLogger(Porudzbina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setParamsForInsertWithCondition(PreparedStatement statement, DomainObject domainObject, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
 

    
    
    
    
}
