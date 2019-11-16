/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinematicketsystem;

import java.util.ArrayList;

/**
 *
 * @author Johnes
 */
public class Order {

    private int id;
    private Movie movie;
    private double price;
    ArrayList<Integer> numOfTickets = new ArrayList<>();

    //Constructor
    public Order() {
    }

    public Order(int id, Movie movie, double price) {
        this.id = id;
        this.movie = movie;
        this.price = price;
    }

    
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumOfTickets(ArrayList<Integer> numOfTickets) {
        this.numOfTickets = numOfTickets;
    }

    //Getters
    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Integer> getNumOfTickets() {
        return numOfTickets;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", movie=" + movie + ", price=" + price + ", numOfTickets=" + numOfTickets + '}';
    }

}
