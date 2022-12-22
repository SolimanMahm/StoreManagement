/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package soli.plan.pkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DELL
 */
public class Suppliers_Customers extends javax.swing.JFrame {

    /**
     * Creates new form Suppliers_Customers
     */
    public static String stte;
    public static String person;
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;
    ArrayList<Data_Suppliers_Customers> list1 = new ArrayList<>(); // name suppliers
    ArrayList<Data_Suppliers_Customers> list3 = new ArrayList<>(); // id suppliers
    ArrayList<Data_Suppliers_Customers> list2 = new ArrayList<>(); // name customers
    ArrayList<Data_Suppliers_Customers> list4 = new ArrayList<>(); // id customers
    boolean flag_lock = false;
    boolean flag_check = false;
    public int select_row = -1;
    public int mouse_click = 1;

    public Suppliers_Customers() {
        initComponents();
        this.setResizable(false);
        this.setLocation(100, 50);
        this.setDefaultCloseOperation(Suppliers_Customers.DO_NOTHING_ON_CLOSE);
        show_data_customers();
        show_data_suppliers();
        count.setText("0   /  " + list1.size() + "");
        int start = 0;
        if (list3.size() != 0) {
            start = Integer.parseInt((list3.get(list3.size() - 1).getS_id()));
        }
        start += 1;
        id.setText(start + "");
        if (Running.lock2.equals("1")) {
            lock.setIcon(new ImageIcon(getClass().getResource("/soli/plan/pkg1/download13.png")));
            flag_lock = true;
            id.setEnabled(false);
            state.setEnabled(false);
            name.setEnabled(false);
            address.setEnabled(false);
            den.setEnabled(false);
            state_den.setEnabled(false);
            Check.setEnabled(false);
        }
    }

