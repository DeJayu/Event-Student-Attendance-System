/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqliteAdmin;

import admin.Events;
import admin.MainForm;
import admin.dashboard;
import customGUI.MyMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class event {
     public void getEventData(JTable table,JTable table2){
            DefaultTableModel model = (DefaultTableModel)table2.getModel();
            while(model.getRowCount() > 0){
                model.removeRow(0);
            }
            
            String Date = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
     
         
            String query = "SELECT * FROM ATTENDANCE WHERE DATE = ?";
            String query1 = "SELECT IDNUMBER,NAME,DEPARTMENT,YEAR FROM USERINFO WHERE IDNUMBER = ?";
                try(Connection con = new connection().getconnection()){
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, Date);
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    int idnumber = rs.getInt("IDNUMBER");
                    st.close();
                    rs.close();
                    PreparedStatement  st1 = con.prepareStatement(query1);
                    st1.setInt(1, idnumber);
                    ResultSet rs1 = st1.executeQuery();
                     for(int i= 0 ; rs1.next(); i++){
                        int idrow = i+ 1;
                        int studentidnumber = rs1.getInt("IDNUMBER");
                        String name = rs1.getString("NAME");
                        String department = rs1.getString("DEPARTMENT");
                        String year = rs1.getString("YEAR");
                        Object [] studentsdata = {idrow,studentidnumber,name,department,year};
                        model.addRow(studentsdata);
                }
                }
                st.close();
                rs.close();
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
     }
        public void addevent(ArrayList<Object> eventdata){
            for(int i = 0 ; i < eventdata.size(); i++){
                Object value = eventdata.get(i);
                if(value == null || value.toString().equalsIgnoreCase("Event Name")){
                new MyMessage(null, false).message("ADD EVENT FAIL", "PLEASE FILL OUT ALL THE INFORMATION IN THE FORM", "INFORMATION", "", "");
                    return;
                } 
            }
         
            if(checkevent((String)eventdata.get(0))){
                return;
            }
            
           String query = "INSERT INTO EVENT (DATE,EVENTNAME,TIMEIN,TIMEOUT)VALUES(?,?,?,?)";
           try(Connection con = new connection().getconnection()){
               PreparedStatement st = con.prepareStatement(query);
               st.setString(1, (String) eventdata.get(0));
               st.setString(2, (String) eventdata.get(1));
               st.setString(3, (String) eventdata.get(2));
               st.setString(4, (String)eventdata.get(3));
               st.executeUpdate();
              new MyMessage(null,true).message("SUCCESSFULLY CREATED", "YOU HAVE SUCCESSFULLY CREATED AN EVENT", "INFORMATION", "", "");

           }catch(SQLException ex){
               ex.printStackTrace();
           }
       }
        private boolean checkevent(String date){
         String query = "SELECT EVENTNAME FROM EVENT WHERE DATE = ?";
         try(Connection con = new connection().getconnection()){
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, date);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String event1 = rs.getString("EVENTNAME");
                new MyMessage(null,true).message("THERE ALREADY EVENT ON THAT DAY", "THE EVENT ON THAT DAY IS " + event1 , "INFORMATION", "", "");
                return true;
            }
         }catch(SQLException ex){      
         
         }
         return false;
            
        }
        
      public void displaydata(JTable table){
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            while(model.getRowCount() > 0){
                model.removeRow(0);
            }
            
          String query = "SELECT * FROM EVENT";
          try(Connection con = new connection().getconnection()){
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(query);
              if(rs.next()){
                  String eventdata [] = {  rs.getString("EVENTNAME"),rs.getString("DATE")};
              
                model.addRow(eventdata);
              }
          }catch(SQLException ex){
              ex.printStackTrace();
          }
      }
      
      public void Deleteevent(String date){
          String query= "DELETE FROM ATTENDANCE WHERE DATE = ?";
          String query1 = "DELETE FROM EVENT WHERE DATE = ?";
          try(Connection con = new connection().getconnection()){
              try(PreparedStatement st = con.prepareStatement(query1)){
                  st.setString(1,date);
                  st.executeUpdate();
                  new MyMessage(null,true).message("SUCCESSFULLY", "THE EVENT AND EVENT DATA HAS BEEN DELETED", "INFORMATION", query1, query1);
              }
              try(PreparedStatement st1 = con.prepareStatement(query)){
                    st1.setString(1, date);
                  st1.executeUpdate();
              }
              
              
          }catch(SQLException e){
              e.printStackTrace();
          }
          
      }
        public void editdata(String date){
        String query = "SELECT * FROM EVENT WHERE DATE = ?";
        try(Connection con = new connection().getconnection()){
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, date);
            ResultSet rs = st.executeQuery();
            if(rs.next()){              
                String eventname = rs.getString("EVENTNAME");
                String timein = rs.getString("TIMEIN");
                String timeout = rs.getString("TIMEOUT");
                Events evt = new Events();
                evt.txtdate.setText(date);
                evt.txteventname.setText(eventname);
                evt.txttimein.setText(timein);
                evt.txttimeout.setText(timeout);
            }
        }catch(SQLException io){
        io.printStackTrace();
        }
        }
     public void displayeventname(JLabel j){
     String query = "SELECT EVENTNAME FROM EVENT WHERE DATE = ?";
     try(Connection con = new connection().getconnection()){
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy/MM/dd");   
            Date date = new Date(); 
            Date parsedDate;
            parsedDate = originalFormat.parse(originalFormat.format(date));
            SimpleDateFormat desiredFormat = new SimpleDateFormat("MMMM dd, yyyy");
            String formattedDate = desiredFormat.format(parsedDate);
            PreparedStatement st = con.prepareStatement(query);
            System.out.print(formattedDate);
            st.setString(1, formattedDate);
            ResultSet rs= st.executeQuery();
       
            if(rs.next()){
               String eventname = rs.getString("EVENTNAME");
               j.setText(eventname);
               st.close();
               rs.close();
               con.close();
            }
     }catch(SQLException e){
         e.printStackTrace();
     }   catch (ParseException ex) {
            ex.printStackTrace();
         }
         
}
}