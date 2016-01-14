/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preprocess;

import java.sql.Connection;
//import DBC.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;
import javaapplication12.stopword1;

/**
 *
 * @author user
 */
public class Stemword {

    Porter po = new Porter();
   stopword1 spw=new stopword1();
   public  HashMap<String, String> PronmStemDes = new HashMap<String, String>();

//    public HashMap<String, String> readdata() throws ClassNotFoundException, SQLException {
//    HashMap<String, String> map = new HashMap<String, String>();
//        Statement stmt = null;
////        System.out.println(" :: "+po.stripAffixes(""));
//        DatabaseConnection dbc = new DatabaseConnection();
//
//        Connection con = dbc.Connection();
//        stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("Select product_name,Description from mobile_products");
//
//        while (rs.next()) {
////            System.out.println("\nproduct nm : " + rs.getString("product_name"));
////            System.out.println("Description : " + rs.getString("Description"));
//            map.put(rs.getString("product_name"), rs.getString("Description"));
//        }
//        return map;
//    }

     public HashMap<String, String> Stemming() throws ClassNotFoundException, SQLException {
    HashMap<String, String> map = spw.stp();

//        Set<String> keys =map.keySet();
//        for (String key : keys) {
//     System.out.println("remove====" + map.get(key));
//        }
        Set<String> keyset = map.keySet();
        System.out.println(" " + keyset.size());
        for (String key : keyset) {
            System.out.println(" \n\nproduct nm  " + key + "\tDiscription " + map.get(key));
            String Discription = map.get(key);
            String[] wordsinDis = Discription.split(" ");
            String creatline = new String();

            for (int i = 0; i < wordsinDis.length; i++) {
                String word = po.stripAffixes(wordsinDis[i]);
                System.out.println("oreignal word   " + wordsinDis[i] + " :: " + word);
                //creatline=" ";
                creatline = creatline.concat(word + " ");

            }
            PronmStemDes.put(key, creatline);
            System.out.println("concating  :" + creatline);
        }
        System.out.println(" \n\n ######### in product name and after Steamming Discription ########### ");
        Set<String> Keyset1 = PronmStemDes.keySet();
        System.out.println(" " + Keyset1.size());
        for (String key : Keyset1) {

            System.out.println(" \n\nproduct nm :: " + key + "\tDiscription :: " + PronmStemDes.get(key));
        }
      
       
        return PronmStemDes;
     
    }
}
