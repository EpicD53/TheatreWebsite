package ryerson.lab3.gui;
import ryerson.lab3.helper.UserInfo;
import ryerson.lab3.persistence.User_CRUD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ryerson.lab3.helper.ticket;
import ryerson.lab3.helper.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username=request.getParameter("username"); //get username from 
        String password=request.getParameter("password"); //get password from form
        
        ryerson.lab3.helper.UserInfo uinfo= User_CRUD.read(username, password);
        
        // Check if user didn't enter anything
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || uinfo == null){
           RequestDispatcher rd= request.getRequestDispatcher("loginfailed.jsp");
           rd.forward(request, response);
            }
        
        try {
            
            String retrieved_username = uinfo.getUsername();
            String retrieved_password = uinfo.getPassword();

            
            if (retrieved_username.equals("admin") && retrieved_password.equals("123456")){
                request.getSession().setAttribute("uname", username);

                RequestDispatcher rd= request.getRequestDispatcher("movieManager.jsp");
                rd.forward(request, response);
                    
            } else if (retrieved_username.equals(username) && retrieved_password.equals(password)){
                request.getSession().setAttribute("uname", username);

                RequestDispatcher rd= request.getRequestDispatcher("usermovies.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd= request.getRequestDispatcher("loginfailed.jsp");
                rd.forward(request, response); 
            }
            
        } catch(Exception e) {
            System.out.println(e+ "no data");
        }

        
      
        
        
     
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

          doPost(request, response);

        
    }

}
