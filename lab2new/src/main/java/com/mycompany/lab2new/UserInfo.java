package com.mycompany.lab2new;

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
