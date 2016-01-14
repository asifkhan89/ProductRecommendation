/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class description {

    private static Object con;
    String s1[] = new String[100];
    String s2[] = new String[100];
    int i = 0, x = 0;
    double diss=0.0d;
    Jaccard_Description_similarity j=new Jaccard_Description_similarity();
    HashMap<String, String> map = new HashMap<String, String>();
    stopword1 stp=new stopword1();

    public description() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
           // System.out.println(" connection established");
            String url = "jdbc:mysql://localhost:3306/recommendedsystem";
            Connection con = DriverManager.getConnection(url, "root", "root");
           // System.out.println("conn built");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from mobile_products");

            while (rs.next()) {
                map.put(rs.getString(1), rs.getString(4));

            }
//                     Iterator iter = map.entrySet().iterator();
// 	             while (iter.hasNext()) 
//                     {
//			 Map.Entry mEntry = (Map.Entry) iter.next();
//        		 s1[i]=(String)(mEntry.getValue());
//                         Map.Entry mEntry1 = (Map.Entry)  iter.next();
//                         s2[i]=(String)(mEntry1.getValue());
//                         i++;
//                         x=i;
//                     }
            Set<String> keyset = map.keySet();
            for (String keyset1 : keyset) {
                String s1 = map.get(keyset1);
                Set<String> keyset2 = map.keySet();
                for (String keyset12 : keyset2) {
                    String s2 = map.get(keyset12);
                    //System.out.println(keyset1+" Description similarity  "+keyset12+" is  "+new Jaccard_Description_similarity().compute(s1, s2));
                   //diss=j.compute(s1, s2);
                    //System.out.println("dis="+diss);
                }
            }
             Set<String> keyset3 = map.keySet();
            for (String keyset113 : keyset3) {
                String xx = map.get(keyset113);
                String xx1=map.keySet().toString();
                stp.stopwordremover(xx1, xx);
            }
                /**}
             *
             * @return
             */

        } catch (ClassNotFoundException ex) {
            {

            }
            /**
             *
             * @return
             */
        }
      


    }
   
      
    public static void main(String[] args) throws SQLException {
        description d=new description();
        //functionality f=new functionality();
       
    
    }

}
