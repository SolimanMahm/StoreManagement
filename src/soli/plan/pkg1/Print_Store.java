/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package soli.plan.pkg1;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Print_Store extends javax.swing.JFrame {

    /**
     * Creates new form Print_Store
     */
    public static com.itextpdf.text.Font normal = FontFactory.getFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, 7, Font.BOLD);

    public Print_Store() {
        initComponents();
        this.setResizable(false);
        this.setLocation(736, 335);
        this.setDefaultCloseOperation(Print_Store.DO_NOTHING_ON_CLOSE);
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox1.setText("جدول مجمع لحركة الخزينة");

        jCheckBox2.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox2.setText("تفصيل الداخل الي الخزينة");

        jCheckBox3.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox3.setText("تفصيل الخارج من الخزينة");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("طباعة");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jCheckBox1.isSelected()) {
            Print_Table1();
        }
        if (jCheckBox2.isSelected()) {
            Print_Table2();
        }
        if (jCheckBox3.isSelected()) {
            Print_Table3();
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Print_Table1() {
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\جدول مجمع لحركة الخزينة.pdf"));
            doc.open();
            PdfPTable tb1 = new PdfPTable(4);
            tb1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            tb1.addCell(new Phrase("م", normal));
            tb1.addCell(new Phrase("بتاريخ", normal));
            tb1.addCell(new Phrase("داخل الي الخزينة", normal));
            tb1.addCell(new Phrase("خارج من الخزينة", normal));

            PdfPCell cell;
            for (int i = 0; i < Show_Store.list1.size(); i++) {
                cell = new PdfPCell(new Phrase((i + 1) + "", normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list1.get(i).getData(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list1.get(i).getIn_mony(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list1.get(i).getOut_mony(), normal));
                tb1.addCell(cell);
            }
            doc.add(tb1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some Thing went wrong");
        }
        doc.close();
    }

    public void Print_Table2() {
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\تفصيل الداخل الي الخزينة.pdf"));
            doc.open();
            PdfPTable tb1 = new PdfPTable(5);
            tb1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            tb1.addCell(new Phrase("م", normal));
            tb1.addCell(new Phrase("بتاريخ", normal));
            tb1.addCell(new Phrase("المبلغ", normal));
            tb1.addCell(new Phrase("من جساب", normal));
            tb1.addCell(new Phrase("تفصيل", normal));

            PdfPCell cell;
            for (int i = 0; i < Show_Store.list2.size(); i++) {
                cell = new PdfPCell(new Phrase((i + 1) + "", normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list2.get(i).getDat(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list2.get(i).getMony(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list2.get(i).getState(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list2.get(i).getNots(), normal));
                tb1.addCell(cell);
            }
            doc.add(tb1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some Thing went wrong");
        }
        doc.close();
    }

    public void Print_Table3() {
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\تفصيل الخارج من الخزينة.pdf"));
            doc.open();
            PdfPTable tb1 = new PdfPTable(5);
            tb1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            tb1.addCell(new Phrase("م", normal));
            tb1.addCell(new Phrase("بتاريخ", normal));
            tb1.addCell(new Phrase("المبلغ", normal));
            tb1.addCell(new Phrase("من جساب", normal));
            tb1.addCell(new Phrase("تفصيل", normal));

            PdfPCell cell;
            for (int i = 0; i < Show_Store.list3.size(); i++) {
                cell = new PdfPCell(new Phrase((i + 1) + "", normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list3.get(i).getDat(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list3.get(i).getMony(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list3.get(i).getState(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(Show_Store.list3.get(i).getNots(), normal));
                tb1.addCell(cell);
            }
            doc.add(tb1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some Thing went wrong");
        }
        doc.close();
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
            java.util.logging.Logger.getLogger(Print_Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print_Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print_Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print_Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print_Store().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
