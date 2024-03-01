/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ryerson.lab3.helper;

import java.util.Date;

/**
 *
 * @author andrewsudyk
 */
public class Movie {
    
    String movieName;
    int capacity;
    int age_rating;
    Date screeningDate;
    String genre;
    String viewing_option;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAge_rating() {
        return age_rating;
    }

    public void setAge_rating(int age_rating) {
        this.age_rating = age_rating;
    }

    public Date getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(Date screeningDate) {
        this.screeningDate = screeningDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getViewing_option() {
        return viewing_option;
    }

    public void setViewing_option(String viewing_option) {
        this.viewing_option = viewing_option;
    }

    public Movie(String movieName, int capacity, int age_rating, Date screeningDate, String genre, String viewing_option) {
        this.movieName = movieName;
        this.capacity = capacity;
        this.age_rating = age_rating;
        this.screeningDate = screeningDate;
        this.genre = genre;
        this.viewing_option = viewing_option;
    }
    
    
}
