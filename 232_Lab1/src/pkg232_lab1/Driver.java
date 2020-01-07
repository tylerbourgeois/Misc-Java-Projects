/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg232_lab1;


/**
 *
 * @author tybik
 * @param <E>
 */
public class Driver<E extends Comparable> {

    /**
     * @param args the command line arguments
     */
    public  void main(String[] args) {
        // TODO code application logic here
        TreeManager tree;
        Coffee data = new Coffee(3.11,"brown","samsung");
        Coffee data1 = new Coffee(2.99,"black","sjsjsjs");
        Node<E> root = new Node(data);
        Node<E> add1 = new Node(data1);
        tree = new TreeManager((Comparable) root);
        tree.add(add1);
        tree.preOrder(root);
        
    }
    
}
