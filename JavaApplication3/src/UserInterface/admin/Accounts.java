/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.admin;

import UserInterface.CustomComponents.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Database.Admin.*;


public class Accounts extends javax.swing.JPanel {
//diable and appread component when the table is click
    public void disable(boolean choose,boolean reapread){
          cbcourse.setEnabled(choose);
            cbyear.setEnabled(choose);
            cbgender.setEnabled(choose);
            txtidnum.setEnabled(choose);
            txtname.setEnabled(choose);
            filetext.setEnabled(choose);
            btnaddpicture.setEnabled(choose);
            btnadd.setEnabled(choose);
            btndelete.setVisible(reapread);
            btncancel.setVisible(reapread);
            btnedit1.setVisible(reapread);
            btnviewdata.setVisible(reapread);
            datePicker1.setEnabled(choose);
            txtusername.setEnabled(choose);
            txtpassword.setEnabled(choose);
    }
    private  File f ;
    
    public Accounts() {
        initComponents();
        btnviewdata.setVisible(false);
        btnedit1.setVisible(false);
        btnupdate.setVisible(false);
        btndelete.setVisible(false);
        btncancel.setVisible(false);
        datePicker1.getComponentDateTextField().setEnabled(false);
        txtpassword.setEchoChar((char)0);
        new adminSqlite().accountDatadisplay(accountstable);
        new adminSqlite().addValueCB(cbyear, cbcourse);
        new adminSqlite().studentGenderCount("Male", lblmale);
        new adminSqlite().studentGenderCount("Female", lblfemale);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtsearch = new UserInterface.CustomComponents.MyTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountstable = new UserInterface.CustomComponents.MyTable();
        btnfilter = new UserInterface.CustomComponents.MyButton();
        jPanel2 = new javax.swing.JPanel();
        showpassword = new javax.swing.JCheckBox();
        txtpassword = new UserInterface.CustomComponents.MyPasswordField();
        txtidnum = new UserInterface.CustomComponents.MyTextField();
        txtname = new UserInterface.CustomComponents.MyTextField();
        cbgender = new javax.swing.JComboBox<>();
        cbcourse = new javax.swing.JComboBox<>();
        cbyear = new javax.swing.JComboBox<>();
        filetext = new UserInterface.CustomComponents.MyTextField();
        btnaddpicture = new UserInterface.CustomComponents.MyButton();
        lblBOD = new javax.swing.JLabel();
        lbldesign1 = new javax.swing.JLabel();
        lbldesign3 = new javax.swing.JLabel();
        lbldesign4 = new javax.swing.JLabel();
        lbldesigncourse = new javax.swing.JLabel();
        lbldesignyear1 = new javax.swing.JLabel();
        lblBOD1 = new javax.swing.JLabel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        txtusername = new UserInterface.CustomComponents.MyTextField();
        btnsearch1 = new UserInterface.CustomComponents.MyButton();
        myPicture2 = new UserInterface.CustomComponents.MyPanel("girl.png");
        lbldesign5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblfemale = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnedit1 = new UserInterface.CustomComponents.MyButton();
        btnadd = new UserInterface.CustomComponents.MyButton();
        btndelete = new UserInterface.CustomComponents.MyButton();
        btnviewdata = new UserInterface.CustomComponents.MyButton();
        btncancel = new UserInterface.CustomComponents.MyButton();
        btnupdate = new UserInterface.CustomComponents.MyButton();
        myPicture3 = new UserInterface.CustomComponents.MyPanel("boy.png");
        lbldesign6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblmale = new javax.swing.JLabel();
        studentpicture1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(181, 181, 181));

        jPanel3.setBackground(new java.awt.Color(181, 181, 181));

