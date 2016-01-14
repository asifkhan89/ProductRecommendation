package databaseConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;
import javaapplication12.stopword1;

public class db {

    public db() {
        HashMap<String, String> map12 = new HashMap<String, String>();
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
                map12.put(rs.getString(1), rs.getString(3));
            }
            Set<String> keyset3 = map12.keySet();
            for (String keyset113 : keyset3) {
                String xx = map12.get(keyset113);
                String xx1 = keyset113;
                // System.out.println("call stop word");
                stp.stopwordremover(xx1, xx);
            }
        } catch (Exception e) {
        }
    }
}
