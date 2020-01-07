/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg232_inlab_4;

import java.io.FileNotFoundException;

/**
 *
 * @author tybik
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Graph g = new Graph(5); //new graph of length 5
        
        g.loadFromFileWeighted("directional.dat");
        System.out.println("Directional Graph");
        g.printGraph();
        g.loadFromFileWeighted("weighted.dat");
        System.out.println("Weighted Graph");
        g.printGraph();
        
        g.loadFromFileDirectional("directional.dat"); //loads graph from directional file
        int i = 4; //int to search for 
        System.out.print("Breadth First Search for " + i + ": ");
        g.breadthfirstSearch(i); //BFS
        System.out.println();
        System.out.print("\nDepth First Search for " + i + ": "); 
        g.depthfirstSearch(i); //DFS
        System.out.println();
        g.loadFromFileWeighted("weighted.dat"); //loads weighted graph
        g.dijkstra(0); //dijkstra
        System.out.println();
        g.primsALG(); //prim's
        g.loadFromFileWeighted("directional.dat");
        g.floydALG(); //floyd's 
        g.loadFromFileWeighted("weighted.dat"); //loads weighted graph
        g.floydwarshallALG(); //floyd-warshall
        
    }
    
}