        txtsearch.setText("Search");
        txtsearch.setBackground(java.awt.Color.white);
        txtsearch.setBorderColor(new java.awt.Color(181, 181, 181));
        txtsearch.setCustomIcon2(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\3741750_bussiness_ecommerce_marketplace_onlinestore_search_icon (1).png"));
        txtsearch.setRadius(30);
        txtsearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsearchFocusLost(evt);
            }
        });
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 153, 153));

        accountstable.setAutoCreateRowSorter(true);
        accountstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "IdNum", "Name", "Department", "Gender", "Year", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accountstable.setBackground(new java.awt.Color(255, 255, 255));
        accountstable.setGridColor(new java.awt.Color(0, 0, 0));
        accountstable.setOpaque(false);
        accountstable.setRequestFocusEnabled(false);
        accountstable.setShowGrid(false);
        accountstable.getTableHeader().setReorderingAllowed(false);
        accountstable.setToolTipText("");
        accountstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountstableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(accountstable);

        btnfilter.setText("Filter");
        btnfilter.setRadius(30);
      

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        showpassword.setContentAreaFilled(false);
        showpassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9041325_eye_fill_icon (3).png"));
        showpassword.setSelectedIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\9034884_eye_off_icon (1).png"));
       
        showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpasswordActionPerformed(evt);
            }
        });

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
       
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });

        txtidnum.setText("Id Num#");
        txtidnum.setBackground(new java.awt.Color(0, 0, 0,0));
        txtidnum.setBorderColor(new java.awt.Color(230, 245, 241));
        txtidnum.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\11185794_user_person_profile_avatar_people_icon (1).png"));
        txtidnum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtidnumFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtidnumFocusLost(evt);
            }
        });

        txtname.setText("Student Name");
        txtname.setBackground(new java.awt.Color(0, 0, 0,0));
        txtname.setBorderColor(new java.awt.Color(230, 245, 241));
        txtname.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\11185794_user_person_profile_avatar_people_icon (1).png"));
        txtname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnameFocusLost(evt);
            }
        });

        cbgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gender", "Male", "Female" }));
        cbgender.setBackground(new java.awt.Color(0,0,0,0));
        cbgender.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        cbgender.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbgender.setForeground(new java.awt.Color(122, 140, 141));
        cbgender.setRequestFocusEnabled(false);
        cbgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbgenderActionPerformed(evt);
            }
        });

        cbcourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Course" }));
        cbcourse.setBackground(new java.awt.Color(0,0,0,0));
        cbcourse.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbcourse.setForeground(new java.awt.Color(122, 140, 141));

        cbyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year" }));
        cbyear.setBackground(new java.awt.Color(0,0,0,0));
        cbyear.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbyear.setForeground(new java.awt.Color(122, 140, 141));

        filetext.setText("Student Photo");
        filetext.setBackground(new java.awt.Color(0, 0, 0,0));
        filetext.setBorderColor(new java.awt.Color(230, 245, 241));
        filetext.setCustomIcon1(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\image\\11185794_user_person_profile_avatar_people_icon (1).png"));
        filetext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filetextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                filetextFocusLost(evt);
            }
        });
        filetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filetextActionPerformed(evt);
            }
        });

        btnaddpicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/285633_image_icon (1).png"))); // NOI18N
        btnaddpicture.setRadius(10);
        btnaddpicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddpictureActionPerformed(evt);
            }
        });

        lblBOD.setText("Student Photo:");
        lblBOD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBOD.setForeground(java.awt.Color.black);

        lbldesign1.setText("Id Number:");
        lbldesign1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbldesign1.setForeground(java.awt.Color.black);

        lbldesign3.setText("Student Name:");
        lbldesign3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbldesign3.setForeground(java.awt.Color.black);

        lbldesign4.setText("Gender:");
        lbldesign4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbldesign4.setForeground(java.awt.Color.black);

        lbldesigncourse.setText("Course:");
        lbldesigncourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbldesigncourse.setForeground(java.awt.Color.black);

        lbldesignyear1.setText("Year:");
        lbldesignyear1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbldesignyear1.setForeground(java.awt.Color.black);

        lblBOD1.setText("DOB(Date Of Birth):");
        lblBOD1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBOD1.setForeground(java.awt.Color.black);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lbldesign1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270)
                .addComponent(lbldesign3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txtidnum, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lbldesign4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbldesigncourse, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lbldesignyear1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lblBOD1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(cbgender, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cbcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbyear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblBOD, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(filetext, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnaddpicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(showpassword))
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldesign1)
                    .addComponent(lbldesign3))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidnum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldesign4)
                    .addComponent(lbldesigncourse)
                    .addComponent(lbldesignyear1)
                    .addComponent(lblBOD1))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbgender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbyear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(lblBOD)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filetext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddpicture, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(showpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnsearch1.setText("Search");
        btnsearch1.setRadius(30);
        btnsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearch1ActionPerformed(evt);
            }
        });

        myPicture2.setBackground(new java.awt.Color(0, 0, 0,0));

        lbldesign5.setText("Girls:");
        lbldesign5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lbldesign5.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0,0));

        lblfemale.setText("Numbers");
        lblfemale.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblfemale.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblfemale);

        javax.swing.GroupLayout myPicture2Layout = new javax.swing.GroupLayout(myPicture2);
        myPicture2.setLayout(myPicture2Layout);
        myPicture2Layout.setHorizontalGroup(
            myPicture2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPicture2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPicture2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbldesign5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        myPicture2Layout.setVerticalGroup(
            myPicture2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPicture2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbldesign5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,0));
        jPanel1.setLayout(null);

        btnedit1.setText("Edit");
        btnedit1.setRadius(30);
        btnedit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnedit1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit1);
        btnedit1.setBounds(650, 0, 90, 30);

        btnadd.setText("Add");
        btnadd.setRadius(30);
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd);
        btnadd.setBounds(753, 0, 90, 30);

        btndelete.setText("Delete");
        btndelete.setRadius(30);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete);
        btndelete.setBounds(555, 0, 90, 30);

        btnviewdata.setText("View Student Data");
        btnviewdata.setRadius(30);
        btnviewdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewdataActionPerformed(evt);
            }
        });
        jPanel1.add(btnviewdata);
        btnviewdata.setBounds(433, 0, 110, 30);

        btncancel.setText("Cancel");
        btncancel.setRadius(30);
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel);
        btncancel.setBounds(311, 0, 110, 30);

        btnupdate.setText("Update");
        btnupdate.setRadius(30);
        jPanel1.add(btnupdate);
        btnupdate.setBounds(651, 0, 90, 30);

        myPicture3.setBackground(new java.awt.Color(0, 0, 0,0));

        lbldesign6.setText("Boys:");
        lbldesign6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lbldesign6.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0,0));

        lblmale.setText("Numbers");
        lblmale.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblmale.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lblmale);

        javax.swing.GroupLayout myPicture3Layout = new javax.swing.GroupLayout(myPicture3);
        myPicture3.setLayout(myPicture3Layout);
        myPicture3Layout.setHorizontalGroup(
            myPicture3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPicture3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPicture3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbldesign6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        myPicture3Layout.setVerticalGroup(
            myPicture3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPicture3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbldesign6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        studentpicture1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(myPicture2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259)
                .addComponent(myPicture3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(btnsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnfilter, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentpicture1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myPicture2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myPicture3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(studentpicture1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1115, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddpictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddpictureActionPerformed
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter =new FileNameExtensionFilter("studentImages",ImageIO.getReaderFileSuffixes());
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();
        if(f != null){
       
             new Function.Image.FitImage().rizelabel(f, studentpicture1);
            filetext.setText(f.getAbsolutePath());
            return;
        }
    }//GEN-LAST:event_btnaddpictureActionPerformed

    private void accountstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountstableMouseClicked
       if(new adminSqlite().getDataSelected(accountstable,this)){
        disable(false,true);
      
        }
    }//GEN-LAST:event_accountstableMouseClicked
    
    private void txtidnumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidnumFocusGained
      new MyTextField().focuseGained(txtidnum, "Id Num#");
    }//GEN-LAST:event_txtidnumFocusGained

    private void txtidnumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidnumFocusLost
     new MyTextField().focusLost(txtidnum, "Id Num#");
    }//GEN-LAST:event_txtidnumFocusLost

    private void txtnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnameFocusGained
      new MyTextField().focuseGained(txtname, "Username");
    }//GEN-LAST:event_txtnameFocusGained

    private void txtnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnameFocusLost
    new MyTextField().focusLost(txtname, "Username");
    }//GEN-LAST:event_txtnameFocusLost

    private void txtsearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchFocusGained
        new MyTextField().focuseGained(txtsearch,"Search");
    }//GEN-LAST:event_txtsearchFocusGained

    private void txtsearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchFocusLost
      new MyTextField().focusLost(txtsearch,"Search");
    }//GEN-LAST:event_txtsearchFocusLost

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
    btnadd.setEnabled(true);
    btnviewdata.setVisible(false);
    btndelete.setVisible(false);
    btnedit1.setVisible(false);
    btncancel.setVisible(false);
    }//GEN-LAST:event_btncancelActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
    new DataTableFilter().searchAccountdatafilter(txtsearch.getText(), accountstable);
    }//GEN-LAST:event_txtsearchActionPerformed

    private void btnsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearch1ActionPerformed
    new DataTableFilter().searchAccountdatafilter(txtsearch.getText(), accountstable);
    }//GEN-LAST:event_btnsearch1ActionPerformed

    private void filetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filetextActionPerformed
        File f = new File(filetext.getText());
        new Function.Image.FitImage().rizelabel(f, studentpicture1);
    }//GEN-LAST:event_filetextActionPerformed

    private void filetextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filetextFocusLost
        new MyTextField().focusLost(filetext,"Student Photo");
    }//GEN-LAST:event_filetextFocusLost

    private void filetextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filetextFocusGained
        new MyTextField().focuseGained(filetext, "Student Photo");
    }//GEN-LAST:event_filetextFocusGained

    private void txtusernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusGained
      new MyTextField().focuseGained(txtusername,"Username");
    }//GEN-LAST:event_txtusernameFocusGained

    private void txtusernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusLost
      new MyTextField().focusLost(txtusername,"Username");
    }//GEN-LAST:event_txtusernameFocusLost

    private void txtpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusGained
       new Function.FocusEvents.PasswordField().focusGained(txtpassword,"Password", showpassword);
    }//GEN-LAST:event_txtpasswordFocusGained

    private void txtpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusLost
       new Function.FocusEvents.PasswordField().focusLost(txtpassword, "Password",showpassword);
    }//GEN-LAST:event_txtpasswordFocusLost

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
      new Function.KeyType.PasswordField().checkEmpty(txtpassword, showpassword, "Password");
    }//GEN-LAST:event_txtpasswordKeyPressed



    private void showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpasswordActionPerformed
        new Function.KeyType.PasswordField().showpasswordChar(showpassword, txtpassword);
    }//GEN-LAST:event_showpasswordActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
       ArrayList<Object> data = new ArrayList<>();
       data.addAll(Arrays.asList(txtusername.getText(),txtpassword.getText(),txtpassword.getText(),Integer.parseInt(txtidnum.getText()),txtname.getText(),
               cbgender.getSelectedItem(),datePicker1.getText(),cbcourse.getSelectedItem(),cbyear.getSelectedItem()));
       new adminSqlite().addAccount(data,f, "Account");    
    }//GEN-LAST:event_btnaddActionPerformed

    private void cbgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbgenderActionPerformed

    }//GEN-LAST:event_cbgenderActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
     new adminSqlite().deleteAccount( Integer.parseInt(txtidnum.getText()));
     new adminSqlite().accountDatadisplay(accountstable);
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnedit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnedit1ActionPerformed
   disable(true,true);
   btnedit1.setVisible(false);
    }//GEN-LAST:event_btnedit1ActionPerformed

    private void btnviewdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewdataActionPerformed
      new adminSqlite().viewstudentdata(Integer.parseInt(txtidnum.getText()));
    }//GEN-LAST:event_btnviewdataActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public  UserInterface.CustomComponents.MyTable accountstable;
    private  UserInterface.CustomComponents.MyButton btnadd;
    private  UserInterface.CustomComponents.MyButton btnaddpicture;
    private  UserInterface.CustomComponents.MyButton btncancel;
    private  UserInterface.CustomComponents.MyButton btndelete;
    private  UserInterface.CustomComponents.MyButton btnedit1;
    private  UserInterface.CustomComponents.MyButton btnfilter;
    private  UserInterface.CustomComponents.MyButton btnsearch1;
    private  UserInterface.CustomComponents.MyButton btnupdate;
    private  UserInterface.CustomComponents.MyButton btnviewdata;
    public javax.swing.JComboBox<String> cbcourse;
    public javax.swing.JComboBox<String> cbgender;
    public javax.swing.JComboBox<String> cbyear;
    public com.github.lgooddatepicker.components.DatePicker datePicker1;
    private  UserInterface.CustomComponents.MyTextField filetext;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBOD;
    private javax.swing.JLabel lblBOD1;
    public javax.swing.JLabel lbldesign1;
    private javax.swing.JLabel lbldesign3;
    private javax.swing.JLabel lbldesign4;
    private javax.swing.JLabel lbldesign5;
    private javax.swing.JLabel lbldesign6;
    private javax.swing.JLabel lbldesigncourse;
    private javax.swing.JLabel lbldesignyear1;
    private javax.swing.JLabel lblfemale;
    private javax.swing.JLabel lblmale;
    private  UserInterface.CustomComponents.MyPanel myPicture2;
    private  UserInterface.CustomComponents.MyPanel myPicture3;
    private javax.swing.JCheckBox showpassword;
    public javax.swing.JLabel studentpicture1;
    public  UserInterface.CustomComponents.MyTextField txtidnum;
    public  UserInterface.CustomComponents.MyTextField txtname;
    public  UserInterface.CustomComponents.MyPasswordField txtpassword;
    private  UserInterface.CustomComponents.MyTextField txtsearch;
    public  UserInterface.CustomComponents.MyTextField txtusername;
    // End of variables declaration//GEN-END:variables
  
}
