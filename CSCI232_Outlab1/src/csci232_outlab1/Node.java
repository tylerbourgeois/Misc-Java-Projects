/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232_outlab1;

/**
 *
 * @author Tyler Bourgeois
 */
//node class to manage nodes
public class Node {
    Coffee data;
    Node left;
    Node right;
    
    public Node(Coffee data){
        this.data=data;
        left = null;
        right = null;
    }
    
    //getters and setters for each value
    public Coffee getData(){ return this.data;}
    public double getPrice(){return data.getPrice();}
    public String getColor(){return data.getColor();}
    public String getCompany(){return data.getDistributor();}
    
    public void setPrice(double p){data.Price = p;}
    public void setColor(String col){data.Color = col;}
    public void setCompany(String com){data.Distributor = com;}
    public void setData(Coffee d){data=d;}
    
    public Node getLeft(){return left;}
    public Node getRight(){return right;}
    
    public void setLeft(Node n){this.left = n;}
    public void setRight(Node n){this.right = n;}
   
}
