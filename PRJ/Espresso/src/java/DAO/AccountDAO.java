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
    private int rowsAffected = 0;

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

        String sql = "INSERT INTO [dbo].[accounts] ([account], [pass], [lastName], [firstName], [birthday], [gender], [phone], [isUse], [roleInSystem], [accountImage]) \n"
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
            ps.setString(10, account.getAccountImage());

            rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowsAffected;
    }

    @Override
    public int updateData(Account account) {

        String sql = "UPDATE accounts\n"
                + "SET [pass]=?, [firstName]=?, [lastName]=?, [birthday]=?, [gender]=?, [phone]=?, [isUse]=?, [roleInSystem]=?, [accountImage]=?\n"
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
            ps.setString(9, account.getAccountImage());
            ps.setString(10, account.getAccount());

            rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowsAffected;
    }

    @Override
    public int deleteData(Account account) {

        String sql = "UPDATE accounts\n"
                + "SET isUse='false'\n"
                + "WHERE account = ?)\n"
                + ";";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getAccount());
            rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowsAffected;
    }

    public int setActive(Account account) {

        String sql = "UPDATE [dbo].[accounts]\n"
                + "SET [isUse]='true'\n"
                + "WHERE ([dbo].[accounts].[account] = ?)\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getAccount());
            rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowsAffected;
    }

    @Override
    public List<Account> listAll() {
        List<Account> list = new ArrayList<>();

        String sql = "SELECT account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem, accountImage\n"
                + "FROM accounts\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();

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
                account.setAccountImage(resultSet.getString(10));

                list.add(account);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Account getData(String account, String pass) {
        String sql = "SELECT account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem, accountImage\n"
                + "FROM accounts\n"
                + "WHERE account = ? AND pass = ?\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, pass);
            resultSet = ps.executeQuery();

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
                        resultSet.getInt(9),
                        resultSet.getString(10)
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public Account getDataById(Account account) {
        String sql = "SELECT account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem, accountImage\n"
                + "FROM accounts\n"
                + "WHERE account = ?\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getAccount());
            resultSet = ps.executeQuery();

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
                        resultSet.getInt(9),
                        resultSet.getString(10)
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
