/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.ManagerAccount;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebServlet(name = "EditAccount", urlPatterns = {"/EditAccount"})
public class EditAccount extends HttpServlet {

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
        String Username = request.getParameter("user");
        String Pass = request.getParameter("pass");
        String Gender = request.getParameter("gender");
        String Email = request.getParameter("email");
        String Add = request.getParameter("add");
        String Phone = request.getParameter("phone");
        String Roll = request.getParameter("roll");

        request.setAttribute("user", Username);
        request.setAttribute("pass", Pass);
        request.setAttribute("email", Email);
        request.setAttribute("add", Add);
        request.setAttribute("phone", Phone);
        request.setAttribute("gender", Gender);
        request.setAttribute("roll", Roll);

        if (Pass.isEmpty()) {
            request.setAttribute("wrongText", "Pass is empty!!!");
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        }
        if (Gender == null) {
            request.setAttribute("wrongText", "Gender is empty!!!");
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        }
        if (Email == null) {
            request.setAttribute("wrongText", "Email is empty!!!");
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        }
        if (Add.isEmpty()) {
            request.setAttribute("wrongText", "Address is empty!!!");
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        }

        if (Roll == null) {
            request.setAttribute("wrongText", "Roll is empty!!!");
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        }

        if (dao.checkEmailExist(Email)) {
            if (!dao.LoadAccountByUser(Username).getEmail().equals(Email)) {
                request.setAttribute("wrongText", "This Email already exist!!!");
                request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
            }
        }

        dao.UpdateAccount(Username, Pass, Gender, Email, Add, Phone, Roll);
        request.getRequestDispatcher("Account").forward(request, response);
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
