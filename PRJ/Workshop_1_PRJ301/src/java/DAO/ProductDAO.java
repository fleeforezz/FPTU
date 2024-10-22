/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Product;
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
public class ProductDAO implements Business<Product> {

    private ServletContext sc;
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    int rs = 0;

    public Connection getConnection(ServletContext sc) throws ClassNotFoundException, SQLException {
        return new DBContext().getConnection();
    }

    public ProductDAO() throws ClassNotFoundException, SQLException {
        this.sc = null;
        this.conn = this.getConnection(sc);
    }

    public ProductDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        this.sc = sc;
        this.conn = this.getConnection(sc);
    }

    @Override
    public int insertData(Product product) {

        String sql = "INSERT INTO [dbo].[products] ([productName], [productImage], [brief], [postedDate], [typeId], [account], [unit], [price], [discount])\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, product.getProductName());
            ps.setString(2, product.getProductImage());
            ps.setString(3, product.getBrief());
            ps.setDate(4, (Date) product.getPostedDate());
            ps.setInt(5, product.getTypeId());
            ps.setString(6, product.getAccount());
            ps.setString(7, product.getUnit());
            ps.setInt(8, product.getPrice());
            ps.setInt(9, product.getDiscount());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public int updateData(Product productId) {
        String sql = "UPDATE [dbo].[products]\n"
                + "SET [productName]=?, [productImage]=?, [brief]=?, [postedDate]=?, [typeId]=?, [account]=?, [unit]=?, [price]=?, [discount]=?\n"
                + "WHERE ([dbo].[products].[productId] = ?)\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, productId.getProductId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public int deleteData(Product product) {
        String sql = "DELETE FROM [dbo].[products]\n"
                + "WHERE ([dbo].[products].[productId] = ?)\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProductId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public List<Product> listAll() {
        List<Product> list = new ArrayList<>();

        String sql = "SELECT productId, productName, productImage, brief, postedDate, typeId, account, unit, price, discount\n"
                + "FROM dbo.products\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();

                product.setProductId(resultSet.getString(1));
                product.setProductName(resultSet.getString(2));
                product.setProductImage(resultSet.getString(3));
                product.setBrief(resultSet.getString(4));
                product.setPostedDate(resultSet.getDate(5));
                product.setTypeId(resultSet.getInt(6));
                product.setAccount(resultSet.getString(7));
                product.setUnit(resultSet.getString(8));
                product.setPrice(resultSet.getInt(9));
                product.setDiscount(resultSet.getInt(10));

                list.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<Product> listProductByAccountName(String account) {

        List<Product> list = new ArrayList<>();

        String sql = "SELECT productId, productName, productImage, brief, postedDate, typeId, account, unit, price, discount\n"
                + "FROM products\n"
                + "WHERE account = ?\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();

                product.setProductId(resultSet.getString(1));
                product.setProductName(resultSet.getString(2));
                product.setProductImage(resultSet.getString(3));
                product.setBrief(resultSet.getString(4));
                product.setPostedDate(resultSet.getDate(5));
                product.setTypeId(resultSet.getInt(6));
                product.setAccount(resultSet.getString(7));
                product.setUnit(resultSet.getString(8));
                product.setPrice(resultSet.getInt(9));
                product.setDiscount(resultSet.getInt(10));

                list.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Product getDataById(Product product) {
        String sql = "SELECT productId, productName, productImage, brief, postedDate, typeId, account, unit, price, discount\n"
                + "FROM products\n"
                + "WHERE productId = ?\n"
                + ";";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProductId());
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                return new Product(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getInt(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10)
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
