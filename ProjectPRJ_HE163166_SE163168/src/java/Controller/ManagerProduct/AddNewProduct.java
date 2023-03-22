/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.ManagerProduct;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class AddNewProduct extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       DAO dao=new DAO();
        String id=request.getParameter("id");
        String Name=request.getParameter("name");
        String Price=request.getParameter("price");
        String Image=request.getParameter("image");
        String Cid=request.getParameter("cid");
        
        request.setAttribute("id", id);
        request.setAttribute("name", Name);
        request.setAttribute("price", Price);
        request.setAttribute("image", Image);
        request.setAttribute("cid", Cid);
        
        if(id.isEmpty()){
            request.setAttribute("wrongText","ID is empty!!!");
            request.getRequestDispatcher("AddNewProduct.jsp").forward(request, response);
        }
        if(dao.CheckIdExist(id)){
            request.setAttribute("wrongText","ID is Exist!!!");
            request.getRequestDispatcher("AddNewProduct.jsp").forward(request, response);
        }
        
        if(Name.isEmpty()){
            request.setAttribute("wrongText","Name is empty!!!");
            request.getRequestDispatcher("AddNewProduct.jsp").forward(request, response);
        }
        if(Price.isEmpty()){
            request.setAttribute("wrongText","Price is empty!!!");
            request.getRequestDispatcher("AddNewProduct.jsp").forward(request, response);
        }
        if(Image.isEmpty()){
            request.setAttribute("wrongText","Image is empty!!!");
            request.getRequestDispatcher("AddNewProduct.jsp").forward(request, response);
        }
        if(Cid.isEmpty()){
            request.setAttribute("wrongText","Cid is empty!!!");
            request.getRequestDispatcher("AddNewProduct.jsp").forward(request, response);
        }
        
        dao.AddNewProduct(id, Name, Price, Image, Cid);
        request.setAttribute("successText", "Add Successful!!!");
        request.getRequestDispatcher("AddNewProduct.jsp").forward(request, response);
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
