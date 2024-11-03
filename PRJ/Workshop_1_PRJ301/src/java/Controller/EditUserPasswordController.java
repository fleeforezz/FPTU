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
import java.sql.SQLException;
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
@WebServlet(name = "EditUserPasswordController", urlPatterns = {"/editPassword"})
public class EditUserPasswordController extends HttpServlet {

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
        request.getRequestDispatcher("editPassword.jsp").forward(request, response);
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
            HttpSession session = request.getSession();
            Account userAccount = (Account) session.getAttribute("acc");
            
            String old_password_raw = request.getParameter("old-password");
            String new_password_raw = request.getParameter("new-password");
            
            AccountDAO accountDAO = new AccountDAO();
            Account account = new Account();
            
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
                    request.getRequestDispatcher("editPassword.jsp").forward(request, response);
                } else {
                    request.setAttribute("newPassSameOldPass", "New password cannot be the same as old password");
                    request.getRequestDispatcher("editPassword.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("sameOldPassError", "Your old password is incorrect");
                request.getRequestDispatcher("editPassword.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EditUserPasswordController.class.getName()).log(Level.SEVERE, null, ex);
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
