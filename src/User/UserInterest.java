package User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserInterest extends TableOperations {

    LinkedHashMap<String, Double> prodWeight = new LinkedHashMap<>();
    LinkedHashMap<String, Double> prodWeightUpdated = new LinkedHashMap<>();
    public static StringBuilder sb = new StringBuilder();

    public ArrayList getRowVal(String user, String val) {
        ArrayList<Integer> sessionVal = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt;
            stmt = con.createStatement();
            int iVal = getColCount(user);
            int value;
            String q = "SELECT * FROM " + user + " WHERE pname='" + val + "'";
            ResultSet rs = stmt.executeQuery(q);

            while (rs.next()) {
                for (int i = 1; i < iVal; i++) {
                    value = rs.getInt("session_" + i);
                    if (value == 0) {
                    } else {
                        sessionVal.add(value);
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return sessionVal;
    }

    public void calc(String user, String val) {

        ArrayList<Integer> list = new ArrayList<>();
        list = getRowVal(user, val);
        int size = list.size();
        double constant = 70;
        double res = 0.0;

        if (size >= 2) {
            System.out.println();
            for (int i = size - 1; i >= 0; i--) {
                if (i > 0) {
                    double val1 = list.get(i);
                    double val2 = list.get(i - 1);
                    System.out.println("const: " + constant);
                    System.out.println("val1 " + val1);
                    System.out.println("val2 " + val2);
                    double res1 = (constant - val1);
                    double res2 = (val1 - val2);
                    if (res1 == 0) {
                        res1 = 1;
                    }
                    if (res2 == 0) {
                        res2 = 1;
                    }
                    double temp = (double) Math.abs(res1 / res2);
                    res += Math.pow(temp, -0.125);
                    constant = val1;
                    System.out.println("val3 " + res);
                }
            }
            System.out.println(val + "\n" + res);
            prodWeight.put(val, res);
        }
    }

    public void passVal(String user) {
        HashSet<String> set = new HashSet<>();
        try {
            Connection con = getConnection();
            Statement stmt;
            stmt = con.createStatement();
            String q = "SELECT * FROM " + user;
            ResultSet rs = stmt.executeQuery(q);

            while (rs.next()) {
                String value = rs.getString("pname");
                set.add(value);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        for (String set1 : set) {
            calc(user, set1);
        }

        CompareValue sortedRating = new CompareValue(prodWeight);
        TreeMap<String, Double> sortedRate = new TreeMap<>(sortedRating);
        sortedRate.putAll(prodWeight);

        for (Map.Entry<String, Double> entrySet : sortedRate.entrySet()) {
            String key = entrySet.getKey();
            Double value = entrySet.getValue();
            System.out.println("Product: " + key);
            System.out.println("weight: " + value);
            prodWeightUpdated.put(key, value);
            //sb.append("\t").append(key).append("\t\t").append(value).append("\n");
        }
    }

    public LinkedHashMap getMap() {
        return prodWeightUpdated;
    }

//    public static void main(String[] args) {
//        UserInterest c = new UserInterest();
//        c.passVal("asif");
//    }
}

class CompareValue implements Comparator<String> {

    Map<String, Double> base;

    public CompareValue(Map<String, Double> base) {
        this.base = base;
    }

    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
