/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.SignUp;



import DAL.AES;
import DAL.DAO;

import Models.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class XacNhanEmail extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        DAO dao=new DAO();
        
        HttpSession ses = request.getSession();
        Account a = (Account) ses.getAttribute("a");
        String code =(String)ses.getAttribute("code");
        String tag="XacNhanEmail";
        request.setAttribute("tag", tag);
        String Ucode = "";
        try {
            Ucode = request.getParameter("Ucode");

        } catch (Exception e) {
        }
        if (Ucode != null) {
            if (Ucode.equals(code)) {
                dao.SignUp(a.getUserName(), a.getPass(), Integer.toString(a.getGender()), a.getEmail(), a.getAdd(), a.getPhone(), "0");
                Account account = dao.Login(a.getUserName(),a.getPass());
                ses.setAttribute("account", account);
                response.sendRedirect("Main");
            }
            else{
                request.setAttribute("wrongText", "Ma xac nhan sai!");
                request.getRequestDispatcher("XacNhanEmail.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("XacNhanEmail.jsp").forward(request, response);
        }
        
//        out.print("CODE:"+code);
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
        processRequest(request, response);
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
