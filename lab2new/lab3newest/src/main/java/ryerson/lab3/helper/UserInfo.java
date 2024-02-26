package ryerson.lab3.helper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author student
 */
public class UserInfo {
    
    int age;
    String firstname;
    String lastname;
    String address;
    String email;
    String username;
    String password;

    public UserInfo(int age, String firstname, String lastname, String address, String email, String username, String password) {
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirtsname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /*to be completed
    For now, we just add book info to make the example work. This class must be completed in future
    */
    private ArrayList <ticket> tickets = new ArrayList<>(); //stores all the tickets the user may have
    
    public void addTicket(ticket ticket){
        tickets.add(ticket);
    }
    public ArrayList<ticket> getTicket(){
        return tickets;
    }
    
}
