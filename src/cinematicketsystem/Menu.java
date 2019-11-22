/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinematicketsystem;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import java.util.Scanner;

/**
 *
 * @author Johnes
 */
public class Menu {

    //Global variables
    Scanner scan = new Scanner(System.in);
    int id = 1;// variable that increments id in Order (Java Class) 

    /**
     *
     * @param movies
     * @param orders
     * @throws java.lang.Exception
     */
    public void mainMenu(ArrayList<Movie> movies, ArrayList<Order> orders) throws Exception {
        String choice = "w";

        do {
            System.out.println("________________________________________________");
            System.out.println("Welcome to the Cinema" + "\n");
            System.out.println("Option 1: Create a new Order");
            System.out.println("Option 2: List of Films");
            System.out.println("Option 3: View previous Orders");
            System.out.println("Option 4: Quit Program");
            System.out.println("________________________________________________");
            choice = scan.next();

            switch (choice) {
                //-------------------------------------------------------------------                        
                case "1": //1: Create a new Order
                    createOrder(movies, orders);
                    break;

                case "2": //1: List of Films
                    listOfFilms(movies);
                    break;

                case "3": //1: View previous Orders
                    viewPreviousOrders(orders);
                    break;

                case "4": //1: Quit Program
                    do {
                        System.out.println("Are you sure you want to quit?");
                        System.out.println("Type ('y'/Yes or 'n'/No) ");
                        choice = scan.next();
                        if (choice.equals("y") || choice.equals("n")) {
                            if (choice.equals("n")) {
                                mainMenu(movies, orders);
                                break;
                            } else {
                                System.out.println("Exiting...");
                                System.exit(0);
                            }

                        } else {
                            System.out.println("You chose and invalid option. Please, "
                                    + "try again.\n");
                        }

                    } while (!choice.equals("y") || !choice.equals("n"));

                default:
                    System.out.println("You chose and invalid option. Please, "
                            + "try again.\n");
                    break;

            }

        } while (!choice.equals("0"));

    }

