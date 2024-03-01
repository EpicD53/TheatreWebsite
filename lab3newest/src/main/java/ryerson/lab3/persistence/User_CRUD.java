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
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS?zeroDateTimeBehavior=CONVERT_TO_NULL","root","student123");
            System.out.println("Connection established.");
        }catch(Exception e){System.out.println(e + "DENIED");}
        return con;
    }

    public static UserInfo read(String username, String password){
        UserInfo bean=null;
        try{
            Connection con=getCon();

            String q = "SELECT * FROM USER WHERE username like '" + username + "'"; 
                //write a statement for SQL

            PreparedStatement ps=con.prepareStatement(q);
                //PreparedStatement: Precompiled statement for the JDBC driver
            
            ResultSet rs=ps.executeQuery(); 
                //ResultSet: the row in the database
                //execute the query ps we wrote previously  
            if(rs.next()){

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
        }catch(Exception e){
            System.out.println(e);}
        return bean;
    }
    
    public static UserInfo create(String firstname, String lastname, String email, String address, int age, String username, String password) {
        UserInfo bean = null;
        
            try {
            Connection con = getCon();
            String q = "INSERT INTO USER (firstname, lastname, email, address, age, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setInt(5, age);
            ps.setString(6, username);
            ps.setString(7, password);

            ps.executeUpdate();
            
            bean = new UserInfo(age, firstname, lastname, address, email, username, password);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e + "create method didn't work");
        }
        return bean;
    }
        public static boolean usernameExists(String username) {
        // Logic to query the database and check if a user with 'username' exists
        UserInfo bean = null;
        Connection con=getCon();
        
        try{
        
            String q = "SELECT * FROM USER WHERE username like '" + username + "'"; 
                    //write a statement for SQL

            PreparedStatement ps=con.prepareStatement(q);
                    //PreparedStatement: Precompiled statement for the JDBC driver

            ResultSet rs=ps.executeQuery(); 
                    //ResultSet: the row in the database
                    //execute the query ps we wrote previously

            if(rs.next()) {
                //a record of this username was found
                con.close();
                return true;
            } else {
                //no record found
                con.close();
                return false;
            }

        }catch(Exception e){
            System.out.println(e);}
        return false; //cannot gurantee a record was found
        }
        
        public static boolean emailExists(String email) {
        // Logic to query the database and check if a user with 'email' exists
        UserInfo bean = null;
        Connection con=getCon();
        
        try{
        
            String q = "SELECT * FROM USER WHERE email like '" + email + "'"; 
                    //write a statement for SQL

            PreparedStatement ps=con.prepareStatement(q);
                    //PreparedStatement: Precompiled statement for the JDBC driver

            ResultSet rs=ps.executeQuery(); 
                    //ResultSet: the row in the database
                    //execute the query ps we wrote previously

            if(rs.next()) {
                //a record of this email was found
                con.close();
                return true;
            } else {
                //no record found
                con.close();
                return false;
            }

        }catch(Exception e){
            System.out.println(e);}
        return false; //cannot gurantee a record was found
        }
        
}
