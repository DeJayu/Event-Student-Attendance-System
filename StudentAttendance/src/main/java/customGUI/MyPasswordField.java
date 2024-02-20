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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

/**
 *
 * @author Admin
 */
public class MyPasswordField extends JPasswordField{

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
    public MyPasswordField(){
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(0, 0, 0, 0));
        setForeground(new Color(122, 140, 141));
        setFont(new java.awt.Font("Arial", 0, 13));
        setSelectionColor(new Color(0,102,204));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(230, 245, 241));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        super.paintComponent(g);
        paintIcon(g);
    }
    
    private Icon CustomIcon1;
   private Icon CustomIcon2;
   
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
