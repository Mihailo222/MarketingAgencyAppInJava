/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class DatabaseConnectionFactory {
    
    private Connection connection;
    private static DatabaseConnectionFactory instance;
    
     private List<Connection> connectionPool;
  
    
    private DatabaseConnectionFactory() throws SQLException{
         connectionPool = new ArrayList<>();
        
        
    for (int i = 0; i < 100; i++) {
        try { 
            
        String url="jdbc:mysql://localhost/prosoft_project";
        String user="root";
        String pass="";
        
        connection=DriverManager.getConnection(url, user, pass);
        System.out.println("Konekcija je uspostavljena.");
        
        connection.setAutoCommit(false);
        connectionPool.add(connection);
        } catch (SQLException ex) {


            System.out.println("Konekcija sa bazom nije uspela.\n"+ex.getMessage());
            ex.printStackTrace();
            
           throw ex;

        }
    }
        
    }
    
    
    
    
    public static DatabaseConnectionFactory getInstance() throws SQLException{
        
        if(instance==null)
            instance=new DatabaseConnectionFactory();
        
        return instance;
       
    }
    
    
    
     public synchronized void push(Connection connection) {
        connectionPool.add(connection);
    }
    
     
     
     
     public synchronized Connection pop() throws Exception {
        if (connectionPool.isEmpty()) {
            throw new Exception("Nema slobodne konekcije");
        }
        Connection connection = connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }
     
     
     
     
     /*   
   public void disconnect() throws SQLException{
        
        try{
        if(connection!=null || !connection.isClosed()){
            connection.close();
            System.out.println("Konekcija sa bazom uspesno raskinuta.");
        }
        
        
        }catch(SQLException ex){
            System.out.println("Greska! Konekcija sa bazom nije uspesno raskinuta!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;  
                }
        
        
        
        
    }
    
    
    
      
   public void commit() throws SQLException {
        try {
            connection.commit();
            System.out.println("Transakcija uspesno potvrdjena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije potvrdjena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }
   
   
   
     public void rollback() throws SQLException {
        try {
            connection.rollback();
            System.out.println("Transakcija uspesno ponistena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije ponistena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }
     
     
     
     
      public Connection getConnection() {
        return connection;
    }*/
    
}
