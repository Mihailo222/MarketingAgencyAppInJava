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
public class StavkaRacuna extends DomainObject implements Serializable{
    
    private int id;
    private Racun racun;
    private Usluga usluga;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int id, Racun racun, Usluga usluga) {
        this.id = id;
        this.racun = racun;
        this.usluga = usluga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
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
        final StavkaRacuna other = (StavkaRacuna) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.racun, other.racun)) {
            return false;
        }
        return Objects.equals(this.usluga, other.usluga);
    }

    @Override
    public String toString() {
        return "StavkaRacuna{" + "id=" + id + ", racun=" + racun + ", usluga=" + usluga + '}';
    }

    @Override
    public String getTableName() {
       return "stavka_racuna ";
    }

    @Override
    public String getColumnsForInsert() {
      return " racun_id, usluga_id ";
    }

    @Override
    public String getParamsForInsert() {
       return " (?, ?) ";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, Object object) throws SQLException {
         StavkaRacuna stavka=(StavkaRacuna)object;
        statement.setInt(1, stavka.getRacun().getId());
        
        statement.setInt(2, stavka.getUsluga().getId());
    }

    
     public void setStavkaID(int stavkaID) {
        this.id = stavkaID;
    }
    
    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setStavkaID(primaryKey);
         System.out.println("Stavka je dobila ID: " + primaryKey);
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
        /*switch(selectCondition){
            case "racun_id":
                return "racun_id=?";
            default:
                return "n/a";
        }*/
        return "WHERE racun_id=? ";
    }

    @Override
    public void setParamsForDeleteCondition(PreparedStatement statement, Object object) throws SQLException {
      statement.setInt(1,        ((Racun)object).getId());
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
        
        List<DomainObject> stavke=new ArrayList<>();
        
        try {
            
            
            
            while(resultSet.next()){
                StavkaRacuna stavka = new StavkaRacuna();
                stavka.setRacun(racun);
                String opis=resultSet.getString("u.opis");
                String naziv=resultSet.getString("u.naziv");
                double cena=resultSet.getDouble("u.cena");
                int idU=resultSet.getInt("u.id");
                
                Usluga u = new Usluga(idU, naziv, opis, cena);
                stavka.setUsluga(u);
                stavke.add(stavka);
            }
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StavkaRacuna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stavke;
    }

    @Override
    public String returnTableNameForJoin() {
       return "s";
    }

    @Override
    public String returnTableNameForJoinWithCondition() {
              
       return " s JOIN racun r  ON s.racun_id=r.id  JOIN usluga u ON u.id=s.usluga_id WHERE racun_id=? ";
    }

    @Override
    public void setParamsForJoin(PreparedStatement statement,  Object kriterijum) {
        try {
            statement.setInt(1, (Integer)kriterijum);
            
        } catch (SQLException ex) {
            Logger.getLogger(StavkaRacuna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setParamsForInsertWithCondition(PreparedStatement statement, DomainObject domainObject, Object object) {
        try {
            StavkaRacuna stavka=(StavkaRacuna)domainObject;
            statement.setInt(1, ((Racun)object).getId());
            
            statement.setInt(2, stavka.getUsluga().getId());
        } catch (SQLException ex) {
            Logger.getLogger(StavkaRacuna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
   
    
    
}
