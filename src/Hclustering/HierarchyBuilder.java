package Hclustering;

import static Hclustering.DefaultClusteringAlgorithm.LevalWiseClusters;
import static Hclustering.DefaultClusteringAlgorithm.OriginalCluster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class HierarchyBuilder {

    private DistanceMap distances;
    private List<Cluster> clusters;

    HierarchyBuilder() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DistanceMap getDistances() {
        return distances;
    }

    public List<Cluster> getClusters() {
        return clusters;
    }

    public HierarchyBuilder(List<Cluster> clusters, DistanceMap distances) {
        this.clusters = clusters;
        this.distances = distances;
    }

    //List<List<Cluster>> LevalWiseClusters = new ArrayList<>();
    List<List<Cluster>> GeneratedClusters = new ArrayList<>();
    public static int levelcounter = 0;
    public void agglomerate(LinkageStrategy linkageStrategy) {
        int kj = 0;

        ClusterPair minDistLink = distances.removeFirst();
        if (minDistLink != null) {
            System.out.println("levelcounter " + levelcounter);

            clusters.remove(minDistLink.getrCluster());
            clusters.remove(minDistLink.getlCluster());

            Cluster oldClusterL = minDistLink.getlCluster();
            Cluster oldClusterR = minDistLink.getrCluster();
            Cluster newCluster = minDistLink.agglomerate(null);

            for (Cluster iClust : clusters) {
                ClusterPair link1 = findByClusters(iClust, oldClusterL);
                ClusterPair link2 = findByClusters(iClust, oldClusterR);
                ClusterPair newLinkage = new ClusterPair();
                newLinkage.setlCluster(iClust);
                // System.out.println("\niClust."+iClust.getName());
                newLinkage.setrCluster(newCluster);
                Collection<Distance> distanceValues = new ArrayList<Distance>();

                if (link1 != null) {
                    Double distVal = link1.getLinkageDistance();
                    Double weightVal = link1.getOtherCluster(iClust).getWeightValue();
                    // System.out.println("");
                    distanceValues.add(new Distance(distVal, weightVal));
                    // System.out.println("link1 :" + link1.toString() + " weight" + weightVal);
                    distances.remove(link1);
                }
                if (link2 != null) {
                    Double distVal = link2.getLinkageDistance();
                    Double weightVal = link2.getOtherCluster(iClust).getWeightValue();
                    distanceValues.add(new Distance(distVal, weightVal));
                    // System.out.println("link2 :" + link2.toString() + " weight" + weightVal);
                    distances.remove(link2);
                }

                Distance newDistance = linkageStrategy.calculateDistance(distanceValues);

                newLinkage.setLinkageDistance(newDistance.getDistance());
                distances.add(newLinkage);
            }
            //System.out.println("newCluster is :" + newCluster.getName().toString() + "\n\n");

            List<Cluster> clstrlst = listOfCluster(newCluster);
            flag = 0;
            GeneratedClusters.add(clstrlst);
            // System.out.println("GeneratedClusters size"+GeneratedClusters.size());
//            for (int i = 0; i < GeneratedClusters.size(); i++) {
//                int flag = 0;
//                List<Cluster> get = GeneratedClusters.get(i);
//                for (int j = 0; j < clstrlst.size(); j++) {
//                    if (get.contains(clstrlst.get(j))) {
//                        System.out.println(" Got ");
//                        System.out.println("");
//                        GeneratedClusters.get(i).indexOf(clstrlst.get(j));
//                        GeneratedClusters.remove(GeneratedClusters.get(i).indexOf(clstrlst.get(j)));
//                        flag = 1;
//                        break;
//                    }
//                }
//                if (flag == 0) {
//                    GeneratedClusters.add(clstrlst);
//                    System.out.println("sucess");
//                }
//            }

            System.out.println("clstrlst size " + clstrlst.size());
            for (int i = 0; i < clstrlst.size(); i++) {
                System.out.println(" cluster member " + (kj++) + " :" + clstrlst.get(i).getName());
            }
            System.out.println("");

            List< List<Cluster>> levlclstr = new ArrayList<>();
            // levlclstr.add(clstrlst);
            for (int i = 0; i < GeneratedClusters.size(); i++) {
                levlclstr.add(GeneratedClusters.get(i));
            }
            for (int i = 0; i < OriginalCluster.size(); i++) {
                if (!clstrlst.contains(OriginalCluster.get(i))) {
                    List<Cluster> Innerclstr = new ArrayList<>();
                    Innerclstr.add(OriginalCluster.get(i));

                    int flag = 0;
                    for (int j = 0; j < levlclstr.size(); j++) {
                        List<Cluster> get = levlclstr.get(j);
                        for (int k = 0; k < get.size(); k++) {

                            if (get.get(k).getName() == OriginalCluster.get(i).getName()) {
                                flag = 1;
                            }

                        }
                    }

                    if (flag == 0) {
                        //if(!levlclstr.toString().contains(Innerclstr.toString())){
                        levlclstr.add(Innerclstr);
                    }
                }
            }
            //}
            System.out.println(".............Befor updation.....");
            for (int i = 0; i < levlclstr.size(); i++) {
                List<Cluster> prevget = levlclstr.get(i);
                for (int j = 0; j < prevget.size(); j++) {
                    System.out.print(prevget.get(j).getName() + ", ");
                }
                System.out.println("");
            }
            
//Update generated cluster list.................................
            List<List<Cluster>> updatedList = updateList2(levlclstr);
//            List< List<Cluster>> updatedList = new ArrayList<>();
//            for (int i = 0; i < levlclstr.size(); i++) {
//                List<Cluster> prevget = levlclstr.get(i);
//
//                int flag = 0;
//                int index = 0;
//                for (int j = i + 1; j < levlclstr.size(); j++) {
//                    if (levlclstr.get(j).containsAll(levlclstr.get(i))) {
//                        flag = 1;
//                        index = j;
//                    }
//                }
//                if (flag == 1) {
//                    {
//                        if (!updatedList.contains(levlclstr.get(index))) {
//                            updatedList.add(levlclstr.get(index));
//                        }
//                    }
//                } else {
//                    if (!updatedList.contains(levlclstr.get(i))) {
//                        updatedList.add(levlclstr.get(i));
//                    }
//                }
//            }
            LevalWiseClusters.put(levelcounter, updatedList);

            levelcounter++;
            clusters.add(newCluster);

        }
        
    }

    public List< List<Cluster>> updateList2(List< List<Cluster>> mergedlist) {
        System.out.println("\n\n.............UPDATED LIST........................");
        List< List<Cluster>> updatedList = new ArrayList<>();
        for (int i = 0; i < mergedlist.size(); i++) {
            List<Cluster> prevget = mergedlist.get(i);

            int flag = 0;
            int index = 0;
            for (int j = i + 1; j < mergedlist.size(); j++) {
                if (mergedlist.get(j).containsAll(mergedlist.get(i))) {
                    flag = 1;
                    index = j;
                }
            }
            if (flag == 1) {
                {
                    if (!updatedList.contains(mergedlist.get(index))) {
                        updatedList.add(mergedlist.get(index));
                    }
                }
            } else {
                if (!updatedList.contains(mergedlist.get(i))) {
                    updatedList.add(mergedlist.get(i));
                }
            }
        }

        for (int i = 0; i < updatedList.size(); i++) {
            List<Cluster> prevget = updatedList.get(i);
            for (int j = 0; j < prevget.size(); j++) {
                System.out.print(prevget.get(j).getName() + ", ");
            }
            System.out.println("");
        }
        System.out.println(".........................................");
        return updatedList;
    }

    
    int flag;
    List<Cluster> temp;

    public List<Cluster> listOfCluster(Cluster newCluster) {
        if (flag == 0) {
            temp = new ArrayList<>();
        }
        List<Cluster> children = newCluster.getChildren();
        for (Cluster cluster1 : children) {
            if (!cluster1.isLeaf()) {
                flag = 1;
                listOfCluster(cluster1);
            } else {
                temp.add(cluster1);
                //System.out.println("Cluster name " + cluster1.getName());
            }
        }
        // System.out.println("temp size" + temp.size());
        return temp;
    }

    public void listOfCluster2(List<Cluster> newCluster) {
        //System.out.println("asd");
        ListIterator<Cluster> children = newCluster.listIterator();// .getChildren();
        while (children.hasNext()) {
            Cluster cluster1 = children.next();
            // System.out.println("22222  :-" + cluster1.countLeafs());
            if (cluster1.countLeafs() > 1) {
                System.out.println("......Next Cluster......");
                listOfCluster(cluster1);
            }
        }
        //clusters.
    }

    private ClusterPair findByClusters(Cluster c1, Cluster c2) {
        return distances.findByCodePair(c1, c2);
    }

    public boolean isTreeComplete() {
        return clusters.size() == 1;
    }

    public Cluster getRootCluster() {
        if (!isTreeComplete()) {
            throw new RuntimeException("No root available");
        }
        return clusters.get(0);
    }

}
