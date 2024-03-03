/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customGUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public final class myPicture extends JPanel {

   private BufferedImage img;
   
  
  public myPicture(){
       String imagename ;
  imagename = "Event.png";
  
    try {          
            img = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\image\\"+imagename));
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
    public myPicture(String imagename1){
 
  
    try {          
            img = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\image\\"+imagename1));
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
    
    
     public void rizelabel(File f,JLabel com){
         try{
            BufferedImage img = ImageIO.read(f.getAbsoluteFile());      
          Image img1 =  img.getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_SMOOTH);
           ImageIcon format = new ImageIcon(img1);
            com.setIcon(format);
        }catch(IOException e){
            
        }
  
  }
   @Override
    protected void paintComponent(Graphics g2){
        super.paintComponent(g2);       
        g2.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);

        
    }

      
  
    
   
}
