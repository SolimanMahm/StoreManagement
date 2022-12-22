/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package soli.plan.pkg1;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Reports extends javax.swing.JFrame {

    /**
     * Creates new form Reports
     */
    public static com.itextpdf.text.Font normal = FontFactory.getFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, 7, Font.BOLD);
    ArrayList<Data_Suppliers_Customers> list1 = new ArrayList<>();
    ArrayList<Data_Suppliers_Customers> list2 = new ArrayList<>();
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    Panel_1 p1;
    Panel_2 p2;
    panel_3 p3;
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;
    public static String stt, name, from_date, to_date;

    public Reports() {
        initComponents();
        this.setResizable(false);
        this.setLocation(50, 20);
        this.setDefaultCloseOperation(Reports.DO_NOTHING_ON_CLOSE);
        Get_data_suppliers();
        Get_data_customers();
        p1 = new Panel_1();
        p2 = new Panel_2();
        p3 = new panel_3();
        jPanel3.setLayout(layout);
        c.gridx = 0;
        c.gridy = 0;
        jPanel3.add(p1, c);
        jPanel3.add(p2, c);
        jPanel3.add(p3, c);
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        SimpleDateFormat year = new SimpleDateFormat("YYYY");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat day = new SimpleDateFormat("dd");
        Date date = new Date();
        this.year.setText(Running.date);
        this.month.setText("01");
        this.day.setText("01");
        year1.setText(Running.date);
        if (Integer.parseInt(year.format(date)) > Integer.parseInt(Running.date)) {
            month1.setText("12");
            day1.setText("31");
        } else {
            month1.setText(month.format(date));
            day1.setText(day.format(date));
        }
        String s[] = null;
        s = new String[list1.size() + list2.size() + 1];
        int i = 1;
        for (int x = 0; x < list1.size(); x++) {
            s[i] = list1.get(x).getS_name();
            i++;
        }
        for (int x = 0; x < list2.size(); x++) {
            s[i] = list2.get(x).getC_name();
            i++;
        }
        Arrays.sort(s, 1, s.length);
        s[0] = "(جميع الموردين و العملاء)";
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(s));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        day = new javax.swing.JTextField();
        month = new javax.swing.JTextField();
        year = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        day1 = new javax.swing.JTextField();
        month1 = new javax.swing.JTextField();
        year1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("فترة زمنية من : ");

        day.setEditable(false);
        day.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        day.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        month.setEditable(false);
        month.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        month.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });

        year.setEditable(false);
        year.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        year.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("الي : ");

        day1.setEditable(false);
        day1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        day1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        month1.setEditable(false);
        month1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        month1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        month1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month1ActionPerformed(evt);
            }
        });

        year1.setEditable(false);
        year1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        year1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "موردين و عملاء", "موردين فقط", "عملاء فقط" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("التقرير المطلوب : ");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                    ", "اعداد كشف حساب عن مورد أو عميل محدد خلال الفترة الزمنية المكتوبة أعلاه", "تقرير عن المديونات (دائن/مدين) خلال الفترة الزمنية المكتوبة أعلاه", "تقرير ميزان المراجعة الختامي خلال الفترة الزمنية المكتوبة أعلاه" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soli/plan/pkg1/download 4.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, 0, 900, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 100)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Soli plan 1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("jFrame");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void month1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_month1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_month1ActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        stt = jComboBox1.getSelectedItem().toString();
        int x = jComboBox3.getSelectedIndex();
        from_date = "";
        from_date += year.getText();
        if (month.getText().length() == 1) {
            from_date += "/0" + month.getText();
        } else {
            from_date += "/" + month.getText();
        }
        if (day.getText().length() == 1) {
            from_date += "/0" + day.getText();
        } else {
            from_date += "/" + day.getText();
        }
        to_date = "";
        to_date += year1.getText();
        if (month1.getText().length() == 1) {
            to_date += "/0" + month1.getText();
        } else {
            to_date += "/" + month1.getText();
        }
        if (day1.getText().length() == 1) {
            to_date += "/0" + day1.getText();
        } else {
            to_date += "/" + day1.getText();
        }
        if (x == 1) {
            p1 = new Panel_1();
            c.gridx = 0;
            c.gridy = 0;
            jPanel3.add(p1, c);
            jLabel4.setVisible(false);
            p1.setVisible(true);
            p2.setVisible(false);
            p3.setVisible(false);
        } else if (x == 2) {
            jLabel4.setVisible(false);
            p1.setVisible(false);
            p2.setVisible(true);
            p3.setVisible(false);
        } else if (x == 3) {
            jLabel4.setVisible(false);
            p1.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(true);
        } else {
            jLabel4.setVisible(true);
            p1.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        String s[] = null;
        if (jComboBox1.getSelectedIndex() == 0) {
            s = new String[list1.size() + list2.size() + 1];
            int i = 1;
            for (int x = 0; x < list1.size(); x++) {
                s[i] = list1.get(x).getS_name();
                i++;
            }
            for (int x = 0; x < list2.size(); x++) {
                s[i] = list2.get(x).getC_name();
                i++;
            }
            Arrays.sort(s, 1, s.length);
            s[0] = "(جميع الموردين و العملاء)";
        } else if (jComboBox1.getSelectedIndex() == 1) {
            s = new String[list1.size() + 1];
            for (int i = 0; i < list1.size(); i++) {
                s[i + 1] = list1.get(i).getS_name().toString();
            }
            s[0] = "(جميع الموردين)";
        } else if (jComboBox1.getSelectedIndex() == 2) {
            s = new String[list2.size() + 1];
            for (int i = 0; i < list2.size(); i++) {
                s[i + 1] = list2.get(i).getC_name().toString();
            }
            s[0] = "(جميع العملاء)";
        }
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(s));
        name = s[0];
        p1.setVisible(false);
        jLabel4.setVisible(true);
        jComboBox3.setSelectedIndex(0);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        name = jComboBox2.getSelectedItem().toString();
        p1.setVisible(false);
        jLabel4.setVisible(true);
        jComboBox3.setSelectedIndex(0);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    public void Get_data_suppliers() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * FROM suppliers WHERE Y_id = '" + Running.Y_id + "' order by S_name");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Data_Suppliers_Customers d1 = new Data_Suppliers_Customers(set.getString("S_id"), set.getString("S_name"), set.getString("S_address"), set.getString("den"), set.getString("state_den"));
                list1.add(d1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void Get_data_customers() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE Y_id = '" + Running.Y_id + "' order by C_name");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Data_Suppliers_Customers d1 = new Data_Suppliers_Customers(set.getString("C_id"), set.getString("C_name"), set.getString("C_address"), set.getString("C_den"), set.getString("C_state_den"), 0);
                list2.add(d1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField day;
    private javax.swing.JTextField day1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField month;
    private javax.swing.JTextField month1;
    private javax.swing.JTextField year;
    private javax.swing.JTextField year1;
    // End of variables declaration//GEN-END:variables
}