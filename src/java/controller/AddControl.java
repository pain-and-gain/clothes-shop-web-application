/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import entities.Account;
import entities.Category;
import entities.Product;
import entities.ProductError;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AddControl extends HttpServlet {

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
        try{
        request.setCharacterEncoding("UTF-8");
        String name= request.getParameter("name");
        String image= request.getParameter("image");
        String description= request.getParameter("description");
        String title= request.getParameter("title");
        double price= Double.parseDouble(request.getParameter("price"));
        String category= request.getParameter("category");
        ProductError err= new ProductError();
        boolean check=true;
        DAO dao= new DAO();
                if(name==null|| name.trim().isEmpty()){
            err.setNameError("Product's name can't null");
            check=false;
        }
        if(name.length()>=100){
            err.setNameError("Product's name must be less than 100 charactes");
            check=false;
        }
        if(image==null|| name.trim().isEmpty()){
            err.setImageError("Image can't null");
            check=false;
        }
        if(title.length()>=100){
            err.setTitleError("Title must be less than 100 characters");
            check=false;
        }
        if(price<=0){
            err.setPriceError("Price must be >0");
            check=false;
        }
            List<Category> listC= dao.getAllCategory();
            request.setAttribute("listC", listC);
        if(check==true){
        HttpSession session= request.getSession();
        Account acc= (Account) session.getAttribute("acc");
        dao.AddProduct(name, image, price, title, description,category);
        response.sendRedirect("ManagerControl");
        }else{
            request.setAttribute("AddErrorMSG", err);
            request.getRequestDispatcher("Add.jsp").forward(request, response);
        }
        }catch(Exception e){
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
