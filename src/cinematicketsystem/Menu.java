/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinematicketsystem;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author Johnes
 */
public class Menu {

    Scanner scan = new Scanner(System.in);

    /**
     *
     * @param movies
     * @param orders
     * @throws java.lang.Exception
     */
    public void mainMenu(ArrayList<Movie> movies, ArrayList<Order> orders) throws Exception {
        String choice = "w";

        do {
            System.out.println("");
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
                    for (int i = 0; i < movies.size(); i++) {
                        System.out.println(movies.get(i));
                    }
                    break;

                case "3": //1: View previous Orders

                    if (orders.isEmpty()) {
                        System.out.println("There in no previous order");
                    } else {
                        for (int i = 0; i < orders.size(); i++) {
                            System.out.println(orders.get(i));
                        }
                    }
                    break;

                case "4": //1: Quit Program
                    do {
                        System.out.println("Are you sure you want to quit?");
                        choice = scan.nextLine();
                        if (choice.equals("y") || choice.equals("n")) {
                            if (choice.equals("n")) {
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
     *
     *
     * @param movies
     * @param orders
     * @throws java.lang.Exception
     */
    public void createOrder(ArrayList<Movie> movies, ArrayList<Order> orders) throws Exception {
        int choice = 0;
        String spare = "w";
        String spare1 = "w";
        int numOfTickets = 0;
        Movie movie = new Movie();

        do {
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
                    spare1 = "o";
                    break;
                }
            }

        } while (!spare1.equals("o"));

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

        

        do {
            int[] ageCustomers = new int[numOfTickets];
            int var = -0;

            spare1 = "o";
            for (int i = 0; i < ageCustomers.length; i++) {

                int personNum = i + 1;
                System.out.println("What is the age of person number " + personNum + "?");
                var = tryCatchNumber();
                if (var > 0) {
                    ageCustomers[i] = var;
                } else {
                    i--;
                }
                
                if (i == numOfTickets) {
                    spare1 = "o";
                    break;
                }

            }

        } while (!spare1.equals("o"));

        System.out.println("Yeahh");
        // calculate discount
        // 0 - 12 40%
        // 13 - 64 normal price
        // > 65 - 20%
        
        //Display total price transaction
        // register details of the payment in a text file
    }

    public int tryCatchNumber() throws Exception {

        Scanner scan1 = new Scanner(System.in);
        try {

            int var = 0;

            var = scan1.nextInt();

            return var;

        } catch (Exception a) {
            System.out.println(a);
        }
        return 0;

    }

}
