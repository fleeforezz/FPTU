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
@WebServlet(name = "CollectionController", urlPatterns = {"/collection/*"})
public class CollectionController extends HttpServlet {

    private static final String VIEW_PATH = "/WEB-INF/collection/";

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
            throws ServletException, IOException {
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
        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Action not specified");
        }

        String action = pathInfo.substring(1);

        switch (action) {
            case "list":
                ProductDAO productDAO;
                try {
                    productDAO = new ProductDAO();
                    List<Product> productList = productDAO.listAll();
                    request.setAttribute("productList", productList);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(CollectionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher(VIEW_PATH + "productList.jsp").forward(request, response);
                break;
            case "product":
                String productId_raw = request.getParameter("productId");

                if (productId_raw != null) {
                    try {
                        productDAO = new ProductDAO();
                        Product product = new Product();

                        product.setProductId(productId_raw);

                        Product productDetail = productDAO.getDataById(product);
                        request.setAttribute("productDetail", productDetail);
                        
                        int discountProduct = (int) (productDetail.getPrice() * (1 - (productDetail.getDiscount() / 100.0)));
                        System.out.println(discountProduct + "=" + productDetail.getPrice() + "x" + "(1-" + productDetail.getDiscount() + "/100)");
                        request.setAttribute("discountProduct", discountProduct);

                        request.getRequestDispatcher(VIEW_PATH + "productDetail.jsp").forward(request, response);

                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(CollectionController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                request.getRequestDispatcher(VIEW_PATH + "productDetail.jsp").forward(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid action");
                break;
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
        processRequest(request, response);
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
