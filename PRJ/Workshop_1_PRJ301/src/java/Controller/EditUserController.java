/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import Entity.Account;
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

/**
 *
 * @author jso
 */
@WebServlet(name = "EditUserController", urlPatterns = {"/editUser"})
public class EditUserController extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");
        // Get User Account from session
        HttpSession session = request.getSession();
        Account userSession = (Account) session.getAttribute("acc");

        // Get Paramenter from jsp
        String lastName_raw = request.getParameter("lastName");
        String firstName_raw = request.getParameter("firstName");
        boolean gender_raw = "1".equals(request.getParameter("gender"));
        String birthday_raw = request.getParameter("birthday");
        // Convert String to DateTimeFormat
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
//        LocalDate convertedBirthdate = LocalDate.parse(birthday_raw, formatter);
        String phone_raw = request.getParameter("phone");
        
        
        AccountDAO accountDAO = new AccountDAO();
        Account account = new Account();
//        account.setAccount(userSession.getAccount());
        account.setAccount(userSession.getAccount());
        account.setPass(userSession.getPass());
        account.setFirstName(firstName_raw);
        account.setLastName(lastName_raw);
//        account.setBirthday(Date.valueOf(convertedBirthdate));
        account.setPhone(phone_raw);
        account.setGender(gender_raw);
        account.setIsUse(userSession.isIsUse());
        account.setRoleInSystem(userSession.getRoleInSystem());
        
        
        // Get Account Info logic
        Account getAccountInfo = accountDAO.getDataById(account);
        request.setAttribute("getAccountInfo", getAccountInfo);
        
        // Update Account Info logic
        accountDAO.updateData(account);
        
        request.getRequestDispatcher("editUser.jsp").forward(request, response);
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
            Logger.getLogger(EditUserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditUserController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditUserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditUserController.class.getName()).log(Level.SEVERE, null, ex);
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
