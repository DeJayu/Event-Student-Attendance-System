/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlite;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Admin
 */
public class adminSqlite {
    
    
    public void accountDatadisplay(JTable table)  {

        try {
            Connection con = new connection().getconnection();
            Statement st = con.createStatement();
            String query= "SELECT USERINFO.IDNUMBER,USERINFO.NAME,USERINFO.GENDER,USERINFO.DEPARTMENT,USERINFO.YEAR,LOGINPROCESS.USERNAME FROM USERINFO"
                    + " INNER JOIN LOGINPROCESS ON USERINFO.IDNUMBER = LOGINPROCESS.USERINFO_IDNUMBER";
            
            ResultSet result = st.executeQuery(query);
            for(int id = 1;result.next();id++){
              int idnumber = result.getInt("USERINFO.IDNUMBER");
                String name = result.getString("USERINFO.NAME");
                String gender = result.getString("USERNAME.GENDER");
                String  department = result.getString("USERINFO.DEPARTMENT");
                String year = result.getString("USERINFO.YEAR");
                String username= result.getString("LOGINPROCESS.USERNAME");
                
               Object [] accountdata = {id,idnumber,name,gender,department,year,username};
                
               DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
               tblModel.addRow(accountdata);
                
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(adminSqlite.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void addValueYearCB(JComboBox cb) {
     
        try {
                Connection con = new connection().getconnection();
                Statement st = con.createStatement();
                ResultSet result = st.executeQuery("SELECT YEAR FROM COURSEYEAR");
                while(result.next()){
                String year = result.getString("YEAR");
                
                  if (year != null && !year.isEmpty()) {
            cb.addItem(year);
                   }
           
            }
              con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
      
        
        }
        
   
}
   
