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
public class Movie {

    private int id;
    private String title;
    private String genre;
    private double price;

    //Constructor
    public Movie(String title, String genre, double price, int id) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public Movie() {
    }  
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", genre=" + genre + ", price=" + price + '}';
    }

}
