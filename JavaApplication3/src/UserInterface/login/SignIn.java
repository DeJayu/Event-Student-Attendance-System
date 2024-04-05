/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserInterface.login;

import UserInterface.CustomComponents.MyPasswordField;
import UserInterface.CustomComponents.MyPanel;
import UserInterface.CustomComponents.MyTextField;
import UserInterface.Message.MyMessage;
import Database.Admin.adminSqlite;
import Database.Admin.loginAccount;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class SignIn extends javax.swing.JFrame {
private boolean file;
  private File f;
  
  public void addaccount(){
      
        ArrayList<Object> signupvalue = new ArrayList<>();
       if(txtidnum.getText().equalsIgnoreCase("Id Number")|| txtidnum.getText().equalsIgnoreCase(null)){
        new MyMessage(null, false).message("CREATE ACCOUNT FAILED", "PLEASE FILL OUT ALL THE INFORMATION IN THE FORM", "INFORMATION", "", "");
     return;  
               }
       
        signupvalue.addAll(Arrays.asList(txtusername1.getText(), txtpassword1.getText(), txtconfirmpassword.getText(),  Integer.parseInt(txtidnum.getText()) ,
            txtfirstname.getText(), txtlastname.getText(), cbgender.getSelectedItem(), bod.getText(), cbcourse.getSelectedItem(), cbyear.getSelectedItem()));
        
        if(new adminSqlite().addAccount(signupvalue, f,"Signup")){
            
            jTabbedPane1.setSelectedIndex(0);
            btnsignin3.setVisible(false);
            btnsignup.setVisible(true);
          txtusername1.setText("Username");
          txtpassword1.setText("Password");
          txtconfirmpassword.setText("Confirm Password");
          txtidnum.setText("Id Number");
          txtfirstname.setText("First Name");
          txtlastname.setText("Last Name");
          bod.setText(null);
          cbgender.setSelectedIndex(0);
          cbcourse.insertItemAt("Course", 0);
          cbcourse.setSelectedIndex(0);
          cbyear.insertItemAt("Year", 0);
          cbyear.setSelectedIndex(0);
        
        }
  }
    public SignIn() {
        initComponents();
        showpassword.setVisible(false);
        signupshowpassword.setVisible(false);
        showconfirmpassword.setVisible(false);
        txtpassword.setEchoChar((char) 0);
        txtpassword1.setEchoChar((char) 0);
        txtconfirmpassword.setEchoChar((char) 0);
        lblvalid1.setVisible(false);
        lblvalid2.setVisible(false);
        lblvalid3.setVisible(false);
        lblvalid4.setVisible(false);
        bod.getComponentDateTextField().setEnabled(false);
        bod.setText(null);
        cbcourse.insertItemAt("Course", 0);
        cbcourse.setSelectedIndex(0);
        cbyear.insertItemAt("Year", 0);
        cbyear.setSelectedIndex(0);
        new adminSqlite().addValueCB(cbyear, cbcourse);     
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new UserInterface.CustomComponents.MyPanel(this);
        showpassword = new javax.swing.JCheckBox();
        btnsignin = new UserInterface.CustomComponents.MyButton();
        txtpassword = new UserInterface.CustomComponents.MyPasswordField();
        txtusername = new UserInterface.CustomComponents.MyTextField();
        AboutLabel = new javax.swing.JLabel();
        jPanel3 = new MyPanel(this);
        signupshowpassword = new javax.swing.JCheckBox();
        showconfirmpassword = new javax.swing.JCheckBox();
        txtpassword1 = new UserInterface.CustomComponents.MyPasswordField();
        txtusername1 = new UserInterface.CustomComponents.MyTextField();
        txtidnum = new UserInterface.CustomComponents.MyTextField();
        txtfirstname = new UserInterface.CustomComponents.MyTextField();
        txtlastname = new UserInterface.CustomComponents.MyTextField();
        txtconfirmpassword = new UserInterface.CustomComponents.MyPasswordField();
        btnsignin1 = new UserInterface.CustomComponents.MyButton();
        lblvalid2 = new javax.swing.JLabel();
        lblvalid1 = new javax.swing.JLabel();
        lblvalid3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bod = new com.github.lgooddatepicker.components.DatePicker();
        cbgender = new javax.swing.JComboBox<>();
        cbcourse = new javax.swing.JComboBox<>();
        cbyear = new javax.swing.JComboBox<>();
        lblvalid4 = new javax.swing.JLabel();
        myButton2 = new UserInterface.CustomComponents.MyButton();
        studentpic = new javax.swing.JLabel();
        signuppanel = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        btnsignup = new UserInterface.CustomComponents.MyButton();
        labelwelcome2 = new javax.swing.JLabel();
        labelwelcome1 = new javax.swing.JLabel();
        labelwelcome = new javax.swing.JLabel();
        btnsignin3 = new UserInterface.CustomComponents.MyButton();
        myPicture2 = new UserInterface.CustomComponents.MyPanel("ATTENDANCE.png");
        myButton1 = new UserInterface.CustomComponents.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        showpassword.setContentAreaFilled(false);
        showpassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9041325_eye_fill_icon (3).png"));
        showpassword.setSelectedIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9034884_eye_off_icon (1).png"));
     
        showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(showpassword);
        showpassword.setBounds(260, 300, 19, 20);

        btnsignin.setText("Sign In");
        btnsignin.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnsignin.setForeground(new java.awt.Color(255, 255, 255));
        btnsignin.setRadius(50);
        btnsignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsigninActionPerformed(evt);
            }
        });
        jPanel2.add(btnsignin);
        btnsignin.setBounds(40, 370, 246, 42);

        txtpassword.setText("Password");
        txtpassword.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\8491307_padlock_security_password_icon.png"));
        txtpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpasswordFocusLost(evt);
            }
        });
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });
        jPanel2.add(txtpassword);
        txtpassword.setBounds(40, 290, 250, 50);

        txtusername.setText("Username");
        txtusername.setBackground(new java.awt.Color(0, 0, 0,0));
        txtusername.setBorderColor(new java.awt.Color(230, 245, 241));
        txtusername.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\11185794_user_person_profile_avatar_people_icon (1).png"));
        txtusername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtusernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtusernameFocusLost(evt);
            }
        });
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel2.add(txtusername);
        txtusername.setBounds(40, 210, 250, 50);

        AboutLabel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        AboutLabel.setForeground(new java.awt.Color(0, 0, 0));
        AboutLabel.setText("About");
        AboutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AboutLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AboutLabelMouseExited(evt);
            }
        });
        jPanel2.add(AboutLabel);
        AboutLabel.setBounds(0, 640, 37, 10);

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        signupshowpassword.setContentAreaFilled(false);
        signupshowpassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9041325_eye_fill_icon (3).png"));
        signupshowpassword.setSelectedIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9034884_eye_off_icon (1).png"));
     
        signupshowpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupshowpasswordActionPerformed(evt);
            }
        });
        jPanel3.add(signupshowpassword);
        signupshowpassword.setBounds(280, 460, 19, 20);

        showconfirmpassword.setContentAreaFilled(false);
        showconfirmpassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9041325_eye_fill_icon (3).png"));
        showconfirmpassword.setSelectedIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9034884_eye_off_icon (1).png"));

        showconfirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showconfirmpasswordActionPerformed(evt);
            }
        });
        jPanel3.add(showconfirmpassword);
        showconfirmpassword.setBounds(280, 530, 19, 20);

        txtpassword1.setText("Password");
        txtpassword1.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\8491307_padlock_security_password_icon.png"));
       
        txtpassword1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpassword1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpassword1FocusLost(evt);
            }
        });
    
        txtpassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassword1ActionPerformed(evt);
            }
        });

        txtpassword1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassword1KeyPressed(evt);
            }
          
        });
        jPanel3.add(txtpassword1);
        txtpassword1.setBounds(30, 450, 280, 40);

        txtusername1.setText("Username");
        txtusername1.setBackground(new java.awt.Color(0, 0, 0,0));
        txtusername1.setBorderColor(new java.awt.Color(230, 245, 241));
        txtusername1.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\11185794_user_person_profile_avatar_people_icon (1).png"));
        txtusername1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtusername1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtusername1FocusLost(evt);
            }
        });
     
       
        jPanel3.add(txtusername1);
        txtusername1.setBounds(30, 370, 280, 40);

        txtidnum.setText("Id Number");
        txtidnum.setBackground(new java.awt.Color(0, 0, 0,0));
        txtidnum.setBorderColor(new java.awt.Color(230, 245, 241));
        txtidnum.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\StudentAttend\\11185794_user_person_profile_avatar_people_icon (1).png"));
        txtidnum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtidnumFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtidnumFocusLost(evt);
            }
        });
      
        txtidnum.addKeyListener(new java.awt.event.KeyAdapter() {
       
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidnumKeyTyped(evt);
            }
        });
        jPanel3.add(txtidnum);
        txtidnum.setBounds(30, 140, 280, 40);

        txtfirstname.setText("First Name");
        txtfirstname.setBackground(new java.awt.Color(0, 0, 0,0));
        txtfirstname.setBorderColor(new java.awt.Color(230, 245, 241));
        txtfirstname.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\StudentAttend\\11185794_user_person_profile_avatar_people_icon (1).png"));
        txtfirstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfirstnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfirstnameFocusLost(evt);
            }
        });

        txtfirstname.addKeyListener(new java.awt.event.KeyAdapter() {
       
        });
        jPanel3.add(txtfirstname);
        txtfirstname.setBounds(30, 200, 130, 40);

        txtlastname.setText("Last Name");
        txtlastname.setBackground(new java.awt.Color(0, 0, 0,0));
        txtlastname.setBorderColor(new java.awt.Color(230, 245, 241));
        txtlastname.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\StudentAttend\\11185794_user_person_profile_avatar_people_icon (1).png"));
        txtlastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtlastnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtlastnameFocusLost(evt);
            }
        });
      
        txtlastname.addKeyListener(new java.awt.event.KeyAdapter() {
         
        });
        jPanel3.add(txtlastname);
        txtlastname.setBounds(180, 200, 130, 40);

        txtconfirmpassword.setText("Confirm Password");
        txtconfirmpassword.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\8491307_padlock_security_password_icon.png"));
     
        txtconfirmpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtconfirmpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtconfirmpasswordFocusLost(evt);
            }
        });
     
        txtconfirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfirmpasswordActionPerformed(evt);
            }
        });
      
        txtconfirmpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtconfirmpasswordKeyPressed(evt);
            }
          
        });
        jPanel3.add(txtconfirmpassword);
        txtconfirmpassword.setBounds(30, 520, 280, 40);

        btnsignin1.setText("Sign Up");
        btnsignin1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnsignin1.setForeground(new java.awt.Color(255, 255, 255));
        btnsignin1.setRadius(50);
        btnsignin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignin1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnsignin1);
        btnsignin1.setBounds(50, 580, 246, 42);

        lblvalid2.setText("The Confirm Password  didnt Match up! ");
        lblvalid2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(lblvalid2);
        lblvalid2.setBounds(30, 560, 300, 16);

        lblvalid1.setText("The Confirm Password didnt Match up!");
        lblvalid1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(lblvalid1);
        lblvalid1.setBounds(30, 490, 240, 16);

        lblvalid3.setText("Idnumber is Already Have Taken Please Input Another");
        lblvalid3.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(lblvalid3);
        lblvalid3.setBounds(30, 180, 290, 16);

        jLabel1.setText("BOD(Date Of Birth)");
        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(30, 250, 150, 10);
        jPanel3.add(bod);
        bod.setBounds(30, 270, 280, 40);

        cbgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gender", "Male", "Female", " " }));
        cbgender.addMouseListener(new java.awt.event.MouseAdapter() {
       
        });
        cbgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbgenderActionPerformed(evt);
            }
        });
        jPanel3.add(cbgender);
        cbgender.setBounds(30, 320, 90, 40);

        cbcourse.setToolTipText("");
        cbcourse.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbcoursePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbcoursePopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel3.add(cbcourse);
        cbcourse.setBounds(130, 320, 90, 40);

        cbyear.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbyearPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbyearPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel3.add(cbyear);
        cbyear.setBounds(230, 320, 80, 40);

        lblvalid4.setForeground(new java.awt.Color(255, 0, 0));
        lblvalid4.setText("Idnumber is Already Have Taken Please Input Another");
        jPanel3.add(lblvalid4);
        lblvalid4.setBounds(30, 410, 290, 16);

        myButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/285633_image_icon (1).png"))); // NOI18N
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(myButton2);
        myButton2.setBounds(180, 90, 40, 40);

        studentpic.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.add(studentpic);
        studentpic.setBounds(90, 20, 130, 110);

        jTabbedPane1.addTab("tab2", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 330, 680));

        signuppanel.setBackground(new java.awt.Color(39, 159, 217));
        signuppanel.setForeground(new java.awt.Color(30, 30, 30));
        signuppanel.setLayout(null);

        label1.setText("Still Havent Join Us?");
        label1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        signuppanel.add(label1);
        label1.setBounds(190, 520, 250, 19);

        btnsignup.setText("Sign Up");
        btnsignup.setBorderColor(new java.awt.Color(0, 0, 0));
        btnsignup.setColor(new java.awt.Color(0, 0, 0));
        btnsignup.setColorClick(new java.awt.Color(102, 102, 102));
        btnsignup.setColorOver(new java.awt.Color(51, 51, 51));
        btnsignup.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnsignup.setForeground(new java.awt.Color(255, 255, 255));
        btnsignup.setRadius(50);
        btnsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignupActionPerformed(evt);
            }
        });
        signuppanel.add(btnsignup);
        btnsignup.setBounds(130, 540, 268, 40);

        labelwelcome2.setText("System");
        labelwelcome2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        labelwelcome2.setForeground(new java.awt.Color(255, 255, 255));
        signuppanel.add(labelwelcome2);
        labelwelcome2.setBounds(220, 120, 90, 32);

        labelwelcome1.setText("Event Attendance ");
        labelwelcome1.setFont(new java.awt.Font("SansSerif", 1, 42)); // NOI18N
        labelwelcome1.setForeground(new java.awt.Color(255, 255, 255));
        signuppanel.add(labelwelcome1);
        labelwelcome1.setBounds(80, 80, 370, 54);

        labelwelcome.setText("Welcome User");
        labelwelcome.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        labelwelcome.setForeground(new java.awt.Color(255, 255, 255));
        signuppanel.add(labelwelcome);
        labelwelcome.setBounds(140, 40, 250, 47);

        btnsignin3.setText("Sign In");
        btnsignin3.setBorderColor(new java.awt.Color(0, 0, 0));
        btnsignin3.setColor(new java.awt.Color(0, 0, 0));
        btnsignin3.setColorClick(new java.awt.Color(102, 102, 102));
        btnsignin3.setColorOver(new java.awt.Color(51, 51, 51));
        btnsignin3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnsignin3.setForeground(new java.awt.Color(255, 255, 255));
        btnsignin3.setRadius(50);
        btnsignin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignin3ActionPerformed(evt);
            }
        });
        signuppanel.add(btnsignin3);
        btnsignin3.setBounds(130, 540, 268, 40);

        myPicture2.setBackground(new java.awt.Color(0, 0, 0,0));
        signuppanel.add(myPicture2);
        myPicture2.setBounds(-10, 110, 510, 460);

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        myButton1.setBorderColor(new java.awt.Color(39, 159, 217));
        myButton1.setColor(new java.awt.Color(39, 159, 217));
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        signuppanel.add(myButton1);
        myButton1.setBounds(450, 0, 30, 30);

        getContentPane().add(signuppanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, -1, 480, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   

    private void showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpasswordActionPerformed
         new Function.KeyType.PasswordField().showpasswordChar(showpassword, txtpassword);
    }//GEN-LAST:event_showpasswordActionPerformed

    private void btnsigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsigninActionPerformed
       if(new loginAccount().loginAccs(txtusername.getText(), txtpassword.getText())){
            txtpassword.setText(null);
            txtusername.setText(null);
           txtpassword.setEchoChar((char)0);
           this.dispose();
           return;
       }
    }//GEN-LAST:event_btnsigninActionPerformed

    private void txtpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusGained
      new Function.FocusEvents.PasswordField().focusGained(txtpassword,"Password", showpassword);
    }//GEN-LAST:event_txtpasswordFocusGained

    private void txtpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusLost
      new Function.FocusEvents.PasswordField().focusLost(txtpassword, "Password",showpassword);
    }//GEN-LAST:event_txtpasswordFocusLost

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        if(new loginAccount().loginAccs(txtusername.getText(), txtpassword.getText())){
     txtpassword.setText(null);
     txtusername.setText(null);
    txtpassword.setEchoChar((char)0);
    this.dispose();
    return;
       }
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        new Function.KeyType.PasswordField().checkEmpty(txtpassword, showpassword, "Password");
    }//GEN-LAST:event_txtpasswordKeyPressed

    private void txtusernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusGained
        new MyTextField().focuseGained(txtusername, "Username");
    }//GEN-LAST:event_txtusernameFocusGained

    private void txtusernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusLost
        new MyTextField().focusLost(txtusername, "Username");
    }//GEN-LAST:event_txtusernameFocusLost

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        if(new loginAccount().loginAccs(txtusername.getText(), txtpassword.getText())){
     txtpassword.setText(null);
     txtusername.setText(null);
    txtpassword.setEchoChar((char)0);
    this.dispose();
    return;
       }
    }//GEN-LAST:event_txtusernameActionPerformed

    private void signupshowpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupshowpasswordActionPerformed
    new Function.KeyType.PasswordField().showpasswordChar(signupshowpassword, txtpassword1);
    }//GEN-LAST:event_signupshowpasswordActionPerformed

    private void showconfirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showconfirmpasswordActionPerformed
       new Function.KeyType.PasswordField().showpasswordChar(showconfirmpassword, txtconfirmpassword);
    }//GEN-LAST:event_showconfirmpasswordActionPerformed

    private void txtpassword1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassword1FocusGained
       new Function.FocusEvents.PasswordField().focusGained(txtpassword1, "Password", signupshowpassword);
    }//GEN-LAST:event_txtpassword1FocusGained

    private void txtpassword1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassword1FocusLost
       new Function.FocusEvents.PasswordField().focusLost(txtpassword1, "Password", signupshowpassword);
    }//GEN-LAST:event_txtpassword1FocusLost

    private void txtpassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassword1ActionPerformed
        new MyPasswordField().checkvalidation( txtpassword1, txtconfirmpassword);
        if (new MyPasswordField().isValidation() == false) {
            new MyMessage(null, false).message("REMINDER", "The confirm password and pass didnt match please match the two to procceed", "INFORMATION", "OK", "OK");
            jTabbedPane1.setSelectedIndex(1);

            return;
        }
        jTabbedPane1.setSelectedIndex(0);
        btnsignin3.setVisible(false);
        btnsignup.setVisible(true);
    }//GEN-LAST:event_txtpassword1ActionPerformed

    private void txtpassword1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassword1KeyPressed
    new Function.KeyType.PasswordField().checkEmpty(txtpassword1, signupshowpassword, "Username");
    }//GEN-LAST:event_txtpassword1KeyPressed

    private void txtusername1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusername1FocusGained
        new MyTextField().focuseGained(txtusername1, "Username");
    }//GEN-LAST:event_txtusername1FocusGained

    private void txtusername1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusername1FocusLost
        new MyTextField().focusLost(txtusername1, "Username");
    }//GEN-LAST:event_txtusername1FocusLost

    private void txtidnumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidnumFocusGained
        new MyTextField().focuseGained(txtidnum, "Id Number");
    }//GEN-LAST:event_txtidnumFocusGained

    private void txtidnumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidnumFocusLost
        new MyTextField().focusLost(txtidnum, "Id Number");
    }//GEN-LAST:event_txtidnumFocusLost

    private void txtidnumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidnumKeyTyped
     new Function.KeyType.TextField().NumberTypeOnly(evt, txtidnum);
        
    }//GEN-LAST:event_txtidnumKeyTyped

    private void txtfirstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfirstnameFocusGained
        new MyTextField().focuseGained(txtfirstname, "First Name");
    }//GEN-LAST:event_txtfirstnameFocusGained

    private void txtfirstnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfirstnameFocusLost
        new MyTextField().focusLost(txtfirstname, "First Name");
    }//GEN-LAST:event_txtfirstnameFocusLost

    private void txtlastnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtlastnameFocusGained
        new MyTextField().focuseGained(txtlastname, "Last Name");
    }//GEN-LAST:event_txtlastnameFocusGained

    private void txtlastnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtlastnameFocusLost
        new MyTextField().focuseGained(txtlastname, "Last Name");
    }//GEN-LAST:event_txtlastnameFocusLost

    private void txtconfirmpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfirmpasswordFocusGained
       new Function.FocusEvents.PasswordField().focusGained(txtconfirmpassword, "Confirm Password", showconfirmpassword);
    }//GEN-LAST:event_txtconfirmpasswordFocusGained

    private void txtconfirmpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfirmpasswordFocusLost
     new Function.FocusEvents.PasswordField().focusLost(txtconfirmpassword, "Confirm Password", showconfirmpassword);
    }//GEN-LAST:event_txtconfirmpasswordFocusLost

    private void txtconfirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmpasswordActionPerformed
        new MyPasswordField().checkvalidation(txtpassword1, txtconfirmpassword);
        if (new MyPasswordField().isValidation() == false) {
            jTabbedPane1.setSelectedIndex(1);

            new MyMessage(null, false).message("REMINDER", "The Confirm Password and Password Didnt Match! ", "INFORMATION", "OK", "OK");
            return;
        }
        jTabbedPane1.setSelectedIndex(0);
        btnsignin3.setVisible(false);
        btnsignup.setVisible(true);
    }//GEN-LAST:event_txtconfirmpasswordActionPerformed

    private void txtconfirmpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconfirmpasswordKeyPressed
      new Function.KeyType.PasswordField().checkEmpty(txtconfirmpassword, showconfirmpassword, "Confirm Password");
    }//GEN-LAST:event_txtconfirmpasswordKeyPressed


    private void btnsignin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignin1ActionPerformed
        addaccount();
        
    }//GEN-LAST:event_btnsignin1ActionPerformed

    private void btnsignin3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignin3ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        btnsignin3.setVisible(false);
        btnsignup.setVisible(true);
        label1.setText("Still Havent Join Us");
    }//GEN-LAST:event_btnsignin3ActionPerformed

    private void btnsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignupActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        btnsignup.setVisible(false);
        btnsignin3.setVisible(true);
        label1.setText("Already have Account?");
    }//GEN-LAST:event_btnsignupActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
    this.dispose();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void AboutLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutLabelMouseEntered
        AboutLabel.setForeground(new Color(39, 159, 217));
    }//GEN-LAST:event_AboutLabelMouseEntered

    private void AboutLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutLabelMouseExited
       AboutLabel.setForeground(Color.black);
    }//GEN-LAST:event_AboutLabelMouseExited

    private void AboutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutLabelMouseClicked
   new About(this,true).setVisible(true);
    }//GEN-LAST:event_AboutLabelMouseClicked

    private void cbcoursePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcoursePopupMenuWillBecomeVisible
        cbcourse.removeItemAt(0);
    }//GEN-LAST:event_cbcoursePopupMenuWillBecomeVisible

    private void cbcoursePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcoursePopupMenuWillBecomeInvisible
         cbcourse.insertItemAt("Course", 0);
    }//GEN-LAST:event_cbcoursePopupMenuWillBecomeInvisible

    private void cbyearPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbyearPopupMenuWillBecomeInvisible
         cbyear.insertItemAt("Year", 0);
    }//GEN-LAST:event_cbyearPopupMenuWillBecomeInvisible

    private void cbyearPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbyearPopupMenuWillBecomeVisible
        cbyear.removeItemAt(0);
    }//GEN-LAST:event_cbyearPopupMenuWillBecomeVisible

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
    new Function.File.file().FilePictureFilter(f);  
    if(new Function.File.file().FileCheckGender(f, cbgender,studentpic)){
       new Function.Image.FitImage().rizelabel(f, studentpic);
       return;
    }
    }//GEN-LAST:event_myButton2ActionPerformed

    private void cbgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbgenderActionPerformed
      if(!new Function.File.file().FileCheckGender(f, cbgender,studentpic)){
       new Function.Image.FitImage().rizelabel(f, studentpic);
        return ;
    }
    }//GEN-LAST:event_cbgenderActionPerformed

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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AboutLabel;
    private com.github.lgooddatepicker.components.DatePicker bod;
    private UserInterface.CustomComponents.MyButton btnsignin;
    private UserInterface.CustomComponents.MyButton btnsignin1;
    private UserInterface.CustomComponents.MyButton btnsignin3;
    private UserInterface.CustomComponents.MyButton btnsignup;
    private javax.swing.JComboBox<String> cbcourse;
    private javax.swing.JComboBox<String> cbgender;
    private javax.swing.JComboBox<String> cbyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel labelwelcome;
    private javax.swing.JLabel labelwelcome1;
    private javax.swing.JLabel labelwelcome2;
    private javax.swing.JLabel lblvalid1;
    private javax.swing.JLabel lblvalid2;
    private javax.swing.JLabel lblvalid3;
    private javax.swing.JLabel lblvalid4;
    private UserInterface.CustomComponents.MyButton myButton1;
    private UserInterface.CustomComponents.MyButton myButton2;
    private UserInterface.CustomComponents.MyPanel myPicture2;
    private javax.swing.JCheckBox showconfirmpassword;
    private javax.swing.JCheckBox showpassword;
    private javax.swing.JPanel signuppanel;
    private javax.swing.JCheckBox signupshowpassword;
    private javax.swing.JLabel studentpic;
    private UserInterface.CustomComponents.MyPasswordField txtconfirmpassword;
    private UserInterface.CustomComponents.MyTextField txtfirstname;
    private UserInterface.CustomComponents.MyTextField txtidnum;
    private UserInterface.CustomComponents.MyTextField txtlastname;
    public static UserInterface.CustomComponents.MyPasswordField txtpassword;
    private UserInterface.CustomComponents.MyPasswordField txtpassword1;
    private UserInterface.CustomComponents.MyTextField txtusername;
    private UserInterface.CustomComponents.MyTextField txtusername1;
    // End of variables declaration//GEN-END:variables
}
