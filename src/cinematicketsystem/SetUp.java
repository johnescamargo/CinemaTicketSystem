/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinematicketsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Johnes
 */
public class SetUp {

    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void setMovies() {
        try {

            // Scanner to read the file.
            Scanner myScanner = new Scanner(new File("films.txt"));
            // Counter to keep track of where on the array we are.
            int i = 0;

            // The loop will repeat as long as there is lines to be read 
            // in the file.
            while (myScanner.hasNext()) {

                String line = myScanner.nextLine();
                String[] parts = line.split(";");
                String title = parts[0];
                String genre = parts[1];
                double price = Double.parseDouble(parts[2]);

                movies.add(new Movie(title, genre, price, (i + 11)));
               // System.out.println(movies.get(i));

                i++;

            } //end of loop

        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e);
            System.exit(1);
        }

    }

    

}
