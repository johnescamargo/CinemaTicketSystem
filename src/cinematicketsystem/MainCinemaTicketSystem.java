/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinematicketsystem;

/**
 *
 * @author Johnes 2019105
 */
public class MainCinemaTicketSystem {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // Create instances of the objects
        SetUp setup = new SetUp();
        Menu menu = new Menu();

        setup.setMovies();//Call method to Set up films 
        menu.mainMenu(setup.movies, setup.orders);//Call main menu
    }

}
