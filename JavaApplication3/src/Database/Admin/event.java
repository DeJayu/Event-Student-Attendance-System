/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Admin;

import UserInterface.Message.MyMessage;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import Database.connection.connection;

/**
 *
 * @author Admin
 */
public class event {
    // get all the students data in a specific date
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
                while(rs.next()){
                    int idnumber = rs.getInt("IDNUMBER");
                    PreparedStatement  st1 = con.prepareStatement(query1);
                    st1.setInt(1, idnumber);
                    ResultSet rs1 = st1.executeQuery();
                    int i = 1;
                    while(rs1.next()){
                        int idrow = 1;
                        
                        int studentidnumber = rs1.getInt("IDNUMBER");
                        String name = rs1.getString("NAME");
                        String department = rs1.getString("DEPARTMENT");
                        String year = rs1.getString("YEAR");
                        Object [] studentsdata = {idrow,studentidnumber,name,department,year};
                        model.addRow(studentsdata); 
                        idrow++;
                }
                }
            
            }catch(SQLException e){
                e.printStackTrace();
            }
     }
     
     //add event
        public void addevent(ArrayList<Object> eventdata,JTable j){
            for(int i = 0 ; i < eventdata.size(); i++){
                Object value = eventdata.get(i);
                if(value == null || value.toString().equalsIgnoreCase("Event Name")){
                new MyMessage(null, false).message("ADD EVENT FAIL", "PLEASE FILL OUT ALL THE INFORMATION IN THE FORM", "INFORMATION", "", "");
                    return;
                } 
            }
              SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy/MM/dd");
              Date date = new Date();
              Date parsedDate ;
         try {
             parsedDate = originalFormat.parse(originalFormat.format(date));
             SimpleDateFormat desiredFormat = new SimpleDateFormat("MMMM dd, yyyy");       
            String formattedDate = desiredFormat.format(parsedDate);
            Date currentdate = desiredFormat.parse(formattedDate);
           Date eventday = desiredFormat.parse((String)eventdata.get(0));
           if(currentdate.after(eventday)){
               new MyMessage(null,true).message("DATE", "THE DATE YOU WANT TO ADD IS ALREADY HAPPEN !", "INFORMATION", formattedDate, formattedDate);
               return;
           }
         } catch (ParseException ex) {
          ex.printStackTrace();
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
               st.close();
               this.displaydata(j);
              new MyMessage(null,true).message("SUCCESSFULLY CREATED", "YOU HAVE SUCCESSFULLY CREATED AN EVENT", "INFORMATION", "", "");

           }catch(SQLException ex){
               ex.printStackTrace();
           }
       }
        
        //check event if not duplicate
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
        
   
        //display event data
      public void displaydata(JTable table){
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            while(model.getRowCount() > 0){
                model.removeRow(0);
            }    
          String query = "SELECT * FROM EVENT";
          try(Connection con = new connection().getconnection()){
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(query);
             while(rs.next()){
                  String eventdata [] = {  rs.getString("EVENTNAME"),rs.getString("DATE")};
              
                model.addRow(eventdata);
              }
          }catch(SQLException ex){
              ex.printStackTrace();
          }
      }
      
      //delete an event
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
      //edit an event
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
                UserInterface.admin.Events evt = new UserInterface.admin.Events();
                evt.txtdate.setText(date);
                evt.txteventname.setText(eventname);
                evt.txttimein.setText(timein);
                evt.txttimeout.setText(timeout);
              
            }
        }catch(SQLException io){
        io.printStackTrace();
        }
        }
        
        //display event name in dashboard in current date
     public void displayeventname(JLabel j){
         
     String query = "SELECT EVENTNAME FROM EVENT WHERE DATE = ?";
     try(Connection con = new connection().getconnection()){
      
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy/MM/dd");   
            Date date = new Date(); 
            Date parsedDate;
            parsedDate = originalFormat.parse(originalFormat.format(date));
            SimpleDateFormat desiredFormat = new SimpleDateFormat("MMMM d, yyyy");
            String formattedDate = desiredFormat.format(parsedDate);
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, formattedDate);
            ResultSet rs= st.executeQuery();
                 System.out.print(formattedDate);
            if(rs.next()){
                System.out.print(formattedDate);
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
     
     //display in dashboard how many studnet attend today
     public void displayStudentAttend(JLabel l){
     String queery = "SELECT COUNT(IDNUMBER) AS count FROM ATTENDANCE WHERE DATE = ?";
     try(Connection con = new connection().getconnection()){
      PreparedStatement st = con.prepareStatement(queery);
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy/MM/dd");   
            Date date = new Date(); 
            Date parsedDate;
            parsedDate = originalFormat.parse(originalFormat.format(date));
            SimpleDateFormat desiredFormat = new SimpleDateFormat("MMMM d, yyyy");
            String formattedDate = desiredFormat.format(parsedDate);
         st.setString(1, formattedDate);
         ResultSet rs = st.executeQuery();
         if(rs.next()){
             l.setText(rs.getString("count"));
         }
            
     }catch(SQLException e){
         e.printStackTrace();
     }   catch (ParseException ex) {
    ex.printStackTrace();         }
     }
     
     //display student in dashboard
     public void studentattend(JTable j){
        DefaultTableModel model = (DefaultTableModel)j.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        String query = "SELECT * FROM ATTENDANCE WHERE DATE = ?";
        String query1 = "SELECT NAME, DEPARTMENT FROM USERINFO WHERE IDNUMBER = ?";
        try (Connection con = new connection().getconnection();
             PreparedStatement st = con.prepareStatement(query);
             PreparedStatement st1 = con.prepareStatement(query1)) {

            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            Date parsedDate;
            parsedDate = originalFormat.parse(originalFormat.format(date));
            SimpleDateFormat desiredFormat = new SimpleDateFormat("MMMM d, yyyy");
            String formattedDate = desiredFormat.format(parsedDate);
            int i =1 ;
            st.setString(1, formattedDate);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    int idnumber = rs.getInt("IDNUMBER");
                    String timein = rs.getString("TIMEIN");
                    String timeout = rs.getString("TIMEOUT");

                    st1.setInt(1, idnumber);
                    try (ResultSet rs1 = st1.executeQuery()) {
                        while (rs1.next()) {
                            int rowid = i;
                            String name = rs1.getString("NAME");
                            String department = rs1.getString("DEPARTMENT");
                            Object[] data = {rowid,idnumber, name, department, timein, timeout};
                            model.addRow(data);
                            i++;
                        }
                    }
                }
            }
          
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(event.class.getName()).log(Level.SEVERE, null, ex);
        }

             }
     
 
     
     
}