/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqliteAdmin;

import admin.MainForm;
import customGUI.MyMessage;
import customGUI.MyPanel;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import login.SignIn;


/**
 *
 * @author Admin
 */
public class loginAccount {
    
  
    public loginAccount(){
        
    }
    
    public boolean loginAccs(String username,String password){
   
        String query = "SELECT * FROM LOGINPROCESS INNER JOIN USERINFO ui ON USERINFO_IDNUMBER = ui.IDNUMBER WHERE USERNAME = ? AND PASSWORD = ?";
       try(Connection con= new connection().getconnection();){ 
     
       PreparedStatement st = con.prepareStatement(query);
       st.setString(1, username);
       st.setString(2,password);
       
      ResultSet result = st.executeQuery();
      
      
        if(result.next()){ 
           int idnumber = result.getInt("USERINFO_IDNUMBER");
           String name = result.getString("USERNAME");
           String role = result.getString("ROLE");
           byte [] image = result.getBytes("PICTURE");
           System.out.print(image);
           ByteArrayInputStream convert = new ByteArrayInputStream(image);
           
           
            st.close();
            result.close();
            
            if(role.equalsIgnoreCase("Admin")){
                new SignIn().dispose();
                     MainForm main = new MainForm();
                     main.cbprofile.insertItemAt(name, 0);
                     main.cbprofile.setSelectedIndex(0);
                     new MyPanel().resizeimagelabel(convert, main.profilepicture);
                     main.cbprofile.insertItemAt("Setting", 1);
                     main.cbprofile.insertItemAt("Logout", 2);
                main.setVisible(true);
            this.loginrecord(name);
                          return true;
            }
             
           student.MainForm main= new student.MainForm();
           main.cbprofile.insertItemAt(name, 0);
           main.cbprofile.setSelectedIndex(0);
           new MyPanel().resizeimagelabel(convert, main.profilepicture);
           main.cbprofile.insertItemAt("Setting", 1);
           main.cbprofile.insertItemAt("Logout", 2);
            new adminSqlite().studentdata(idnumber, new student.dashboard().dashboardtable);
            this.loginrecord(name);
        
           
           main.setVisible(true);
          
           con.close();
           return true;
        }
        
        new MyMessage(new SignIn(),true).message("Account Cannot Found","Wrong Account Or Password please Retype it Again", "INFORMATION", query, query);
        con.close();
     
      }catch(SQLException e){
        e.printStackTrace();
      }
         return false;
    }
    
   
    public void loginrecord(String name) {
    String insertQuery = "INSERT INTO INOUT(TIMEIN, DATE, USERNAME) VALUES (?, ?, ?)";
    try (Connection con = new connection().getconnection();
         PreparedStatement st = con.prepareStatement(insertQuery)) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mma");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        String timeString = timeFormat.format(currentDate);
        
      

        st.setString(1, timeString);
        st.setString(2, formattedDate);
        st.setString(3, name);
        st.executeUpdate();
        st.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
}



public void logoutrecord(String name) {
   String updateQuery = "UPDATE INOUT SET TIMEOUT = ? WHERE USERNAME = ? AND TIMEOUT IS NULL";
   try (Connection con = new connection().getconnection();
         PreparedStatement st = con.prepareStatement(updateQuery)) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mma");
        String formattedDate = dateFormat.format(new Date());

        st.setString(1, formattedDate);
        st.setString(2, name);

        int affectedRows = st.executeUpdate();
        if (affectedRows > 0) {
            new MyMessage(null, true).message("LOGOUT", "SUCCESSFULLY LOGOUT", "INFORMATION", "", "");
           
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

    }
    
    

