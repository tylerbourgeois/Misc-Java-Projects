/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232lab1;

/**
 *
 * @author tybik
 * @param <E>
 */

public class Node<E>
{
    private Coffee data;
    private Node<E> right;
    private Node<E> left;
    
    public Node (Coffee data)
    {
        this.data = data;
        this.right = null;
        this.left = null;
    }
    
    public void setRight(Node<E> what)
    {
        this.right = what;
    }
    
    public void setLeft(Node<E> what)
    {
        this.left = what;
    }
    
    public Coffee getData()
    {
        return this.data;
    }
    
    public void setData(Coffee data){
        this.data = data;
    }
    
    public Node<E> getRight()
    {
        return right;
    }
    
    public Node<E> getLeft()
    {
        return left;
    }
    
  

}
