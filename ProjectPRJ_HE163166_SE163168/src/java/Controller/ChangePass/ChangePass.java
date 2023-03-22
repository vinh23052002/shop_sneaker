/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.ChangePass;

import DAL.DAO;
import Models.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import javafx.scene.control.Accordion;

/**
 *
 * @author asus
 */
public class ChangePass extends HttpServlet {

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
        DAO dao = new DAO();
        boolean done = true;
        HttpSession ses = request.getSession();
        Account a = (Account) ses.getAttribute("account");
        String pass = dao.decrypt(a.getPass(), "123");

        String Oldpass = request.getParameter("Oldpass");
        String Newpass = request.getParameter("Newpass");
        String Repass = request.getParameter("Repass");

        request.setAttribute("Oldpass", Oldpass);
        request.setAttribute("Newpass", Newpass);
        request.setAttribute("Repass", Repass);
        
         if(Newpass.isEmpty()){
            request.setAttribute("wrongText", "New Password is Empty !!");
            request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        }
        
        if(Repass.isEmpty()){
            request.setAttribute("wrongText", "Re Password is Empty !!");
            request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        }
        
        if (!Oldpass.equals(pass)) {
            done = false;
            request.setAttribute("wrongText", "Mat khau cu khong dung!!!");
            request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        }
        if (!Repass.equals(Newpass)) {
            done = false;
            request.setAttribute("wrongText", "New Password va Re PassWord khong giong nhau!!");
            request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        }
        if(Oldpass.equals(Newpass)){
            done = false;
            request.setAttribute("wrongText", "New Password va Old PassWord giong nhau!!");
            request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        }
        if (done == true) {
            String Ecode = dao.getRandom();
            ses.setAttribute("Ecode", Ecode);
            ses.setAttribute("Newpass", Newpass);
            dao.SendMail(a.getEmail(), "MA XAC NHAN DOI MAT KHAU", Ecode, "vinhnqhe163166@fpt.edu.vn", "vinhvip123");
            String tag = "XacNhanEmail_ChangePass";
            request.setAttribute("tag", tag);
            request.getRequestDispatcher("XacNhanEmail.jsp").forward(request, response);
        }
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
