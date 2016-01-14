
package Hclustering.view;


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

import Hclustering.Cluster;
import Hclustering.ClusteringAlgorithm;
import Hclustering.CompleteLinkageStrategy;
import Hclustering.DefaultClusteringAlgorithm;
//import DmatrixProcess.DistanceMatrix;
//import Hclustering.AverageLinkageStrategy;
import Hclustering.LinkageStrategy;
import com.apporiented.algorithm.clustering.SingleLinkageStrategy;
//import PreWork.BasicProcess;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class DendrogramPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    final static BasicStroke solidStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);

    private Cluster model;
    private ClusterComponent component;
    private Color lineColor = Color.BLACK;
    private boolean showDistanceValues = false;
    private boolean showScale = true;
    private int borderTop = 20;
    private int borderLeft = 20;
    private int borderRight = 20;
    private int borderBottom = 20;
    private int scalePadding = 10;
    private int scaleTickLength = 4;
    private int scaleTickLabelPadding = 4;
    private double scaleValueInterval = 0;
    private int scaleValueDecimals = 0;

    private double xModelOrigin = 0.0;
    private double yModelOrigin = 0.0;
    private double wModel = 0.0;
    private double hModel = 0.0;

    public boolean isShowDistanceValues() {
        return showDistanceValues;
    }

    public void setShowDistances(boolean showDistanceValues) {
        this.showDistanceValues = showDistanceValues;
    }

    public boolean isShowScale() {
        return showScale;
    }

    public void setShowScale(boolean showScale) {
        this.showScale = showScale;
    }

    public int getScalePadding() {
        return scalePadding;
    }

    public void setScalePadding(int scalePadding) {
        this.scalePadding = scalePadding;
    }

    public int getScaleTickLength() {
        return scaleTickLength;
    }

    public void setScaleTickLength(int scaleTickLength) {
        this.scaleTickLength = scaleTickLength;
    }

    public double getScaleValueInterval() {
        return scaleValueInterval;
    }

    public void setScaleValueInterval(double scaleTickInterval) {
        this.scaleValueInterval = scaleTickInterval;
    }

    public int getScaleValueDecimals() {
        return scaleValueDecimals;
    }

    public void setScaleValueDecimals(int scaleValueDecimals) {
        this.scaleValueDecimals = scaleValueDecimals;
    }

    public int getBorderTop() {
        return borderTop;
    }

    public void setBorderTop(int borderTop) {
        this.borderTop = borderTop;
    }

    public int getBorderLeft() {
        return borderLeft;
    }

    public void setBorderLeft(int borderLeft) {
        this.borderLeft = borderLeft;
    }

    public int getBorderRight() {
        return borderRight;
    }

    public void setBorderRight(int borderRight) {
        this.borderRight = borderRight;
    }

    public int getBorderBottom() {
        return borderBottom;
    }

    public void setBorderBottom(int borderBottom) {
        this.borderBottom = borderBottom;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Cluster getModel() {
        return model;
    }

    public void setModel(Cluster model) {
        this.model = model;
        component = createComponent(model);
        updateModelMetrics();
    }

    private void updateModelMetrics() {
        double minX = component.getRectMinX();
        double maxX = component.getRectMaxX();
        double minY = component.getRectMinY();
        double maxY = component.getRectMaxY();

        xModelOrigin = minX;
        yModelOrigin = minY;
        wModel = maxX - minX;
        hModel = maxY - minY;
    }

    private ClusterComponent createComponent(Cluster cluster, VCoord initCoord, double clusterHeight) {

        ClusterComponent comp = null;
        if (cluster != null) {
            comp = new ClusterComponent(cluster, cluster.isLeaf(), initCoord);
            double leafHeight = clusterHeight / cluster.countLeafs();
            double yChild = initCoord.getY() - (clusterHeight / 2);
            double distance = cluster.getDistanceValue() == null ? 0 : cluster.getDistanceValue();
            for (Cluster child : cluster.getChildren()) {
                int childLeafCount = child.countLeafs();
                double childHeight = childLeafCount * leafHeight;
                double childDistance = child.getDistanceValue() == null ? 0 : child.getDistanceValue();
                VCoord childInitCoord = new VCoord(initCoord.getX() + (distance - childDistance), yChild + childHeight
                        / 2.0);
                yChild += childHeight;

                /* Traverse cluster node tree */
                ClusterComponent childComp = createComponent(child, childInitCoord, childHeight);

                childComp.setLinkPoint(initCoord);
                comp.getChildren().add(childComp);
            }
        }
        return comp;

    }

    private ClusterComponent createComponent(Cluster model) {

        double virtualModelHeight = 1;
        VCoord initCoord = new VCoord(0, virtualModelHeight / 2);

        ClusterComponent comp = createComponent(model, initCoord, virtualModelHeight);
        comp.setLinkPoint(initCoord);
        return comp;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(lineColor);
        g2.setStroke(solidStroke);

        int wDisplay = getWidth() - borderLeft - borderRight;
        int hDisplay = getHeight() - borderTop - borderBottom;
        int xDisplayOrigin = borderLeft;
        int yDisplayOrigin = borderBottom;

        if (component != null) {

            int nameGutterWidth = component.getMaxNameWidth(g2, false) + component.getNamePadding();
            wDisplay -= nameGutterWidth;

            if (showScale) {
                Rectangle2D rect = g2.getFontMetrics().getStringBounds("0", g2);
                int scaleHeight = (int) rect.getHeight() + scalePadding + scaleTickLength + scaleTickLabelPadding;
                hDisplay -= scaleHeight;
                yDisplayOrigin += scaleHeight;
            }

            /* Calculate conversion factor and offset for display */
            double xFactor = wDisplay / wModel;
            double yFactor = hDisplay / hModel;
            int xOffset = (int) (xDisplayOrigin - xModelOrigin * xFactor);
            int yOffset = (int) (yDisplayOrigin - yModelOrigin * yFactor);
            component.paint(g2, xOffset, yOffset, xFactor, yFactor, showDistanceValues);

            if (showScale) {
                int x1 = xDisplayOrigin;
                int y1 = yDisplayOrigin - scalePadding;
                int x2 = x1 + wDisplay;
                int y2 = y1;
                g2.drawLine(x1, y1, x2, y2);

                double totalDistance = component.getCluster().getTotalDistance();
                double xModelInterval;
                if (scaleValueInterval <= 0) {
                    xModelInterval = totalDistance / 10.0;
                } else {
                    xModelInterval = scaleValueInterval;
                }

                int xTick = xDisplayOrigin + wDisplay;
                y1 = yDisplayOrigin - scalePadding;
                y2 = yDisplayOrigin - scalePadding - scaleTickLength;
                double distanceValue = 0;
                double xDisplayInterval = xModelInterval * xFactor;
                while (xTick >= xDisplayOrigin) {
                    g2.drawLine(xTick, y1, xTick, y2);

                    String distanceValueStr = String.format("%." + scaleValueDecimals + "f", distanceValue);
                    Rectangle2D rect = g2.getFontMetrics().getStringBounds(distanceValueStr, g2);
                    g2.drawString(distanceValueStr, (int) (xTick - (rect.getWidth() / 2)), y2 - scaleTickLabelPadding);
                    xTick -= xDisplayInterval;
                    distanceValue += xModelInterval;
                }

            }
        } else {

            /* No data available */
            String str = "No data";
            Rectangle2D rect = g2.getFontMetrics().getStringBounds(str, g2);
            int xt = (int) (wDisplay / 2.0 - rect.getWidth() / 2.0);
            int yt = (int) (hDisplay / 2.0 - rect.getHeight() / 2.0);
            g2.drawString(str, xt, yt);
        }
    }

   // public static void main(String[] args) {
        public  void mainMeth(Object strategy ,ArrayList<ArrayList<Double>> disMatrix,ArrayList<String> uname){
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setLocation(400, 300);
        frame.setTitle(strategy.toString()+" Dendrogram Reperesentation ");
       // frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel content = new JPanel();
        DendrogramPanel dp = new DendrogramPanel();

        frame.setContentPane(content);
        content.setBackground(Color.red);
        content.setLayout(new BorderLayout());
        content.add(dp, BorderLayout.CENTER);
        dp.setBackground(Color.LIGHT_GRAY);
        dp.setLineColor(Color.BLACK);
        dp.setScaleValueDecimals(1);
        dp.setScaleValueInterval(2);
        dp.setShowDistances(false);

        Cluster cluster = createSampleCluster(strategy,disMatrix,uname);

        dp.setModel(cluster);
        frame.setVisible(true);

//LevalWiseClusters
        HashMap<Integer, List<List<Cluster>>> levalsCluster = DefaultClusteringAlgorithm.LevalWiseClusters;
        Set<Integer> keySet = levalsCluster.keySet();
        for (Integer lvlNo : keySet) {
            System.out.println("\n...........Lavel............." + lvlNo);
            List<List<Cluster>> get = levalsCluster.get(lvlNo);
            for (List<Cluster> inr : get) {
                for (Cluster clst : inr) {
                    System.out.print("\t " + clst.getName());
                }
                System.out.println("");
            }

        }
    }

    private static Cluster createSampleCluster(Object strategy,ArrayList<ArrayList<Double>> disMatrix,ArrayList<String> uname) {

//        double[][] distances = DistanceMatrix.distanceMatrix;
//
//        
//        File[] listOfFiles = BasicProcess.listOfFiles;
            double[][] dismatx1 = new double[uname.size()][uname.size()];
        String[] names = new String[uname.size()];

        for (int i = 0; i < uname.size(); i++) {
            names[i] = uname.get(i);
            System.out.println("%%%%%%%%%%%%%%  " + uname.get(i));
        }

        for (int i = 0; i < disMatrix.size(); i++) {
            ArrayList temp = disMatrix.get(i);
            for (int j = 0; j < temp.size(); j++) {
                dismatx1[i][j] = (double) temp.get(j);
                System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVjhffbf%%%  " + (double) temp.get(j));
            }
            System.out.println("==============");
        }
//        String[] names = new String[listOfFiles.length];//{"Actor", "attack1", "attack1_2", "attack1_3", "earthquack_1", "earthquack_2", "flood1", "flood2"};
//        for (int i = 0; i < listOfFiles.length; i++) {
//            names[i] = listOfFiles[i].getName();
//        }
        ClusteringAlgorithm algo = new DefaultClusteringAlgorithm();
        Cluster cluster = algo.performClustering(dismatx1, names, (LinkageStrategy) strategy);
        cluster.toConsole(0);
        // listOfCluster(cluster);
        return cluster;
    }


    public static void listOfCluster(Cluster newCluster) {
        ///// count = 0;
        System.out.println("size  " + newCluster.getWeightValue());//newCluster.countLeafs());
        //   newCluster.getWeightValue()
        List<Cluster> children = newCluster.getChildren();

        for (Cluster cluster1 : children) {
            if (!cluster1.isLeaf()) {
                listOfCluster(cluster1);
            } else {
                //count++;
                System.out.println("Cluster name " + cluster1.getName());
            }
        }
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

    }

}
