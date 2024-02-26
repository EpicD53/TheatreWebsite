package ryerson.lab3.helper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
/**
 *
 * @author student
 */
public class ticket {
    
    String movieName;
    int seatNumber;
    Date screeningDate;
   

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(Date screeningDate) {
        this.screeningDate = screeningDate;
    }


    /*
    To be completed
     */
    public ticket(String movieName, int seatNumber, Date screeningDate) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.screeningDate = screeningDate;
    }

    
}
