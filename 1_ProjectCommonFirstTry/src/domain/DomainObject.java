/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
/**
 *
 * @author Acer
 */
public abstract class DomainObject {
    
    
     public abstract String getTableName();
//********************
    public abstract String getColumnsForInsert();

    public abstract String getParamsForInsert();

    public abstract void setParamsForInsert(PreparedStatement statement, Object object) throws SQLException;
//************************
    
    public abstract String getConditionForSelect();
    public abstract void setParamsForSelectCondition(PreparedStatement statement, DomainObject domainObject, String kriterijum) throws SQLException;
 //****************************
    public abstract String getConditionForDelete(String selectCondition);
    public abstract void setParamsForDeleteCondition(PreparedStatement statement, Object object) throws SQLException;
    //**************************
    public abstract String getConditionForUpdate(String selectCondition);
    public abstract void setParamsForUpdateCondition(PreparedStatement statement, DomainObject domainObject) throws SQLException;
    public abstract String getParamsForUpdate(String param);
    
    //****************************
    
    public abstract List<DomainObject> getListOfAllObjects(ResultSet resultSet);
    public abstract String returnTableNameForJoin();
    public abstract String returnTableNameForJoinWithCondition();
    public abstract void setParamsForJoin(PreparedStatement statement,  Object kriterijum);
    
    
    
    
    
    public boolean containsAutoIncrementPK() {
        return true;
    }

    public abstract void setAutoIncrementPrimaryKey(int primaryKey);

   

    public abstract void setParamsForInsertWithCondition(PreparedStatement statement, DomainObject domainObject, Object object); 
    

    
}
