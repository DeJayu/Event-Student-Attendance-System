/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlite;

import customGUI.MyMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;



/**
 *
 * @author Admin
 */
public class adminSqlite {
    
    
    public void accountDatadisplay(JTable table)  {
   String query = "SELECT * " +
               "FROM USERINFO  " +
               "INNER JOIN LOGINPROCESS LP ON IDNUMBER = LP.USERINFO_IDNUMBER";

        try {
            Connection con = new connection().getconnection();
            Statement st = con.createStatement();
           
            ResultSet result = st.executeQuery(query);
            for(int id = 0;result.next();id++){
                int rownum = (id + 1);
              int idnumber = result.getInt("IDNUMBER");
                String name = result.getString("NAME");
                String gender = result.getString("GENDER");
                String department = result.getString("DEPARTMENT");
                String year = result.getString("YEAR");
                String username = result.getString("USERNAME");
               Object [] accountdata = {rownum,idnumber,name,department,gender,year,username};
               DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
               tblModel.addRow(accountdata);
                
            }
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
  
    }
    
    public void addValueCourseCB(JComboBox cb) {
        try {
            Connection con = new connection().getconnection();
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("SELECT DEPARTMENT FROM COURSEYEAR");
            while(result.next()){
                String course = result.getString("DEPARTMENT");
              
                if(course != null && !course.isEmpty()){
                    cb.addItem(course);
                }
            }
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }
    
    public void addValueCB(JComboBox cb,JComboBox cb2) {
     
        try(Connection con = new connection().getconnection();) {
             
                Statement st = con.createStatement();
                ResultSet result = st.executeQuery("SELECT * FROM COURSEYEAR");
                while(result.next()){
                String year = result.getString("YEAR");
                String course = result.getString("DEPARTMENT");
                
                  if (year != null && !year.isEmpty()) {
            cb.addItem(year);
                   }
                  if(course != null && !course.isEmpty()){
                      cb2.addItem(course);
                  }

           
            }
                  st.close();
                                   con.close();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
     
        
        }
    //add account on database   
       public void addAccount(ArrayList<Object> userData, File file,JLabel pass,JLabel conpass,JLabel user,JLabel idnum) {
     try (Connection con = new connection().getconnection()) {
        
         
          
        for (int i = 0; i < userData.size(); i++) {
            Object value = userData.get(i);
            if (value == null || value.toString().equalsIgnoreCase("password") || value.toString().equalsIgnoreCase("username") ||
                    value.toString().equalsIgnoreCase("gender") || value.toString().equalsIgnoreCase("id number") ||
                    value.toString().equalsIgnoreCase("first name") || value.toString().equalsIgnoreCase("last name") ||
                    value.toString().equalsIgnoreCase("course") || value.toString().equalsIgnoreCase("year") ||
                    value.toString().equalsIgnoreCase("confirm password")) {
                new MyMessage(null, false).message("CREATE ACCOUNT FAILED", "PLEASE FILL OUT ALL THE INFORMATION IN THE FORM", "INFORMATION", "", "");
                return;
            }
        }

        if (isDuplicate("USERNAME", (String) userData.get(0))) {
            new MyMessage(null, false).message("CREATE ACCOUNT FAILED", "DUPLICATE USERNAME", "INFORMATION", "", "");
            user.setVisible(true);
            return;
        }

        if (isDuplicate("IDNUMBER", String.valueOf(userData.get(2)))) {
            new MyMessage(null, false).message("CREATE ACCOUNT FAILED", "DUPLICATE IDNUMBER", "INFORMATION", "", "");
            idnum.setVisible(true);
            return;
        }

        if (!userData.get(1).equals(userData.get(2))) {
            new MyMessage(null, false).message("PASSWORD DIDN'T MATCH", "PASSWORD DIDN'T MATCH", "INFORMATION", "", "");
            pass.setVisible(true);
            conpass.setVisible(true);
            return;
        }

        String query1 = "INSERT INTO lOGINPROCESS(USERNAME,PASSWORD,USERINFO_IDNUMBER) VALUES(?,?,?) ";
        String query2 = "INSERT INTO USERINFO(IDNUMBER,NAME,GENDER,BOD,DEPARTMENT,YEAR,PICTURE) VALUES (?,?,?,?,?,?,?)";
        FileInputStream fis = new FileInputStream(file);
        byte[] imageData = fis.readAllBytes();
          
          
          try (PreparedStatement st = con.prepareStatement(query1)) {
                
            st.setString(1, (String) userData.get(0));
            st.setString(2, (String) userData.get(1));
            st.setInt(3,(int) userData.get(3));
            st.executeUpdate(); 
           st.close();
           
                
        }


        try (PreparedStatement st1 = con.prepareStatement(query2)) {
            
            
            st1.setInt(1, (int) userData.get(3));
            st1.setString(2, (String) userData.get(4) + " " + (String) userData.get(5));
            st1.setString(3, (String) userData.get(6));
            st1.setString(4, (String) userData.get(7));
            st1.setString(5, (String) userData.get(8));
            st1.setString(6, (String) userData.get(9));

           st1.setBytes(7, imageData);
            st1.executeUpdate();
               st1.close();
               
              con.close();
              
            new MyMessage(null, false).message("SUCCESSFULLY CREATED AN ACCOUNT", "YOU SUCCESSFULLY CREATED AN ACCOUNT", "INFORMATION", "", "");
        }
        } catch (SQLException | FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
       
       private boolean isDuplicate(String columnname ,String value){
        String query = "SELECT COUNT(*) FROM USERINFO WHERE "  + columnname + " = ?";
        if(columnname.equalsIgnoreCase("USERNAME")){
            query = "SELECT COUNT(*) FROM LOGINPROCESS WHERE "  + columnname + " = ?";
        }
        try( Connection con = new connection().getconnection();){
           
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, value);
            ResultSet result = st.executeQuery();
            if(result.next()){
                return result.getInt(1) > 0 ;
            }
             st.close();
             con.close();
       
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        return false;  
       }
       private void deleteAccount(int idnumber){
           String query = "DELETE FROM USERINFO WHERE IDNUMBER = ?" ;
           String query1 = "DELETE FROM LOGINPROCESS WHERE USERINFO_IDNUMBER = ?";
           
        try(Connection con = new connection().getconnection()){
            try(PreparedStatement st = con.prepareStatement(query);){
                st.setInt(1, (int)idnumber);
                st.executeUpdate();
                st.close();
             }
            try(PreparedStatement st = con.prepareStatement(query1)){
                st.setInt(1, (int)idnumber);
                st.executeUpdate();
                st.close();
            }
       }catch(SQLException e){
           e.printStackTrace();
       }
        
      
       }
         private void updateAccount(ArrayList<Object> studentinfo,String updateOperation){
            String query ;
            if(updateOperation == "PASSWORD"){
                
                query = "UPDATE LOGINPROCESS SET PASSWORD = ? WHERE USERINFO_IDNUMBER = ?";
               if(!checkmatch("PASSWORD",(int) studentinfo.get(0),(String) studentinfo.get(1))){
                new MyMessage(null,false).message("INCORRECT", "THE OLD PASSWORD INCORRECT", "INFORMATION", "", "");
                return;
               }
            }else if (updateOperation == "USERNAME"){
                query = "UPDATE LOGINPROCESS SET USERNAME = ? WHERE USERINFO_IDNUMBER";
                if(!checkmatch("USERNAME",(int) studentinfo.get(0),(String) studentinfo.get(1))){
                    new MyMessage(null,false).message("INCORRECT", "THE OLD USERNAME IS INCORRECT", "INFORMATION", "", "");
                    return;
                }
              
            }
            
            query = "UPDATE USERINFO SET NAME = ? ,GENDER = ?,BOD = ? ,DEPARTMENT = ?,YEAR =? WHERE IDNUMBER = ? " ;
                
                try(Connection con = new connection().getconnection()){
                    PreparedStatement st = con.prepareStatement(query);
                    if(updateOperation == "PASSWORD"){
                        st.setString(0, (String) studentinfo.get(0));
                        st.setInt(1, (int) studentinfo.get(1));
                        st.executeUpdate();
                        st.close();
                        con.close();
                        return;
                    }else if(updateOperation.equalsIgnoreCase("USERNAME")){
                            st.setString(0,(String) studentinfo.get(0));
                            st.setInt(1, (int) studentinfo.get(1));
                            st.executeUpdate();
                            st.close();
                            con.close();
                            return;
                            } 
                    st.setString(0,(String) studentinfo.get(0));
                    st.setString(1,(String) studentinfo.get(1));
                    st.setString(2, (String) studentinfo.get(2));
                    st.setString(3, (String) studentinfo.get(3));
                    st.setString(4, (String) studentinfo.get(4));
                    st.setInt(5, (int) studentinfo.get(5));
                    st.executeUpdate();
                    st.close();
                    con.close();
                    
                    
                    } catch (SQLException ex) {
                        ex.printStackTrace();
        
        }
         
         }
         private boolean checkmatch(String columnname ,int idnumber ,String password){
             String query = "SELECT COUNT(PASSWORD) FROM LOGINPROCESS WHERE USERINFO_IDNUMBER = ? AND PASSWORD = ? ";
             
             if(columnname.equalsIgnoreCase("USERNAME")){
                 query = "SELECT COUNT(USERNAME) FROM LOGINPROCESS WHERE USERINFO_IDNUMBER = ? AND USERNAME = ?";
             }
             
             try(Connection con = new connection().getconnection()){
                 PreparedStatement st = con.prepareStatement(query);
                 st.setInt(1,(int) idnumber);
                 st.setString(2,(String)password );
                 ResultSet result = st.executeQuery();
                 if(result.next()){
                     return result.getInt(1) > 0; 
                 }
                 st.close();
             }catch(SQLException ex){
                 ex.printStackTrace();
             }
         return false;
             
         }

}

