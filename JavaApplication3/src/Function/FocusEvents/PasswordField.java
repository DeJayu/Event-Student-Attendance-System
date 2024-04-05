/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.FocusEvents;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

/**
 *
 * @author Admin
 */
public class PasswordField {
        
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
        
        
}
