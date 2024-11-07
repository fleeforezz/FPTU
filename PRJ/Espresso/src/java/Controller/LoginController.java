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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jso
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        HttpSession session = request.getSession();

        String username_raw = request.getParameter("account");
        String password_raw = request.getParameter("pass");
        String remember_me_raw = request.getParameter("remember");
        
        // Need to save 3 cookies: username, password, remember-me
        Cookie username_cookie = new Cookie("username_cookie", username_raw);
        Cookie password_cookie = new Cookie("password_cookie", password_raw);
        Cookie remember_cookie = new Cookie("remember_cookie", remember_me_raw);
        
        if (remember_me_raw != null) {
            username_cookie.setMaxAge(60*60*24*7); // Save 7 days
            password_cookie.setMaxAge(60*60*24*7); // Save 7 days
            remember_cookie.setMaxAge(60*60*24*7); // Save 7 days
        } else {
            username_cookie.setMaxAge(0); // Save 7 days
            password_cookie.setMaxAge(0); // Save 7 days
            remember_cookie.setMaxAge(0); // Save 7 days
        }
        
        response.addCookie(username_cookie);
        response.addCookie(password_cookie);
        response.addCookie(remember_cookie);
        

        AccountDAO accountDAO;
        try {
            accountDAO = new AccountDAO();

            Account loginAccount = accountDAO.getData(username_raw, password_raw);

            if (loginAccount != null) {
                if (loginAccount.isIsUse()) {
                    session.setAttribute("acc", loginAccount);
                    response.sendRedirect("home");
                } else {
                    request.setAttribute("ErrorMessage", "Incorrect username or password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                
            } else {
                request.setAttribute("ErrorMessage", "Incorrect username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
