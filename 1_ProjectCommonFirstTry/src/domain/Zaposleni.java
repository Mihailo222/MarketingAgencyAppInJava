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

/**
 *
 * @author Acer
 */
public class Zaposleni extends DomainObject implements Serializable{
    
    private int id;
    private String ime;
    private String prezime;
    private Odeljenje odeljenje;
    private Zvanje zvanje;

    public Zaposleni() {
    }

    public Zaposleni(int id, String ime, String prezime, Odeljenje odeljenje, Zvanje zvanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.odeljenje = odeljenje;
        this.zvanje = zvanje;
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

    public Odeljenje getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(Odeljenje odeljenje) {
        this.odeljenje = odeljenje;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Zaposleni other = (Zaposleni) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (this.odeljenje != other.odeljenje) {
            return false;
        }
        return this.zvanje == other.zvanje;
    }

    @Override
    public String toString() {
        return  + id + " " + ime + " " + prezime + ", " + odeljenje + ", " + zvanje;
    }

    @Override
    public String getTableName() {
       return "zaposleni";
    }

    @Override
    public String getColumnsForInsert() {
        return "ime, prezime, odeljenje, zvanje";
    }

    @Override
    public String getParamsForInsert() {
       return "(?, ?, ?, ?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, Object object) throws SQLException {
       Zaposleni zaposleni = (Zaposleni) object;
       statement.setString(1, zaposleni.getIme());
       statement.setString(2, zaposleni.getPrezime());
       String odeljenjeS=zaposleni.getOdeljenje().toString();
       statement.setString(3, odeljenjeS);
       
       String zvanjeS=zaposleni.getZvanje().toString();
       statement.setString(4, zvanjeS);
       
    }
    
     public void setZaposleniID(int zaposleniID) {
        this.id = zaposleniID;
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setZaposleniID(primaryKey);
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
      
        
                List<DomainObject> zaposleni = new ArrayList<>();
        try {
            /*  while(rs.next()){
            Zaposleni z=new Zaposleni();
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setPrezime(rs.getString("prezime"));
            String zvanje=rs.getString("zvanje");
            String odeljenje=rs.getString("odeljenje");
            z.setOdeljenje(Odeljenje.valueOf(odeljenje));
            z.setZvanje(Zvanje.valueOf(zvanje));
            
            
            zaposleni.add(z);
            
            
            }*/
            
            
            
            
            
            while(resultSet.next()){
        
                Zaposleni zaposlen = new Zaposleni();
                zaposlen.setId(resultSet.getInt("id"));
                zaposlen.setIme(resultSet.getString("ime"));
                zaposlen.setPrezime(resultSet.getString("prezime"));
                
                String odeljenje = resultSet.getString("odeljenje");
                String zvanje = resultSet.getString("zvanje");
                zaposlen.setOdeljenje(Odeljenje.valueOf(odeljenje));
                zaposlen.setZvanje(Zvanje.valueOf(zvanje));
                
                
                
                zaposleni.add(zaposlen);
                
                
                
                
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            return zaposleni;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Zaposleni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        return null;
        
        
        
    }

    @Override
    public String returnTableNameForJoin() {
        return "z";
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
