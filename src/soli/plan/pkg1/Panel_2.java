/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package soli.plan.pkg1;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static soli.plan.pkg1.Print_Goods.normal;

/**
 *
 * @author DELL
 */
public class Panel_2 extends javax.swing.JPanel {

    /**
     * Creates new form Panel_2
     */
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;
    int cnt = 1;
    double x3 = 0.0, x4 = 0.0;
    ArrayList<Data_Suppliers_Customers> customerses = new ArrayList<>();
    ArrayList<Data_Suppliers_Customers> suppliers = new ArrayList<>();

    public Panel_2() {
        initComponents();
        get_customers();
        get_suppliers();
    }

    public void get_customers() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * FROM customers where Y_id = '" + Running.Y_id + "'");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Data_Suppliers_Customers d1 = new Data_Suppliers_Customers(set.getString("C_id"), set.getString("C_name"), set.getString("C_address"), set.getString("C_den"), set.getString("C_state_den"));
                customerses.add(d1);
            }
            for (int i = 0; i < customerses.size(); i++) {
                get_bills_customers(customerses.get(i).getS_name(), customerses.get(i).getDen(), customerses.get(i).getState_den());
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

    public void get_bills_customers(String name, String den, String state) {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * from bills where name = '" + name + "' and Y_id = '" + Running.Y_id + "'");
            ResultSet set = preparedStatement.executeQuery();
            double x = 0.0;
            String s = "عميل";
            while (set.next()) {
                if (Double.parseDouble(set.getString("Total_after_discount")) != 0.0) {
                    if (!set.getString("nots").equals("مرتجع")) {
                        x += Double.parseDouble(set.getString("total")) - (Double.parseDouble(set.getString("total")) / Double.parseDouble(set.getString("Total_after_discount")));
                    } else {
                        x -= Double.parseDouble(set.getString("total")) - (Double.parseDouble(set.getString("total")) / Double.parseDouble(set.getString("Total_after_discount")));
                    }
                } else {
                    if (!set.getString("nots").equals("مرتجع")) {
                        x += Double.parseDouble(set.getString("total"));
                    } else {
                        x -= Double.parseDouble(set.getString("total"));
                    }
                }
            }
            preparedStatement = connection.prepareStatement("select * from instore where Y_id = '" + Running.Y_id + "' and nots = '" + name + "' ");
            ResultSet set2 = preparedStatement.executeQuery();
            double x2 = 0.0;
            while (set2.next()) {
                x2 += Double.parseDouble(set2.getString("mony"));
            }
            DefaultTableModel mm = (DefaultTableModel) jTable1.getModel();
            Object[] col = new Object[5];
            col[4] = cnt++;
            col[3] = name;
            col[2] = s;
            if (x > x2) {
                if (state.equals("عليه")) {
                    col[0] = (x - x2) + Double.parseDouble(den); // عليه
                    x3 += (x - x2) + Double.parseDouble(den);
                } else {
                    col[0] = (x - x2) - Double.parseDouble(den); // عليه
                    x3 += (x - x2) - Double.parseDouble(den);
                }
                col[1] = 0;
            } else {
                if (state.equals("عليه")) {
                    col[1] = (x2 - x) - Double.parseDouble(den); // له
                    x4 += (x2 - x) - Double.parseDouble(den);
                } else {
                    col[1] = (x2 - x) + Double.parseDouble(den); // له
                    x4 += (x2 - x) + Double.parseDouble(den);
                }
                col[0] = 0;
            }
            if (Double.parseDouble(col[0].toString()) == 0.0 && Double.parseDouble(col[1].toString()) == 0.0) {
                cnt--;
            } else {
                mm.addRow(col);
            }
            jLabel3.setText(x4 + "");
            jLabel5.setText(x3 + "");
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

    public void get_suppliers() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * FROM suppliers where Y_id = '" + Running.Y_id + "'");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Data_Suppliers_Customers d1 = new Data_Suppliers_Customers(set.getString("S_id"), set.getString("S_name"), set.getString("S_address"), set.getString("den"), set.getString("state_den"));
                suppliers.add(d1);
            }
            for (int i = 0; i < suppliers.size(); i++) {
                get_bills_suppliers(suppliers.get(i).getS_name(), suppliers.get(i).getDen(), suppliers.get(i).getState_den());
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

    public void get_bills_suppliers(String name, String den, String state) {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * from bills where name = '" + name + "' and Y_id = '" + Running.Y_id + "'");
            ResultSet set = preparedStatement.executeQuery();
            double x = 0.0;
            String s = "مورد";
            while (set.next()) {
                if (Double.parseDouble(set.getString("Total_after_discount")) != 0.0) {
                    if (!set.getString("nots").equals("مرتجع")) {
                        x += Double.parseDouble(set.getString("total")) - (Double.parseDouble(set.getString("total")) / Double.parseDouble(set.getString("Total_after_discount")));
                    } else {
                        x -= Double.parseDouble(set.getString("total")) - (Double.parseDouble(set.getString("total")) / Double.parseDouble(set.getString("Total_after_discount")));
                    }
                } else {
                    if (!set.getString("nots").equals("مرتجع")) {
                        x += Double.parseDouble(set.getString("total"));
                    } else {
                        x -= Double.parseDouble(set.getString("total"));
                    }
                }
            }
            preparedStatement = connection.prepareStatement("select * from outstore where Y_id = '" + Running.Y_id + "' and nots = '" + name + "'");
            ResultSet set2 = preparedStatement.executeQuery();
            double x2 = 0.0;
            while (set2.next()) {
                x2 += Double.parseDouble(set2.getString("mony"));
            }
            DefaultTableModel mm = (DefaultTableModel) jTable1.getModel();
            Object[] col = new Object[5];
            col[4] = cnt++;
            col[3] = name;
            col[2] = s;
            if (x > x2) {
                if (state.equals("له")) {
                    col[1] = (x - x2) + Double.parseDouble(den); // له
                    x4 += (x - x2) + Double.parseDouble(den);
                } else {
                    col[1] = (x - x2) - Double.parseDouble(den); // له
                    x4 += (x - x2) - Double.parseDouble(den);
                }
                col[0] = 0;
            } else {
                if (state.equals("عليه")) {
                    col[0] = (x2 - x) + Double.parseDouble(den); // عليه
                    x3 += (x2 - x) + Double.parseDouble(den);
                } else {
                    col[0] = (x2 - x) - Double.parseDouble(den); // عليه
                    x3 += (x2 - x) - Double.parseDouble(den);
                }
                col[1] = 0;
            }
            if (Double.parseDouble(col[0].toString()) == 0.0 && Double.parseDouble(col[1].toString()) == 0.0) {
                cnt--;
            } else {
                mm.addRow(col);
            }
            jLabel3.setText(x4 + "");
            jLabel5.setText(x3 + "");
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("بيان المديونات (دائن/مدين) خلال الفترة الزمنية المكتوبة أعلاه");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "عليه", "له", "مورد/عميل", "الاسم", "م"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setMinWidth(450);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(450);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(450);
            jTable1.getColumnModel().getColumn(4).setMinWidth(40);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(40);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("اجمالي الدائنين (له) : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("0");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("اجمالي المدينين (عليه) : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soli/plan/pkg1/download15.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(181, 181, 181)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\بيان المديونات.pdf"));
            doc.open();
            PdfPTable tb1 = new PdfPTable(5);
            tb1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            tb1.addCell(new Phrase("م", normal));
            tb1.addCell(new Phrase("الأسم", normal));
            tb1.addCell(new Phrase("مورد/عميل", normal));
            tb1.addCell(new Phrase("له", normal));
            tb1.addCell(new Phrase("عليه", normal));

            PdfPCell cell;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                cell = new PdfPCell(new Phrase((i + 1) + "", normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 3).toString(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 2).toString(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 1).toString(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 0).toString(), normal));
                tb1.addCell(cell);
            }
            doc.add(tb1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some Thing went wrong");
        }
        doc.close();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
