package javaapplication12;

import Preprocess.Stemword;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;

public class MainFile {

    public MainFile() throws ClassNotFoundException, SQLException {
        HashMap<String, String> map1 = new HashMap<String, String>();
        stopword1 stp = new stopword1();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // System.out.println(" connection established");
            String url = "jdbc:mysql://localhost:3306/recommendedsystem";
            Connection con = DriverManager.getConnection(url, "root", "root");
            // System.out.println("conn built");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from mobile_products");
            while (rs.next()) {
                map1.put(rs.getString(1), rs.getString(4));
            }
            Set<String> keyset3 = map1.keySet();
            for (String keyset113 : keyset3) {
                String xx = map1.get(keyset113);
                String xx1 = keyset113;
                // System.out.println("call stop word");
                stp.stopwordremover(xx1, xx);
            }
        } catch (Exception e) {
        }
        Stemword sw = new Stemword();
        map1 = sw.Stemming();
        functionality f = new functionality(map1);
    }
}
