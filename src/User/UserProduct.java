package User;

import guimain.MainFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class UserProduct extends javax.swing.JFrame {

    public UserProduct() throws SQLException, ClassNotFoundException {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        HashSet hash = new HashSet();
        uname.setText(User.jTextField_username.getText());

        Class.forName("com.mysql.jdbc.Driver");
        //System.out.println(" connection established");
        String url = "jdbc:mysql://localhost:3306/product";
        Connection con = DriverManager.getConnection(url, "root", "root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from UserProRating");
        while (rs.next()) {
            //int uid = Integer.parseInt(rs.getString(1));
            String productname = rs.getString(2);
            //double rating = Double.valueOf(rs.getString(3));
            //System.out.println("prodName "+productname);
            hash.add(productname);
        }
        for (Object hash1 : hash) {
            jComboBox_products.addItem(hash1);
        }
        con.close();
        //System.out.println("Connection closed");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uname = new javax.swing.JLabel();
        jComboBox_products = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UserProduct");
        setResizable(false);

        uname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        uname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uname.setText("USERNAME");

        jComboBox_products.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox_products.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jComboBox_products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_productsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(uname, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jComboBox_products, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox_products, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_productsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_productsActionPerformed
        String uname = User.jTextField_username.getText();
        //System.out.println(uname);
        String prod = jComboBox_products.getSelectedItem().toString();
        //System.out.println(prod);
        TableOperations tb = new TableOperations();
        tb.setValue(uname, prod);
        this.setVisible(false);
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        tb.decreementValue(uname, prod);
    }//GEN-LAST:event_jComboBox_productsActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UserProduct().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    System.out.println(ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox jComboBox_products;
    public static javax.swing.JLabel uname;
    // End of variables declaration//GEN-END:variables
}
