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
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Racun extends DomainObject implements Serializable{
    
    private int id;
    private Date datum;
    private double ukupno;
  
    private Menadzer menadzer;
    private Porudzbina porudzbina;
    
    List<StavkaRacuna> stavkeRacuna = new ArrayList<>(); 
    

    public Racun() {
    }

    public Racun(int id, Date datum, double ukupno, Menadzer menadzer, Porudzbina porudzbina) {
        this.id = id;
        this.datum = datum;
        this.ukupno = ukupno;
        this.menadzer = menadzer;
        this.porudzbina = porudzbina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkupno() {
        return ukupno;
    }

    public void setUkupno(double ukupno) {
        this.ukupno = ukupno;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }

    public List<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
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
        final Racun other = (Racun) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.ukupno) != Double.doubleToLongBits(other.ukupno)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.menadzer, other.menadzer)) {
            return false;
        }
        if (!Objects.equals(this.porudzbina, other.porudzbina)) {
            return false;
        }
        return Objects.equals(this.stavkeRacuna, other.stavkeRacuna);
    }

    @Override
    public String toString() {
        return "Racun{" + "id=" + id + ", datum=" + datum + ", ukupno=" + ukupno + ", menadzer=" + menadzer + ", porudzbina=" + porudzbina + ", stavkeRacuna=" + stavkeRacuna + '}';
    }

    @Override
    public String getTableName() {
       return " racun ";
    }

    @Override
    public String getColumnsForInsert() {
       return " menadzer_id, porudzbina_id, datum, ukupno ";
       
    }

    @Override
    public String getParamsForInsert() {
         return " (?,?,?,?) ";
    }

    @Override  
    public void setParamsForInsert(PreparedStatement statement, Object object) throws SQLException {
          
        
            statement.setInt(1, ((Racun)object).getMenadzer().getId());
            statement.setInt(2, ((Racun)object).getPorudzbina().getId());
            java.util.Date datumUTIL=((Racun)object).getDatum();
            java.sql.Date datumSQL=new java.sql.Date(datumUTIL.getTime());
            statement.setDate(3, datumSQL);
            statement.setDouble(4, ((Racun)object).getUkupno());
            
            
         
            System.out.println("Objekat racun je unesen u bazu.");
            
            ResultSet rsID=statement.getGeneratedKeys();
            if(rsID.next()){
                ((Racun)object).setId(rsID.getInt(1));
                System.out.println("ID RACUNA JE: "+((Racun)object).getId());
            }
    }
    
     public void setRacunID(int racunID) {
        this.id = racunID;
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {

        setRacunID(primaryKey);
         System.out.println("Racun je dobio ID: " + primaryKey);
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

      return   " WHERE id=? ";

    }

    @Override
    public void setParamsForDeleteCondition(PreparedStatement statement, Object object) throws SQLException {

        statement.setInt(1, (Integer)object);

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

        
        try {
            List<DomainObject> racuni = new ArrayList<>();
            
            
            while(resultSet.next()){
                Racun r=new Racun();
                //R.ID

                r.setId(resultSet.getInt("r.id"));
                java.sql.Date datumSQL = resultSet.getDate("r.datum");
                java.util.Date datumUTIL=new java.util.Date(datumSQL.getTime());
                
                //R.DATUM, R.UKUPNO
                r.setDatum(datumUTIL);
                r.setUkupno(resultSet.getDouble("r.ukupno"));
                System.out.println("Na racun su zakaceni id, datum, ukupno: " +r.getId()+" "+r.getDatum()+" "+r.getUkupno());
                
                
                
                //R.SETPORUDZBINA
                Porudzbina por=new Porudzbina();
                por.setId(resultSet.getInt("p.id"));
                java.sql.Date datumPorSQL = resultSet.getDate("p.datum");
                java.util.Date datumPorUTIL = new java.util.Date(datumPorSQL.getTime());   
                por.setDatum(datumPorUTIL);
                
                por.setOpis(resultSet.getString("p.opis"));
                System.out.println("NA por. su okaceni id, datum, opis:" +por.getId()+por.getDatum()+por.getOpis());
                //******************************************
                Klijent k=new Klijent();
                
                k.setId(resultSet.getInt("k.id"));
                k.setIme(resultSet.getString("k.ime"));
                k.setPrezime(resultSet.getString("k.prezime"));
                k.setPreduzece(resultSet.getString("k.preduzece"));
                k.setMaticni_broj(resultSet.getString("k.maticni_broj"));
                
                por.setKlijent(k);
                
                
                
                
                r.setPorudzbina(por);
                
                
                
                racuni.add(r);
                
                
                
            }
            

            
            
            return racuni;
        } catch (SQLException ex) {
            Logger.getLogger(Racun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;

    }

    @Override
    public String returnTableNameForJoin() {
      return " r  JOIN porudzbina p ON r.porudzbina_id=p.id JOIN klijent k ON k.id=p.klijent_id JOIN zaposleni z ON z.id=p.zaposleni_id ";
    }

    @Override
    public String returnTableNameForJoinWithCondition() {


        return  " r JOIN porudzbina p ON r.porudzbina_id=p.id JOIN klijent k ON k.id=p.klijent_id  JOIN zaposleni z ON z.id=p.zaposleni_id where p.klijent_id IN ( select k.id from klijent k where ime=?)" ;


    }

  
  

    @Override
    public void setParamsForJoin(PreparedStatement statement,  Object kriterijum) {

        try {
            statement.setString(1, (String) kriterijum);
        } catch (SQLException ex) {
            Logger.getLogger(Racun.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void setParamsForInsertWithCondition(PreparedStatement statement, DomainObject domainObject, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    

  
    
}
