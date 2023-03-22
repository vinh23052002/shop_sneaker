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
public class EditProduct extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        boolean done = true;
        dao.LoadCategory();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String image = request.getParameter("image");
        String cid = request.getParameter("cid");

        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("price", price);
        request.setAttribute("image", image);
        request.setAttribute("cid", cid);
        request.setAttribute("dao", dao);
//        out.println(id+" "+name+" "+price+" "+ image+" "+cid);
        if (name.isEmpty()) {
            request.setAttribute("wrongText", "Name is empty!!!");
            done = false;
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        }
        if (price.isEmpty()) {
            request.setAttribute("wrongText", "Price is empty!!!");
            done = false;
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        }
        if (image.isEmpty()) {
            request.setAttribute("wrongText", "Image is empty!!!");
            done = false;
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        }
        if (cid.isEmpty()) {
            request.setAttribute("wrongText", "Category is empty!!!");
            done = false;
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        }
        if(done=true){
            dao.UpdateProduct(id, name, price, image, cid);
            request.setAttribute("successText", "Update thanh cong");
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
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
