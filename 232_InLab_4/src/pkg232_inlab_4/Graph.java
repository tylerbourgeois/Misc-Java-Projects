/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg232_inlab_4;

import java.io.*;
import java.util.*;

/**
 *
 * @author tybik
 */

public class Graph {
    private int V; //number of vertexes
    private LinkedList<Integer> adj[]; //linked list to store graph for BFS and DFS
    private int graph[][]; //2d int array to store graph for algs
    
    public Graph(int v){ //constructer that passes in vertexes
        V = v;
        graph = new int[V][V];
        adj = new LinkedList[v]; 
        for(int i = 0; i<v; ++i){ //creates linked lists on each vertex for searching
            adj[i] = new LinkedList();
        }     
    }
    
    public void addDirectionalEdge(int v, int w){ //method to add edge to graph
        adj[v].add(w);
    }
    
    public void breadthfirstSearch(int start){ //BFS algorithm
        boolean visited[] = new boolean[V]; //boolean array to store visited vertices
        
        LinkedList<Integer> queue = new LinkedList<Integer>(); //new queue to handle traversal
        visited[start] = true; //sets first vertex to visited
        queue.add(start); //adds s to the queue
        
        while(queue.size() != 0){ //prints out vertices in the queue order
            start = queue.poll();
            System.out.print(start+" ");
            
            Iterator<Integer> iter = adj[start].listIterator(); //linked list iterator
            while(iter.hasNext()){
                int n = iter.next();
                if(!visited[n]){
                    visited[n] = true; //marks next to visited
                    queue.add(n); //adds next to the queue
                }
            }
        }
    }
    
    public void depthfirstSearch(int start){ //dpeth first sorting algorithm
        boolean[] visited= new boolean[V]; //boolean array to store visited vertices
        for(int i = 0; i<V; ++i){ //
            if(visited[i] == false){
                DFSHelper(start, visited); //visits next 
            }
        }
    }
    
    public void DFSHelper(int start, boolean visited[]){
        visited[start] = true;
        System.out.print(start+" "); //prints starting vertex
        Iterator<Integer> i = adj[start].listIterator(); //new iterator
        while(i.hasNext()){ //while there is another vertex after the iterator
            int n = i.next(); //iterates the next vertex
            if(!visited[n]){ //if it has been visited recursively call the function
                DFSHelper(n, visited);
            }
        }
    }
    //function to handle prims algorithm
    public void primsALG(){
        System.out.println("Prim's Algorithm");
        int tree[] = new int[V]; //array to store the new tree
        int minValues[] = new int[V]; //array of keyss used to pick min weight edge
        Boolean mstArray[] = new Boolean[V]; //Stores set of vertices not in the tree
        for(int i = 0; i < V;i++){ //all new keys are made to be infinite
            minValues[i] = Integer.MAX_VALUE;
            mstArray[i] = false;
        }
        minValues[0] = 0; //the key of the first vertex must be zero so it is picked first
        tree[0] = -1; //first node is the root
        for (int i = 0; i < V-1; i++) {  //updates the key value and indexes of the adj vertices
            int u = findminKey(minValues, mstArray); 
            mstArray[u] = true; 
            for (int j = 0; j < V; j++) {
                //checks to see if the graph index is nonzero only for adj vertices of the tree
                //mstArray is false for vertices not currently in the tree
                //only changes the key if the graph is smaller than the key
                if (graph[u][j] != 0 && mstArray[j] == false && graph[u][j] < minValues[j]) { 
                    tree[j] = u; 
                    minValues[j] = graph[u][j]; 
                } 
            }
        }
        
        //prints out the tree by listing the edges and their wheight
        System.out.println("Edge   Weight");
        for(int i = 1; i < V; i++){
            System.out.println(tree[i]+" - " + i + "     "+ graph[i][tree[i]]);
        }
    }   
    //finds the vertex with the smallest key value
    public int findminKey(int keyValuesArray[], Boolean mstArray[]){
        int minimum = Integer.MAX_VALUE, min_i=-1; //creates the min value
        for(int j = 0; j < V; j++){
            if(mstArray[j] == false && keyValuesArray[j] < minimum){ 
                //if the vertex is not in the tree, and the current key value is 
                //less than the minimum change the minimum to the key value and return the minimum vertex
                minimum = keyValuesArray[j];
                min_i = j;
            }
        }
        return min_i;
    }
    
