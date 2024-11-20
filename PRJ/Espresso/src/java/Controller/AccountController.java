/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import Entity.Account;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "AccountController", urlPatterns = {"/account/*"})
public class AccountController extends HttpServlet {

    private static final String VIEW_PATH = "/WEB-INF/account/";
    private static final String UPLOAD_DIRECTORY = "uploads/usersProfile";

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

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Account userSession = (Account) session.getAttribute("acc");
        AccountDAO accountDAO;
        Account account;

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Action not specified");
        }

        String action = pathInfo.substring(1);

        switch (action) {
            case "general":

                try {
                    accountDAO = new AccountDAO();

                    // Get Account Info logic
                    Account getAccountInfo = accountDAO.getDataById(userSession);
                    request.setAttribute("getAccountInfo", getAccountInfo);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher(VIEW_PATH + "editUser.jsp").forward(request, response);
                break;

            case "profile":

                try {
                    accountDAO = new AccountDAO();
                    account = new Account();

                    Account getAccount = accountDAO.getDataById(account);
                    request.setAttribute("getAccount", getAccount);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.getRequestDispatcher(VIEW_PATH + "editProfile.jsp").forward(request, response);
                break;

            case "password":
                
                request.getRequestDispatcher(VIEW_PATH + "editPassword.jsp").forward(request, response);
                break;
                
            case "delete":
                
                request.getRequestDispatcher(VIEW_PATH + "deleteAccount.jsp").forward(request, response);
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
        
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Account userSession = (Account) session.getAttribute("acc");
        AccountDAO accountDAO;
        Account account;

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Action not specified");
        }

        String action = pathInfo.substring(1);

        switch (action) {
            case "general":
                
                // Get Parameters from jsp
                String lastName_raw = request.getParameter("lastName");
                String firstName_raw = request.getParameter("firstName");
                String birthday_raw = request.getParameter("birthday");
                boolean gender_raw = "1".equals(request.getParameter("gender"));
                String phone_raw = request.getParameter("phone");

                // Convert String to DateTimeFormat
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
                LocalDate convertedBirthdate = LocalDate.parse(birthday_raw, formatter);

                try {
                    accountDAO = new AccountDAO();
                    account = new Account();

                    account.setAccount(userSession.getAccount());
                    account.setPass(userSession.getPass());
                    account.setLastName(lastName_raw);
                    account.setFirstName(firstName_raw);
                    account.setBirthday(Date.valueOf(convertedBirthdate));
                    account.setGender(gender_raw);
                    account.setPhone(phone_raw);
                    account.setIsUse(userSession.isIsUse());
                    account.setRoleInSystem(userSession.getRoleInSystem());

                    // Update Account Info logic
                    int updatedAccount = accountDAO.updateData(account);

                    if (updatedAccount == 1) {
                        System.out.println("Update success");
                        request.setAttribute("updateSuccess", "Update account success");
                    } else {
                        System.out.println("Update failed");
                        request.setAttribute("updateFailed", "Update account failed");
                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.getRequestDispatcher(VIEW_PATH + "editUser.jsp").forward(request, response);
                break;
                
            case "profile":

                // File upload logic
                // 1. Get the file part from the request
                Part accountImage_raw = request.getPart("accountImage");
                String fileName = accountImage_raw.getSubmittedFileName();

                // 2. Define the upload path
                String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIRECTORY;

                // 3. Create upload directory if it's doesn't exist
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                // 4. Save the file on serber
                String filePath = uploadPath + File.separator + fileName;
                accountImage_raw.write(filePath);

                try {
                    accountDAO = new AccountDAO();
                    account = new Account();

                    account.setAccount(userSession.getAccount());
                    account.setPass(userSession.getPass());
                    account.setLastName(userSession.getLastName());
                    account.setFirstName(userSession.getFirstName());
                    account.setBirthday(userSession.getBirthday());
                    account.setGender(userSession.isGender());
                    account.setPhone(userSession.getPhone());
                    account.setIsUse(userSession.isIsUse());
                    account.setRoleInSystem(userSession.getRoleInSystem());
                    account.setAccountImage(UPLOAD_DIRECTORY + File.separator + fileName);

                    int updateAccount = accountDAO.updateData(account);

                    if (updateAccount == 1) {
                        request.setAttribute("SUCCESS_MESSAGE", "Update profile image success");
                    } else {
                        request.setAttribute("FAILED_MESSAGE", "Update profile image fail");
                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.getRequestDispatcher(VIEW_PATH + "editProfile.jsp").forward(request, response);
                break;
                
            case "password":
                
                try {
                    session = request.getSession();
                    Account userAccount = (Account) session.getAttribute("acc");

                    String old_password_raw = request.getParameter("old-password");
                    String new_password_raw = request.getParameter("new-password");

                    accountDAO = new AccountDAO();
                    account = new Account();

                    account.setAccount(userAccount.getAccount());
                    account.setPass(new_password_raw);
                    account.setFirstName(userAccount.getFirstName());
                    account.setLastName(userAccount.getLastName());
                    account.setBirthday(userAccount.getBirthday());
                    account.setGender(userAccount.isGender());
                    account.setIsUse(userAccount.isIsUse());
                    account.setPhone(userAccount.getPhone());
                    account.setRoleInSystem(userAccount.getRoleInSystem());

                    Account getAccountInfo = accountDAO.getDataById(account);

                    if (old_password_raw.equals(getAccountInfo.getPass())) {
                        if (!new_password_raw.equals(old_password_raw)) {
                            accountDAO.updateData(account);
                            request.setAttribute("updateSuccess", "Update password success");
                        } else {
                            request.setAttribute("newPassSameOldPass", "New password cannot be the same as old password");
                        }
                    } else {
                        request.setAttribute("sameOldPassError", "Your old password is incorrect");
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.getRequestDispatcher(VIEW_PATH + "editPassword.jsp").forward(request, response);
                break;
                
            case "delete":
                
                session = request.getSession();
                Account userAccount = (Account) session.getAttribute("acc");

                if (userAccount != null) {
                    try {
                        accountDAO = new AccountDAO();

                        account = new Account();
                        account.setAccount(userAccount.getAccount());

                        if (userAccount.isIsUse()) {
                            accountDAO.deleteData(account);
                            session.removeAttribute("acc");
                        } else {
                            System.out.println("The user already diactivate");
                        }

                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    System.out.println("No user account found in session.");
                }

                response.sendRedirect("/espresso/home");
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
