
package javaapplication12;

import java.util.ArrayList;
import java.util.List;

public class Jaccard1_Fuction_Similarity {
    public double compute(String s1, String s2) {
       
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
       
        String[] arrs1 = s1.split(",");
        String[] arrs2 = s2.split(",");
        for (int i = 0; i < arrs1.length; i++) {
            String temp =arrs1[i].trim();
            a.add(temp);
        }
        
        for (int i = 0; i < arrs2.length; i++) {
            String temp =arrs2[i].trim();
            b.add(temp);
        }
        
        a.retainAll(b);
        b.retainAll(a);
        
        List<String> a1 = new ArrayList<>();
        List<String> b1 = new ArrayList<>();
        
        for (int i = 0; i < arrs1.length; i++) {
            String temp =arrs1[i].trim();
            a1.add(temp);
        }
        
        for (int i = 0; i < arrs2.length; i++) {
            String temp =arrs2[i].trim();
            b1.add(temp);
        }
        
        a1.addAll(b1);
        double dd = (double) (a1.size() - b.size());
        double d = (double) b.size() / dd;
        return 1-d;
    }
}
