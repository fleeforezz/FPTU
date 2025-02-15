/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import DAO.CategoryDAO;
import DAO.ProductDAO;
import Entity.Account;
import Entity.Category;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jso
 */
@WebServlet(name = "AdminDashboardController", urlPatterns = {"/admin"})
public class AdminDashboardController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category_name_raw = request.getParameter("categoryName");

        AccountDAO accountDAO;
        ProductDAO productDAO;
        CategoryDAO categoryDAO;
        try {
            accountDAO = new AccountDAO();
            productDAO = new ProductDAO();
            categoryDAO = new CategoryDAO();
            
            List<Account> listAccount = accountDAO.listAll();
            int listAccountSize = listAccount.size();
            
            List<Product> listProduct = productDAO.listAll();
            int listProductSize = listProduct.size();
            
            List<Category> listCategory = categoryDAO.listAll();
            int listCategorySize = listCategory.size();

            Category category = new Category();
            category.setCategoryName(category_name_raw);
            categoryDAO.insertData(category);

            request.setAttribute("listAccount", listAccount);
            request.setAttribute("listAccountSize", listAccountSize);
            request.setAttribute("listProduct", listProduct);
            request.setAttribute("listProductSize", listProductSize);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("listCategorySize", listCategorySize);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("adminDash.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
