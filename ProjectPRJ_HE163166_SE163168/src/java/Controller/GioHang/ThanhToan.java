/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.GioHang;

import DAL.DAO;
import Models.Account;
import Models.GioHang;
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
public class ThanhToan extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        HttpSession ses = request.getSession();
        Account a = (Account) ses.getAttribute("account");
        DAO dao = new DAO();
        dao.LoadGioHangByUser(a.getUserName());

        request.setAttribute("email", a.getEmail());
        request.setAttribute("add", a.getAdd());
        request.setAttribute("phone", a.getPhone());
        request.setAttribute("successText", "Dat Hang Thanh Cong");

        String Email = request.getParameter("email");
        String add = request.getParameter("add");
        String phone = request.getParameter("phone");

        String mess = "Cam on ban da mua hang ben shop minh <3, don hang cua ban se duoc giao vao dia chi: \n"
                + "Adress:"+add+" \n"
                + "Phone:"+phone+" \n"
                + "\n"
                + "Chi Tiet Don Hang:";
        double Total=0;
        for (GioHang o : dao.getGiohang()) {
            Total+=o.getQuantity()*o.getPprice();
            mess+="Ten: "+o.getPname()+"   So Luong: "+o.getQuantity()+"    Gia: "+o.getPprice()+"$\n";
            dao.AddOrderDetail(o.getPid(), o.getQuantity());
            dao.XoaGioHang(Integer.toString(o.getPid()));
        }
        mess+="Tong Tien: "+Total+"$";
        dao.SendMail(Email, "Chi Tiet Don Hang", mess, "vinhnqhe163166@fpt.edu.vn", "vinhvip123");
        dao.AddOrder(a.getUserName());
        request.getRequestDispatcher("Adress_ThanhToan.jsp").forward(request, response);
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
