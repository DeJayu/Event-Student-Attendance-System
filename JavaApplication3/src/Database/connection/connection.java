/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.connection;

import UserInterface.Message.MyMessage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
    Connection con = null;

    public connection(){
           try{
             Class.forName("org.sqlite.JDBC");
            String UrlCon= "jdbc:sqlite:C:eventAttendance.db";
            con = DriverManager.getConnection(UrlCon);

       
        }catch (SQLException e){
            e.printStackTrace();
         
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
         

        }
         
     
    }
    public Connection getconnection(){
        
       return con ;
        
    } 
}  
