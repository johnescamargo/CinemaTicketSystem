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
public class MainCinemaTicketSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Order order = new Order();
        SetUp setup = new SetUp();
        Menu menu = new Menu();

        setup.setMovies();
        menu.mainMenu(setup.movies, setup.orders);
    }

}
