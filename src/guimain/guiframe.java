/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimain;

import databaseConection.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javaapplication12.*;

/**
 *
 * @author Administrator
 */
public class guiframe extends javax.swing.JFrame {

    /**
     * Creates new form guiframe
     */
    public guiframe() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));

        jButton1.setText("Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Stopword ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setText("Cluster");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
           // System.out.println(" connection established");
            String url = "jdbc:mysql://localhost:3306/recommendedsystem";
            Connection con = DriverManager.getConnection(url, "root", "root");
           // System.out.println("conn built");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from mobile_products");
      
            
             
           Vector v1=new Vector();
            while (rs.next()) {
                 
             Vector v = new Vector();
             String s = rs.getString(1);
             String s1=rs.getString(3);
             String s2=rs.getString(4);
              System.out.println(s);
                v.add(s);
                v.add(s1);
                v.add(s2);
                 v1.addElement(v);
                 
            }
           
    Vector columnNames = new Vector ();
    columnNames.addElement("Product Name");
    columnNames.addElement("Functionality");
    columnNames.addElement("Descriptionality");
      JTable table = new JTable(v1, columnNames);
      // table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        for (Object cName:columnNames) {
         //   table.getColumn(i).setMinWidth(50);
            table.getColumn((String) cName).setMinWidth(50);
        }
        
//   JTable table=new JTable(v1,columnNames);
       JScrollPane jp = new JScrollPane(table);
        jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jp.setVisible(true);
        table.setVisible(true);
        //  jPanel2.setLayout(null);
//     if(jPanel2.getComponents().length >0)
//        jPanel2.removeAll();
        
        
        jPanel1.add(jp);
        
        jPanel1.setSize(400,500);
        jPanel1.updateUI();
        jp.updateUI();
        update(this.getGraphics());
        jPanel1.setVisible(true);
            
        }catch(Exception e1){}
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            MainFile m=new MainFile();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(guiframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(guiframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    String remove="";
    String str="";
    Vector vs=new Vector();
        db d=new db();
        stopword1 stp=new stopword1();
        HashMap<String,String> mp=new HashMap<String,String>();
        mp=stp.stp();
         Set<String> keyset = mp.keySet();
        for (String keyset1 : keyset) {
            remove=mp.get(keyset1);
            str=keyset1;
            Vector vx=new Vector();
            vx.add(str);
            vx.add(remove);
            vs.addElement(vx);        
//System.out.println("remove="+remove+"str="+str);
            }
        
         //sframe1 f11=new frame1(vs); 
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(guiframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
