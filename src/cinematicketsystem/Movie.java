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
    private int ageRating;

    /**
     * Constructor
     *
     * @param title
     * @param genre
     * @param price
     * @param id
     * @param ageRating
     */
    public Movie(String title, String genre, double price, int id, int ageRating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.ageRating = ageRating;
    }

    //Constructor
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

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
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

    public int getAgeRating() {
        return ageRating;
    }

    @Override
    public String toString() {
        return "Movie:" + "\n"
                + "Id: " + id + "\n"
                + "Title: " + title + "\n"
                + "Genre: " + genre + "\n"
                + "Age Rating: " + ageRating + "\n"
                + "Price: €" + price + "\n"
                + "_______________________________________________________";
    }

}
