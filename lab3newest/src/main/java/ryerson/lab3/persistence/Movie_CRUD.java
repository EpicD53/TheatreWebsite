/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ryerson.lab3.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ryerson.lab3.helper.Movie;
import java.sql.Date;

/**
 *
 * @author andrewsudyk
 */
public class Movie_CRUD {
    
     private static Connection getCon(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS?zeroDateTimeBehavior=CONVERT_TO_NULL","root","student123");
            System.out.println("Connection established.");
        }catch(Exception e){System.out.println(e + "DENIED");}
        return con;
    }
     
        public static Movie read(String username, String password){
        Movie bean=null;
 
        return bean;
    }
    
    public static Movie create(String movieName, int capacity, int age_rating, Date screening_date, String genre, String viewing_option) {
        Movie bean = null;
        
            try {
            Connection con = getCon();
            String q = "INSERT INTO MOVIE (movie_name, capacity, age_rating, screening_date, genre, viewing_option) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, movieName);
            ps.setInt(2, capacity);
            ps.setInt(3, age_rating);
                java.sql.Date sqlDate = new java.sql.Date(screening_date.getTime()); //
            ps.setDate(4,sqlDate);
            ps.setString(5, genre);
            ps.setString(6, viewing_option);

            ps.executeUpdate();
            
            bean = new Movie(movieName, capacity, age_rating, screening_date, genre, viewing_option);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e + "create method didn't work");
        }
        return bean;
    }
}
