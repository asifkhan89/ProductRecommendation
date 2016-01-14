
package Hclustering;

import static Hclustering.HierarchyBuilder.levelcounter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DefaultClusteringAlgorithm implements ClusteringAlgorithm {

    public static List<Cluster> OriginalCluster ;//= new ArrayList<>();
    public static HashMap<Integer, List< List<Cluster>>> LevalWiseClusters = new HashMap<>();

    public DefaultClusteringAlgorithm() {

    }
    @Override
    public Cluster performClustering(double[][] distances, String[] clusterNames, LinkageStrategy linkageStrategy) {

        checkArguments(distances, clusterNames, linkageStrategy);
        /* Setup model */
        List<Cluster> clusters = createClusters(clusterNames);
        DistanceMap linkages = createLinkages(distances, clusters);

        /* Process */
        HierarchyBuilder builder = new HierarchyBuilder(clusters, linkages);
        while (!builder.isTreeComplete()) {
            builder.agglomerate(linkageStrategy);
        }

        return builder.getRootCluster();
    }

    private void checkArguments(double[][] distances, String[] clusterNames,
            LinkageStrategy linkageStrategy) {
        if (distances == null || distances.length == 0
                || distances[0].length != distances.length) {
            throw new IllegalArgumentException("Invalid distance matrix");
        }
        if (distances.length != clusterNames.length) {
            throw new IllegalArgumentException("Invalid cluster name array");
        }
        if (linkageStrategy == null) {
            throw new IllegalArgumentException("Undefined linkage strategy");
        }
        int uniqueCount = new HashSet<String>(Arrays.asList(clusterNames)).size();
        if (uniqueCount != clusterNames.length) {
            throw new IllegalArgumentException("Duplicate names");
        }
    }

    @Override
    public Cluster performWeightedClustering(double[][] distances, String[] clusterNames,
            double[] weights, LinkageStrategy linkageStrategy) {

        checkArguments(distances, clusterNames, linkageStrategy);

        if (weights.length != clusterNames.length) {
            throw new IllegalArgumentException("Invalid weights array");
        }

        /* Setup model */
        List<Cluster> clusters = createClusters(clusterNames, weights);
        DistanceMap linkages = createLinkages(distances, clusters);

        /* Process */
        HierarchyBuilder builder = new HierarchyBuilder(clusters, linkages);
        while (!builder.isTreeComplete()) {
            builder.agglomerate(linkageStrategy);
        }

        return builder.getRootCluster();
    }

    private DistanceMap createLinkages(double[][] distances, List<Cluster> clusters) {
        DistanceMap linkages = new DistanceMap();
        for (int col = 0; col < clusters.size(); col++) {
            for (int row = col + 1; row < clusters.size(); row++) {
                ClusterPair link = new ClusterPair();
                Cluster lCluster = clusters.get(col);
                Cluster rCluster = clusters.get(row);
                link.setLinkageDistance(distances[col][row]);
                link.setlCluster(lCluster);
                link.setrCluster(rCluster);
                linkages.add(link);
            }
        }
        return linkages;
    }

    private List<Cluster> createClusters(String[] clusterNames) {
        System.out.println("");
        OriginalCluster = new ArrayList<>();
       OriginalCluster.clear();
        LevalWiseClusters = new HashMap<>();
        levelcounter=0;
        LevalWiseClusters.clear();
        List<Cluster> clusters = new ArrayList<Cluster>();
        for (String clusterName : clusterNames) {
            Cluster cluster = new Cluster(clusterName);
            clusters.add(cluster);
            OriginalCluster.add(cluster);
        }
        List<List<Cluster>> temp = new ArrayList<>();
        
        for (int i = 0; i < OriginalCluster.size(); i++) {
            List<Cluster> temp2 = new ArrayList<>();
            temp2.add(OriginalCluster.get(i));
            temp.add(temp2);
        }
       // HierarchyBuilder hc=new HierarchyBuilder();
        
        LevalWiseClusters.put(levelcounter, temp);
        levelcounter++;
        return clusters;
    }

    private List<Cluster> createClusters(String[] clusterNames, double[] weights) {
        List<Cluster> clusters = new ArrayList<Cluster>();
        for (int i = 0; i < weights.length; i++) {
            Cluster cluster = new Cluster(clusterNames[i]);
            cluster.setDistance(new Distance(0.0, weights[i]));
            clusters.add(cluster);
        }
        return clusters;
    }

}
