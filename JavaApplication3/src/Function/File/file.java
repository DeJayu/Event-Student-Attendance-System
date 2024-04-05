/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.File;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class file {
    
    
    
    
    
    
    public boolean FileCheckGender(File f,JComboBox j,JLabel label){
        if(f == null ){
        String defaultImageFileName = j.getSelectedItem().equals("Female") ? "girlprofile.jpg" : "boyprofile.jpg";
        f = new File(System.getProperty("user.dir") + "\\src\\image\\" + defaultImageFileName);
        new Function.Image.FitImage().rizelabel(f, label);
        return false;
        }
        
        return true;
        
    }
    
    public void FilePictureFilter(File f){
          JFileChooser filechoose = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("studentpicture",ImageIO.getReaderFileSuffixes());
        filechoose.setFileFilter(filter);
        filechoose.showOpenDialog(null);
       f = filechoose.getSelectedFile();
    }
}
