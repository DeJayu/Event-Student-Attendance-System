/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.accountsetting;
import UserInterface.CustomComponents.*;

import UserInterface.Message.MyMessage;
import UserInterface.CustomComponents.MyPanel;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Database.connection.connection;


public class accountsettings {
  
     public void fetchuserData(String user) {
     String query1 = "SELECT * FROM LOGINPROCESS INNER JOIN USERINFO ui ON USERINFO_IDNUMBER = ui.IDNUMBER WHERE USERNAME = ?";

         try(Connection con = new connection().getconnection()){;
            PreparedStatement st1 = con.prepareStatement(query1);
            st1.setString(1, user);
            ResultSet result1 = st1.executeQuery();
             
            if(result1.next()){
                int idnumber = result1.getInt("USERINFO_IDNUMBER");
                String name = result1.getString("NAME");
                String gender = result1.getString("GENDER");
                String bod = result1.getString("BOD");
                String department = result1.getString("DEPARTMENT");
                String year = result1.getString("YEAR");
                
                byte [] image = result1.getBytes("PICTURE");
                 ByteArrayInputStream bais = new ByteArrayInputStream(image);
                 
               
               
                 
               UserInterface.accountsettings.accountsettings setting = new UserInterface.accountsettings.accountsettings(new UserInterface.admin.MainForm(),true);
               setting.lblnameholder.setText(name);
               setting.lblidholder.setText(String.valueOf(idnumber));
               setting.lblgenderholder.setText(gender);
               setting.lblbirthdateholder.setText(bod);
               setting.lbldepartmentholder.setText(department);
               setting.lblyearholder.setText(year);
                new Function.Image.FitImage().resizeimagelabel(bais, setting.profilepicture);
               setting.setVisible(true);
               
            }
            st1.close();
            result1.close();
            
            }catch(SQLException ex){
                    ex.printStackTrace();
                    }
     }
     
         public void updateAccount(ArrayList<Object> studentinfo,String updateOperation){
            
             for(int i = 0;i <  studentinfo.size();i++){
                 Object value = studentinfo.get(i);
                 if(updateOperation.equalsIgnoreCase("PASSWORD")){
                        if(value == null || value.toString().equalsIgnoreCase("Old Password") || value.toString().equalsIgnoreCase("New Password") ||
                                value.toString().equalsIgnoreCase("Confirm New Password")){
                            new MyMessage(null,true).message("NO INPUT", "PLEASE FILL UP ALL THE DATA SHOWN", "INFORMATION", updateOperation, updateOperation);
                            return;
                        }
                       
                 }else if (updateOperation.equalsIgnoreCase("USERNAME")){
                        if(value == null || value.toString().equalsIgnoreCase("Old Username") || value.toString().equalsIgnoreCase("New Password") || 
                               value.toString().equalsIgnoreCase("Confirm New Password")){
                            new MyMessage(null,true).message("NO INPUT", "PLEASE FILL UP ALL THE DATA SHOWN", "INFORMATION", updateOperation, updateOperation);
                            return;
                        }
                     
                 }else{
                     if(value == null || value.toString().equalsIgnoreCase("FIRST NAME") || value.toString().equalsIgnoreCase("LAST NAME") || value.toString().equalsIgnoreCase("GENDER")){
                            new MyMessage(null,true).message("NO INPUT", "PLEASE FILL UP ALL THE DATA SHOWN", "INFORMATION", updateOperation, updateOperation);
                         return;
                     }
                 }
             }
             
             
             String query ;
            if(updateOperation == "PASSWORD"){
                
                query = "UPDATE LOGINPROCESS SET PASSWORD = ? WHERE USERINFO_IDNUMBER = ?";
               if(!checkmatch("PASSWORD",(int) studentinfo.get(0),(String) studentinfo.get(1))){
                    new MyMessage(null,false).message("INCORRECT", "THE OLD PASSWORD INCORRECT", "INFORMATION", "", "");
                    return;
                   }
               
                   if(studentinfo.get(2).equals(studentinfo.get(3))){
                         new MyMessage(null,true).message("NOT MATCH", "NOT MATCH THE NEW PASSWORD AND CONFRIRM PASSWORD", "INFORMATION", updateOperation, updateOperation);
                         return;
                     }
            }else if (updateOperation == "USERNAME"){
                query = "UPDATE LOGINPROCESS SET USERNAME = ? WHERE USERINFO_IDNUMBER = ?";
                if(!checkmatch("USERNAME",(int) studentinfo.get(0),(String) studentinfo.get(1))){
                    new MyMessage(null,false).message("INCORRECT", "THE OLD USERNAME IS INCORRECT", "INFORMATION", "", "");
                    return;
                }
                
                    if(studentinfo.get(2).equals(studentinfo.get(3))){
                            new MyMessage(null,true).message("NOT MATCH", "NOT MATCH THE NEW USERNAME AND CONFRIRM USERNAME", "INFORMATION", updateOperation, updateOperation);
                            return;
                        }
              
            }
            
            query = "UPDATE USERINFO SET NAME = ? ,GENDER = ?,BOD = ? ,DEPARTMENT = ?,YEAR =? WHERE IDNUMBER = ? " ;
                
                try(Connection con = new connection().getconnection()){
                    PreparedStatement st = con.prepareStatement(query);
                    if(updateOperation == "PASSWORD"){
                        st.setString(1, (String) studentinfo.get(2));
                        st.setInt(2, (int) studentinfo.get(0));
                        st.executeUpdate();
                        st.close();
                        con.close();
                        new MyMessage(null,false).message("SUCCESSFULLY UPDATED", "THE PASSWORD SUCCESSFULLY UPDATAE", "INFORMATION", query, query);

                        return;
                    }else if(updateOperation.equalsIgnoreCase("USERNAME")){
                            st.setString(1,(String) studentinfo.get(2));
                            st.setInt(2, (int) studentinfo.get(0));
                            st.executeUpdate();
                            st.close();
                            con.close();
                            new MyMessage(null,false).message("SUCCESSFULLY UPDATED", "THE USERNAME SUCCESSFULLY UPDATAE", "INFORMATION", query, query);
                            return;
                            } 
                    st.setString(1,(String) studentinfo.get(0));
                    st.setString(2,(String) studentinfo.get(1));
                    st.setString(3, (String) studentinfo.get(2));
                    st.setString(4, (String) studentinfo.get(3));
                    st.setString(5, (String) studentinfo.get(4));
                    st.setInt(6, (int) studentinfo.get(5));
                    st.executeUpdate();
                    st.close();
                    con.close();
                    new MyMessage(null,false).message("SUCCESSFULLY UPDATED", "THE ACCOUNT INFO SUCCESSFULLY UPDATAE", "INFORMATION", query, query);
                    
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
                 st.setInt(1, (int) idnumber);
                 st.setString(2,(String)password );
                 ResultSet result = st.executeQuery();
                 if(result.next()){
                     return result.getInt(1) > 0; 
                 }
                 st.close();
                 con.close();
             }catch(SQLException ex){
                 ex.printStackTrace();
             }
         return false;
             
         }

}
