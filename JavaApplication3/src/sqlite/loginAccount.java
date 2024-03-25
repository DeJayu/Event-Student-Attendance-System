/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlite;

import accountsetting.accountsettings;
import admin.MainForm;
import customGUI.MyMessage;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.JDialog;
import login.SignIn;


/**
 *
 * @author Admin
 */
public class loginAccount {
    
    int idnumber ;
    
    public loginAccount(String username,String password){
   
        String query = "SELECT * FROM LOGINPROCESS WHERE USERNAME = ? AND PASSWORD = ?";
             try{ 
      
       Connection con= new connection().getconnection();
       PreparedStatement st = con.prepareStatement(query);
       st.setString(1, username);
       st.setString(2,password);
       
      ResultSet result = st.executeQuery();
      
      
        if(result.next()){ 
            this.idnumber = result.getInt("USERINFO_IDNUMBER");
           String name = result.getString("USERNAME");
            st.close();
            result.close();
            new SignIn().dispose();
                 MainForm main = new MainForm();
                 main.cbprofile.insertItemAt(name, 0);
                 main.cbprofile.setSelectedIndex(0);
                 main.cbprofile.insertItemAt("Setting", 1);
                 main.cbprofile.insertItemAt("Logout", 2);
            main.setVisible(true);
            
                     return;
                
            
           
            
            
       
        }
        
        new MyMessage(new SignIn(),true).message("Account Cannot Found","Wrong Account Or Password please Retype it Again", "INFORMATION", query, query);
        
        
        con.close();
      }catch(SQLException e){
        e.printStackTrace();
      }
      
      
      
      
        
    }
    
    public void senddata () {
         String query1 = "SELECT * FROM USERINFO WHERE IDNUMBER = ?";
         try(Connection con = new connection().getconnection()){;
        PreparedStatement st1 = con.prepareStatement(query1);
            st1.setInt(1, idnumber);
            ResultSet result1 = st1.executeQuery();
            
            if(result1.next()){
                String name = result1.getString("NAME");
                String gender = result1.getString("GENDER");
                String bod = result1.getString("BOD");
                String department = result1.getString("DEPARTMENT");
                String year = result1.getString("YEAR");
                
                byte [] image = result1.getBytes("PICTURE");
                
                ArrayList<Object> userdata = new ArrayList<>();
                
              userdata.addAll(Arrays.asList(idnumber,name,gender,bod,department,year));
            }
            
            }catch(SQLException ex){
                    
                    }
    }
       
    }
    
    

