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
public class CSCI232Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Coffee data = new Coffee(4.11,"Black","Samsung");
        TreeManager tree = new TreeManager(data);
        Coffee c;
        Node<Coffee> n;
        
        c = new Coffee(5.45,"Brown","Sony");
        n = new Node<>(c);
        tree.add(n);
        
        c = new Coffee(2.21,"Gray","RedCo");
        n = new Node<>(c);
        tree.add(n);
        
        c = new Coffee(1.21,"Brown","Blue");
        n = new Node<>(c);
        tree.add(n);
        
        c = new Coffee(6.21,"Red","Cats");
        n = new Node<>(c);
        tree.add(n);
        
        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.postOrder(tree.getRoot());
        System.out.println();
        tree.inOrder(tree.getRoot());
        
       tree.delete(2.50,"Black","Python");
//        
//        tree.preOrder(tree.getRoot());
        
    }
    
}
