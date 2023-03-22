/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.SignUp;

import DAL.DAO;
import Models.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
public class SignUpControl extends HttpServlet {

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
        Boolean done=true;
        
        String Username = request.getParameter("user");
        String Pass = request.getParameter("pass");
        String RePass = request.getParameter("repass");
        String Gender = request.getParameter("gender");
        String Email = request.getParameter("email");
        String Add = request.getParameter("add");
        String Phone = request.getParameter("phone");
        
        request.setAttribute("user", Username);
        request.setAttribute("pass", Pass);
        request.setAttribute("repass", RePass);
        request.setAttribute("email", Email);
        request.setAttribute("add", Add);
        request.setAttribute("phone", Phone);
        request.setAttribute("gender", Gender);
        if(Username.isEmpty()){
            done=false;
            request.setAttribute("wrongText","UserName is empty!!!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if(Pass.isEmpty()){
            done=false;
            request.setAttribute("wrongText","Pass is empty!!!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if(Gender==null){
            done=false;
            request.setAttribute("wrongText","Gender is empty!!!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if(Email.isEmpty()){
            done=false;
            request.setAttribute("wrongText","Email is empty!!!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if(Add.isEmpty()){
            done=false;
            request.setAttribute("wrongText","Address is empty!!!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        
        if(Phone.isEmpty()){
            done=false;
            request.setAttribute("wrongText","Phone is empty!!!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
      
        if (!Pass.equals(RePass)) {
            done=false;
            request.setAttribute("wrongText", "Pass and RePass not same!!!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if (dao.checkUserExist(Username)) {
            done=false;
            request.setAttribute("wrongText", "This User already exist!!!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if (dao.checkEmailExist(Email)) {
            done=false;
            request.setAttribute("wrongText", "This Email already exist!!!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        if(done==true){
             Account a=new Account(Username, Pass,Integer.parseInt(Gender), Email, Add, Phone, 0);
        HttpSession ses=request.getSession();
        ses.setAttribute("a", a);
        String code=dao.getRandom();
//        request.setAttribute("code", code);
        ses.setAttribute("code", code);
        dao.SendMail(Email, "MA XAC NHAN DANG KY TAI KHOAN", code, "vinhnqhe163166@fpt.edu.vn", "vinhvip123");
//        request.setAttribute("a", a);
        
        request.getRequestDispatcher("XacNhanEmail").forward(request, response);
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