    /**
     * Method that creates a new order and save it into ArrayList of orders
     *
     * @param movies - receives ArrayList of films
     * @param orders - receives ArrayList of orders
     * @throws java.lang.Exception
     */
    public void createOrder(ArrayList<Movie> movies, ArrayList<Order> orders) throws Exception {
        String spare = "w";
        String spare1 = "w";
        int numOfTickets = 0;
        Movie movie = new Movie();

        do {
            //Print films in the console 
            for (int i = 0; i < movies.size(); i++) {
                System.out.println(movies.get(i).toString());
            }

            System.out.println("Choose a film. Type in its ID");
            spare = scan.next();
            spare1 = "q";
            for (int i = 0; i < movies.size(); i++) {
                String movieId = Integer.toString(movies.get(i).getId());
                if (movieId.equals(spare)) {
                    movie = movies.get(i);//save an instance of Movie
                    System.out.println("This film has am age rating of "
                            + "classification: " + movie.getAgeRating());
                    if (movie.getAgeRating() != 0) {//advising users about the age rating
                        System.out.println("Be aware that just people over "
                                + movie.getAgeRating() + " are allowed to watch this film");
                    }
                    spare1 = "o";
                    break;
                }
            }

        } while (!spare1.equals("o"));

        //Do-while loop to certificate that the number of tickets is correct
        do {
            spare1 = "w";
            System.out.println("Type in the number of tickets you need");
            spare = scan.next();

            if ("1".equals(spare)) {
                numOfTickets = Integer.parseInt(spare);
                break;
            } else if ("2".equals(spare)) {
                numOfTickets = Integer.parseInt(spare);
                break;
            } else if ("3".equals(spare)) {
                numOfTickets = Integer.parseInt(spare);
                break;
            } else if ("4".equals(spare)) {
                numOfTickets = Integer.parseInt(spare);
                break;
            } else if ("5".equals(spare)) {
                numOfTickets = Integer.parseInt(spare);
                break;
            } else if ("6".equals(spare)) {
                numOfTickets = Integer.parseInt(spare);
                break;
            } else {
                System.out.println("Wrong Input");
                System.out.println("6 is the max number of Tickets that is allowed per person ");
            }

        } while (!spare1.equals("o"));
        

        int[] ageCustomers = new int[numOfTickets];
        double[] discountCustomers = new double[numOfTickets];

       // Do-while loop to certificate that the age is correct
        do {

            int var = 0;

            spare1 = "o";
            for (int i = 0; i < ageCustomers.length; i++) {

                int personNum = i + 1;
                System.out.println("What is the age of person number " + personNum + "?");
                var = tryCatchNumber();//Call method and save variable

                if (var > 0) {
                    if (var >= movie.getAgeRating()) {
                        ageCustomers[i] = var;
                    } else {
                        System.out.println("This Person is not allowed to watch this film");
                        System.out.println("Would you like to return to Menu?");
                        System.out.println("Type ('y'/Yes or 'n'/No) ");
                        spare = scan.next();
                        if (spare.equals("y")) {
                            System.out.println("No order has been taken. Exiting...");
                            mainMenu(movies, orders);//Come back to Main menu
                        } else {
                            i--;
                        }
                    }
                } else {
                    System.out.println(var + " is not an a valid age. Try again " + "\n");
                    i--;
                }

                if (i == numOfTickets) {
                    spare1 = "o";
                    break;
                }

            }

        } while (!spare1.equals("o"));
        
        

        System.out.println("Calculating the discount");
        //Calculating the discount for customers
        double moviePrice = movie.getPrice();
        double totalPrice = 0;
        for (int x = 0; x < ageCustomers.length; x++) {
            int d = ageCustomers[x];

            if (d >= 0 && d <= 12) { // 40% discount
                double res = moviePrice * 40;
                res = res / -100;
                res = res + moviePrice;
                discountCustomers[x] = res;
                System.out.println("40% of Discount for the person number: " + (x + 1));
            } else if (d >= 13 && d <= 64) {
                discountCustomers[x] = moviePrice;//normal price
                System.out.println("Normal price for the person number: " + (x + 1));
            } else {
                discountCustomers[x] = moviePrice;//20% discount
                double res = moviePrice * 20;
                res = res / -100;
                res = res + moviePrice;
                discountCustomers[x] = res;
                System.out.println("20% of Discount for the person number: " + (x + 1));
            }
            totalPrice = totalPrice + discountCustomers[x];
        }

        //Get rid of the numbers in variable we do not need such as 12.99999999994 
        // for 12.99
        String price2 = Double.toString(totalPrice);
        if (price2.length() > 4) {
            price2 = price2.substring(0, 4);
        }
        System.out.println("Total Price: €" + price2);
        

        //save order into ArrayList of orders
        orders.add(new Order(id, movie, totalPrice, numOfTickets));
        id++;

        // call method fileWriterRegister to Print into a file.txt
        fileWriterRegister(id, orders, totalPrice, numOfTickets);
    }

    /**
     * Method that prints list of Films
     *
     * @param movies
     */
    public void listOfFilms(ArrayList<Movie> movies) {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i));
        }
    }

    /**
     * Method that prints previous orders
     *
     * @param orders - receives ArryList of orders
     */
    public void viewPreviousOrders(ArrayList<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("There in no previous order");
        } else {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println(orders.get(i));
            }
        }
    }

    /**
     * Register details of the payment in a text file called "register.txt"
     * 
     *
     * @param id1 - id of Film
     * @param order - receives ArryList of orders
     * @param totalPrice - Total price of the purchasing
     * @param numOfTickets - number of tickets
     * @throws java.io.IOException - Checks if a file is missing or there is no file
     */
    public void fileWriterRegister(int id1, ArrayList<Order> order, double totalPrice, int numOfTickets) throws IOException {
        FileWriter myFile;
        Date date = new Date();
        try {
            myFile = new FileWriter("register.txt", true);
            myFile.append("Begging -------------------------------------------------------------------" + "\n");
            myFile.append(order.get(id1 - 2).toString()); //Get Object and save it
            myFile.append("");
            myFile.append(date.toString() + "\n");
            myFile.append("End -----------------------------------------------------------------------" + "\n");
            myFile.append("" + "\n");

            myFile.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Cannot find that file");
        }
    }

    /**
     * Method that verify if what users type are numbers and return these numbers
     *
     * @return @throws java.lang.Exception
     */
    public int tryCatchNumber() throws Exception {
        int var;
        Scanner scan1 = new Scanner(System.in);
        try {
            var = scan1.nextInt();
            return var;
        } catch (Exception a) {
            System.out.println(a);
        }
        return 0;

    }

}
