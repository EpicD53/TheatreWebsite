/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ryerson.lab3.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ryerson.lab3.helper.ticket;
import java.util.Date;

/**
 *
 * @author andrewsudyk
 */
public class Ticket_CRUD {
     private static Connection getCon(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS?zeroDateTimeBehavior=CONVERT_TO_NULL","root","student123");
            System.out.println("Connection established.");
        }catch(Exception e){System.out.println(e + "DENIED");}
        return con;
    }
    
    public static ticket read(String username){
ticket bean = null;
    // Declare variables at the method level
    int seatNumber = 0;
    String movieName = "";
    int ticket_id = 0;
    int screening_id = 0;
    Date screeningDate = null;

    try {
        Connection con = getCon();
        String q = "SELECT * FROM TICKET WHERE username like '" + username + "'";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Assign values to variables
            seatNumber = rs.getInt("seatnumber");
            movieName = rs.getString("movie_name");
            ticket_id = rs.getInt("ticket_id");
            screening_id = rs.getInt("screening_id");
        }

        String x = "SELECT * FROM MOVIE WHERE screening_id like '" + screening_id + "'";
        PreparedStatement pss = con.prepareStatement(x);
        ResultSet rss = pss.executeQuery();

        if (rss.next()) {
            // Retrieve the date from the ResultSet
            java.sql.Date sqlDate = rss.getDate("screening_date");
            // Convert sqlDate to java.util.Date
            screeningDate = sqlDate != null ? new Date(sqlDate.getTime()) : null;
        }

        // Use the variables here to create a ticket object
        bean = new ticket(movieName, seatNumber, screeningDate);
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    return bean;
}
}
