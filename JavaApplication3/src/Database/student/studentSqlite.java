/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.student;

import Database.connection.connection;
import UserInterface.Message.MyMessage;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author user
 */
public class studentSqlite {
    
    
  
    
    public void studenttimein(int idnum){
        String query1 = "SELECT USERINFO_IDNUMBER FROM LOGINPROCESS WHERE IDNUMBER = ?";
        String query ="INSERT INTO ATTTENDANCE VALUE(DATE,IDNUMBER,TIMEIN) VALUES (?,?,?)";
        try(Connection con = new connection().getconnection()){
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mma");
            Date currentDate = new Date();
            String formattedDate = dateFormat.format(currentDate);
            String timeString = timeFormat.format(currentDate);
        
            PreparedStatement st = con.prepareStatement(query1);
            st.setInt(1, idnum);
            ResultSet rs = st.executeQuery();
        
            if(rs.next()){
                int idnumber = rs.getInt("USERINFO_IDNUMBER");
                
                if(checkAttendance(idnumber,formattedDate,"TIMEIN")){
                    new MyMessage(null,true).message("TIMEIN", "YOU ALREADY TIMEIN FOR TODAY EVENT", "INFORMATION", query1, query);
                    return;
                }
               
                if(checkevent(formattedDate)){
                st.close();
                rs.close();
                PreparedStatement st1 =con.prepareStatement(query);
                st.setString(1, formattedDate);
                st.setInt(2, idnumber);
                st.setString(3, timeString);
                st.executeQuery();
                new MyMessage(null,true).message("SUCCESSFULLY", "SUCCESSFULLY ATTEND THE EVENT IDNUMBER "+ idnum, "INFORMATION", query1, query);
                return;
                }
                new MyMessage(null,true).message("EVENT", "THERE IS NO EVENT TODAY", "INFORMATION", query1, query);
   
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
          
       private boolean checkevent(String formattedDate){
                String query1 = "SELECT * FROM EVENT WHERE DATE = ?";

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
    
    public void studenttimeout(int idnumber){
          SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
            Date currentDate = new Date();
            String formattedDate = dateFormat.format(currentDate);
           
        
        
        if(checkevent(formattedDate)){
            new MyMessage(null,true).message("EVENT", "THERE IS NO EVENT FOR TODAY", "INFORMATION", formattedDate, formattedDate);
            return;
        }
        
        if(checkAttendance(idnumber,formattedDate,"TIMEOUT")){
            new MyMessage(null,true).message("TIMEOUT", "YOU ALREADY TIMEOUT FOR TODAY", "INFORMATION", formattedDate, formattedDate);
        }
       String query = "UPDATE ATTENDANCE SET TIMEOUT = ? WHERE IDNUMBER = ? AND DATE = ?";
       try(Connection con = new connection().getconnection()){
       PreparedStatement st =con.prepareStatement(query);
       st.setString(1, query);
       st.setInt(2, idnumber);
       st.setString(3, formattedDate);
       int i = st.executeUpdate();
       if(i> 0){
           new MyMessage(null,true).message("TIME IN", "TIME IN SUCCESSFULY", "INFORMATION", query, query);
       }
       }catch(SQLException ex){
       ex.printStackTrace();
       }
    }
  
}
