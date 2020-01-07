/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;
import java.util.*;
/**
 *
 * @author tybik
 */
public class Frame {
    public Frame(){} //empty constructor because no variables need to be iniatilzed
    
    private int firstRoll(){ //returns an Int for the first bowl of a frame, wheighs each number based on the directions
        int check = new Random().nextInt(22); //sets check int to a random integer between 0 and 21
        //the following lines return the number of pins knocked down 
        if(check<6) return check; 
        if(check<8) return 6;
        if(check<11) return 7;
        if(check<15) return 8;
        if(check<19) return 9;
        return 10;
    }
    
    public void printHeadings(){//prints the headings of the frame
        int currentframe = 1; //stores the value of the current frame for use in the while loop
        while(currentframe<10){ //while loop to print out frames 1-9
            System.out.print("+----Frame " + currentframe + "----");
            currentframe ++;
        }
        System.out.print("+----Frame 10---+---------------+\n"); //prints out the heading for the final frame
    }
    public void printClosings(){ //prints the closing line of +'s and -'s
        for(int i = 0;i<11;i++){ //prints out a closing for each frame
            System.out.print("+---------------");
        }
        System.out.print("+\n"); //prints out the final + and a new line
    }
    public void printFrameScores(){
        Random r = new Random(); //new random object called "r"
        int[][] scores = new int[2][11]; //creates a 2-D array to store the score of the frames
        
//Simulates a perfect game
//        for(int i = 0;i<11;i++){ 
//            scores[0][i] = 10;
//        }
//        scores[1][10] = 10;

        for(int i = 0;i<10;i++){ //for loop to simulate the first ten frames
            scores[0][i] = this.firstRoll(); //sets the first element of i index of the scores array to the return value of the firstRoll method
            if(scores[0][i] < 10){ //if the first roll is less than 10, roll again for the second score in the frame
                scores[1][i] = r.nextInt((11-scores[0][i])); //sets the score of the second roll of the frame to a random number between 0 and the number of pins remaining
            }
        }
        //if/else statements to calculate if there is an 11th frame or not and the values of it
        if(scores[0][9] == 10){ //if a strike was rolled in the 10th frame
            scores[0][10] = this.firstRoll(); //sets the value fo the roll to the value given from the firstRoll method
            if(scores[0][10] < 10){ //if the roll in the 11th frame isn't a strike then roll again
                scores[1][10] = r.nextInt((11-scores[0][10])); //see explanation above
            }
        }
        else if((scores[0][9] + scores[1][9]) == 10){ //if a spare was rolled in the 10th frame
             scores[0][10] = this.firstRoll(); //sets the 11th frame roll to the value given from the firstRoll method
        }
        
        int j = 0; //variable for the current index in the while loop
        while(j<10){ //prints out the first 10 frames
            if((scores[0][j] + scores[1][j]) < 10){ //if neither a spare nor a strike
                System.out.print("+   " + scores[0][j] + "   |   " + scores[1][j] + "   "); //print the score in each frame
            }
            else if(scores[0][j] == 10){//if a strike
                System.out.print("+   X   |   0   "); //prints an X for a strike
            }
            else if((scores[0][j] + scores[1][j]) == 10){ //if spare
                System.out.print("+   " + scores[0][j] + "   |   S   "); //print the value of the first roll and S
            }
            j++;
        }
        
        if(scores[0][10] > 0){ //only runs if there is a 11th frame
            if((scores[0][j] + scores[1][j]) < 10){ //if not a spare or a strike
                System.out.print("+   " + scores[0][j] + "   |   " + scores[1][j] + "   "); //prints out the score in each frame
            }
            else if(scores[0][j] == 10){ //if frame 11's first roll is a strike
                if(scores[1][j] == 10){ //if frame 11's second roll is a strike too
                    System.out.print("+   X   |   X   "); //prints out X and X
                }
                else{
                    System.out.print("+   X   |   0   "); //prints out X
                }
            }
            else if((scores[0][j] + scores[1][j]) == 10){ //if there is a spare in the 11th frame
                System.out.print("+   " + scores[0][j] + "   |   S   "); //prints out the value of the first bowl and S
            }
            System.out.print("+\n"); //closes off the line with a + and sets the cursour to a the next line
        }
        else System.out.print("+               +\n");//prints out an empty frame if there is no 11th frame
        this.printClosings(); //prints the spacing line between the frame scores and running total
        this.printTotalScores(scores); //prints out the total scores
    }
    public void printTotalScores(int[][] scores){ //prints out the total scores given a 2D array of frame scores
        int[] totals = new int[11]; //creates a new array to store the individual score in each frame
        int totalscore = 0; //creates an int to set a total score to 0
        for(int i = 0;i<10;i++){ //for loop to calculate the total score in each frame, the running total, and print out the running total
            if((scores[0][i]+scores[1][i]) != 10){ //if not a strike or a spare
                totals[i] = ((scores[0][i]+scores[1][i])); //sets the total of the frame to the total score
            }
            else if(scores[0][i] == 10){ //if strike
                if(i != 9) //if not the 11th frame
                    if(scores[0][i+1] == 10){//if the score in the next frame is also a strike 
                        totals[i] = 20 + scores [0][i+2]; //adds 20 to the second roll after the first strike
                    }
                    else{ //if the score in the next frame isn't a strike
                        totals[i] = scores[0][i] + scores[0][i+1] + scores[1][i+1]; //adds the strike score to the next two rolls
                    }
                else{//if the 11th frame
                    if(scores[0][i+1] == 10){//adds 20 to the second roll after the strike in the 10th frame
                        totals[i] = 20 + scores [1][10];
                    }
                    else{ //adds the strike score to the two rolls in the 11th frame
                        totals[i] = scores[0][i] + scores[0][i+1] + scores[1][i+1];
                    }
                }
            }
            else if((scores[0][i]+scores[1][i]) == 10){ //if a spare
                totals[i] = 10 + scores[0][i+1]; //add the score in the next frame + 10 for the spare to the value of the total at the index
            }
            
            totalscore += totals[i]; //adds the value of the total score of the frame to the total score overall
            
            if(totalscore <= 10){ //if the total score of the frame is less than or equal to 10 print the proper spacing for it with the score
                System.out.print("+       " + totalscore + "       ");
            }
            else if(totalscore > 10 && totalscore < 100){ //if the total score of the frame is greater than 10 and less than 100 print the proper spacing for it with the score
                System.out.print("+       " + totalscore + "      ");
            }
            else if(totalscore >= 100){ //if the total score of the frame is greater than or equal to 100 print the proper spacing for it with the score
                System.out.print("+      " + totalscore + "      ");
            }
        }
        System.out.print("+               +\n"); //prints nothing in the last frame and finishes off the formatting
    }
}