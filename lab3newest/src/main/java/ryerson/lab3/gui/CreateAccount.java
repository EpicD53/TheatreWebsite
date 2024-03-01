/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.CreateAccount to edit this template
 */
package ryerson.lab3.gui;

/**
 *
 * @author saadusmani
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import ryerson.lab3.persistence.User_CRUD;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int age = Integer.parseInt(request.getParameter("age"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(User_CRUD.usernameExists(username) || User_CRUD.emailExists(email)) {
            RequestDispatcher rd= request.getRequestDispatcher("AccountExists.jsp");
            rd.forward(request, response);
        } else {
        
        ryerson.lab3.helper.UserInfo uinfo = User_CRUD.create(firstname, lastname, email, address, age, username, password);
        
        request.getSession().setAttribute("uname", username);
            
        RequestDispatcher rd= request.getRequestDispatcher("AccountCreated.jsp");
        rd.forward(request, response);
        }
    }
}
