

package com.apporiented.algorithm.clustering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cluster {

    public HashMap<String, ArrayList<String>>clusterUsers =new HashMap<String, ArrayList<String>>();
    ArrayList<String> usr = new ArrayList<>();
    private String name;

    private Cluster parent;

    private List<Cluster> children;

	private Distance distance = new Distance();

    public Distance getDistance() {
        return distance;
    }

    public Double getWeightValue() {
		return distance.getWeight();
    }

    public Double getDistanceValue() {
		return distance.getDistance();
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public List<Cluster> getChildren() {
        if (children == null) {
            children = new ArrayList<Cluster>();
        }

        return children;
    }

    public void setChildren(List<Cluster> children) {
        this.children = children;
    }

    public Cluster getParent() {
        return parent;
    }

    public void setParent(Cluster parent) {
        this.parent = parent;
    }


    public Cluster(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChild(Cluster cluster) {
        getChildren().add(cluster);

    }

    public boolean contains(Cluster cluster) {
        return getChildren().contains(cluster);
    }

    @Override
    public String toString() {
        return "Cluster " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cluster other = (Cluster) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (name == null) ? 0 : name.hashCode();
    }

    public boolean isLeaf() {
        return getChildren().size() == 0;
    }

    public int countLeafs() {
        return countLeafs(this, 0);
    }

    public int countLeafs(Cluster node, int count) {
        if (node.isLeaf()) count++;
        for (Cluster child : node.getChildren()) {
            count += child.countLeafs();
        }
        return count;
    }
public static String output = new String();
    public void toConsole(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");

        }
//        System.out.println("wwwwwwwwww "+getName());
//        System.out.println("rrtrtrtgfg"+isLeaf());
//        String clnm;
//        if(isLeaf()==false){
        usr.add(getName());
//        }else{
//         usr.add(getName());
//        }
        String name = getName() + (isLeaf() ? " (leaf)" : "") + (distance != null ? "  distance: " + distance : "");
//        System.out.println("######"+name);
        output = output+name+"\n";
//        System.out.println("123");
        for (Cluster child : getChildren()) {
            child.toConsole(indent + 1);
        }
       
    }
    public void dis(){
    
//    System.out.println("arrrrrrrrrrrrrrrrrrr"+usr);
    
    }

    public double getTotalDistance() {
        Double dist = getDistance() == null ? 0 : getDistance().getDistance();
        if (getChildren().size() > 0) {
            dist += children.get(0).getTotalDistance();
        }
        return dist;

    }

}
