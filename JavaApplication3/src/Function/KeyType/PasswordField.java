/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.KeyType;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

/**
 *
 * @author Admin
 */
public class PasswordField {
            
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
    
}
