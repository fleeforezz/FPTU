/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Category;
import Utils.DBContext;
import java.sql.Connection;
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
public class CategoryDAO implements Business<Category> {

    private ServletContext sc;
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    private int rowsAffected = 0;

    public Connection getConnection(ServletContext sc) throws ClassNotFoundException, SQLException {
        return new DBContext().getConnection();
    }

    public CategoryDAO() throws ClassNotFoundException, SQLException {
        this.sc = null;
        this.conn = this.getConnection(sc);
    }

    public CategoryDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        this.sc = sc;
        this.conn = this.getConnection(sc);
    }

    @Override
    public int insertData(Category category) {

        String sql = "INSERT INTO [dbo].[categories] ([categoryName], [memo]) \n"
                + "VALUES (?,?)\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getMemo());

            rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowsAffected;
    }

    @Override
    public int updateData(Category category) {

        String sql = "UPDATE [dbo].[categories]\n"
                + "SET [typeId]=?, [categoryName]=?, [memo]=?\n"
                + "WHERE ([dbo].[categories].[typeId] = ?)\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, category.getTypeId());

            rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowsAffected;
    }

    @Override
    public int deleteData(Category category) {

        String sql = "DELETE FROM [dbo].[categories]\n"
                + "WHERE ([dbo].[accounts].[typeId] = ?)\n"
                + ";";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, category.getTypeId());

            rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowsAffected;
    }

    @Override
    public List<Category> listAll() {

        List<Category> list = new ArrayList<>();

        String sql = "SELECT typeId, categoryName, memo\n"
                + "FROM categories\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Category category = new Category();

                category.setTypeId(resultSet.getInt(1));
                category.setCategoryName(resultSet.getString(2));
                category.setMemo(resultSet.getString(3));

                list.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Category checkDataExist(String account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Category getData(String account, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category getDataById(Category obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
