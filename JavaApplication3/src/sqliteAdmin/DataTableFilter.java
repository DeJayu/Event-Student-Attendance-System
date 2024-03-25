/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqliteAdmin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import sqliteAdmin.connection;

public class DataTableFilter {
    
    
   public void searchAccountdatafilter(String searchtext, JTable table) {
    String query = "SELECT * FROM USERINFO " +
            "INNER JOIN LOGINPROCESS LP ON IDNUMBER = LP.USERINFO_IDNUMBER WHERE LOWER(NAME) LIKE LOWER(?) OR " +
            "LOWER(IDNUMBER) LIKE LOWER(?) OR LOWER(LP.USERNAME) LIKE LOWER(?)";
    DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
    tblModel.setRowCount(0); 
    try (Connection con = new connection().getconnection()) {
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, "%" + searchtext.toLowerCase() + "%");
        st.setString(2, "%" + searchtext.toLowerCase() + "%");
        st.setString(3, "%" + searchtext.toLowerCase() + "%");
        ResultSet result = st.executeQuery();
        int id = 1;
        while(result.next()){
            String role = result.getString("ROLE");
            if (role.equalsIgnoreCase("Student")) {
                int rownumber = id;
                int idnumber = result.getInt("IDNUMBER");
                String name = result.getString("NAME");
                String gender = result.getString("GENDER");
                String department = result.getString("DEPARTMENT");
                String year = result.getString("YEAR");
                String username = result.getString("USERNAME");
                Object[] accountdata = {rownumber,idnumber, name, department,gender, year, username};
                tblModel.addRow(accountdata);
                id++;
            }
        }

        if (tblModel.getRowCount() == 0 || searchtext.equalsIgnoreCase("Search")) {
            st.close();
            result.close();
            String query1 = "SELECT * FROM USERINFO INNER JOIN LOGINPROCESS LP ON IDNUMBER = LP.USERINFO_IDNUMBER WHERE LP.ROLE = 'Student'";
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery(query1);
            int id1 = 1;
            while(rs.next()){
               String role = rs.getString("ROLE");
               if(role.equalsIgnoreCase("Student")){
                int rownumber = id1 ;
                 int idnumber = rs.getInt("IDNUMBER");
                 String name = rs.getString("NAME");
                 String gender = rs.getString("GENDER");
                 String department = rs.getString("DEPARTMENT");
                 String year = rs.getString("YEAR");
                 String username = rs.getString("USERNAME");
                 Object[] studentsacc = {rownumber,idnumber, name, department,gender, year, username};
                 tblModel.addRow(studentsacc);
                 id1++;
               }
           }
            st1.close();
            rs.close();
        }

        st.close();
        result.close();
        con.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

   public void searchdashboardfilterdata(String textfilder,JTable table){
       DefaultTableModel model = (DefaultTableModel)table.getModel();
       while(model.getRowCount() > 0){
         model.removeRow(0);
       }
   String query = "SELECT * FROM USERINFO INNER JOIN LOGINPROCESS LP ON IDNUMBER = LP.USERINFO_IDNUMBER WHERE LOWER(NAME) LIKE(?) OR "
           + "LOWER(IDNUMBER) LIKE(?) OR LOWER(LP.USERNAME) LIKE (?)";
   String query2 = "SELECT TIMEIN,TIMEOUT FROM ATTENDANCE WHERE IDNUMBER = ?";
       try(Connection con = new connection().getconnection()){
           PreparedStatement st = con.prepareStatement(query);
           st.setString(1, "%"+ textfilder +"%");
           st.setString(2, "%"+ textfilder +"%");
           st.setString(3, "%"+ textfilder +"%");
           ResultSet rs = st.executeQuery();
           
        for(int i = 0;rs.next();i++){
               int row = i + 1;
               int idnumber = rs.getInt("IDNUMBER");
               String name = rs.getString("NAME");
               String department = rs.getString("DEPARTMENT");
               st.close();
               rs.close();
               PreparedStatement st1 = con.prepareStatement(query2);
               st1.setInt(1, idnumber);
               ResultSet rs1 = st.executeQuery();
               if(rs1.next()){
                   String timein = rs1.getString("TIMEIN");
                   String timeout = rs1.getString("TIMEOUT");
                   
                   Object [] data ={row,idnumber,name,department,timein,timeout};
                   model.addRow(data);
               }
           }

       }catch(SQLException ex){
           ex.printStackTrace();
       }
       
   }
}
