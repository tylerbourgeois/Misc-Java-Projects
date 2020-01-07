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
public class Bowling {
    
    public Bowling(){} //empty constructor because no variables need to be iniatilzed 
    public void playGame(){
        Frame f = new Frame(); //creates a new set of frames
        f.printHeadings(); //prints the frame headings
        f.printFrameScores(); //pritns the frame scores
        f.printClosings(); //prints the final line of +'s and -'s
        System.out.println();
    }
    
}
