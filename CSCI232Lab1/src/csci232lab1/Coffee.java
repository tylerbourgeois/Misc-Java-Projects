/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232lab1;

/**
 *
 * @author tybik
 */
public class Coffee{
    private final double price;
    private final String color;
    private final String distributor;
    
    Coffee(double price, String color, String distributor){
        this.price = price;
        this.color = color;
        this.distributor = distributor;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getDistributor() {
        return distributor;
    }
    
    
    
    public int compareTo(Coffee c){
        if(c.getPrice() < price) return -1;
        if(c.getPrice() > price) return 1;
        if(c.getDistributor().compareTo(distributor) < 0) return -1;
        if(c.getDistributor().compareTo(distributor) > 0) return 1;
        if(c.getColor().compareTo(color) < 0) return -1;
        if(c.getColor().compareTo(color) > 0) return 1;
        return 0;
    }
//    @Override
//    public int compareTo(Object coffee) {
//        Coffee otherCoffee = (Coffee) coffee; 
//        System.out.println("compare to being called " + price + " and " + otherCoffee.price);
//        if(price < otherCoffee.price){
//            return -1;
//        }
//        else if (price == otherCoffee.price){
//            if(distributor.compareTo(otherCoffee.distributor) < 0){
//                return -1;
//            }
//            else if(distributor.compareTo(otherCoffee.distributor) == 0) {
//                if(color.compareTo(otherCoffee.color) < 0) {
//                    return -1;
//                }
//                if(color.compareTo(otherCoffee.color) == 0) {
//                    return 0;
//                }
//                else {
//                    return 1;
//                }
//            }
//            else{
//                return 1;
//            }
//        }
//        else {
//            return 1;
//        }
//    }
    @Override
    public String toString(){
        return price + ", " + distributor + ", " + color;
    }
}

