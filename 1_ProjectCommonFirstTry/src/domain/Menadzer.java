/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Acer
 */
public class Menadzer extends DomainObject implements Serializable{
    
private int id;
private String username;
private String password;
private String firstname;
private String surname;

    public Menadzer() {
    }

    public Menadzer(int id, String username, String password, String firstname, String surname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
    }
    
    public Menadzer(String username, String password){
        this.username=username;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return  firstname + ", " + surname;
    }

    @Override
    public String getTableName() {
       return "menadzer";
    }

   
    @Override
    public String getParamsForInsert() {
        return "";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, Object object) throws SQLException {
        
    }

    @Override
    public String getConditionForSelect() {
        
      
                return "  username=? AND password=? ";
        
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        
    }

    @Override
    public String getColumnsForInsert() {
        return "";
    }

    @Override
    public void setParamsForSelectCondition(PreparedStatement statement, DomainObject domainObject, String kriterijum) throws SQLException {
       
        Menadzer menadzer=(Menadzer)domainObject;
        statement.setString(1, menadzer.getUsername());
        statement.setString(2, menadzer.getPassword());
        
    
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String returnTableNameForJoin() {
       return "m";
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
