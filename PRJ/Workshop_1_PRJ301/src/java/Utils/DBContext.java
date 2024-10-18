/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jso
 */
public class DBContext {

    private String hostname;
    private String instance;
    private String port;
    private String dbName;
    private String userName;
    private String password;

    public DBContext() {
        this.hostname = "localhost";
        this.port = "1433";
        this.dbName = "ProductIntro";
        this.userName = "sa";
        this.password = "0822863716";
    }

    private String urlString() {
        return String.format("jdbc:sqlserver://%s:%s;DatabaseName=%s;UserName=%s;Password=%s;",
                this.hostname, this.port, this.dbName, this.userName, this.password);
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connect = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connect = DriverManager.getConnection(urlString());

        return connect;
    }
    
//    public static void main(String[] args) {
//        
//        try {
//            Connection conn = new DBContext().getConnection();
//            System.out.println(conn);
//        } catch (Exception e) {
//        }
//    }
}
