
package guimain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import ClusteringAlgorithms.HierarchicalClstr;
import javax.swing.table.DefaultTableModel;

public class FileTable {

    public DefaultTableModel printTable() {
        DefaultTableModel dtm;
        Vector header = new Vector();
        Vector rows = new Vector();
        HierarchicalClstr d = new HierarchicalClstr();
//        HashMap<String, ArrayList<String>> clusterUsers = d.clusterUsers;
         HashMap<Integer, ArrayList<String>> clusterUsers = MainFrame.ClusteredProduct ;
        Integer count = null;

        for (Map.Entry<Integer, ArrayList<String>> entrySet : clusterUsers.entrySet()) {
            Integer key = entrySet.getKey();
            ArrayList<String> value = entrySet.getValue();
            count = key;

            Vector data = new Vector();
            data.add(key);
            data.add(value);

            rows.add(data);
        }
        header.add("Cluster_name");
        header.add("Products");

        dtm = new DefaultTableModel(rows, header);
        return dtm;

    }
}
