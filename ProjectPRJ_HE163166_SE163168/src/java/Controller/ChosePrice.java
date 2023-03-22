/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAO;
import Models.Product;
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
public class ChosePrice extends HttpServlet {

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
        DAO dao = new DAO();
        String txt = request.getParameter("txt");
        if(txt.equals("1")){
            dao.ChosePriceProduct(0, 500);
        }
        if(txt.equals("2")){
            dao.ChosePriceProduct(500, 1000);
        }
        if(txt.equals("3")){
            dao.ChosePriceProduct(1000,99999);
        }
        if(txt.equals("def")){
            dao.LoadProduct();
        }
        
        for (Product o : dao.getProduct()) {

            out.println("<div class=\"col-12 col-md-6 col-lg-3 mb-4 category_right_content_item\">\n"
                    + "                                        <div class=\"card\">\n"
                    + "                                            <a href=\"item?pid=" + o.getId() + "\" title=\"View Product\"><img class=\"card-img-top\" src=\"image/" + o.getImage() + "\" alt=\"Card image cap\"></a>\n"
                    + "\n"
                    + "                                            <div class=\"card-body\">\n"
                    + "                                                <h4 class=\"card-title show_txt\"><a href=\"item?pid=" + o.getId() + "\" title=\"View Product\">" + o.getName() + "</a></h4>\n"
                    + "                                                <p class=\"card-text show_txt\"></p>\n"
                    + "                                                <div class=\"row\">\n"
                    + "                                                    <div class=\"col\">\n"
                    + "\n"
                    + "                                                        <a href=\"item?pid=" + o.getId() + "\" title=\"View Product\"><p class=\"btn btn-danger btn-block\">" + o.getPrice() + "$</p></a>\n"
                    + "                                                    </div>\n"
                    + "\n"
                    + "                                                </div>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>");
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
