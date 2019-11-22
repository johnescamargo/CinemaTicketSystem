/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinematicketsystem;

/**
 *
 * @author Johnes
 */
public class Order {

    private int id;
    private Movie movie;
    private double price;
    private int numOfTickets;

    //Constructor
    public Order() {
    }

    /**
     *
     * @author Johnes
     * @param id
     * @param movie
     * @param price
     * @param numOfTickets
     */
    public Order(int id, Movie movie, double price, int numOfTickets) {
        this.id = id;
        this.movie = movie;
        this.price = price;
        this.numOfTickets = numOfTickets;
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

    public void setNumOfTickets(int numOfTickets) {
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

    /**
     *
     * 
     * @param price1
     * @return 
     */
    public String getPriceString(double price1) {
        String price2 = Double.toString(price1);

        if (price2.length() > 4) {
            price2 = price2.substring(0, 4);
            return price2;
        }
        return price2;

    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    @Override
    public String toString() {
        return "Order Id: " + id + "\n"
                + "Movie: " + movie.getTitle() + "\n"
                + "Number of Tickets: " + numOfTickets + "\n"
                + "Total Price: €" + getPriceString(price) + "\n"
                + "____________________________________________" + "\n";
    }

}
