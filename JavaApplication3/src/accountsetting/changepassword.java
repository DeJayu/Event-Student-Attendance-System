/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package accountsetting;

import customGUI.MyMessage;
import customGUI.MyPasswordField;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class changepassword extends javax.swing.JDialog {
    
  
    
    
    
    
            
       public changepassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        noti.setVisible(false);
        txtnewpassword.setEchoChar((char)0);
        txtconfirmpassword.setEchoChar((char)0);
        txtoldpassword.setEchoChar((char)0);
        showoldpassword.setVisible(false);
        shownewpassword.setVisible(false);
        showconfirmpassword.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerpanel = new javax.swing.JPanel();
        headerlbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        showoldpassword = new javax.swing.JCheckBox();
        confirnbtn = new customGUI.MyButton();
        shownewpassword = new javax.swing.JCheckBox();
        showconfirmpassword = new javax.swing.JCheckBox();
        noti = new javax.swing.JLabel();
        txtoldpassword = new customGUI.MyPasswordField();
        txtnewpassword = new customGUI.MyPasswordField();
        txtconfirmpassword = new customGUI.MyPasswordField();
        noti1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        headerpanel.setBackground(new java.awt.Color(39, 159, 217));

        headerlbl.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        headerlbl.setText("Change Password");

        javax.swing.GroupLayout headerpanelLayout = new javax.swing.GroupLayout(headerpanel);
        headerpanel.setLayout(headerpanelLayout);
        headerpanelLayout.setHorizontalGroup(
            headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerlbl)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        headerpanelLayout.setVerticalGroup(
            headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerlbl)
                .addGap(16, 16, 16))
        );

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        showoldpassword.setContentAreaFilled(false);
        showoldpassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9041325_eye_fill_icon (3).png"));
        showoldpassword.setSelectedIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9034884_eye_off_icon (1).png"));
        showoldpassword.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                showoldpasswordStateChanged(evt);
            }
        });
        showoldpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showoldpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(showoldpassword);
        showoldpassword.setBounds(280, 50, 19, 20);

        confirnbtn.setText("Confirm");
        confirnbtn.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        confirnbtn.setRadius(30);
        jPanel1.add(confirnbtn);
        confirnbtn.setBounds(282, 236, 64, 28);

        shownewpassword.setContentAreaFilled(false);
        shownewpassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9041325_eye_fill_icon (3).png"));
        shownewpassword.setSelectedIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9034884_eye_off_icon (1).png"));
        shownewpassword.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                shownewpasswordStateChanged(evt);
            }
        });
        shownewpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shownewpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(shownewpassword);
        shownewpassword.setBounds(280, 110, 19, 20);

        showconfirmpassword.setContentAreaFilled(false);
        showconfirmpassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9041325_eye_fill_icon (3).png"));
        showconfirmpassword.setSelectedIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9034884_eye_off_icon (1).png"));
        showconfirmpassword.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                showconfirmpasswordStateChanged(evt);
            }
        });
        showconfirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showconfirmpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(showconfirmpassword);
        showconfirmpassword.setBounds(280, 170, 19, 20);

        noti.setForeground(new java.awt.Color(255, 0, 0));
        noti.setText("The New Password didnt Match !");
        jPanel1.add(noti);
        noti.setBounds(30, 140, 250, 16);

        txtoldpassword.setText("Old Password");
        txtoldpassword.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\StudentAttend\\8491307_padlock_security_password_icon.png"));
        txtoldpassword.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                txtoldpasswordHierarchyChanged(evt);
            }
        });
        txtoldpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtoldpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtoldpasswordFocusLost(evt);
            }
        });
        txtoldpassword.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtoldpasswordInputMethodTextChanged(evt);
            }
        });
        txtoldpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtoldpasswordActionPerformed(evt);
            }
        });
        txtoldpassword.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtoldpasswordPropertyChange(evt);
            }
        });
        txtoldpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtoldpasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtoldpasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtoldpasswordKeyTyped(evt);
            }
        });
        jPanel1.add(txtoldpassword);
        txtoldpassword.setBounds(30, 40, 280, 40);

        txtnewpassword.setText("New Password");
        txtnewpassword.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\StudentAttend\\8491307_padlock_security_password_icon.png"));
        txtnewpassword.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                txtnewpasswordHierarchyChanged(evt);
            }
        });
        txtnewpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnewpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnewpasswordFocusLost(evt);
            }
        });
        txtnewpassword.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtnewpasswordInputMethodTextChanged(evt);
            }
        });
        txtnewpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnewpasswordActionPerformed(evt);
            }
        });
        txtnewpassword.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtnewpasswordPropertyChange(evt);
            }
        });
        txtnewpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnewpasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnewpasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnewpasswordKeyTyped(evt);
            }
        });
        jPanel1.add(txtnewpassword);
        txtnewpassword.setBounds(30, 100, 280, 40);

        txtconfirmpassword.setText("Confirm new Password");
        txtconfirmpassword.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\StudentAttend\\8491307_padlock_security_password_icon.png"));
        txtconfirmpassword.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                txtconfirmpasswordHierarchyChanged(evt);
            }
        });
        txtconfirmpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtconfirmpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtconfirmpasswordFocusLost(evt);
            }
        });
        txtconfirmpassword.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtconfirmpasswordInputMethodTextChanged(evt);
            }
        });
        txtconfirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfirmpasswordActionPerformed(evt);
            }
        });
        txtconfirmpassword.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtconfirmpasswordPropertyChange(evt);
            }
        });
        txtconfirmpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtconfirmpasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtconfirmpasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtconfirmpasswordKeyTyped(evt);
            }
        });
        jPanel1.add(txtconfirmpassword);
        txtconfirmpassword.setBounds(30, 160, 280, 40);

        noti1.setForeground(new java.awt.Color(255, 0, 0));
        noti1.setText("The New Password didnt Match !");
        jPanel1.add(noti1);
        noti1.setBounds(30, 200, 250, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnewpasswordHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_txtnewpasswordHierarchyChanged

    }//GEN-LAST:event_txtnewpasswordHierarchyChanged

    private void txtnewpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewpasswordFocusGained
      new MyPasswordField().focusGained(txtnewpassword, "New Password", shownewpassword);
    }//GEN-LAST:event_txtnewpasswordFocusGained

    private void txtnewpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewpasswordFocusLost
       new MyPasswordField().focusLost(txtnewpassword, "New Password", shownewpassword);
    }//GEN-LAST:event_txtnewpasswordFocusLost

    private void txtnewpasswordInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtnewpasswordInputMethodTextChanged
        
    }//GEN-LAST:event_txtnewpasswordInputMethodTextChanged

    private void txtnewpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnewpasswordActionPerformed
        new MyPasswordField().checkvalidation(noti, noti1, txtnewpassword, txtconfirmpassword);
    }//GEN-LAST:event_txtnewpasswordActionPerformed

    private void txtnewpasswordPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtnewpasswordPropertyChange

    }//GEN-LAST:event_txtnewpasswordPropertyChange

    private void txtnewpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnewpasswordKeyPressed
        new MyPasswordField().checkEmpty(txtnewpassword, shownewpassword, "New Password");
    }//GEN-LAST:event_txtnewpasswordKeyPressed

    private void txtnewpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnewpasswordKeyReleased

    }//GEN-LAST:event_txtnewpasswordKeyReleased

    private void txtnewpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnewpasswordKeyTyped

    }//GEN-LAST:event_txtnewpasswordKeyTyped

    private void shownewpasswordStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_shownewpasswordStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_shownewpasswordStateChanged

    private void shownewpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shownewpasswordActionPerformed
       new MyPasswordField().showpasswordChar(shownewpassword, txtnewpassword);
    }//GEN-LAST:event_shownewpasswordActionPerformed

    private void txtconfirmpasswordHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_txtconfirmpasswordHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmpasswordHierarchyChanged

    private void txtconfirmpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfirmpasswordFocusGained
      new MyPasswordField().focusGained(txtconfirmpassword, "Confirm New Password", showconfirmpassword);
    }//GEN-LAST:event_txtconfirmpasswordFocusGained

    private void txtconfirmpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfirmpasswordFocusLost
        new MyPasswordField().focusLost(txtconfirmpassword, "Confirm New Password", showconfirmpassword);
    }//GEN-LAST:event_txtconfirmpasswordFocusLost

    private void txtconfirmpasswordInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtconfirmpasswordInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmpasswordInputMethodTextChanged

    private void txtconfirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmpasswordActionPerformed
           new MyPasswordField().checkvalidation(noti, noti1, txtnewpassword, txtconfirmpassword);
           if(new MyPasswordField().isValidation() == false){
               new MyMessage(null,false).message("NOT MATCH", "The New Password and Confirm New Password Didnt Match Please Input Again", "Warning", "OK", "OK");
           }
    }//GEN-LAST:event_txtconfirmpasswordActionPerformed

    private void txtconfirmpasswordPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtconfirmpasswordPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmpasswordPropertyChange

    private void txtconfirmpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconfirmpasswordKeyPressed
       new MyPasswordField().checkEmpty(txtconfirmpassword, showconfirmpassword, "Confirm New Password");
    }//GEN-LAST:event_txtconfirmpasswordKeyPressed

    private void txtconfirmpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconfirmpasswordKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmpasswordKeyReleased

    private void txtconfirmpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconfirmpasswordKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmpasswordKeyTyped

    private void showconfirmpasswordStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_showconfirmpasswordStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_showconfirmpasswordStateChanged

    private void showconfirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showconfirmpasswordActionPerformed
        new MyPasswordField().showpasswordChar(showconfirmpassword, txtconfirmpassword);
    }//GEN-LAST:event_showconfirmpasswordActionPerformed

    private void txtoldpasswordHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_txtoldpasswordHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoldpasswordHierarchyChanged

    private void txtoldpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtoldpasswordFocusGained
    new MyPasswordField().focusGained(txtoldpassword, "Old Password", showoldpassword);
        
    }//GEN-LAST:event_txtoldpasswordFocusGained

    private void txtoldpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtoldpasswordFocusLost
       new MyPasswordField().focusLost(txtoldpassword, "Old Password", showoldpassword);
    }//GEN-LAST:event_txtoldpasswordFocusLost

    private void txtoldpasswordInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtoldpasswordInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoldpasswordInputMethodTextChanged

    private void txtoldpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtoldpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoldpasswordActionPerformed

    private void txtoldpasswordPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtoldpasswordPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoldpasswordPropertyChange

    private void txtoldpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtoldpasswordKeyPressed
      new MyPasswordField().checkEmpty(txtoldpassword, showoldpassword, "Old Password");
    }//GEN-LAST:event_txtoldpasswordKeyPressed

    private void txtoldpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtoldpasswordKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoldpasswordKeyReleased

    private void txtoldpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtoldpasswordKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoldpasswordKeyTyped

    private void showoldpasswordStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_showoldpasswordStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_showoldpasswordStateChanged

    private void showoldpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showoldpasswordActionPerformed
    new MyPasswordField().showpasswordChar(showoldpassword, txtoldpassword);
    }//GEN-LAST:event_showoldpasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                changepassword dialog = new changepassword(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customGUI.MyButton confirnbtn;
    private javax.swing.JLabel headerlbl;
    private javax.swing.JPanel headerpanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel noti;
    private javax.swing.JLabel noti1;
    private javax.swing.JCheckBox showconfirmpassword;
    private javax.swing.JCheckBox shownewpassword;
    private javax.swing.JCheckBox showoldpassword;
    private customGUI.MyPasswordField txtconfirmpassword;
    private customGUI.MyPasswordField txtnewpassword;
    private customGUI.MyPasswordField txtoldpassword;
    // End of variables declaration//GEN-END:variables
}
