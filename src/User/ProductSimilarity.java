package User;

import ClusteringAlgorithms.HierarchicalClstr;
import FindRatingSim.FindSimilarityitem;
import guimain.MainFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductSimilarity {

    LinkedHashMap<String, Double> map = new LinkedHashMap<>();
    LinkedHashMap<String, Double> mapUpdated = new LinkedHashMap<>();

    public void getSimilarity(String prod) {
        FindSimilarityitem fs = new FindSimilarityitem();
        try {
            HierarchicalClstr d = new HierarchicalClstr();
            //MainFile m = new MainFile();
            HashSet<String> products = new HashSet<>();
            HashMap<Integer, ArrayList<String>> clusterUsers = MainFrame.ClusteredProduct;
            HashMap<Integer, ArrayList<String>> clustProd = new HashMap<>();
            for (Map.Entry<Integer, ArrayList<String>> entrySet : clusterUsers.entrySet()) {
                Integer key = entrySet.getKey();
                ArrayList<String> value = entrySet.getValue();
                if (value.contains(prod)) {
                    clustProd.put(key, value);
                }
            }

            for (Map.Entry<Integer, ArrayList<String>> entrySet : clustProd.entrySet()) {
                Integer key = entrySet.getKey();
                ArrayList<String> value = entrySet.getValue();
                System.out.println("selected cluster: cluster" + key);
                System.out.println("products: " + value);
                products.addAll(value);
            }

            fs.getval();
            fs.findAvgrating();
            for (String product : products) {
                if (product.equals(prod)) {

                } else {
                    double simi = fs.similarity(prod, product);
                    map.put(product, simi);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        TreeMap<String, Double> sortedRate = new TreeMap<>();
        sortedRate.putAll(map);
        for (Map.Entry<String, Double> entrySet : sortedRate.entrySet()) {
            String key = entrySet.getKey();
            Double value = entrySet.getValue();
            System.out.println("key " + key);
            System.out.println("value " + value);
            mapUpdated.put(key, value);
        }

    }

    public LinkedHashMap<String, Double> getMap() {
        return mapUpdated;
    }

//    public static void main(String[] args) {
//        ProductSimilarity ps = new ProductSimilarity();
//        ps.getSimilarity("Nokia 215 Dual sim");
//    }
}
