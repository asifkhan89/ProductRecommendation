package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class TableOperations {

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println(" connection established");
            String url = "jdbc:mysql://localhost:3306/user";
            con = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }

    public void createTab(String user) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS " + user + "(pname varchar(50)) ";
            stmt.executeUpdate(query);
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public HashSet<String> getProduct() {
        HashSet<String> prod = new HashSet<>();
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/product";
            con = DriverManager.getConnection(url, "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from UserProRating");
            while (rs.next()) {
                String productname = rs.getString(2);
                prod.add(productname);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return prod;
    }

    public void insertProduct(String user) throws Exception {
        HashSet<String> product = this.getProduct();
        if (getRowCount(user) == 0) {
            try {
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement("INSERT INTO " + user + "(pname) VALUES ( ? ) ");
                for (String product1 : product) {
                    //stmt.setInt(1, 1);
                    stmt.setString(1, product1);
                    stmt.executeUpdate();
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    public int getRowCount(String user) throws Exception {
        int cnt = 0;
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery("select count(*) from " + user);

            while (resultSet.next()) {
                cnt = resultSet.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cnt;
    }

    public Integer getColCount(String user) {
        int columnsNumber = 0;
        try {
            Connection con = getConnection();
            String query = "select * from " + user;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            columnsNumber = rsmd.getColumnCount();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return columnsNumber;
    }

    public void addSession(String user) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            String query = "ALTER TABLE " + user + " ADD session_" + (getColCount(user)) + " int(20)";
            int successOrFailure = stmt.executeUpdate(query);
            if (successOrFailure > 0) {
                String q = "UPDATE " + user + " SET session_" + (getColCount(user)-1) + "=0 ";
                stmt.executeUpdate(q);
            } else {
                System.out.println("failure");
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void setValue(String user, String val) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            int iVal;
            String str = "session_" + (getColCount(user) - 1);
            String q = "SELECT * FROM " + user + " WHERE pname='" + val + "'";
            ResultSet rs = stmt.executeQuery(q);
            if (rs.next()) {
                iVal = rs.getInt(str);

                if (rs.wasNull() || iVal == 0) {
                    String query = "UPDATE " + user + " SET session_" + (getColCount(user) - 1) + "=60 WHERE pname='" + val + "'";
                    stmt.executeUpdate(query);
                } else {
                    if (iVal >= 69) {
                    } else {
                        iVal += 1;
                    }
                    String query = "UPDATE " + user + " SET session_" + (getColCount(user) - 1) + "=" + iVal + " WHERE pname='" + val + "'";
                    stmt.executeUpdate(query);
                }
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void decreementValue(String user, String val) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = null;
            String str = "";
            Integer iVal = 0;
            if (getColCount(user) > 1) {
                for (int i = 1; i < (getColCount(user) - 1); i++) {
                    str = "session_" + i;
                    String q = "SELECT " + str + " FROM " + user + " where pname='" + val + "'";
                    rs = stmt.executeQuery(q);
                    if (rs.next()) {
                        iVal = rs.getInt(str);
                        //System.out.println(iVal);

                        if (!rs.wasNull() && iVal > 0) {
                            String query = "UPDATE " + user + " SET " + str + "=" + (iVal - 1) + " where pname='" + val + "'";
                            stmt.executeUpdate(query);
                        }
                    }
                }
            }

            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