    public void show_data_suppliers() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * FROM suppliers WHERE Y_id = '" + Running.Y_id + "' order by S_name");
            ResultSet set = preparedStatement.executeQuery();
            DefaultTableModel m1 = (DefaultTableModel) jTable1.getModel();
            DefaultTableModel m2 = (DefaultTableModel) jTable3.getModel();
            Object[] col = new Object[1];
            while (set.next()) {
                Data_Suppliers_Customers d1 = new Data_Suppliers_Customers(set.getString("S_id"), set.getString("S_name"), set.getString("S_address"), set.getString("den"), set.getString("state_den"));
                list1.add(d1);
            }
            for (int i = 0; i < list1.size(); i++) {
                col[0] = list1.get(i).getS_name();
                m1.addRow(col);
            }
            for (int i = 0; i < list1.size(); i++) {
                col[0] = list1.get(i).getS_id();
                m2.addRow(col);
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM suppliers WHERE Y_id = '" + Running.Y_id + "' order by S_id");
            ResultSet set1 = preparedStatement.executeQuery();
            while (set1.next()) {
                Data_Suppliers_Customers d1 = new Data_Suppliers_Customers(set1.getString("S_id"), set1.getString("S_name"), set1.getString("S_address"), set1.getString("den"), set1.getString("state_den"));
                list3.add(d1);
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

    public void show_data_customers() {
        Security security = new Security();
        try {
            connection = security.coneect();
            preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE Y_id = '" + Running.Y_id + "' order by C_name");
            ResultSet set = preparedStatement.executeQuery();
            DefaultTableModel m1 = (DefaultTableModel) jTable2.getModel();
            DefaultTableModel m2 = (DefaultTableModel) jTable4.getModel();
            Object[] col = new Object[1];
            while (set.next()) {
                Data_Suppliers_Customers d1 = new Data_Suppliers_Customers(set.getString("C_id"), set.getString("C_name"), set.getString("C_address"), set.getString("C_den"), set.getString("C_state_den"), 0);
                list2.add(d1);
            }
            for (int i = 0; i < list2.size(); i++) {
                col[0] = list2.get(i).getC_name();
                m1.addRow(col);
            }
            for (int i = 0; i < list2.size(); i++) {
                col[0] = list2.get(i).getC_id();
                m2.addRow(col);
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE Y_id = '" + Running.Y_id + "' order by C_id");
            ResultSet set1 = preparedStatement.executeQuery();
            while (set1.next()) {
                Data_Suppliers_Customers d1 = new Data_Suppliers_Customers(set1.getString("C_id"), set1.getString("C_name"), set1.getString("C_address"), set1.getString("C_den"), set1.getString("C_state_den"), 0);
                list4.add(d1);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        state = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        den = new javax.swing.JTextField();
        state_den = new javax.swing.JComboBox<>();
        Check = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        New = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        lock = new javax.swing.JButton();
        count = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(65, 105, 225));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("قائمة الموردين و العملاء");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(240, 128, 128));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("كود المورد / العميل :");

        id.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        id.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        id.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        state.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "مورد", "عميل" }));
        state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("اسم المورد / العميل :");

        name.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        name.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        name.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("عنوان المورد / العميل :");

        address.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        address.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        address.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("رصيد دين سابق :");

        den.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        den.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        den.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        state_den.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        state_den.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "له", "عليه" }));

        Check.setBackground(new java.awt.Color(240, 128, 128));
        Check.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Check.setText("تم سداد الدين السابق");
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soli/plan/pkg1/Bill.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(id))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Check)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(state_den, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(den, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(address)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(state_den, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Check)
                    .addComponent(den, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(240, 128, 128));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        next.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soli/plan/pkg1/download8.png"))); // NOI18N
        next.setText("التالي");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        prev.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soli/plan/pkg1/download9.png"))); // NOI18N
        prev.setText("السابق");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soli/plan/pkg1/download10.png"))); // NOI18N
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soli/plan/pkg1/download11.png"))); // NOI18N
        delete.setToolTipText("");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        lock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soli/plan/pkg1/download12.png"))); // NOI18N
        lock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockActionPerformed(evt);
            }
        });

        count.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        count.setForeground(new java.awt.Color(255, 255, 255));
        count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        count.setText("jLabel5");
        count.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(New)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next)
                .addGap(173, 173, 173))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(New, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("البحث عن اسم من القائمة الأبجدية للموردين");

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jTable2.setBackground(new java.awt.Color(204, 255, 204));
        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(35);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        jTable3.setBackground(new java.awt.Color(255, 255, 204));
        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(35);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
        }

        jTable4.setBackground(new java.awt.Color(204, 255, 204));
        jTable4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(35);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
        }

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(255, 255, 204));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("أكواد الموردين");

        jTextField3.setBackground(new java.awt.Color(204, 255, 204));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(204, 255, 204));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("البحث عن اسم من القائمة الأبجدية للعملاء");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("أكواد العملاء");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel9))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void lockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockActionPerformed
        Security security = new Security();
        try {
            connection = security.coneect();
            statement = connection.createStatement();
            if (flag_lock) {
                lock.setIcon(new ImageIcon(getClass().getResource("/soli/plan/pkg1/download12.png")));
                flag_lock = false;
                Running.lock2 = "0";
                id.setEnabled(true);
                state.setEnabled(true);
                name.setEnabled(true);
                address.setEnabled(true);
                den.setEnabled(true);
                state_den.setEnabled(true);
                Check.setEnabled(true);
            } else {
                lock.setIcon(new ImageIcon(getClass().getResource("/soli/plan/pkg1/download13.png")));
                flag_lock = true;
                Running.lock2 = "1";
                id.setEnabled(false);
                state.setEnabled(false);
                name.setEnabled(false);
                address.setEnabled(false);
                den.setEnabled(false);
                state_den.setEnabled(false);
                Check.setEnabled(false);
            }
            String quere = "update years set Y_lock2 = '" + Running.lock2 + "' where Y_id = '" + Running.Y_id + "'";
            statement.execute(quere);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_lockActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        Security security = new Security();
        try {
            connection = security.coneect();
            statement = connection.createStatement();
            String Id = id.getText();
            String Name = name.getText();
            String Address = address.getText();
            String Den = den.getText();
            if (Id.isEmpty() || Name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Correct Format.");
            } else {
                if (state.getSelectedItem().equals("مورد")) {
                    if (flag_check) {
                        String quere = "update suppliers set den = '" + 0 + "', state_den = '" + "له" + "' where S_id = '" + Id + "'";
                        statement.execute(quere);
                    } else {
                        String quere = "";
                        if (Id.equals("1") && !Running.Y_id.equals("1")) {
                            quere = "insert into suppliers set S_name = '" + Name + "', S_address = '" + Address + "', Y_id = '" + Running.Y_id + "', den = '" + Den + "', state_den = '" + state_den.getSelectedItem() + "'";
                        } else {
                            quere = "insert into suppliers values ('" + Id + "', '" + Name + "', '" + Address + "', '" + Running.Y_id + "', '" + Den + "', '" + state_den.getSelectedItem() + "')";
                        }
                        statement.execute(quere);
                    }
                } else if (state.getSelectedItem().equals("عميل")) {
                    if (flag_check) {
                        String quere = "update customers set C_den = '" + 0 + "', C_state_den = '" + "له" + "' where C_id = '" + Id + "'";
                        statement.execute(quere);
                    } else {
                        String quere = "";
                        if (Id.equals("1") && !Running.Y_id.equals("1")) {
                            quere = "insert into customers set C_name = '" + Name + "', C_address = '" + Address + "', Y_id = '" + Running.Y_id + "', C_den = '" + Den + "', C_state_den = '" + state_den.getSelectedItem() + "'";
                        } else {
                            quere = "insert into customers values ('" + Id + "', '" + Name + "', '" + Address + "', '" + Running.Y_id + "', '" + Den + "', '" + state_den.getSelectedItem() + "')";
                        }
                        statement.execute(quere);
                    }
                }
                new Suppliers_Customers().setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            String quere = "";
            if (Running.lock2.equals("0")) {
                if (state.getSelectedItem().equals("مورد")) {
                    quere = "update suppliers set S_name = '" + name.getText() + "', S_address = '" + address.getText() + "', den = '" + den.getText() + "',state_den = '" + state_den.getSelectedItem() + "' where S_id = '" + id.getText() + "'";
                } else if (state.getSelectedItem().equals("عميل")) {
                    quere = "update customers set C_name = '" + name.getText() + "', C_address = '" + address.getText() + "', C_den = '" + den.getText() + "',C_state_den = '" + state_den.getSelectedItem() + "' where C_id = '" + id.getText() + "'";
                }
                try {
                    statement.execute(quere);
                    new Suppliers_Customers().setVisible(true);
                    this.dispose();
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_NewActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        mouse_click = 1;
        select_row = jTable1.getSelectedRow();
        String search = jTable1.getValueAt(select_row, 0).toString();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getS_name().equals(search)) {
                select_row = i;
                break;
            }
        }
        id.setText(list1.get(select_row).getS_id());
        state.setSelectedIndex(0);
        name.setText(list1.get(select_row).getS_name());
        address.setText(list1.get(select_row).getS_address());
        den.setText(list1.get(select_row).getDen());
        state_den.setSelectedItem(list1.get(select_row).getState_den());
        count.setText(select_row + 1 + "   /  " + list1.size() + "");
        jTable1.clearSelection();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        String search = jTextField1.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField1KeyReleased

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if (mouse_click == 1) {
            if (select_row + 1 < list1.size()) {
                select_row++;
                id.setText(list1.get(select_row).getS_id());
                state.setSelectedIndex(0);
                name.setText(list1.get(select_row).getS_name());
                address.setText(list1.get(select_row).getS_address());
                den.setText(list1.get(select_row).getDen());
                state_den.setSelectedItem(list1.get(select_row).getState_den());
                count.setText(select_row + 1 + "   /  " + list1.size() + "");
            }
        } else if (mouse_click == 2) {
            if (select_row + 1 < list2.size()) {
                select_row++;
                id.setText(list2.get(select_row).getC_id());
                state.setSelectedIndex(1);
                name.setText(list2.get(select_row).getC_name());
                address.setText(list2.get(select_row).getC_address());
                den.setText(list2.get(select_row).getC_den());
                state_den.setSelectedItem(list2.get(select_row).getC_state_den());
                count.setText(select_row + 1 + "   /  " + list2.size() + "");
            }
        }
    }//GEN-LAST:event_nextActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        mouse_click = 2;
        select_row = jTable2.getSelectedRow();
        String search = jTable2.getValueAt(select_row, 0).toString();
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getC_name().equals(search)) {
                select_row = i;
                break;
            }
        }
        id.setText(list2.get(select_row).getC_id());
        state.setSelectedIndex(1);
        name.setText(list2.get(select_row).getC_name());
        address.setText(list2.get(select_row).getC_address());
        den.setText(list2.get(select_row).getC_den());
        state_den.setSelectedItem(list2.get(select_row).getC_state_den());
        count.setText(select_row + 1 + "   /  " + list2.size() + "");
        jTable2.clearSelection();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        DefaultTableModel table = (DefaultTableModel) jTable2.getModel();
        String search = jTextField3.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        jTable2.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField3KeyReleased

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        if (mouse_click == 1) {
            if (select_row - 1 >= 0) {
                select_row--;
                id.setText(list1.get(select_row).getS_id());
                state.setSelectedIndex(0);
                name.setText(list1.get(select_row).getS_name());
                address.setText(list1.get(select_row).getS_address());
                den.setText(list1.get(select_row).getDen());
                state_den.setSelectedItem(list1.get(select_row).getState_den());
                count.setText(select_row + 1 + "   /  " + list1.size() + "");
            }
        } else if (mouse_click == 2) {
            if (select_row - 1 >= 0) {
                select_row--;
                id.setText(list2.get(select_row).getC_id());
                state.setSelectedIndex(1);
                name.setText(list2.get(select_row).getC_name());
                address.setText(list2.get(select_row).getC_address());
                den.setText(list2.get(select_row).getC_den());
                state_den.setSelectedItem(list2.get(select_row).getC_state_den());
                count.setText(select_row + 1 + "   /  " + list2.size() + "");
            }
        }
    }//GEN-LAST:event_prevActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int x1 = JOptionPane.showConfirmDialog(this, "are you want to delete this data!");
        if (x1 == 0) {
            if (Running.lock2.equals("0")) {
                Security security = new Security();
                try {
                    connection = security.coneect();
                    statement = connection.createStatement();
                    String query = "";
                    if (mouse_click == 1) {
                        query = "delete from suppliers where S_id = '" + list1.get(select_row).getS_id() + "'";
                    } else if (mouse_click == 2) {
                        query = "delete from customers where C_id = '" + list2.get(select_row).getC_id() + "'";
                    }
                    statement.executeUpdate(query);
                    new Suppliers_Customers().setVisible(true);
                    this.dispose();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    try {
                        connection.close();
                        statement.close();
                    } catch (Exception e) {
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please, Open the lock bafore delete!");
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed
        if (Check.isSelected()) {
            flag_check = true;
        } else {
            flag_check = false;
        }
    }//GEN-LAST:event_CheckActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        jTable3.clearSelection();
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        jTable4.clearSelection();
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        stte = state.getSelectedItem().toString();
        person = name.getText().toString();
        new Bills().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateActionPerformed

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
            java.util.logging.Logger.getLogger(Suppliers_Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Suppliers_Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Suppliers_Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Suppliers_Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Suppliers_Customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Check;
    private javax.swing.JButton New;
    private javax.swing.JTextField address;
    private javax.swing.JLabel count;
    private javax.swing.JButton delete;
    private javax.swing.JTextField den;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton lock;
    private javax.swing.JTextField name;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JComboBox<String> state;
    private javax.swing.JComboBox<String> state_den;
    // End of variables declaration//GEN-END:variables
}
