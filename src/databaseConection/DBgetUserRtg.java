/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author pc
 */
public class DBgetUserRtg {

//  public  HashMap<Integer, HashMap<String ,Double>> uidProrating = new HashMap<Integer, HashMap<String ,Double>>();
    public ConcurrentHashMap<String, ConcurrentHashMap<Integer, Double>> ProUIDrating = new ConcurrentHashMap<String, ConcurrentHashMap<Integer, Double>>();

    public DBgetUserRtg() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        // System.out.println(" connection established");
        String url = "jdbc:mysql://localhost:3306/product";
        Connection con = DriverManager.getConnection(url, "root", "root");
        // System.out.println("conn built");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from UserProRating");
        while (rs.next()) {
//                map12.put(rs.getString(1), rs.getString(4));
            int uid = Integer.parseInt(rs.getString(1));
            String productnm = rs.getString(2);
            double rating = Double.valueOf(rs.getString(3));

            System.out.println("user  " + uid + "   product nm " + productnm + " rating  " + rating);
            if (!ProUIDrating.containsKey(productnm)) {
                ProUIDrating.put(productnm, new ConcurrentHashMap<Integer, Double>());
            }
//			if (!userMovies.containsKey(userId)) {
//				userMovies.put(userId, new HashSet<Integer>());
//			}
//			
            ProUIDrating.get(productnm).put(uid, rating);
        }
        System.out.println(" ffffdf " + ProUIDrating);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBgetUserRtg d = new DBgetUserRtg();
    }
}
