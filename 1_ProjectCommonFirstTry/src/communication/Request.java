/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class Request implements Serializable{
    private Operation operation; // Operacije.LOGIN  
    private Object argument;//neki argument

    
 
    public Request(){
        
    }

    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }
    
    
    
    
    
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    @Override
    public String toString() {
        return "Request{" + "operation=" + operation + ", argument=" + argument + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
