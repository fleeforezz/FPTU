/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nhat
 */
public class ConnectDB {
    private String hostname;
    private String instance;
    private String port;
    private String dbName;
    private String userName;
    private String password;
    
//    Default constructor
    public ConnectDB() {
        this.hostname="192.168.1.81";
        this.port="32768";
        this.dbName="testdatabase";
        this.userName="sa";
        this.password="D4g4_asd01292863716";
    }
    
    private String urlString() {
        return String.format("jdbc:sqlserver://%s:%s;DatabaseName=%s;UserName=%s;Password=%s;",
                this.hostname, this.port, this.dbName, this.userName, this.password);
    }
    
//    This method use to connect to SQL Server
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connect = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connect = DriverManager.getConnection(urlString());
        
        return connect;
    }
}
