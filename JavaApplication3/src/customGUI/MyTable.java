/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customGUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Admin
 */


public class MyTable extends JTable{

    
   public  MyTable(){
      JTableHeader header = this.getTableHeader();
     
      
        header.setFont(new Font("Arial",Font.BOLD,12)); 
        header.setOpaque(false);
        header.setFocusable(false);
        header.setBackground(new Color(39,159,217));
        header.setForeground(Color.BLACK);
        setRowHeight(25);
        header.setFocusable(false);
        setShowHorizontalLines(true);
        header.setReorderingAllowed(false);
        header.setFocusable(false);
    
       
    
    }
    
}
