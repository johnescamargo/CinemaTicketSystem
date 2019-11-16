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

    /**
     *
     *
     * @param movies
     * @param orders
     */
    public void mainMenu(ArrayList<Movie> movies, ArrayList<Order> orders) {
        String choice = "w";
        Scanner scan = new Scanner(System.in);

        do {
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
     */
    public void createOrder(ArrayList<Movie> movies, ArrayList<Order> orders) {
        int choice = 0;
        String spare = "w";
        Scanner scan = new Scanner(System.in);

        do {
            for (int i = 0; i < movies.size(); i++) {
                System.out.println(movies.get(i).toString());
            }

            System.out.println("Choose a film. Type in its ID");
            spare = scan.nextLine();

            for (int i = 0; i < movies.size(); i++) {
                String a = Integer.toString(movies.get(i).getId());
                if (a.equals(spare)) {
                    spare = "o";
                    break;
                } else {
                    // System.out.println("Invalid Number. Try again");
                }
            }

        } while (!spare.equals("o"));

        do {
            try {
                System.out.println("Number of Tickets: ");
                choice = scan.nextInt();
                if (choice < 5) {
                    spare = "o";
                } else {
                    System.out.println("Number of Tickets allowed per person ");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } while (!spare.equals("o"));

        int[] ageCustomers = new int[choice - 1];

        for (int i = 0; i < ageCustomers.length; i++) {

            try {

                System.out.println("What is the age of person number: " + (ageCustomers[i] + 1));
                ageCustomers[i] = scan.nextInt();
            } catch (Exception a) {
                System.out.println("Wrong input, try again");
                i--;
            }

        }

        System.out.println("Yeahh");
       // Calculate the total price, save movie and Id
       // orders.add(new Order( id,  movie, price));
        
    }
}
