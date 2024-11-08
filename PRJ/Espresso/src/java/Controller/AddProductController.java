/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Entity.Account;
import Entity.Category;
import Entity.Product;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author jso
 */
@WebServlet(name = "AddProductController", urlPatterns = {"/addProduct"})
public class AddProductController extends HttpServlet {

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
        
        try {
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> listProductCategory = (List<Category>) categoryDAO.listAll();
            
            request.setAttribute("listProductCategory", listProductCategory);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("addProduct.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String UPLOAD_DIRECTORY = "uploads";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account userSession = (Account) session.getAttribute("acc");
        
        String productId_raw = request.getParameter("productId");
        String productName_raw = request.getParameter("productName");
        String brief_raw = request.getParameter("brief");
        String postedDate_raw = request.getParameter("postedDate");
        int typeId_raw = Integer.parseInt(request.getParameter("typeId"));
        String unit_raw = request.getParameter("unit");
        int price_raw = Integer.parseInt(request.getParameter("price"));
        int discount_raw = Integer.parseInt(request.getParameter("discount"));
        
        // Convert String to DateTimeFormat
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate convertedBirthdate = LocalDate.parse(postedDate_raw, formatter);
        
        // File upload logic
        // 1. Get the file part from the request
        Part productImage_raw = request.getPart("productImage");
        String fileName = productImage_raw.getSubmittedFileName();
        
        // 2. Define the upload path
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        
        // 3. Create upload directory if it's doesn't exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        // 4. Save the file on serber
        String filePath = uploadPath + File.separator + fileName;
        productImage_raw.write(filePath);
        
        try {
            ProductDAO productDAO = new ProductDAO();
            Product product = new Product();
            
            product.setProductId(productId_raw);
            product.setProductName(productName_raw);
            product.setProductImage(filePath);
            product.setBrief(brief_raw);
            product.setPostedDate(Date.valueOf(convertedBirthdate));
            product.setTypeId(typeId_raw);
            product.setAccount(userSession.getAccount());
            product.setUnit(unit_raw);
            product.setPrice(price_raw);
            product.setDiscount(discount_raw);
            
            int addedProduct = productDAO.insertData(product);
            
            if (addedProduct == 1) {
                request.setAttribute("SUCCESS_MESSAGE", "Add product success");
            } else {
                request.setAttribute("FAILED_MESSAGE", "Add product fail");
            }
            
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
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
