/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimain;

import Hclustering.Cluster;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import javaapplication12.MainFile;
import Preprocess.Porter;
import User.ProductSimilarity;
import User.UserInterest;
import User.UserProduct;
import databaseConection.db;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javaapplication12.stopword1;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public static HashMap<Integer, ArrayList<String>> ClusteredProduct = new HashMap<Integer, ArrayList<String>>();
    HashSet<String> usrIntProd = new HashSet<>();
    HashSet<String> simiProd = new HashSet<>();
    public MainFrame() {
        initComponents();
        tableUserInterest.setFont(new Font("Serif", Font.PLAIN, 18));
        tableUserInterest.getTableHeader().setFont(new Font("Serif", Font.PLAIN, 18));
        tableSimilarity.setFont(new Font("Serif", Font.PLAIN, 18));
        tableSimilarity.getTableHeader().setFont(new Font("Serif", Font.PLAIN, 18));
        jcltrTable1.setFont(new Font("Serif", Font.PLAIN, 18));
        jcltrTable1.getTableHeader().setFont(new Font("Serif", Font.PLAIN, 18));

        this.setExtendedState(MAXIMIZED_BOTH);
        usrname.setText(UserProduct.uname.getText());
        String prodnm = UserProduct.jComboBox_products.getSelectedItem().toString();
        prdname.setText(prodnm);
        jComboBox1.addItem("AverageLinkageStrategy");
        jComboBox1.addItem("CompleteLinkageStrategy");
        jComboBox1.addItem("SingleLinkageStrategy");
        jComboBox1.addItem("WeightedLinkageStrategy");

        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(" connection established");
            String url = "jdbc:mysql://localhost:3306/recommendedsystem";
            con = DriverManager.getConnection(url, "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from mobile_products where product_name='" + prodnm + "'");
            String features = new String();

            while (rs.next()) {
                features = rs.getString(2);
            }
            System.out.println(features);
            String[] arr = features.split(",");
            System.out.println("length " + arr.length);
            l1.setText(arr[0]);
            l2.setText(arr[1]);
            l3.setText(arr[2]);
            l4.setText(arr[3]);
            l5.setText(arr[4]);
            l6.setText(arr[5]);
            l7.setText(arr[6]);
//            l8.setText(arr[7]);
//                l9.setText(rs.getString(10));
//                l10.setText(rs.getString(11));
//                l11.setText(rs.getString(12));
//                l12.setText(rs.getString(13));
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jDisPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jstopStemPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jcltrTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaCompleteLink = new javax.swing.JTextArea();
        jEnterlevTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel18 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableUserInterest = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableSimilarity = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnDisplay = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        prdname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usrname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel5.setLayout(new java.awt.BorderLayout());

        jDisPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDisPanel6.setLayout(new java.awt.BorderLayout());
        jPanel5.add(jDisPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setBorder(new javax.swing.border.MatteBorder(null));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Display");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 623, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jPanel5.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Products", jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jstopStemPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jstopStemPanel9.setLayout(new java.awt.BorderLayout());
        jPanel6.add(jstopStemPanel9, java.awt.BorderLayout.CENTER);

        jPanel10.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setText("Stopword     ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 82, 17, 0);
        jPanel10.add(jButton6, gridBagConstraints);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setText("Steming word");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 26, 17, 117);
        jPanel10.add(jButton7, gridBagConstraints);

        jPanel6.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel11, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Preprocessing", jPanel6);

        jPanel15.setLayout(new java.awt.BorderLayout());

        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jcltrTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcltrTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jcltrTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jcltrTable1);
        if (jcltrTable1.getColumnModel().getColumnCount() > 0) {
            jcltrTable1.getColumnModel().getColumn(0).setMinWidth(30);
            jcltrTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jcltrTable1.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jTextAreaCompleteLink.setColumns(20);
        jTextAreaCompleteLink.setRows(5);
        jScrollPane5.setViewportView(jTextAreaCompleteLink);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Enter Level: ");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setText("Submit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
            .addComponent(jScrollPane5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jEnterlevTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addGap(164, 164, 164))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jEnterlevTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("Clustering");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 306, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel17, java.awt.BorderLayout.PAGE_START);

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel18, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Clustering", jPanel15);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Display User Interest for Products");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.PAGE_START);

        tableUserInterest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableUserInterest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableUserInterest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Weight"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUserInterest.setRowHeight(25);
        jScrollPane3.setViewportView(tableUserInterest);
        if (tableUserInterest.getColumnModel().getColumnCount() > 0) {
            tableUserInterest.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("User Interest", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel12, java.awt.BorderLayout.CENTER);

        tableSimilarity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Similarity"
            }
        ));
        tableSimilarity.setRowHeight(20);
        jScrollPane4.setViewportView(tableSimilarity);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Display");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addContainerGap(404, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                    .addGap(0, 23, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Similarity", jPanel2);

        jPanel4.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel14, java.awt.BorderLayout.CENTER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        btnDisplay.setText("Display");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(btnDisplay)
                .addGap(0, 694, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(btnDisplay)
                .addGap(0, 442, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                    .addGap(0, 30, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.add(jPanel19, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Reccommendation", jPanel4);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Product Name: ");

        prdname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prdname.setText("l2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("User Name:");

        usrname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usrname.setText("l1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Features:");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Size :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Pixel Density:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("O.S :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Internal Memory:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("RAM :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Primary Camera :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Battery Life: ");

        l1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l1.setText("l1");

        l2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l2.setText("l1");

        l3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l3.setText("l1");

        l4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l4.setText("l1");

        l5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l5.setText("l1");

        l6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l6.setText("l1");

        l7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l7.setText("l1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(prdname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(usrname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(28, 28, 28)
                        .addComponent(btnBack))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(l7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(249, 249, 249))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(usrname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(prdname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(l1)
                            .addComponent(l2)
                            .addComponent(l3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l6)
                    .addComponent(l7)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(jLabel12)
                    .addComponent(l5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l4)
                    .addComponent(jLabel11))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jTextAreaCompleteLink.setText("");
        try {
            // TODO add your handling code here:
            MainFile m = new MainFile();
//            FileTable ft = new FileTable();
//            jcltrTable1.setModel(ft.printTable());
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        
        HashMap<Integer, List<List<Hclustering.Cluster>>> levalsCluster = Hclustering.DefaultClusteringAlgorithm.LevalWiseClusters;
        Set<Integer> keySet = levalsCluster.keySet();
        for (Integer lvlNo : keySet) {
            System.out.println("\n...........Level............." + lvlNo + "\n\n");
            jTextAreaCompleteLink.append("\n\n...........Level............." + lvlNo + "\n\n");
            List<List<Hclustering.Cluster>> get = levalsCluster.get(lvlNo);
            int i = 0;
            for (List<Hclustering.Cluster> inr : get) {
                jTextAreaCompleteLink.append("\tCluster " + i);
                for (Hclustering.Cluster clst : inr) {
                    jTextAreaCompleteLink.append("\t " + clst.getName());
                    System.out.print("\t " + clst.getName());
//                    list.add(clst.getName());
                }
                i++;
                jTextAreaCompleteLink.append("\n");
                System.out.println("");
//                  ClusteredFileName.add(list);
            }

        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        db d = new db();
        Porter po = new Porter();
        stopword1 stp = new stopword1();
        Vector vs = new Vector();
        HashMap<String, String> mp1 = new HashMap<String, String>();
        mp1 = stp.stp();
        Set<String> keyset = mp1.keySet();
        for (String key : keyset) {
            Vector vx = new Vector();
            vx.add(key);
            //System.out.println(" \n\nproduct nm  " + key + "\tDiscription " + map.get(key));
            String Discription = mp1.get(key);
            String[] wordsinDis = Discription.split(" ");
            String creatline = new String();

            for (int i = 0; i < wordsinDis.length; i++) {
                String word = po.stripAffixes(wordsinDis[i]);
                System.out.println("oreignal word   " + wordsinDis[i] + " :: " + word);
                //creatline=" ";

                creatline = creatline.concat(word + " ");

            }
            vx.add(creatline);
            vs.addElement(vx);
        }
        Vector columnNames = new Vector();
        columnNames.addElement("Product Name");

        columnNames.addElement("Descriptionality");
        JTable table = new JTable(vs, columnNames);

        for (Object cName : columnNames) {
            table.getColumn((String) cName).setMinWidth(50);
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jp.setVisible(true);
        table.setVisible(true);
        table.setFont(new Font("Serif", Font.PLAIN, 18));
        table.getTableHeader().setFont(new Font("Serif", Font.PLAIN, 18));
table.setRowHeight(20);
        jstopStemPanel9.removeAll();
        jstopStemPanel9.updateUI();

        jstopStemPanel9.add(jp);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String remove = "";
        String str = "";
        Vector vs = new Vector();
        db d = new db();
        stopword1 stp = new stopword1();
        HashMap<String, String> mp = new HashMap<String, String>();
        mp = stp.stp();
        Set<String> keyset = mp.keySet();
        for (String keyset1 : keyset) {
            remove = mp.get(keyset1);
            str = keyset1;
            Vector vx = new Vector();
            vx.add(str);
            vx.add(remove);
            vs.addElement(vx);
            //System.out.println("remove="+remove+"str="+str);
        }
        Vector columnNames = new Vector();
        columnNames.addElement("Product Name");

        columnNames.addElement("Descriptionality");
        JTable table = new JTable(vs, columnNames);

        for (Object cName : columnNames) {
            table.getColumn((String) cName).setMinWidth(50);
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jp.setVisible(true);
        table.setVisible(true);
        table.setFont(new Font("Serif", Font.PLAIN, 18));
        table.getTableHeader().setFont(new Font("Serif", Font.PLAIN, 18));
table.setRowHeight(20);
        //  jPanel2.setLayout(null);
        //     if(jPanel2.getComponents().length >0)
        //        jPanel2.removeAll();
        jstopStemPanel9.add(jp);
        jstopStemPanel9.setSize(400, 500);
        jp.updateUI();
        update(this.getGraphics());
        jstopStemPanel9.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // System.out.println(" connection established");
            String url = "jdbc:mysql://localhost:3306/recommendedsystem";
            Connection con = DriverManager.getConnection(url, "root", "root");
            // System.out.println("conn built");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from mobile_products");

            Vector v1 = new Vector();
            while (rs.next()) {

                Vector v = new Vector();
                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
                System.out.println(s);
                v.add(s);
                v.add(s1);
                v.add(s2);
                v1.addElement(v);

            }

            Vector columnNames = new Vector();
            columnNames.addElement("Product Name");
            columnNames.addElement("Functionality");
            columnNames.addElement("Descriptionality");
            JTable table = new JTable(v1, columnNames);
            // table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for (Object cName : columnNames) {
                //   table.getColumn(i).setMinWidth(50);
                table.getColumn((String) cName).setMinWidth(50);
            }

            //   JTable table=new JTable(v1,columnNames);
            JScrollPane jp = new JScrollPane(table);
            jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            jp.setVisible(true);
            table.setVisible(true);
            table.setFont(new Font("Serif", Font.PLAIN, 18));
            table.getTableHeader().setFont(new Font("Serif", Font.PLAIN, 18));
            table.setRowHeight(20);
            //  jPanel2.setLayout(null);
            //     if(jPanel2.getComponents().length >0)
            //        jPanel2.removeAll();
            jDisPanel6.add(jp);

            jDisPanel6.setSize(400, 500);
            jDisPanel6.updateUI();
            jp.updateUI();
            update(this.getGraphics());
            jDisPanel6.setVisible(true);

        } catch (Exception e1) {
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        UserProduct up;
        try {
            up = new UserProduct();
            up.setVisible(true);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UserInterest c = new UserInterest();
        String uname = usrname.getText();
        c.passVal(uname);
        DefaultTableModel model = (DefaultTableModel) tableUserInterest.getModel();
        model.setRowCount(0);
        LinkedHashMap<String, Double> map = c.getMap();
//        System.out.println("map" + map);
        for (Map.Entry<String, Double> entrySet : map.entrySet()) {
            String key = entrySet.getKey();
            Double value = entrySet.getValue();
            model.addRow(new Object[]{key, value});
            usrIntProd.add(key);
        }
        //txtUserInterest.append(UserInterest.sb.toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ProductSimilarity ps = new ProductSimilarity();
        ps.getSimilarity(prdname.getText());
        DefaultTableModel model = (DefaultTableModel) tableSimilarity.getModel();
        model.setRowCount(0);
        LinkedHashMap<String, Double> map = ps.getMap();
        TreeMap<String, Double> sorted = new TreeMap<>();
        sorted.putAll(map);
        for (Map.Entry<String, Double> entrySet : sorted.entrySet()) {
            String key = entrySet.getKey();
            Double value = entrySet.getValue();
            model.addRow(new Object[]{key, value});
            simiProd.add(key);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int levelno = Integer.parseInt(jEnterlevTextField1.getText());
//        jSelectlevTextArea1.setText("");
        HashMap<Integer, List<List<Hclustering.Cluster>>> levalsCluster = Hclustering.DefaultClusteringAlgorithm.LevalWiseClusters;
        Set<Integer> keySet = levalsCluster.keySet();

        for (Integer lvlNo : keySet) {
            if (lvlNo == levelno) {
                System.out.println("\n........Selected Level............." + lvlNo + "\n\n");
//                jSelectlevTextArea1.append("\n\n.........Selected Level............." + lvlNo + "\n\n");
                List<List<Hclustering.Cluster>> get = levalsCluster.get(lvlNo);
                int i = 0;
                for (List<Hclustering.Cluster> inr : get) {
//                    jSelectlevTextArea1.append("\tCluster " + i);
                    ArrayList filenm2 = new ArrayList();
//                    ArrayList<ArrayList<String>> filenm = new ArrayList<ArrayList<String>>();
                    for (Hclustering.Cluster clst : inr) {
//                        jSelectlevTextArea1.append("\t " + clst.getName());
                        System.out.print("\t " + clst.getName());
                        filenm2.add(clst.getName());
//                   
                    }
//                    filenm.add(filenm2);
                    ClusteredProduct.put(i, filenm2);
                    i++;
//                    jSelectlevTextArea1.append("\n");
                    System.out.println("");
//                 
                }
            }
        }
//        ArrayList<ArrayList<String>> list = new ArrayList<>();
//        for (Map.Entry<Integer, ArrayList<ArrayList<String>>> entrySet : ClustrTextfilsHierachl.entrySet()) {
//            Integer key = entrySet.getKey();
//            ArrayList<ArrayList<String>> value = entrySet.getValue();
//            if(jEnterlevTextField1.getText().endsWith(key.toString())){
//                list.add(value);
//            }
//        }

        FileTable ft = new FileTable();
        jcltrTable1.setModel(ft.printTable());

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        jTextArea1.setText("");
        jTextArea1.append("---------------<< Reccommended Products >>---------------\n\n");
        for (String usrIntProd1 : usrIntProd) {
            for (String simiProd1 : simiProd) {
                if(usrIntProd1.equalsIgnoreCase(simiProd1)){
                    System.out.println("prod "+simiProd1);
                    jTextArea1.append("\t\t>>  "+simiProd1+"\n");
                }
            }
        }
    }//GEN-LAST:event_btnDisplayActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mf = new MainFrame();

                mf.setVisible(true);
                mf.setExtendedState(MAXIMIZED_BOTH);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public static javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jDisPanel6;
    private javax.swing.JTextField jEnterlevTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaCompleteLink;
    private javax.swing.JTable jcltrTable1;
    private javax.swing.JPanel jstopStemPanel9;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel prdname;
    private javax.swing.JTable tableSimilarity;
    private javax.swing.JTable tableUserInterest;
    private javax.swing.JLabel usrname;
    // End of variables declaration//GEN-END:variables
}
