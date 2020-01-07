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
public class Coffee {
    double Price;
    String Color;
    String Distributor;
    
    public Coffee(double price, String color, String company){
        this.Price = price;
        this.Color = color;
        this.Distributor = company;
    }
    
    
    //getters and setters
    public double getPrice() {
        return Price;
    }

    public String getColor() {
        return Color;
    }

    public String getDistributor() {
        return Distributor;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setDistributor(String Distributor) {
        this.Distributor = Distributor;
    }
    
    //compare to in order to sort through the tree
    public int compareTo(Coffee c){
        System.out.println("Comparing " + c + " to "+ this);
        if(c.getPrice() < Price){return -1;}
        if(c.getPrice() > Price){return 1;}
        if(c.getDistributor().compareTo(Distributor)<0){return -1;}
        if(c.getDistributor().compareTo(Distributor)>0){return 1;}
        if(c.getColor().compareTo(Color)<0){return -1;}
        if(c.getColor().compareTo(Color)>0){return 1;}
        return 0;
    }
    
   //toString to print 
    @Override
    public String toString(){
        return this.Price + ", " + this.Distributor+ ", " +this.Color;
    }
}

