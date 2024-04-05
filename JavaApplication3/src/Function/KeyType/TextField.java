/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.KeyType;

import UserInterface.Message.MyMessage;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class TextField {
    
    public void NumberTypeOnly(KeyEvent evt,JTextField txtidnum){
           char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
            new MyMessage(null, true).message("NOTIFICATION", "This textbox is only ID you can enter please Enter A Number", "INFORMATION MESSAGE", "Ok", "Close");     
        } 
    }
}
