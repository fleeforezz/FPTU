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
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
@WebServlet(name = "ManagerDashboardController", urlPatterns = {"/manager/*"})
public class ManagerDashboardController extends HttpServlet {

    private static final String VIEW_PATH = "/WEB-INF/manager/";
    private static final String UPLOAD_DIRECTORY = "uploads";

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

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Action not specified");
        }

        String action = pathInfo.substring(1);

        switch (action) {
            case "dashboard":
                HttpSession session = request.getSession();

                Account userSession = (Account) session.getAttribute("acc");

                ProductDAO productDAO;
                try {
                    productDAO = new ProductDAO();

                    List<Product> listProduct = productDAO.listProductByAccountName(userSession.getAccount());
                    int listSize = listProduct.size();

                    int sumOfUnit = 0;

                    for (Product product : listProduct) {
                        sumOfUnit += Integer.parseInt(product.getUnit());
                    }

                    request.setAttribute("sumOfUnit", sumOfUnit);
                    request.setAttribute("listSize", listSize);
                    request.setAttribute("listProduct", listProduct);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ManagerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher(VIEW_PATH + "managerDash.jsp").forward(request, response);
                break;
            case "add":
                try {
                    CategoryDAO categoryDAO = new CategoryDAO();
                    List<Category> listProductCategory = (List<Category>) categoryDAO.listAll();

                    request.setAttribute("listProductCategory", listProductCategory);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ManagerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher(VIEW_PATH + "addProduct.jsp").forward(request, response);
                break;
            case "edit":
                break;
            case "delete":
                String productId_raw = request.getParameter("ProductId");
                try {
                    productDAO = new ProductDAO();
                    Product product = new Product();
                    product.setProductId(productId_raw);

                    productDAO.deleteData(product);

                    response.sendRedirect("dashboard");
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ManagerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Action not specified");
        }

        String action = pathInfo.substring(1);

        switch (action) {
            case "add":
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
                String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIRECTORY;

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
                    product.setProductImage(UPLOAD_DIRECTORY + File.separator + fileName);
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

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ManagerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher(VIEW_PATH + "addProduct.jsp").forward(request, response);
                break;
            case "edit":
                break;
            case "delete":
                break;
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
