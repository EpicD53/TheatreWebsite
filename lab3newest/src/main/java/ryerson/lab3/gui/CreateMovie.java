/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ryerson.lab3.gui;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ryerson.lab3.persistence.Movie_CRUD;
import ryerson.lab3.helper.Movie;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author andrewsudyk
 */
@WebServlet(name = "CreateMovie", urlPatterns = {"/CreateMovie"})
public class CreateMovie extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateMovie</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateMovie at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        String movieName = request.getParameter("moviename");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        int age_rating = Integer.parseInt(request.getParameter("agerating"));
        String genre = request.getParameter("genre");
        String viewing_option = request.getParameter("viewingoption");
       // Format should match the format of the date input in the form.
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sqlScreeningDate = null;
            try {
                // Parse the date string from the form
                Date screening_date = formatter.parse(request.getParameter("screeningdate"));
                // Convert from java.util.Date to java.sql.Date
                sqlScreeningDate = new java.sql.Date(screening_date.getTime());
                Movie_CRUD.create(movieName, capacity, age_rating, sqlScreeningDate, genre, viewing_option);
            } catch (ParseException e) {
                // Handle the case where the date is not in the expected format
                e.printStackTrace();
                // Perhaps set a default value for sqlScreeningDate or handle the error appropriately
                 //sqlScreeningDate = new java.sql.Date(System.currentTimeMillis());
            }
            
        
            Movie movie = Movie_CRUD.create(movieName, capacity, age_rating, sqlScreeningDate, genre, viewing_option);
            
            RequestDispatcher rd= request.getRequestDispatcher("movieManager.jsp");
            rd.forward(request, response);
        
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
