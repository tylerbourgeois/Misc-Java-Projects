/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/**
 *
 * @author tybik
 */
public class Driver {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bowling game = new Bowling(); //create new instance of bowling class called game
        game.playGame(); //runs the method playGame for the game object
    }
}
