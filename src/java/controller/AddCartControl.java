/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import dao.DAO;
import entities.CartItem;
import entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class AddCartControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("pid"));
            DAO dao = new DAO();
            Product p = dao.getProductById(id);

            if (session.getAttribute("Cart") == null) {
                List<CartItem> cart = new ArrayList<>();
                cart.add(new CartItem(p, 1));
                session.setAttribute("Cart", cart);
            } else {
                List<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("Cart");
                CartItem item = null;
                for (CartItem cartItem : cart) {
                    if ((cartItem.getProduct()).getId() == p.getId()) {
                        item = cartItem;
                        break;
                    }
                }

                if (item != null) {
                    int amount = item.getAmount();
                    item.setAmount(amount + 1);
                }
                if (item == null ){
                    item=new CartItem(p, 1);
                    cart.add(item);
                }

                session.setAttribute("Cart", cart);
            }
            
            
            request.getRequestDispatcher("HomeControl").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
