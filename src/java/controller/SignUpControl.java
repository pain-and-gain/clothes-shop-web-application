/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import entities.Account;
import entities.AccountError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
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
        try{
        String userID= request.getParameter("uID");
        String username= request.getParameter("username");
        String password= request.getParameter("pass");
        String repassword= request.getParameter("repass");
        boolean check=true;
        AccountError accError= new AccountError();
        if(!repassword.equals(password)){
            accError.setRepassError("It's different with password");
            check=false;
        }   
        
            
        if(password==null||password.trim().isEmpty()){
            accError.setPassError("Password can't null");
            check=false;
        }
        if(password.length()>10){
            accError.setPassError("Password must be less than 11 characters");
            check=false;
        }
        if(username==null||username.trim().isEmpty()){
            accError.setUsernameError("Username can't null");
            check=false;
        }
        if(userID==null|| userID.trim().isEmpty()){
            accError.setuIDError("UserID cann't null");
            check=false;
        }
        if(userID.length()>10){
            accError.setuIDError("UserID must be less than 11 characters");
            check=false;
        }
            DAO dao=new DAO();
                Account acc= dao.checkDuplicate(userID);
                if(acc!=null){
                   accError.setuIDError("UserID has been duplicated");
                   check=false;
                }
                if(check==true){
                    dao.SignUp(userID, username, password);
                   request.getRequestDispatcher("HomeControl").forward(request, response);
                }else{
                    request.setAttribute("Message", "Signup fail!");
                    request.setAttribute("AccError", accError);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
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
