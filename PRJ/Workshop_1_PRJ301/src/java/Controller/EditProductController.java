/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "EditProductController", urlPatterns = {"/editProduct"})
public class EditProductController extends HttpServlet {

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
        
        // Get Parament
        String productId_raw = request.getParameter("ProductId");
        String productName_raw = request.getParameter("productName");
        String productImage_raw = request.getParameter("productImage");
        String brief_raw = request.getParameter("brief");
        String postedDate_raw = request.getParameter("postedDate");
        String unit_raw = request.getParameter("unit");
        int price_raw = Integer.parseInt(request.getParameter("price"));
        int discount_raw = Integer.parseInt(request.getParameter("discount"));
        
        //  
        ProductDAO productDAO = new ProductDAO();
        Product convertedProduct = new Product();
        
        // Get Product By ProductId
        convertedProduct.setProductId(productId_raw);
        Product getProductInfo = productDAO.getProductByProductId(convertedProduct);
        request.setAttribute("getProductInfo", getProductInfo);
        
        // Check if the input from JSP is not null
        if (productName_raw == null || productImage_raw == null || brief_raw == null || postedDate_raw == null || unit_raw == null) {
            response.sendRedirect("editProduct");
        }
        
        // Update product info
        Product editProduct = productDAO.updateData(getProductInfo.getProductId());
        
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(EditProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditProductController.class.getName()).log(Level.SEVERE, null, ex);
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
