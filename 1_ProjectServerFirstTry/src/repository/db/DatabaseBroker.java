/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;
import domain.DomainObject;
import domain.Klijent;
import domain.Menadzer;

import domain.Usluga;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Acer
 */
public class DatabaseBroker { 

    
     private final Connection connection;
     
     
       public DatabaseBroker(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    
    
       public List<DomainObject> getAllObjects(DomainObject domainObject){
            
        try {
           
            String query="select * from "+domainObject.getTableName();
           
            
            Statement statement = connection.createStatement();
            
           
            ResultSet rs = statement.executeQuery(query);
            
            
            
             List<DomainObject> objekti = domainObject.getListOfAllObjects(rs);
     
             rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata  iz baze!");
            return objekti;
            
            
        } catch (SQLException ex) {
           System.out.println("Objekti  nisu uspesno ucitani iz baze!");
        }
        
  return null;
    }
    
       public List<DomainObject> getAllObjectsWithJoin(DomainObject domainObject) throws SQLException{
            
   
        
        try {
            String query="select * from "+domainObject.getTableName()+" "+domainObject.returnTableNameForJoin();
            
    
            
            Statement statement = connection.createStatement();
           
            ResultSet rs = statement.executeQuery(query);
            
            List<DomainObject> objects = new ArrayList<>();
            
     
            objects=domainObject.getListOfAllObjects(rs);
            
    
             rs.close();
            statement.close();
           
            return objects;

            
        } catch (SQLException ex) {
             System.out.println("Neuspesno brisanje objekta  iz baze!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
     }
    
       public List<DomainObject> getAllObjectsWithSelectCondition(Object object, DomainObject domainObject) {
        
    
        
         try {
           
  
           
         String query="select * from "+domainObject.getTableName()+" WHERE "+domainObject.getConditionForSelect();
         System.out.println("UPIT: "+query);
         List<DomainObject> objects = new ArrayList<>();
            
           
         PreparedStatement statement = connection.prepareStatement(query);
     
            
            

        domainObject.setParamsForSelectCondition(statement, domainObject, (String)object);
        
        
        ResultSet rs=statement.executeQuery();
        objects = domainObject.getListOfAllObjects(rs);
    
           
            
            
            
             rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata Klijenti iz baze!");
            return objects;
            
            
        } catch (SQLException ex) {
           System.out.println("Objekti Klijenti nisu uspesno ucitani iz baze!");
        }
         
        
  return null;
        
  
        
    }
    
       public List<DomainObject> getObjectsWithConditionJoin(Object object, DomainObject domainObject) throws SQLException {
            
        
        
        try {
            
          
                  
            String query1 = "select * from "+domainObject.getTableName()+"  "+domainObject.returnTableNameForJoinWithCondition();
           
            PreparedStatement statement = connection.prepareStatement(query1);
            
            domainObject.setParamsForJoin(statement, object);
            ResultSet rs = statement.executeQuery();
            
            List<DomainObject> objects = new ArrayList<>();
            objects = domainObject.getListOfAllObjects(rs);
            
            
            rs.close();
            statement.close();
     
            
            return objects;
            
            
            
            
            
            
            
        } catch (SQLException ex) {
             System.out.println("Neuspesno vracanje objekata  iz baze!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
        
        


    }
     
        public void insertObject(DomainObject domainObject) throws SQLException {
        
        try {

            
          String query="INSERT INTO "+domainObject.getTableName()+" ("+domainObject.getColumnsForInsert()+" ) VALUES "+domainObject.getParamsForInsert();
          System.out.println("UPIT: "+query);
          
         PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
       
 
         
         domainObject.setParamsForInsert(statement, domainObject);
         
         
         
            int rezultat=statement.executeUpdate();
            System.out.println("Objekat  je unesen u bazu.");
            

            
             if(domainObject.containsAutoIncrementPK()){
              ResultSet rsID = statement.getGeneratedKeys();
              if(rsID.next()){
                  domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
              }
              rsID.close();
              
          }

            
            statement.close();

 
        } catch (SQLException ex) {
         System.out.println("Neuspesno dodavanje objekta  u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }
    
        public DomainObject getObject(DomainObject domainObject) throws SQLException {

        try {
           
       
         String query="SELECT * FROM "+domainObject.getTableName()+" WHERE "+domainObject.getConditionForSelect();
        System.out.println(query);
        System.out.println(((Menadzer)domainObject).getUsername()+" "+((Menadzer)domainObject).getPassword());
        
        PreparedStatement statement = connection.prepareStatement(query);
       
        
          domainObject.setParamsForSelectCondition(statement, domainObject, null);
        
          ResultSet rs = statement.executeQuery();
        
            if(rs.next()==true){
                ((Menadzer)domainObject).setId(rs.getInt("id"));
                ((Menadzer)domainObject).setFirstname(rs.getString("firstname"));
                ((Menadzer)domainObject).setSurname(rs.getString("surname"));
                
                
          
            }
            rs.close();
            statement.close();
            
            System.out.println("Uspesno ucitavanje objekta User iz baze.");
           
            return domainObject;
            
        } catch (SQLException ex) {


             System.out.println("Neuspesno ucitavanje objekta User iz baze.");
            ex.printStackTrace();
            throw ex;





        }














    }

        public void updateObject(DomainObject domainObject) throws SQLException {
        try {
          
           String query="UPDATE "+domainObject.getTableName()+" SET "+ domainObject.getParamsForUpdate("ime")+ domainObject.getParamsForUpdate("prezime")+ domainObject.getParamsForUpdate("preduzece")+ domainObject.getParamsForUpdate("maticni_broj")+" WHERE "+domainObject.getConditionForUpdate("id");
           System.out.println(query);
           
         
           PreparedStatement statement = connection.prepareStatement(query);
          
           domainObject.setParamsForUpdateCondition(statement, domainObject);
        
        
            
        
            
             int rs=statement.executeUpdate();
             System.out.println("Objekat klijent je izmenjen.");
            
            statement.close();
            
            
            
            
            
        
        
        } catch (SQLException ex) {
             System.out.println("Neuspesno ažuriranje objekta Klijent iz baze!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
        
    
 
    
    }

        public void deleteObject(Object object, DomainObject domainObject) {
        try { //domain obj je stavka
            
            
            
             
           String query="DELETE FROM "+domainObject.getTableName()+"  "+domainObject.getConditionForDelete("");
         
         
           PreparedStatement ps1 = connection.prepareStatement(query);
           
               
               
          
                
               
              domainObject.setParamsForDeleteCondition(ps1, object);
               ps1.executeUpdate();
               
               
        
      
            
        
        
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
        
        
    }
       
        public void insertMultipleObjects(List<Usluga> uslugeZaBazu, DomainObject domainObject){
           
           try {
              // String query2="insert into usluga (opis, naziv, cena) VALUES (?,?,?);";
               
               String query="INSERT INTO "+domainObject.getTableName()+" ("+domainObject.getColumnsForInsert()+" ) VALUES "+domainObject.getParamsForInsert();
               System.out.println("UPIT: "+query);
               
             
               
               PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           //    PreparedStatement statement=DatabaseConnectionFactory.getInstance().getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
          
               for(Usluga u:uslugeZaBazu){
                   
                   domainObject.setParamsForInsert(statement, u);         
                   statement.addBatch();
                   
               }
               
               statement.executeBatch();
               ResultSet rsKeys=statement.getGeneratedKeys();
               
               
                int j=0;
               while(rsKeys.next()){
                   
                   uslugeZaBazu.get(j).setId(rsKeys.getInt(1));//vrati vrednost prve kolone id liste insertovanih redova
                   j++;
                   
               } 
             
               
               
               rsKeys.close();
               statement.close();
               System.out.println("Dodatne usluge su unesene.");
               
               
             
               
               
           } catch (SQLException ex) {
               Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           
       }
       
        public void insertObjectWithCondition(Object object, DomainObject domainObject) throws SQLException {
        
        try {

            
          String query="INSERT INTO "+domainObject.getTableName()+" ("+domainObject.getColumnsForInsert()+" ) VALUES "+domainObject.getParamsForInsert();
          System.out.println("UPIT: "+query);
          
 
          PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
          //PreparedStatement statement = DatabaseConnectionFactory.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
 
         
         domainObject.setParamsForInsertWithCondition(statement, domainObject, object);
         
         
         
            int rezultat=statement.executeUpdate();
            System.out.println("Objekat  je unesen u bazu.");
            

            
             if(domainObject.containsAutoIncrementPK()){
              ResultSet rsID = statement.getGeneratedKeys();
              if(rsID.next()){
                  domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
              }
              rsID.close();
              
          }

            
            statement.close();

 
        } catch (SQLException ex) {
         System.out.println("Neuspesno dodavanje objekta  u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }
       

        
   
      
       public void izbrisiKlijenta(Klijent klijentZaBrisanje)  {

        
        try{
        //izvlacim sve porudzbine klijenta 
        String query="SELECT * FROM porudzbina WHERE klijent_id=?;";
        
        
        
        
        
        PreparedStatement statement = connection.prepareStatement(query);
    
        statement.setInt(1, klijentZaBrisanje.getId());
        ResultSet rs = statement.executeQuery();
        
        List<Integer> idPorudzbina = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
           
            idPorudzbina.add(id);
            
         }
        
        System.out.println("IDJEVI PORUDZBINA: ");
        for(int i : idPorudzbina){
            System.out.println(i);
        }

        
        
        
        
        
        
        //sad moram da brisem sve stavke 
        
        //hocu da nadjem idjeve svih racuna koji imaju ovu porudzbina_id
        String query0="SELECT * FROM RACUN WHERE PORUDZBINA_ID=?";
      
      
        PreparedStatement ps0 = connection.prepareStatement(query0,Statement.RETURN_GENERATED_KEYS );
     
        
        
     
       List<Integer> keys = new ArrayList<>();

      for (int i = 0; i < idPorudzbina.size(); i++) {
       ps0.setInt(1, idPorudzbina.get(i));
       ResultSet rs1 = ps0.executeQuery(); 
        while (rs1.next()) {
            keys.add(rs1.getInt("id"));
        }
    
}

        
        
        
        
        
          System.out.println("IDJEVI RACUNA: ");
          for(int i=0; i<keys.size(); i++){
              System.out.println(keys.get(i));
          }
          
          
        
        
      
        String queryDelete="delete from stavka_racuna WHERE racun_id=?;";
        
       PreparedStatement ps2 = connection.prepareStatement(queryDelete);
       
        
        for(int i=0; i<keys.size(); i++){
            ps2.setInt(1, keys.get(i));
            ps2.addBatch();
        }
       
        ps2.executeBatch();
        System.out.println("Stavke su obrisane.");










         //*********************************************************************
        //brisem direktno racune sa ovim porudzbina_id-jevima
        
        String query1="DELETE FROM racun WHERE porudzbina_id=?";
      
        
        PreparedStatement statement1 = connection.prepareStatement(query1);
        //PreparedStatement statement1 = DatabaseConnectionFactory.getInstance().getConnection().prepareStatement(query1);
        for(int i=0; i<idPorudzbina.size(); i++){
            statement1.setInt(1, idPorudzbina.get(i));
            statement1.addBatch();
        }
      
        int[] ids=statement1.executeBatch(); //obrisani svi racuni datog klijenta???
      
        
        
        
        
        
        
        
        
        
        
        
        //brisem sve porudzbine datog klijenta
        System.out.println("ZAPOCINJE BRISANJE PORUDZBINA SA DATIM KLIJENT ID-JEM");
         String query3="DELETE FROM porudzbina WHERE klijent_id=?";
        
         PreparedStatement statement3 = connection.prepareStatement(query3);
         //PreparedStatement statement3 = DatabaseConnectionFactory.getInstance().getConnection().prepareStatement(query3);
         statement3.setInt(1, klijentZaBrisanje.getId());
         statement3.executeUpdate();
        
         
         
         
         
         
         
        String query4="delete from klijent where id=?";
       
        PreparedStatement statement4 = connection.prepareStatement(query4);
        //PreparedStatement statement4 = DatabaseConnectionFactory.getInstance().getConnection().prepareStatement(query4);
        statement4.setInt(1, klijentZaBrisanje.getId());
        statement4.executeUpdate();
        
        
        
        
        
        
        
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
       
       
       
    }


   
 
   
    
    

    
    

    
    
  
    

 }
    
    
   
    
    

