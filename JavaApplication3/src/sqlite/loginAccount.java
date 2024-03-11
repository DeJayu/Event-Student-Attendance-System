/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlite;

import admin.MainForm;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JDialog;
import login.login;


/**
 *
 * @author Admin
 */
public class loginAccount {
    
    public loginAccount(JDialog dialog,String username,String password){
   
        String query = "SELECT * FROM LOGINPROCESS WHERE USERNAME = ? AND PASSWORD = ?";
         
      try{ 
       Connection con= new connection().getconnection();
       PreparedStatement st = con.prepareStatement(query);
       st.setString(1, username);
       st.setString(2,password);
       
      ResultSet result = st.executeQuery();
 
  
        if(result.next()){
            
            dialog.dispose();
            String name = result.getString("USERNAME");
            MainForm main = new MainForm();
             main.setProfilename(name);
            main.setVisible(true);

        }
  
        con.close();
      }catch(SQLException e){
        e.printStackTrace();
      }
        
    }
    
    
}
