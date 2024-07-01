/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import java.sql.SQLException;
import repository.db.DatabaseBroker;
import repository.db.DatabaseConnectionFactory;

/**
 *
 * @author Acer
 */
public abstract class OpstaSO {
 
    protected DatabaseBroker dbbr;
    
    public OpstaSO() throws Exception{
        dbbr=new DatabaseBroker(DatabaseConnectionFactory.getInstance().pop());
    }
    
    public void execute(Object object) throws Exception{
        
         try {
            validate(object);
            executeOperation(object);
            commit();
        } catch (Exception ex) {
            rollback();
            throw new Exception("Neuspesan rad sa objektom!");
        }
        
        
        
        
    }
    
    
     public void commit() throws SQLException {
         
         dbbr.getConnection().commit();
        
    }

    private void rollback() throws SQLException {
      
        dbbr.getConnection().rollback();
       
    }
    
    protected abstract void executeOperation(Object object) throws Exception;

    protected abstract void validate(Object object) throws Exception;
    
    
    
    
}
