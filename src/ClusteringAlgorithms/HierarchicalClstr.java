package ClusteringAlgorithms;

//import Clustring.RatingMatrix;
//import Clustring.Recommendation;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

import com.apporiented.algorithm.clustering.AverageLinkageStrategy;
import com.apporiented.algorithm.clustering.Cluster;
import com.apporiented.algorithm.clustering.ClusteringAlgorithm;
import com.apporiented.algorithm.clustering.CompleteLinkageStrategy;
import com.apporiented.algorithm.clustering.DefaultClusteringAlgorithm;
import com.apporiented.algorithm.clustering.SingleLinkageStrategy;
import com.apporiented.algorithm.clustering.WeightedLinkageStrategy;
import guimain.MainFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HierarchicalClstr extends JPanel {

    public static HashMap<String, ArrayList<String>> clusterUsers = new HashMap<>();
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

    public void main(ArrayList<String> usernames, ArrayList<ArrayList<Double>> disMatrix) throws IOException, Exception {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setLocation(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel content = new JPanel();
        HierarchicalClstr dp = new HierarchicalClstr();

        frame.setContentPane(content);
        content.setBackground(Color.red);
        content.setLayout(new BorderLayout());
        content.add(dp, BorderLayout.CENTER);
        dp.setBackground(Color.WHITE);
        dp.setLineColor(Color.BLACK);
        dp.setScaleValueDecimals(0);
        dp.setScaleValueInterval(1);
        dp.setShowDistances(false);

        Cluster cluster = createSampleCluster(usernames, disMatrix);
        dp.setModel(cluster);
        frame.setVisible(true);
    }

    private static Cluster createSampleCluster(ArrayList<String> usernames, ArrayList<ArrayList<Double>> disMatrix) throws IOException, Exception {
//         RatingMatrix rm = new RatingMatrix();
//        rm.getusers();
//        rm.getsize();
//        rm.getmovieIDs();
//        String []names=rm.names;
//        double [][]userRating =rm.uIds;
        double[][] dismatx1 = new double[usernames.size()][usernames.size()];
        String[] names = new String[usernames.size()];

        for (int i = 0; i < usernames.size(); i++) {
            names[i] = usernames.get(i);
            //  System.out.println("%%%%%%%%%%%%%%  "+usernames.get(i));
        }

        for (int i = 0; i < disMatrix.size(); i++) {
            ArrayList temp = disMatrix.get(i);
            for (int j = 0; j < temp.size(); j++) {
                dismatx1[i][j] = (double) temp.get(j);
                //  System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVjhffbf%%%  "+(double) temp.get(j));
            }
            //System.out.println("==============");
        }

//        double[][] distances = new double[][]{{2, 2, 2, 1, 4, 4}, {0, 1, 4, 4, 4, 5}, {5, 5, 4, 3, 3, 2},
//        {5, 5, 4, 3, 2, 2}, {2, 2, 1, 1, 4, 4}, {0, 1, 4, 4, 4, 5}};
////         double[][] distances = new double[][] { { 4, 4, 3}, { 4, 4, 1 }, { 3, 2, 2},
////                { 3, 2, 2 }};
//        String[] names1 = new String[]{"1", "2", "6", "7", "9", "10"};
//          String[] names = new String[] { "O1", "O2", "O3", "O4" };
        ClusteringAlgorithm alg = new DefaultClusteringAlgorithm();
        Cluster cluster = null;
//        if (MainFrame.jComboBox1.getSelectedItem().toString().equals("AverageLinkageStrategy")) {
//            cluster = alg.performClustering(dismatx1, names, new AverageLinkageStrategy());
//        } else if (MainFrame.jComboBox1.getSelectedItem().toString().equals("CompleteLinkageStrategy")) {
//            cluster = alg.performClustering(dismatx1, names, new CompleteLinkageStrategy());
//        } else if (MainFrame.jComboBox1.getSelectedItem().toString().equals("SingleLinkageStrategy")) {
//            cluster = alg.performClustering(dismatx1, names, new SingleLinkageStrategy());
//        } else if (MainFrame.jComboBox1.getSelectedItem().toString().equals("WeightedLinkageStrategy")) {
//            cluster = alg.performClustering(dismatx1, names, new WeightedLinkageStrategy());
//        }
        cluster = alg.performClustering(dismatx1, names, new SingleLinkageStrategy());
        cluster.toConsole(0);
        System.out.println("vvvvvvvvvvvvvvvv" + cluster.output);
        String temp = Cluster.output;
        String[] temparr = temp.split("\n");
        // ArrayList allValues = new ArrayList();
        ArrayList allValues = null;
        String key = new String();
        for (int i = 0; i < temparr.length; i++) {
//            System.out.println("Teemmmmmm :" + temparr[i]);
            String s = temparr[i];
            s = s.trim();

            if (s.contains("clstr")) {

                key = s.split(" ")[0];
//              System.out.println("key " + key);
                allValues = new ArrayList();
            } else if (s.contains("leaf")) {

                String value = s.split("(leaf)")[0];
                value = value.replace(" (", "");
//                System.out.println("vvvvv " + value);
                allValues.add(value);
                //allValues.add(value);
            }

            if (allValues.size() > 0) {
                //  System.out.println(" Arrrr" + allValues);
                clusterUsers.put(key, allValues);
            }
        }
//        String s1=clusterUsers.toString();
//        String[] s2=s1.split(",");
//        for(int i=0;i<s2.length;i++)
//        {
//            System.out.println(s2[i]);
//        }
        Set<String> kaysets = clusterUsers.keySet();
        for (String keys : kaysets) {
            ArrayList prnm = clusterUsers.get(keys);
            System.out.println(" " + keys);
            for (int i = 0; i < prnm.size(); i++) {
                System.out.println("prod nm :" + prnm.get(i));
            }
        }

        cluster.dis();
//        Recommendation rd = new Recommendation();
//        rd.getclusteruser(clusterUsers);
//        rd.reduced();
//        rd.popularProduct();
//        rd.forsingaluserinCluster();
//        rd.getoriganalItem();
//        rd.recommendedItem();
//        rd.Dis();
        return cluster;
    }

}
