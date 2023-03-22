/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.ForgetPass;

import DAL.DAO;
import Models.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
public class ForgetPass_ChangePass extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       DAO dao=new DAO();
        HttpSession ses=request.getSession();
        String Fuser=(String)ses.getAttribute("Fuser");
        Account a=dao.LoadAccountByUser(Fuser);
        
        String Newpass= request.getParameter("Newpass");
        String Repass= request.getParameter("Repass");
        
        request.setAttribute("Newpass", Newpass);
        request.setAttribute("Repass", Repass);
        
       
        if(Newpass.isEmpty()){
            request.setAttribute("wrongText", "New Password is Empty !!");
            request.getRequestDispatcher("ForgetPass_ChangePass.jsp").forward(request, response);
        }
        
        if(Repass.isEmpty()){
            request.setAttribute("wrongText", "Re Password is Empty !!");
            request.getRequestDispatcher("ForgetPass_ChangePass.jsp").forward(request, response);
        }
        
        if(!Repass.equals(Newpass)){
            request.setAttribute("wrongText", "New Password va Re PassWord khong giong nhau!!");
            request.getRequestDispatcher("ForgetPass_ChangePass.jsp").forward(request, response);
        }
        else{
            dao.ChangePassword(Newpass, Fuser);
            a=dao.LoadAccountByUser(Fuser);
            ses.setAttribute("account", a);
            response.sendRedirect("Main");
        }
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
