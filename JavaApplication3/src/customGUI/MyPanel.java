/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customGUI;

import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Admin
 */
public class MyPanel extends JPanel {

   private BufferedImage img;
  private int mouseX, mouseY;
  private boolean isOnTop ;
  private Dimension lastSize;
  private Point lastLocation;
    public MyPanel(){

    }
  
     // make the panel that you can press it and frame will follow
    public MyPanel(JFrame com){
      com.addMouseListener(new MouseAdapter(){
      @Override
       public void mousePressed(MouseEvent e) {
        mouseX = e.getXOnScreen();
        mouseY = e.getYOnScreen();
        
       }
      });
       com.addMouseMotionListener(new MouseAdapter(){
        @Override
        public void mouseDragged(MouseEvent e) {
              int frameX = com.getLocation().x + e.getXOnScreen() - mouseX;;
              int frameY = com.getLocation().y +  e.getYOnScreen() - mouseY;
              com.setLocation(frameX ,frameY );
              mouseX = e.getXOnScreen();
              mouseY = e.getYOnScreen(); 
              
             
        } 
     });
      
       
   
       }
      
    
  //add a picture on a panel that on ackage image 
   public MyPanel(String imagename1){ 
        try {          
                img = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\image\\"+imagename1));
            } catch (IOException e) {
                e.printStackTrace();
            }
  }
    
      //put an image on the label and fit it in 
     public void rizelabel(File f,JLabel com){
       
         try{
            BufferedImage img = ImageIO.read(f.getAbsoluteFile());      
          Image img1 =  img.getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_SMOOTH);
           ImageIcon format = new ImageIcon(img1);
            com.setIcon(format);
        }catch(IOException e){
            e.printStackTrace();
        }
  
  }
   @Override
    //draw the image in the panel
    protected void paintComponent(Graphics g2){
       
        super.paintComponent(g2);       
        g2.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);

        
    }

      
  
    
   
}
