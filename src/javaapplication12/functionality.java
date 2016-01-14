/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import Preprocess.Stemword;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import Hclustering.CompleteLinkageStrategy;


/**
 *
 * @author Administrator
 */
public class functionality {
//     

    HashMap<String, String> fun = new HashMap<String, String>();
    Stemword spw1 = new Stemword();
    Jaccard1_Fuction_Similarity jf = new Jaccard1_Fuction_Similarity();
    Jaccard_Description_similarity jd = new Jaccard_Description_similarity();
    double a = 0.5, b = 0.5;
    ArrayList<ArrayList<Double>> outerArrayList = new ArrayList<ArrayList<Double>>();
    ArrayList<String> productnm = new ArrayList<String>();

    public functionality(HashMap<String, String> mapx) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // System.out.println("Driver loaded");
            String url = "jdbc:mysql://localhost:3306/recommendedsystem";
            Connection con = DriverManager.getConnection(url, "root", "root");
            //System.out.println("Connection Created");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from mobile_products");
            while (rs.next()) {
                fun.put(rs.getString(1), rs.getString(3));

            }

            System.out.println("Product1                product 2");
            Set<String> keyset1 = fun.keySet();
            for (String keyset11 : keyset1) {

                String s1 = fun.get(keyset11);
                String s3 = mapx.get(keyset11);
                ArrayList<Double> iner = new ArrayList<Double>();
                Set<String> keyset12 = fun.keySet();
                for (String keyset121 : keyset12) {
                    String s2 = fun.get(keyset121);
                    String s4 = mapx.get(keyset121);
                    //System.out.print(keyset11+" \t "+keyset121+"\n");
                    double dis1 = jf.compute(s1, s2);
                    double dis12 = jd.compute(s3, s4);
                    double aax = (a * dis1 + b * dis12);

                    //System.out.println("Description Similarity="+dis12+"\nFunction Similarity="+dis1+"\nChar similarity="+(a*dis1+b*dis12)+"\n");
                    iner.add(aax);
                }
                outerArrayList.add(iner);
                productnm.add(keyset11);

            }
            //        if (MainFrame.jComboBox1.getSelectedItem().toString().equals("AverageLinkageStrategy")) {
//            cluster = alg.performClustering(dismatx1, names, new AverageLinkageStrategy());
//        } else if (MainFrame.jComboBox1.getSelectedItem().toString().equals("CompleteLinkageStrategy")) {
//            cluster = alg.performClustering(dismatx1, names, new CompleteLinkageStrategy());
//        } else if (MainFrame.jComboBox1.getSelectedItem().toString().equals("SingleLinkageStrategy")) {
//            cluster = alg.performClustering(dismatx1, names, new SingleLinkageStrategy());
//        } else if (MainFrame.jComboBox1.getSelectedItem().toString().equals("WeightedLinkageStrategy")) {
//            cluster = alg.performClustering(dismatx1, names, new WeightedLinkageStrategy());
//        }
            Hclustering.view.DendrogramPanel ddp = new Hclustering.view.DendrogramPanel();
            Object strategy = new CompleteLinkageStrategy();
//            Object strategy = new AverageLinkageStrategy();
//        Object strategy = new SingleLinkageStrategy();

            ddp.mainMeth(strategy, outerArrayList, productnm);
//            HierarchicalClstr d = new HierarchicalClstr();
//            d.main(productnm, outerArrayList);

            //boolean elementsLeft = true;
            // int c=0;
//          for (int i = 0; i < outerArrayList.size(); i++) {
//            int xx=outerArrayList.get(0).size();
//              for (int k = 0; k <xx; k++) {
//                  System.out.println(outerArrayList.get(k));
//                  
//              }
//          }
//          
        } catch (Exception e) {
        }
    }
}
