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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author jso
 */
public class AccountDAO implements Business<Account> {

    private ServletContext sc;
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;

    public Connection getConnection(ServletContext sc) throws ClassNotFoundException, SQLException {
        return new DBContext().getConnection();
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

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public int updateData(Account account) {
        int rs = 0;

        String sql = "UPDATE [dbo].[accounts]\n"
                + "SET [pass]=?, [firstName]=?, [lastName]=?, [birthday]=?, [gender]=?, [phone]=?, [isUse]=?, [roleInSystem]=?\n"
                + "WHERE ([dbo].[accounts].[account] = ?)\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, account.getPass());
            ps.setString(2, account.getFirstName());
            ps.setString(3, account.getLastName());
            ps.setDate(4, (Date) account.getBirthday());
            ps.setBoolean(5, account.isGender());
            ps.setString(6, account.getPhone());
            ps.setBoolean(7, account.isIsUse());
            ps.setInt(8, account.getRoleInSystem());
            ps.setString(9, account.getAccount());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public int deleteData(Account account) {
        int rs = 0;

        String sql = "DELETE FROM [dbo].[accounts]\n"
                + "WHERE ([dbo].[accounts].[account] = ?)\n"
                + ";";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, account.getAccount());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public List<Account> listAll() {
        List<Account> list = new ArrayList<>();

        String sql = "SELECT [dbo].[accounts].[account], [dbo].[accounts].[pass], [dbo].[accounts].[lastName], [dbo].[accounts].[firstName], [dbo].[accounts].[birthday], [dbo].[accounts].[gender], [dbo].[accounts].[phone], [dbo].[accounts].[isUse], [dbo].[accounts].[roleInSystem]\n"
                + "FROM [dbo].[accounts]\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);

            while (resultSet.next()) {
                Account account = new Account();

                account.setAccount(resultSet.getString(1));
                account.setPass(resultSet.getString(2));
                account.setLastName(resultSet.getString(3));
                account.setFirstName(resultSet.getString(4));
                account.setBirthday(resultSet.getDate(5));
                account.setGender(resultSet.getBoolean(6));
                account.setPhone(resultSet.getString(7));
                account.setIsUse(resultSet.getBoolean(8));
                account.setRoleInSystem(resultSet.getInt(9));

                list.add(account);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Account checkAccountExist(String account) {
        String sql = "SELECT [dbo].[accounts].[account], [dbo].[accounts].[pass]\n"
                + "FROM [dbo].[accounts]\n"
                + "WHERE [dbo].[accounts].[account] = ?\n"
                + ";";

        try {

            ps = conn.prepareStatement(sql);
            ps.executeQuery();

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

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public Account getAccount(String account, String pass) {
        String sql = "SELECT account, pass\n"
                + "FROM accounts\n"
                + "WHERE account = ? AND pass = ?\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, pass);
            ps.executeQuery();

            while (resultSet.next()) {
//                return new Account(
//                        resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getString(4),
//                        resultSet.getDate(5),
//                        resultSet.getBoolean(6),
//                        resultSet.getString(7),
//                        resultSet.getBoolean(8),
//                        resultSet.getInt(9) 
//                );

                Account acc = new Account(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getBoolean(6),
                        resultSet.getString(7),
                        resultSet.getBoolean(8),
                        resultSet.getInt(9));
                System.out.println(acc.getAccount());
                return acc;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
