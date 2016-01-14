package Hclustering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vspace
 */
public class ShowTable {

    HashMap<Integer, ArrayList<ArrayList<String>>> map = new HashMap<Integer, ArrayList<ArrayList<String>>>();
//Hashtable<Integer, String> source = new Hashtable<Integer,String>();
//    HashMap<Integer, String>  map = new HashMap(source);
    DefaultTableModel dtm;
   // Vector<ReportInfo> rilist;

    public void TableReportInfo1(HashMap hm) {
        map = hm;

    }

    public DefaultTableModel printTable() {

        Vector header = new Vector();
        Vector rows = new Vector();

        Iterator<Integer> keySetIterator = map.keySet().iterator();

        while (keySetIterator.hasNext()) {
            Integer key = keySetIterator.next();
            //System.out.println("key: " + key + " value: " + map.get(key)); 
            Vector data = new Vector();
            data.add(key);
            data.add(map.get(key));
            // System.out.println(data);
            rows.add(data);
        }

        header.add("Cluster NO");
        header.add("Documents Of Cluster");
//       
        //for (ReportInfo ri : rilist) {
//            Vector data = new Vector();
//            data.add(key);
//            data.add("jf");
//    

       // }
        dtm = new DefaultTableModel(rows, header);
        return dtm;

    }

}
