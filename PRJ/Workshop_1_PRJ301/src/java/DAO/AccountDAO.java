/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Account;
import Utils.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;

/**
 *
 * @author jso
 */
public class AccountDAO implements Business<Account> {

    private ServletContext sc;
    private Connection conn;
    private PreparedStatement ps = null;

    public Connection getConnection(ServletContext sc) throws ClassNotFoundException, SQLException {
        if (sc == null) {
            return new DBContext().getConnection();
        } else {
            return new DBContext().getConnection();
        }
    }

    public AccountDAO() throws ClassNotFoundException, SQLException {
        this.sc = null;
        this.conn = this.getConnection(sc);
    }

    public AccountDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        this.sc = sc;
        this.conn = this.getConnection(sc);
    }

    @Override
    public int insertData(Account account) {
        ResultSet resultSet = null;
        int rs = 0;
        

        String sql = "INSERT INTO [dbo].[accounts] ([account], [pass], [lastName], [firstName], [birthday], [gender], [phone], [isUse], [roleInSystem]) \n"
                + "VALUES (?,?,?,?,?,?,?,?,?);";
        
        try {
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, account.getAccount());
            ps.setString(2, account.getPass());
            ps.setString(3, account.getLastName());
            ps.setString(4, account.getFirstName());
            ps.setDate(5, (Date) account.getBirthday());
            ps.setBoolean(6, account.isGender());
            ps.setString(7, account.getPhone());
            ps.setBoolean(8, account.isIsUse());
            ps.setInt(9, account.getRoleInSystem());
            
            ps.executeUpdate();
            
            while (resultSet.next()) {
                return new Account(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getBoolean(6),
                        resultSet.getString(7),
                        resultSet.getBoolean(8),
                        resultSet.getInt(9)
                );
            }
            
        } catch (Exception e) {
        }

        return rs;
    }

    @Override
    public int updateData(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
