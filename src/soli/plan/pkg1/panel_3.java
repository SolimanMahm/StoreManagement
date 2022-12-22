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
import static soli.plan.pkg1.Print_Goods.normal;

/**
 *
 * @author DELL
 */
public class panel_3 extends javax.swing.JPanel {

    /**
     * Creates new form panel_3
     */
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;
    double purchases = 0.0, bounce = 0.0, Other_Expenses = 0.0, employee = 0.0, sales = 0.0, Other_income = 0.0, Staff_collections = 0.0, Returned_purchases = 0.0;
    double x3 = 0.0, x4 = 0.0;
    ArrayList<Data_Suppliers_Customers> customerses = new ArrayList<>();
    ArrayList<Data_Suppliers_Customers> suppliers = new ArrayList<>();

    public panel_3() {
        initComponents();
        purchases();
        Other_Expenses();
        employee();
        debtor();
        jTable1.setValueAt(purchases, 0, 0);
        jTable1.setValueAt(bounce, 1, 0);
        jTable1.setValueAt(x3, 2, 0);
        jTable1.setValueAt(Other_Expenses, 3, 0);
        jTable1.setValueAt(employee, 4, 0);
        jLabel5.setText((purchases + bounce + x3 + Other_Expenses + employee) + "");

        sales();
        Other_income();
        Staff_collections();
        jTable2.setValueAt(sales, 0, 0);
        jTable2.setValueAt(Returned_purchases, 1, 0);
        jTable2.setValueAt(x4, 2, 0);
        jTable2.setValueAt(Other_income, 3, 0);
        jTable2.setValueAt(Staff_collections, 4, 0);
        jLabel7.setText((sales + Returned_purchases + x4 + Other_income + Staff_collections) + "");

        jLabel9.setText(((sales + Returned_purchases + x4 + Other_income + Staff_collections) - (purchases + bounce + x3 + Other_Expenses + employee)) + "");
    }

    public void purchases() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * FROM bills where Y_id = '" + Running.Y_id + "' and state = 'مورد'");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                if (!set.getString("nots").equals("مرتجع")) {
                    if (Double.parseDouble(set.getString("Total_after_discount")) != 0.0) {
                        purchases += Double.parseDouble(set.getString("total")) - (Double.parseDouble(set.getString("total")) / Double.parseDouble(set.getString("Total_after_discount")));
                    } else {
                        purchases += Double.parseDouble(set.getString("total"));
                    }
                } else {
                    if (Double.parseDouble(set.getString("Total_after_discount")) != 0.0) {
                        bounce += Double.parseDouble(set.getString("total")) - (Double.parseDouble(set.getString("total")) / Double.parseDouble(set.getString("Total_after_discount")));
                    } else {
                        bounce += Double.parseDouble(set.getString("total"));
                    }
                }
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

    public void Other_Expenses() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT mony FROM outstore where Y_id = '" + Running.Y_id + "' and state = 'مصاريف أخري'");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Other_Expenses += Double.parseDouble(set.getString("mony"));
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

    public void employee() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT mony FROM outstore where Y_id = '" + Running.Y_id + "' and state = 'موظف'");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                employee += Double.parseDouble(set.getString("mony"));
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

    public void sales() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * FROM bills where Y_id = '" + Running.Y_id + "' and state = 'عميل'");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                if (!set.getString("nots").equals("مرتجع")) {
                    if (Double.parseDouble(set.getString("Total_after_discount")) != 0.0) {
                        sales += Double.parseDouble(set.getString("total")) - (Double.parseDouble(set.getString("total")) / Double.parseDouble(set.getString("Total_after_discount")));
                    } else {
                        sales += Double.parseDouble(set.getString("total"));
                    }
                } else {
                    if (Double.parseDouble(set.getString("Total_after_discount")) != 0.0) {
                        Returned_purchases += Double.parseDouble(set.getString("total")) - (Double.parseDouble(set.getString("total")) / Double.parseDouble(set.getString("Total_after_discount")));
                    } else {
                        Returned_purchases += Double.parseDouble(set.getString("total"));
                    }
                }
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

    public void Other_income() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT mony FROM instore where Y_id = '" + Running.Y_id + "' and state = 'ايرادات أخري'");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Other_income += Double.parseDouble(set.getString("mony"));
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

    public void Staff_collections() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT mony FROM instore where Y_id = '" + Running.Y_id + "' and state = 'موظف'");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                Staff_collections += Double.parseDouble(set.getString("mony"));
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

    public void debtor() {
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
            if (x > x2) {
                if (state.equals("عليه")) {
                    x3 += (x - x2) + Double.parseDouble(den);
                } else {
                    x3 += (x - x2) - Double.parseDouble(den);
                }
            } else {
                if (state.equals("عليه")) {
                    x4 += (x2 - x) - Double.parseDouble(den);
                } else {
                    x4 += (x2 - x) + Double.parseDouble(den);
                }
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
            if (x > x2) {
                if (state.equals("له")) {
                    x4 += (x - x2) + Double.parseDouble(den);
                } else {
                    x4 += (x - x2) - Double.parseDouble(den);
                }
            } else {
                if (state.equals("عليه")) {
                    x3 += (x2 - x) + Double.parseDouble(den);
                } else {
                    x3 += (x2 - x) - Double.parseDouble(den);
                }
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("تقرير ميزان المراجعة خلال الفترة الزمنية المكتوبة أعلاه");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("جدول المدين");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0", "مشتريات", "1"},
                {"0", "مرتجع مبيعات", "2"},
                {"0", "مدينون", "3"},
                {"0", "مصاريف اضافيه", "4"},
                {"0", "مدفوعات موظفين", "5"}
            },
            new String [] {
                "القيمة", "البيان", "م"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(200);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(2).setMinWidth(40);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(40);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("جدول الدائن");

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0", "مبيعات", "1"},
                {"0", "مرتجع مشتريات", "2"},
                {"0", "دائنين", "3"},
                {"0", "ايرادات اضافية", "4"},
                {"0", "تحصيلات موظفين", "5"}
            },
            new String [] {
                "القيمة", "البيان", "م"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(35);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(200);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(200);
            jTable2.getColumnModel().getColumn(2).setMinWidth(40);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(40);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("اجمالي المدين : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("اجمالي الدائن : ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("اجمالي الارباح : ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel9");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel4)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jButton1)
                    .addComponent(jLabel9))
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
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\تقرير ميزان المراجعة.pdf"));
            doc.open();
            PdfPTable tb1 = new PdfPTable(3);
            tb1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            tb1.addCell(new Phrase("م", normal));
            tb1.addCell(new Phrase("البيان", normal));
            tb1.addCell(new Phrase("القيمة", normal));

            PdfPCell cell;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                cell = new PdfPCell(new Phrase((i + 1) + "", normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 1).toString(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 0).toString(), normal));
                tb1.addCell(cell);
            }
            cell = new PdfPCell(new Phrase(" ", normal));
            tb1.addCell(cell);
            cell = new PdfPCell(new Phrase(" ", normal));
            tb1.addCell(cell);
            cell = new PdfPCell(new Phrase(" ", normal));
            tb1.addCell(cell);
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                cell = new PdfPCell(new Phrase((i + 1) + "", normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(jTable2.getValueAt(i, 1).toString(), normal));
                tb1.addCell(cell);
                cell = new PdfPCell(new Phrase(jTable2.getValueAt(i, 0).toString(), normal));
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
