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
public class Panel_1 extends javax.swing.JPanel {

    /**
     * Creates new form Panel_1
     */
    ArrayList<Data_Bills> get_Bills = new ArrayList<>();
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;
    int cnt = 2;
    double Purchase = 0.0, bounce = 0.0;
    String state = null, s;

    public Panel_1() {
        initComponents();
        s = Reports.name;
        DefaultTableModel mm = (DefaultTableModel) jTable1.getModel();
        Object[] col = new Object[5];
        col[4] = cnt++;
        col[3] = "كشف حساب";
        col[2] = Reports.stt + " : " + Reports.name;
        mm.addRow(col);
        col = new Object[5];
        col[4] = cnt++;
        mm.addRow(col);
        get_bills();
    }

    public void get_bills() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * FROM bills WHERE name = '" + Reports.name + "' and Y_id = '" + Running.Y_id + "' and data between '" + Reports.from_date + "' and '" + Reports.to_date + "'");
            ResultSet set = preparedStatement.executeQuery();
            DefaultTableModel mm = (DefaultTableModel) jTable1.getModel();
            Object[] col = new Object[5];
            while (set.next()) {
                Data_Bills b = new Data_Bills(set.getString("state"), set.getString("name"), set.getString("data"), set.getString("total"), set.getString("Total_after_discount"), set.getString("nots"));
                get_Bills.add(b);
            }
            if (get_Bills.get(0).state.equals("عميل")) {
                preparedStatement = connection.prepareStatement("SELECT C_den, C_state_den FROM customers WHERE C_name = '" + Reports.name + "' and Y_id = '" + Running.Y_id + "'");
                ResultSet set1 = preparedStatement.executeQuery();
                set1.next();
                col = new Object[5];
                col[4] = cnt++;
                col[3] = "رصيد دين سابق";
                col[2] = set1.getString("C_den");
                mm.addRow(col);
            }else if(get_Bills.get(0).state.equals("مورد")){
                preparedStatement = connection.prepareStatement("SELECT den, state_den FROM suppliers WHERE S_name = '" + Reports.name + "' and Y_id = '" + Running.Y_id + "'");
                ResultSet set1 = preparedStatement.executeQuery();
                set1.next();
                col = new Object[5];
                col[4] = cnt++;
                col[3] = "رصيد دين سابق";
                col[2] = set1.getString("den");
                mm.addRow(col);
            }
            int f = 0;
            for (int i = 0; i < get_Bills.size(); i++) {
                col[4] = cnt++;
                col[3] = get_Bills.get(i).date;
                if (!get_Bills.get(i).nots.equals("مرتجع")) {
                    col[2] = "قيمة مشتريات بفاتورة رقم : " + (i + 1) + "";
                    if (get_Bills.get(i).state.equals("عميل")) {
                        if (Double.parseDouble(get_Bills.get(i).all_discount) != 0.0) {
                            col[0] = Double.parseDouble(get_Bills.get(i).total) - (Double.parseDouble(get_Bills.get(i).total) / Double.parseDouble(get_Bills.get(i).all_discount));
                            Purchase += Double.parseDouble(get_Bills.get(i).total) - (Double.parseDouble(get_Bills.get(i).total) / Double.parseDouble(get_Bills.get(i).all_discount));
                        } else {
                            col[0] = get_Bills.get(i).total;
                            Purchase += Double.parseDouble(get_Bills.get(i).total);
                        }
                        col[1] = 0;
                        f = 1;
                    } else {
                        if (Double.parseDouble(get_Bills.get(i).all_discount) != 0.0) {
                            col[1] = Double.parseDouble(get_Bills.get(i).total) - (Double.parseDouble(get_Bills.get(i).total) / Double.parseDouble(get_Bills.get(i).all_discount));
                            Purchase += Double.parseDouble(get_Bills.get(i).total) - (Double.parseDouble(get_Bills.get(i).total) / Double.parseDouble(get_Bills.get(i).all_discount));
                        } else {
                            col[1] = Double.parseDouble(get_Bills.get(i).total);
                            Purchase += Double.parseDouble(get_Bills.get(i).total);
                        }
                        col[0] = 0;
                        f = 2;
                    }
                } else {
                    col[2] = "قيمة مرتجع بفاتورة رقم : " + (i + 1) + "";
                    if (get_Bills.get(i).state.equals("عميل")) {
                        if (Double.parseDouble(get_Bills.get(i).all_discount) != 0.0) {
                            col[1] = Double.parseDouble(get_Bills.get(i).total) - (Double.parseDouble(get_Bills.get(i).total) / Double.parseDouble(get_Bills.get(i).all_discount));
                            bounce += Double.parseDouble(get_Bills.get(i).total) - (Double.parseDouble(get_Bills.get(i).total) / Double.parseDouble(get_Bills.get(i).all_discount));
                        } else {
                            col[1] = get_Bills.get(i).total;
                            bounce += Double.parseDouble(get_Bills.get(i).total);
                        }
                        col[0] = 0;
                        f = 1;
                    } else {
                        if (Double.parseDouble(get_Bills.get(i).all_discount) != 0.0) {
                            col[0] = Double.parseDouble(get_Bills.get(i).total) - (Double.parseDouble(get_Bills.get(i).total) / Double.parseDouble(get_Bills.get(i).all_discount));
                            bounce += Double.parseDouble(get_Bills.get(i).total) - (Double.parseDouble(get_Bills.get(i).total) / Double.parseDouble(get_Bills.get(i).all_discount));
                        } else {
                            col[0] = get_Bills.get(i).total;
                            bounce += Double.parseDouble(get_Bills.get(i).total);
                        }
                        col[1] = 0;
                        f = 2;
                    }
                }
                mm.addRow(col);
            }
            if (f == 1) {
                jLabel14.setText(Purchase + "");
                jLabel15.setText(bounce + "");
                if (Purchase == 0.0) {
                    jLabel17.setText(".");
                }
                get_instore();
                get_customers();
            } else if (f == 2) {
                jLabel12.setText(Purchase + "");
                jLabel13.setText(bounce + "");
                if (Purchase == 0.0) {
                    jLabel17.setText(".");
                }
                get_outstore();
                get_suppliers();
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

    public void get_instore() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("select * from instore WHERE Y_id = '" + Running.Y_id + "' and nots = '" + Reports.name + "'");
            ResultSet set = preparedStatement.executeQuery();
            double x = 0.0;
            while (set.next()) {
                x += Double.parseDouble(set.getString("mony"));
            }
            jLabel17.setText("له");
            jLabel16.setText(x + "");
            if ((x - Purchase) == 0.0) {
                jLabel18.setText(".");
            } else {
                if (x < Purchase) {
                    jLabel19.setText((Purchase - bounce - x) + "");
                    jLabel18.setText("عليه");
                } else {
                    jLabel19.setText((x - Purchase - bounce) + "");
                    jLabel18.setText("له");
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

    public void get_outstore() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("select * from outstore WHERE Y_id = '" + Running.Y_id + "' and nots = '" + Reports.name + "'");
            ResultSet set = preparedStatement.executeQuery();
            double x = 0.0;
            while (set.next()) {
                x += Double.parseDouble(set.getString("mony"));
            }
            jLabel17.setText("عليه");
            jLabel16.setText(x + "");
            if ((x - Purchase) == 0.0) {
                jLabel18.setText(".");
            } else {
                if (x < Purchase) {
                    jLabel19.setText((Purchase - bounce - x) + "");
                    jLabel18.setText("له");
                } else {
                    jLabel19.setText((x - Purchase - bounce) + "");
                    jLabel18.setText("عليه");
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
            preparedStatement = connection.prepareStatement("select * from suppliers WHERE Y_id = '" + Running.Y_id + "' and S_name = '" + Reports.name + "'");
            ResultSet set = preparedStatement.executeQuery();
            set.next();
            jLabel9.setText(set.getString("den"));
            if (Double.parseDouble(set.getString("den")) == 0.0) {
                jLabel11.setText(".");
            } else {
                jLabel11.setText(set.getString("state_den"));
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

    public void get_customers() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("select * from customers WHERE Y_id = '" + Running.Y_id + "' and C_name = '" + Reports.name + "'");
            ResultSet set = preparedStatement.executeQuery();
            set.next();
            jLabel9.setText(set.getString("C_den"));
            if (Double.parseDouble(set.getString("C_den")) == 0.0) {
                jLabel11.setText(".");
            } else {
                jLabel11.setText(set.getString("C_state_den"));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 153));
        setPreferredSize(new java.awt.Dimension(1280, 673));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("اعداد كشف عن مورد أو عميل محدد خلال الفترة الزمنية المكتوبة أعلاه");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, "1"}
            },
            new String [] {
                "عليه", "له", "البيان", "بتاريخ", "م"
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
            jTable1.getColumnModel().getColumn(0).setMinWidth(100);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setMinWidth(300);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(4).setMinWidth(40);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(40);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("رصيد دين سابق : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("جملة المشتريات : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("جملة مرتجع المشتريات : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("جملة المبيعات : ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("جملة مرتجع المبيعات : ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ما تم سداده : ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("----------------------------------------------------------");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("جملة المستحق : ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("0");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(".");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("0");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("0");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("0");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("0");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("0");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("عليه");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("له");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("0");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addGap(87, 87, 87))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\كشف عن مورد أو عميل محدد.pdf"));
            doc.open();
            PdfPTable tb1 = new PdfPTable(5);
            tb1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            tb1.addCell(new Phrase("م", normal));
            tb1.addCell(new Phrase("بتاريخ", normal));
            tb1.addCell(new Phrase("البيان", normal));
            tb1.addCell(new Phrase("له", normal));
            tb1.addCell(new Phrase("عليه", normal));

            PdfPCell cell;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                cell = new PdfPCell(new Phrase((i + 1) + "", normal));
                tb1.addCell(cell);
                if (jTable1.getValueAt(i, 3) == null) {
                    cell = new PdfPCell(new Phrase(" ", normal));
                    tb1.addCell(cell);
                } else {
                    cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 3).toString(), normal));
                    tb1.addCell(cell);
                }
                if (jTable1.getValueAt(i, 2) == null) {
                    cell = new PdfPCell(new Phrase(" ", normal));
                    tb1.addCell(cell);
                } else {
                    cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 2).toString(), normal));
                    tb1.addCell(cell);
                }
                if (jTable1.getValueAt(i, 1) == null) {
                    cell = new PdfPCell(new Phrase(" ", normal));
                    tb1.addCell(cell);
                } else {
                    cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 1).toString(), normal));
                    tb1.addCell(cell);
                }
                if (jTable1.getValueAt(i, 0) == null) {
                    cell = new PdfPCell(new Phrase(" ", normal));
                    tb1.addCell(cell);
                } else {
                    cell = new PdfPCell(new Phrase(jTable1.getValueAt(i, 0).toString(), normal));
                    tb1.addCell(cell);
                }
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
