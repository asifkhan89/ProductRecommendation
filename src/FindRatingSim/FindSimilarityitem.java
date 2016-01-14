package FindRatingSim;

//import Matrix.Matrix1;
import databaseConection.DBgetUserRtg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FindSimilarityitem {

//    ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Double>> movieUserRatings = new ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Double>>();
    HashMap<String, Double> uidAvg = new HashMap<>();
    ConcurrentHashMap<String, ConcurrentHashMap<Integer, Double>> productUserRatings = new ConcurrentHashMap<String, ConcurrentHashMap<Integer, Double>>();

    public void getval() throws Exception {
//        Matrix1 matrix = new Matrix1();
        DBgetUserRtg du = new DBgetUserRtg();
        productUserRatings = du.ProUIDrating;
        Set<String> keys = productUserRatings.keySet();
//        System.out.println(keys.size());
//        System.out.println(keys);
        for (String key : keys) {
            System.out.println("\n in sim movie ID " + key);
            ConcurrentHashMap hm = new ConcurrentHashMap();
            hm = productUserRatings.get(key);
            Set<Integer> key1 = hm.keySet();
            for (Integer key2 : key1) {
                System.out.println("\nuser's and rating " + key2 + "  " + hm.get(key2));
            }
        }
    }

    public void findAvgrating() {
        Set<String> keys = productUserRatings.keySet();
        for (String key : keys) {
            System.out.println("\nmovie ID " + key);
            ConcurrentHashMap hm = new ConcurrentHashMap();
            hm = productUserRatings.get(key);
            Set<Integer> key1 = hm.keySet();
            double add = 0;
            double avg = 0;
            int count = 0;
            for (Integer key2 : key1) {
//                System.out.println("\nuser's and rating " + key2 + "  " + hm.get(key2));
                add = add + (double) hm.get(key2);
                count++;
            }
//            System.out.println("addition" + add);
            avg = add / count;
            System.out.println("avg=" + avg);
            uidAvg.put(key, avg);
        }
    }

    public double similarity(String i, String j) {
        ConcurrentHashMap hmI = productUserRatings.get(i);
        ConcurrentHashMap hmJ = productUserRatings.get(j);
        System.out.println("## " + hmI);
        System.out.println("## " + hmJ);
        ArrayList getcommanuser = new ArrayList();
        Set<Integer> kaySetI = hmI.keySet();
        Set<Integer> kaySetj = hmJ.keySet();
        for (Integer kayj1 : kaySetj) {
            if (kaySetI.contains(kayj1)) {
//                System.out.println("comman usr " + kayj1);
                getcommanuser.add(kayj1);
            }
        }
        double ri = uidAvg.get(i);
        double rj = uidAvg.get(j);
//        System.out.println("avgi  " + ri + "  and avgj  " + rj);
        double divdnd = 0, ai = 0, bj = 0;
        double sim = 0;
        for (int k = 0; k < getcommanuser.size(); k++) {
            double rui = (double) hmI.get(getcommanuser.get(k));
            double ruj = (double) hmJ.get(getcommanuser.get(k));
            divdnd = divdnd + (rui - ri) * (ruj - rj);
            ai = ai + Math.pow((rui - ri), 2);
            bj = bj + Math.pow((ruj - rj), 2);
            System.out.println(" divdnd " + divdnd);
//            System.out.println("ai "+ai +" bj  "+bj);
        }
        sim = divdnd / (Math.sqrt(ai) * Math.sqrt(bj));
        System.out.println("Similarity :" + sim);
        double dis = 1 - sim;
        System.out.println("dis  :" + dis);
        if (Double.isNaN(dis)) {
            dis = 0.0;
        }
        return sim;
    }

    public static void main(String[] args) throws Exception {
        FindSimilarityitem fs = new FindSimilarityitem();
        fs.getval();
        fs.findAvgrating();
        fs.similarity("Nokia 215 Dual sim", "Sony Xperia Z3v");
    }
}
