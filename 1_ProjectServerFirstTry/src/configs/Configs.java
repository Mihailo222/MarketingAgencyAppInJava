/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Acer
 */
public class Configs {
    
    public static Properties prop=new Properties();
    
    
    public static void SaveProperty(){
    
        
        try{
            FileOutputStream output = new FileOutputStream("config.properties");  // kreiranje config fajla + upis u fajl 
            prop.setProperty("db.url","jdbc:mysql://localhost/prosoft_project");
            prop.setProperty("db.user","root");
            prop.setProperty("db.password","");
            
            
            prop.store(output, "Database Configuration");
            System.out.println("config.properties file is successfully created.");
        }catch(IOException e){
        
            e.printStackTrace();
        }
        
    } 
    
}
