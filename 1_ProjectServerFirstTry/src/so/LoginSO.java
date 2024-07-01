/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Menadzer;


/**
 *
 * @author Acer
 */
public class LoginSO extends OpstaSO{

    private Menadzer dbMenadzer;

    public LoginSO() throws Exception {
        super();
    }

    
    
    
    public Menadzer getMenadzer() {
        return dbMenadzer;
    }

  
    
    @Override
    protected void executeOperation(Object user) throws Exception {
    
        
        dbMenadzer = (Menadzer)dbbr.getObject((Menadzer)user);
       
    }
    
    
    
    

    @Override
    protected void validate(Object user) throws Exception {

        if(user==null ||  !(user instanceof Menadzer)) throw new Exception("Neodgovarajući menadžer.");
       
    }
    
}
