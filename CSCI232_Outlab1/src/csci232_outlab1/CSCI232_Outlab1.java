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
public class CSCI232_Outlab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //test coffee for root
        Coffee test = new Coffee(5.11,"Dark","Starbucks");
        Node root = new Node(test);
        //creates new tree with the root
        TreeManager tree = new TreeManager(root);
        //new coffees to insert
        Coffee test2 = new Coffee(2.50,"Medium","Mercury");
        Coffee test3 = new Coffee(4.39,"Light","Tulleys");
        Coffee test4 = new Coffee(3.40,"Medium","Override");
        Coffee test5 = new Coffee(2.00,"Light","Redding");
        //inserts new nodes
        Node a = new Node(test2);
        tree.insertNode(a);
        Node b = new Node(test3);
        tree.insertNode(b);
        Node c = new Node(test4);
        tree.insertNode(c);
        Node d = new Node(test5);
        tree.insertNode(d);
        //prints in various ways
        System.out.println("inOrder: ");
        tree.inOrder(tree.getRoot());
        System.out.println("preOrder: ");
        tree.preOrder(tree.getRoot());
        System.out.println("postOrder: ");
        tree.postOrder(tree.getRoot());
        tree.delete(2.50,"Medium","Mercury");
        System.out.println("Delete then print inOrder: ");
        tree.inOrder(tree.getRoot());
    }
    
}
