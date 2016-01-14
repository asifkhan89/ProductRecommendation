/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimain;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Administrator
 */
public class gui extends JFrame implements ActionListener {

    JFrame frame;
    JPanel p1;
    JPanel p2;
    GridLayout g1, g2;
    FlowLayout f1;
    JButton b1, b2, b3;
    JTable table;
    Vector v1;
    JScrollPane s1;

    public gui() {
        frame = new JFrame("Similarity");
        p1 = new JPanel();
        p2 = new JPanel();
        b1 = new JButton("Display");
        b2 = new JButton("Stopword remover");
        b3 = new JButton("Cluster");
        f1 = new FlowLayout();
        g1 = new GridLayout(2, 1);

        frame.setLayout(g1);
        frame.add(p1);
        frame.add(p2);
        p1.setLayout(f1);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        gui g = new gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // System.out.println(" connection established");
            String url = "jdbc:mysql://localhost:3306/recommendedsystem";
            Connection con = DriverManager.getConnection(url, "root", "root");
            // System.out.println("conn built");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from mobile_products");

            v1 = new Vector();
            while (rs.next()) {

                Vector v = new Vector();
                String s = rs.getString(1);
                String s1 = rs.getString(3);
                String s2 = rs.getString(4);
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
            table = new JTable(v1, columnNames);
            s1 = new JScrollPane(table);
            p2.add(s1);

        } catch (Exception e1) {
        }
    }
}