    public void floydwarshallALG(){
        //new 2d int array to store distances
        int dist[][] = new int[V][V];
        
        //makes a copy of the original graph
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V;j++){
                dist[i][j] = graph[i][j];
            }
        }
        
        //sets all instances of zero to a large number to store that the vertex is not connected 
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V;j++){
                if(graph[i][j] == 0){
                    dist[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        
        //sets the middle up down diagonal to zero
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V;j++){
                dist[i][i] = 0;
            }
        }
        
        //add all vertices one by one to the new set of vertices
        for(int k = 0; k < V; k++){
            for(int j = 0; j < V; j++){ //chooses vertices a source one by one
                for(int i = 0; i < V; i++){ //picks all vertices as destinatinations for the above vertex
                    if (dist[i][k] + dist[k][j] < dist[i][j]) { //if the vertex k is on the shortest path update the distance
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                    }
                }
            }
        }
        
        //prints distance matrix 
        System.out.println("\nFloyd Warshall Algorithm");
        for(int i = 0; i < V; ++i){
            for(int j = 0; j < V; ++j){
                if(dist[i][j]<10){
                    System.out.print(dist[i][j]+"   ");
                }
                else{
                    System.out.print(dist[i][j]+"  ");
                }
            }
            System.out.println();
        }
    }
    
    
    public void dijkstra(int src){
        System.out.println("\nDijkstra's Algorithm");
        int distance[] = new int[V]; //array to store distance output
        Boolean spt[] = new Boolean[V]; //array to store if the distance is the shortest
        for(int i = 0; i < V; i++){ //sets all distances to a max value and all shortest paths to false
            distance[i] = Integer.MAX_VALUE;
            spt[i] = false;
        }
        distance[src] = 0; //sets the distance from the source vertex to itself to zero
        for(int i = 0; i < V - 1; i++){ //checks all remaining vertexes distances
            int k = findminDistance(distance, spt); //fins the min distance from the vertex to the source
            spt[k] = true; //mark the vertex as processed
            for(int j = 0; j < V; j++){ //updates the distance value
                if (!spt[j] && graph[k][j]!=0 && distance[k] != Integer.MAX_VALUE && distance[k]+graph[k][j] < distance[j]) { //check if the vertex is not in spt and the distance to the source is not zero, and check that the distance is less than alternate paths
                    distance[j] = distance[k] + graph[k][j]; 
                }
            }
        }
        
        //prints the distances from the source
        System.out.println("Vertex   Distance from Source");
        for(int i = 0; i< V; i++){
            System.out.println(i + "        " + distance[i]);
        }
    }
    
    int findminDistance(int distance[], Boolean spt[]){ //find minimum distance from source
        int minimum = Integer.MAX_VALUE, min_i =- 1;
        for(int v = 0; v<V; v++){
            if(spt[v] == false && distance[v] <= minimum){
                minimum = distance[v];
                min_i = v;
            }
        }
        return min_i;
    }
    
    public void loadFromFileDirectional(String file) throws FileNotFoundException{ //load the directional file
       Scanner k = new Scanner(new File(file));
            if(!k.hasNext()) return;
            int currentline = 0;
            while(k.hasNext()){
                String line = k.nextLine();
                String[] temp = line.split("\\s+");
                for(int i = 0; i < temp.length;i++){
                    if(Integer.parseInt(temp[i]) != 0){
                        addDirectionalEdge(currentline,i);
                    }
                }
                currentline++;
            }
    }
    
    public void loadFromFileWeighted(String file) throws FileNotFoundException{ //load the wheighted file
        Scanner k = new Scanner(new File(file));
        if(!k.hasNext()) return;
        int currentline = 0;
        while(k.hasNext()){
            String line = k.nextLine();
            String[] temp = line.split("\\s+");
            for(int i = 0; i < temp.length;i++){
                graph[currentline][i] = Integer.parseInt(temp[i]);
            }
            currentline++;
        }         
    }

    public void floydALG() {//floyds algorithm
        int dist[][] = new int[V][V]; //distance array to store the output matrix 
        for(int i = 0; i < V; i++){ //similar to floyd-warshall, creates a copy 
            for(int j = 0; j< V; j++){
                dist[i][j] = graph[i][j];
            }            
        }
        //next adds all vertices to the new set of vertices to show the paths in the graph 
        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++) {//picks all vertices as a source
                for(int j = 0; j < V; j++){ //picks all vertices as a destination
                    dist[i][j] = (dist[i][j]!=0) || ((dist[i][k]!=0) && (dist[k][j]!=0))?1:0; //checks to see if vertex k is on the way from i to j, then checks to see if the value of the distance from i to j is 1 
                }
            }
        }
        
        //prints out the paths in the graph
        System.out.println("\nFloyd's Algorithm");
        for(int i = 0; i< V; i++){
            for(int j = 0; j < V; j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void printGraph(){
        for(int i = 0;i<V;i++){
            for(int j = 0; j<V;j++){
                if(i < 10) System.out.print(graph[i][j]+"  ");
                else System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
