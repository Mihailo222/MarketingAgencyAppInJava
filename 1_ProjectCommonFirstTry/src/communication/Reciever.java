/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Reciever {
    private Socket socket;
    
    public Reciever(Socket socket){
        this.socket=socket;
              
    }
    
    
    
    public Object recieve() throws Exception{
        
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();//baca exception za oba catch bloka
            throw new Exception("Error receiving object!\n"+ex.getMessage());
        }
        
  
        
    }
    
    
    
}
