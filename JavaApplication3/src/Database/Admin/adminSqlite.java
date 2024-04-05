/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Admin;

import Database.connection.connection;
import UserInterface.Message.MyMessage;
import java.io.ByteArrayInputStream;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;



/**
 *
 * @author Admin
 */
public class adminSqlite {
    
    //display accounts that register in the table in accounts
    public void accountDatadisplay(JTable table)  {
      DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
      while(tblModel.getRowCount() > 0){
          tblModel.removeRow(0);
      }
   String query = "SELECT * " +
               "FROM USERINFO  " +
               "INNER JOIN LOGINPROCESS LP ON IDNUMBER = LP.USERINFO_IDNUMBER";

        try {
            Connection con = new connection().getconnection();
            Statement st = con.createStatement();
           
            ResultSet result = st.executeQuery(query);
            int id = 1;
            while(result.next()){
                String Role = result.getString("ROLE");
                if(Role.equalsIgnoreCase("Student")){
                    int rownum = (id);
                  int idnumber = result.getInt("IDNUMBER");
                    String name = result.getString("NAME");
                    String gender = result.getString("GENDER");
                    String department = result.getString("DEPARTMENT");
                    String year = result.getString("YEAR");
                    String username = result.getString("USERNAME");
                   Object [] accountdata = {rownum,idnumber,name,department,gender,year,username};
                   tblModel.addRow(accountdata);
                   id++;
                }
            }
            st.close();
            result.close();
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
  
    }
    
      //populate combobox of the course and year
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
       public boolean addAccount(ArrayList<Object> userData, File file,String formoperation) {
        
         
     try (Connection con = new connection().getconnection()) {
         
         
         
          if(file == null){
              String defaultpicture = userData.get(6).equals("Male") ? "boyprofile.jpg" : "girlprofile.jpg";              
              file = new File(System.getProperty("user.dir")+"\\src\\image\\" + defaultpicture);                       
               }
              
     
        for (int i = 0; i < userData.size(); i++) {
            Object value = userData.get(i);
            if (value.equals(null)|| value.toString().equalsIgnoreCase("password") || value.toString().equalsIgnoreCase("username") ||
                    value.toString().equalsIgnoreCase("gender") || value.toString().equalsIgnoreCase("id number") ||
                    value.toString().equalsIgnoreCase("first name") || value.toString().equalsIgnoreCase("last name") ||
                    value.toString().equalsIgnoreCase("course") || value.toString().equalsIgnoreCase("year") ||
                    value.toString().equalsIgnoreCase("confirm password")) {
                new MyMessage(null, false).message("CREATE ACCOUNT FAILED", "PLEASE FILL OUT ALL THE INFORMATION IN THE FORM", "INFORMATION", "", "");
                return false;
            }
        }

        if (isDuplicate("USERNAME", (String) userData.get(0))) {
            new MyMessage(null, false).message("CREATE ACCOUNT FAILED", "DUPLICATE USERNAME", "INFORMATION", "", "");
            return false;
        }

        if (isDuplicate("IDNUMBER", String.valueOf(userData.get(3)))) {
            new MyMessage(null, false).message("CREATE ACCOUNT FAILED", "DUPLICATE IDNUMBER", "INFORMATION", "", "");
            return false;
        }
        
            if (!userData.get(1).equals(userData.get(2))) {
                new MyMessage(null, false).message("PASSWORD DIDN'T MATCH", "PASSWORD DIDN'T MATCH", "INFORMATION", "", "");
                return false;
            }
        
             if (formoperation.equalsIgnoreCase("Signup") && userData.get(7).toString().isEmpty()) {
                new MyMessage(null, false).message("CREATE ACCOUNT FAILED", "PLEASE FILL OUT ALL THE INFORMATION IN THE FORM", "INFORMATION", "", "");
                return false;
            } else if (!formoperation.equalsIgnoreCase("Signup") && userData.get(6).toString().isEmpty()) {
                new MyMessage(null, false).message("CREATE ACCOUNT FAILED", "PLEASE FILL OUT ALL THE INFORMATION IN THE FORM", "INFORMATION", "", "");
                return false;
            }
        String query1 = "INSERT INTO lOGINPROCESS(USERNAME,PASSWORD,USERINFO_IDNUMBER,ROLE) VALUES(?,?,?,?) ";
        String query2 = "INSERT INTO USERINFO(IDNUMBER,NAME,GENDER,BOD,DEPARTMENT,YEAR,PICTURE) VALUES (?,?,?,?,?,?,?)";
        FileInputStream fis = new FileInputStream(file);
        byte[] imageData = fis.readAllBytes();
          
          
          try (PreparedStatement st = con.prepareStatement(query1)) {
                
            st.setString(1, (String) userData.get(0));
            st.setString(2, (String) userData.get(1));
            st.setInt(3,(int) userData.get(3));
             st.setString(4, "Student");
            st.executeUpdate(); 
           st.close();
           
                
        }


        try (PreparedStatement st1 = con.prepareStatement(query2)) {
            
            
            st1.setInt(1, (int) userData.get(3));
            if(formoperation.equalsIgnoreCase("Signup")){
                st1.setString(2, (String) userData.get(4) + " " + (String) userData.get(5));
                  st1.setString(3, (String) userData.get(6));
                st1.setString(4, (String) userData.get(7));
                st1.setString(5, (String) userData.get(8));
                st1.setString(6, (String) userData.get(9));
            }else{
                st1.setString(2, (String) userData.get(4));
                   st1.setString(3, (String) userData.get(5));
                st1.setString(4, (String) userData.get(6));
                st1.setString(5, (String) userData.get(7));
                st1.setString(6, (String) userData.get(8));
               st1.setBytes(7, imageData);
            
            }
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
     return true;
    }
       
       //check if the username and idnumber is duplicated in the database
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
       
       // get the data selected in the table of the accounts
       public boolean getDataSelected(JTable table,UserInterface.admin.Accounts acc){
            String idnumber = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
             String query = "SELECT * FROM USERINFO INNER JOIN LOGINPROCESS LP ON IDNUMBER = LP.USERINFO_IDNUMBER WHERE IDNUMBER = ?";
           try(Connection con = new connection().getconnection()){
               PreparedStatement st = con.prepareStatement(query);
               st.setInt(1, Integer.parseInt(idnumber));
               ResultSet rs = st.executeQuery();
               if(rs.next()){
                acc.txtidnum.setText(String.valueOf(rs.getInt("IDNUMBER")));
                acc.txtname.setText(rs.getString("NAME"));
                acc.cbgender.setSelectedItem(rs.getString("GENDER"));
                acc.cbcourse.setSelectedItem(rs.getString("DEPARTMENT"));
                acc.cbyear.setSelectedItem(rs.getString("YEAR"));
                acc.datePicker1.setText(rs.getString("BOD"));
                acc.txtusername.setText(rs.getString("USERNAME"));
                byte[] picture = rs.getBytes("PICTURE");
                
                
                ByteArrayInputStream bais = new ByteArrayInputStream(picture);
              new Function.Image.FitImage().resizeimagelabel(bais, acc.studentpicture1); 
                st.close();
                rs.close();
                return true;
               }               
                st.close();
                rs.close();
            
           } catch (SQLException ex) {
          ex.printStackTrace();
        }
           return false ;
       }
       
       //delete all of information of an account 
        public void deleteAccount(int idnumber){
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

                new MyMessage(null,true).message("ACCOUNT DELETED", "ACCOUNT SUCCESSFULLY HAS BEEN DELETED", "INFORMATION", query1, query1);
           }catch(SQLException e){
               e.printStackTrace();
           }


           }
        
        //display student attend in dashboard in today
        public void studentAttendData(JTable table){
                String query = "SELECT * FROM ATTENDANCE INNER JOIN USERINFO UI ON IDNUMBER = UI.IDNUMBBER WHERE DATA = ? ";
                try(Connection con = new connection().getconnection()){
                    SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy/MM/dd");   
                    Date date = new Date(); 
                    Date parsedDate;
                    parsedDate = originalFormat.parse(originalFormat.format(date));
                    SimpleDateFormat desiredFormat = new SimpleDateFormat("MMMM d yyyy");
                    String formattedDate = desiredFormat.format(parsedDate);

                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, formattedDate);
                    ResultSet rs = st.executeQuery();
                   for(int i = 0 ; rs.next(); i++){
                       int id = i + 1 ;
                       String name = rs.getString("NAME");
                       String department = rs.getString("DEPARTMENT");
                       String timein = rs.getString("TIMEIN");
                       String timeout = rs.getString("TIMEOUT");
                       Object [] students = {id,name,department,timein,timeout};
                       DefaultTableModel model = (DefaultTableModel)table.getModel();
                       model.addRow(students);            
                   }

                } catch (SQLException  ex) {
               ex.printStackTrace();
            } catch (ParseException ex) {
             ex.printStackTrace();
            }
            }
        
    

        //count how many boys and girls accounts
        public void studentGenderCount(String Operation,JLabel num){
          String query = "SELECT COUNT(GENDER) AS gender_count FROM USERINFO INNER JOIN LOGINPROCESS lp ON IDNUMBER = lp.USERINFO_IDNUMBER " +
               "WHERE GENDER = ? AND lp.ROLE = 'Student'";
            try (Connection con = new connection().getconnection();
                 PreparedStatement st = con.prepareStatement(query)) {
                st.setString(1, Operation.equalsIgnoreCase("Male") ? "Male" : "Female");
                ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        num.setText(String.valueOf(rs.getInt("gender_count")));
                    }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        
        //update an account information
        public void updateaccountstudent(ArrayList<Object> updatedata){
   String query = "UPDATE USERINFO AS UI " +
               "INNER JOIN LOGPROCESS AS LP ON UI.IDNUMBER = LP.USERINFO_IDNUMBER " +
               "SET UI.IDNUMBER = ?,UI.NAME = ?,UI.GENDER =?,UI.BOD = ? UI.DEPARTMENT = ?,UI.YEAR = ?,LP.USERINFO_IDNUMBER = ? WHERE UI.IDNUMBER = ?";
        try(Connection con =new connection().getconnection()){
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1,(int)updatedata.get(0));
            st.setString(2,(String) updatedata.get(1));
            st.setString(3, (String)updatedata.get(2));
            st.setString(4, (String)updatedata.get(3));
            st.setString(5, (String)updatedata.get(4));
            st.setString(6, (String)updatedata.get(5));
            st.setInt(7, (int)updatedata.get(6));
            st.setInt(8, (int)updatedata.get(7));
            
            st.executeUpdate();
            new MyMessage(null,true).message("SUCCESSFULLY UPDATED", "THE USER HAS BEEN SUCCESSFULLY UPDATED", "INFORMATION", query, query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    
            
        }
        
        //admin timein account
        public void admintimein(String username, String password) {
        String query = "SELECT * FROM LOGINPROCESS INNER JOIN USERINFO UI ON LOGINPROCESS.USERINFO_IDNUMBER = UI.IDNUMBER WHERE USERNAME = ? AND PASSWORD = ?";
        String query2 = "INSERT INTO ATTENDANCE(IDNUMBER, TIMEIN, DATE) VALUES (?, ?, ?)";

        try (Connection con = new connection().getconnection()) {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String role = rs.getString("ROLE");
                int idnumber = rs.getInt("IDNUMBER");
                String name = rs.getString("NAME");
                st.close();
                rs.close();
                if (role.equalsIgnoreCase("Student")) {
                    SimpleDateFormat desiredFormat = new SimpleDateFormat("MMMM d, yyyy");
                    SimpleDateFormat timeFormat = new SimpleDateFormat("h:mma");
                    Date currentDate = new Date();

                    String formattedDate = desiredFormat.format(currentDate);
                    String timeString = timeFormat.format(currentDate);

                    if (checkAttendance(idnumber, formattedDate,"TIMEIN")) {
                         new MyMessage(null, true).message("TIMEIN", "YOU ALREADY TIME IN ", "INFORMATION", role, role);

                        return; 
                    }
                    
                    if(CheckEventTime("TIMEIN")){
                        new MyMessage(null,true).message("TIMEIN", "THE TIME IN IS STILL NOT OPEN YET", "INFORMATION", "", "");
                        return;
                    }

                    if (checkevent(formattedDate)) {
                        PreparedStatement st2 = con.prepareStatement(query2);
                        st2.setInt(1, idnumber);
                        st2.setString(2, timeString);
                        st2.setString(3, formattedDate);
                        int i = st2.executeUpdate();
                        if (i > 0) {
                            st2.close();
                            new MyMessage(null, true).message("SUCCESSFULLY TIMEIN", "YOU SUCCESSFULLY TIMED IN " + name, "INFORMATION", role, role);
                             new event().studentattend(new UserInterface.admin.dashboard().dashboardtable);
                        }
                        return;
                    }
                    new MyMessage(null, true).message("NO EVENT", "THERE'S NO EVENT TODAY", "INFORMATION", role, role);
                    return;
                }
                new MyMessage(null, true).message("ACCOUNT", "YOU ARE AN ADMIN SO YOU CANNOT TIMEIN", "INFORMATION", role, role);
                return;
            }
            new MyMessage(null, true).message("ACCOUNT", "NO ACCOUNT FOUND", "INFORMATION", "", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
        //check if there is an event on current day
        private boolean checkevent(String formattedDate){
                String query1 = "SELECT * FROM EVENT WHERE DATE = ? ";

         try(Connection con = new connection().getconnection()){
                PreparedStatement st1 = con.prepareStatement(query1);
                st1.setString(1, formattedDate);
                ResultSet result = st1.executeQuery();
                if(result.next()){
                    st1.close();
                    result.close();
                    return true;
                }
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
               return false;
       }
       
        //check attendance  if you aleady  time in and time out 
    private boolean checkAttendance(int idnumber, String formattedDate,String method) {
        String query = "SELECT * FROM ATTENDANCE WHERE IDNUMBER = ? AND DATE = ?";
        try (Connection con = new connection().getconnection()) {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, idnumber);
            st.setString(2, formattedDate);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                  String timeIn = result.getString("TIMEIN");
                  String timeout = result.getString("TIMEOUT");
                if (timeIn != null && !timeIn.isEmpty() && method.equalsIgnoreCase("TIMEIN")) {
                    st.close();
                    result.close();
                    return true; 
                }else if(timeout != null && !timeout.isEmpty() && method.equalsIgnoreCase("TIMEOUT")){
                       st.close();
                    result.close();
                    return true; 
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
       
    //admin timeout account
       public void admintimeout(String username,String password){
           String query = "SELECT * FROM LOGINPROCESS WHERE USERNAME = ? AND PASSWORD = ?";
           String query1 ="UPDATE ATTENDANCE SET TIMEOUT = ? WHERE IDNUMBER = ? AND DATE = ?";
           try(Connection con = new connection().getconnection()){
               PreparedStatement st = con.prepareStatement(query);
               st.setString(1, username);
               st.setString(2, password);
               ResultSet rs = st.executeQuery();
               if(rs.next()){
                   int idnumber = rs.getInt("USERINFO_IDNUMBER");
                  String role = rs.getString("ROLE");
                  st.close();
                  rs.close();
                  if(role.equalsIgnoreCase("Student")){

                    SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy/MM/dd");
                    SimpleDateFormat timeformat = new SimpleDateFormat("h:mma"); 
                    Date date = new Date();
                    Date parsedDate;

                    parsedDate = originalFormat.parse(originalFormat.format(date));
                    SimpleDateFormat desiredFormat = new SimpleDateFormat("MMMM d, yyyy");
                    String formattedDate = desiredFormat.format(parsedDate);
                    String timeString = timeformat.format(date);
                    
                       if (checkAttendance(idnumber, formattedDate,"TIMEOUT")) {
                         new MyMessage(null, true).message("TIMEOUT", "YOU ALREADY TIME OUT FOR TODAY ", "INFORMATION", role, role);
                        return; 
                    }
                       
                       if(CheckEventTime("TIMEOUT")){
                        new MyMessage(null,true).message("TIMEOUT", "THE TIME OUT IS STILL NOT OPEN YET", "INFORMATION", "", "");
                        return;
                       }
                
                        
                        PreparedStatement st1 = con.prepareStatement(query1);
                        st1.setString(1, timeString);
                        st1.setInt(2, idnumber);
                        st1.setString(3, formattedDate);
                        int update = st1.executeUpdate();
                       if(update > 0 ){
                            new MyMessage(null,true).message("TIMEOUT", "YOU SUCCESSFULLY TIME OUT", "INFORMATION", role, role);
                                new event().studentattend(new UserInterface.admin.dashboard().dashboardtable);

                              return;
                       }
                      
                  }else {
                        new MyMessage(null,true).message("ACCOUNT", "YOU ARE THE ADMIN SO YOU CANNOT TIMEOUT", "INFORMATION", role, role);
                      return;
                  }
               }
               
             new MyMessage(null,true).message("ACCOUNT", "NO ACCOUNT FOUND", "INFORMATION", "", "");
             return;

               
           }catch(SQLException ex){
               ex.printStackTrace();
           } catch (ParseException ex) {
           ex.printStackTrace();
        }
       }
      
       //view selected data in accounts
       public void viewstudentdata(int idnum){
           String query="SELECT * FROM USERINFO WHERE IDNUMBER = ?";
           try(Connection con = new connection().getconnection()){
               PreparedStatement st = con.prepareStatement(query);
               st.setInt(1, idnum);
               ResultSet rs = st.executeQuery();
               if(rs.next()){
                   UserInterface.admin.ViewStudentData data = new UserInterface.admin.ViewStudentData(null,true);
                   data.idnumber.setText(String.valueOf(rs.getInt("IDNUMBER")));
                   data.name.setText(rs.getString("NAME"));
                   data.gender.setText( rs.getString("GENDER"));
                   data.bod.setText(rs.getString("BOD"));
                   data.department.setText(rs.getString("DEPARTMENT"));
                   data.year.setText(  rs.getString("YEAR"));
                   byte [] image1 = rs.getBytes("PICTURE");
                   ByteArrayInputStream bais = new ByteArrayInputStream(image1);
                   new Function.Image.FitImage().resizeimagelabel(bais, data.studentpicture);
                   this.studentdata(idnum, data.myTable1);
                   data.setVisible(true);
               }
           }catch(SQLException e){
               e.printStackTrace();
           }
       }
           
       //display a specific student data
    public void studentdata(int idnum ,JTable j){
        DefaultTableModel model = (DefaultTableModel)j.getModel();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
    String query = "SELECT ATTENDANCE.DATE AS ATTENDANCE_DATE, EVENT.DATE AS EVENT_DATE, EVENT.EVENTNAME, ATTENDANCE.TIMEIN, ATTENDANCE.TIMEOUT " +
               "FROM ATTENDANCE INNER JOIN EVENT ON ATTENDANCE.DATE = EVENT.DATE " +
               "WHERE ATTENDANCE.IDNUMBER = ?";

        try(Connection con = new connection().getconnection()){
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, idnum);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String Date = rs.getString("EVENT_DATE");
                String eventname = rs.getString("EVENTNAME");
                String timein = rs.getString("TIMEIN");
                String timeout = rs.getString("TIMEOUT");
                String [] data ={Date,eventname,timein,timeout};
                model.addRow(data);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    //display account history 
    public void history(JTable j){
        String query = "SELECT * FROM INOUT";
        DefaultTableModel model = (DefaultTableModel)j.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        try(Connection con = new connection().getconnection()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int i = 0;
            while(rs.next()){
                int idnum = i;
                String username = rs.getString("USERNAME");
                String date = rs.getString("DATE");
                String timein = rs.getString("TIMEIN");
                String timeout = rs.getString("TIMEOUT");
                Object [] time ={idnum,date,username,timein,timeout};
                model.addRow(time);
                i++;
            }
        }catch(SQLException ex ){
            ex.printStackTrace();
        }
        
        
    }
    
    //check timein and timeout time
    private boolean CheckEventTime(String operation){
        String query = "SELECT * FROM EVENT WHERE DATE  = ?";
        SimpleDateFormat desiredFormat = new SimpleDateFormat("MMMM d, yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mma");
        Date currentDate = new Date();

        String formattedDate = desiredFormat.format(currentDate);
              String timeString = timeFormat.format(currentDate);
              
        try(Connection con = new connection().getconnection()){
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, formattedDate);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String timein = rs.getString("TIMEIN");
                String timeout = rs.getString("TIMEOUT");
                  Date timeOut = timeFormat.parse(timeout);
                  Date timeIn = timeFormat.parse(timein);
                  String currentTimeString = timeFormat.format(currentDate);
                  Date currentTime = timeFormat.parse(currentTimeString);
                if(timeIn.after(currentTime) && operation.equalsIgnoreCase("TIMEIN")){
                    return true;
                }
                
                if(timeOut.after(currentTime) && operation.equalsIgnoreCase("TIMEOUT")){
                    return true;
                }
                
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (ParseException ex) {
         ex.printStackTrace();
        }
        return false;
    }
    
}



