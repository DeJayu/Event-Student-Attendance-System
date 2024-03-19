/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 *
 * @author Admin
 */
public class MyPasswordField extends JPasswordField{

    /**
     * @return the validation
     */
    public boolean isValidation() {
        return validation;
    }

    /**
     * @param validation the validation to set
     */
    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    /**
     * @return the validation
     */
  
     private boolean validation;
     
     
         //this class for the focus gained event for passwordfield
        public void focusGained(JPasswordField pass , String name, JCheckBox cb){
            if(pass.getText().equalsIgnoreCase(name)){
                pass.setText(null);
                cb.setVisible(false);
                return;
            }
        }
        
        //this class is for focus lost event for passwordfield
        public void focusLost(JPasswordField pass , String name , JCheckBox cb){
            if(pass.getText().isEmpty()){
                pass.setText(name);
                pass.setEchoChar((char)0);
                cb.setVisible(false);
                return;
            }
        }
        
        //this class check the value of the PasswordField if its empty
        public void checkEmpty(JPasswordField pass,JCheckBox cb ,String name){
            pass.setEchoChar('*');
            if(pass.getText().isEmpty() || pass.getText().equalsIgnoreCase(name)){
                cb.setVisible(false);
                return;
            }
            
            cb.setVisible(true);
        }
        
        //show the password char of the PasswordField
       public void showpasswordChar(JCheckBox cb,JPasswordField pass ){
         if(cb.isSelected()){
            pass.setEchoChar((char)0);
            return;
        }
            pass.setEchoChar('*');
        

    }
    
       
       //this class check the password and confirm password if they the same value. 
       public void checkvalidation(JLabel label,JLabel label2,JPasswordField pass,JPasswordField pass2){
        
           if(pass.getText().equalsIgnoreCase(pass2.getText()) ){
               label.setVisible(false);
               label2.setVisible(false);
               setValidation(false) ;
               return;
           }
           label.setVisible(true);
           label2.setVisible(true);
           setValidation(true) ;
       }
       
    /**
     * @return the CustomIcon1
     */
    public Icon getCustomIcon1() {
        return CustomIcon1;
    }

    /**
     * @param CustomIcon1 the CustomIcon1 to set
     */
    public void setCustomIcon1(Icon CustomIcon1) {
        this.CustomIcon1 = CustomIcon1;
        initBorder();
    }

    /**
     * @return the CustomIcon2
     */
    public Icon getCustomIcon2() {
        return CustomIcon2;
    }

    /**
     * @param CustomIcon2 the CustomIcon2 to set
     */
    public void setCustomIcon2(Icon CustomIcon2) {
        this.CustomIcon2 = CustomIcon2;
        initBorder();
    }
    
    //custome gui for passwordfield
    public MyPasswordField(){
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(0, 0, 0, 0));
        setForeground(new Color(122, 140, 141));
        setFont(new java.awt.Font("Arial", 0, 13));
        setSelectionColor(new Color(0,102,204));
     
        
    }

    
    
    @Override
    //custom rendering for gui of the passwordfield
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(230, 245, 241));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        super.paintComponent(g);
        
        //paint the icons in the passwordfield
        paintIcon(g);
    }
    
    private Icon CustomIcon1;
   private Icon CustomIcon2;
   
   //custom gui for custom icons placements
     private void paintIcon(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        if (getCustomIcon1() != null){
            Image Icon1=((ImageIcon) getCustomIcon1()).getImage();
            int hieght =(getHeight() - getCustomIcon1().getIconHeight()) / 2;
            g2.drawImage(Icon1,0,hieght, this);
            
        } 
        if(getCustomIcon2() != null){
            Image icon2=((ImageIcon) getCustomIcon2()).getImage();
            int hieght =(getHeight() - getCustomIcon2().getIconHeight()) / 2 ;
            g2.drawImage(icon2,getWidth() - getCustomIcon2().getIconWidth(), hieght, this);
            
            
        }
    
}   
     //code for the icons so that dont overlap with the text
    private void initBorder(){
        int left = 5;
        int right = 5;
        
        if(getCustomIcon1() != null){
            left = getCustomIcon1().getIconWidth();
        }
        if(getCustomIcon2() != null){
            right = getCustomIcon2().getIconWidth();
            
        }
        
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5,left,5,right));
    }

    
    
}
