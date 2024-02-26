package ryerson.lab3.persistence;

import ryerson.lab3.helper.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_CRUD {

    private static Connection getCon(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false","root","student");
            System.out.println("Connection established.");
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static UserInfo read(String username, String password){
        UserInfo bean=null;
        try{
            Connection con=getCon();

            String q = "select * from USER WHERE username LIKE '" + username + "'"; 
                //write a statement for SQL

            PreparedStatement ps=con.prepareStatement(q);
                //PreparedStatement: Precompiled statement for the JDBC driver
            
            ResultSet rs=ps.executeQuery(); 
                //ResultSet: the row in the database
                //execute the query ps we wrote previously  
            if(rs.next()){
                //bean= new UserInfo();
                int age=rs.getInt("age");
                String firstname=rs.getString("firstname");
                String lastname=rs.getString("lastname");
                String address=rs.getString("address");
                String email=rs.getString("email");
                //skip username
                String pass=rs.getString("password");

                if (pass.equals(password)){
                    bean = new UserInfo(age, firstname, lastname, address, email, username, password);
                }
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return bean;
    }
}
