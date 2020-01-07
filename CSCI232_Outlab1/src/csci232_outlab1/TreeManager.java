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


//class to manage the tree
public class TreeManager {
    Node root;
    
    public TreeManager(Node r){
        this.root = r;
    }
    
    public Node getRoot(){
        return this.root;
    }
    
    public void setRoot(Node in){
        this.root = in;
    }
    
    public void insertNode(Node n){
        //New node becomes the root if there is no root
        if(this.root==null){this.root=n;return;}  
        else{
            //r is the iterator, starting with the root
            Node r = root;
            while(true){    
                //checks if the data in r is less than n
                if(r.getData().compareTo(n.getData())<0){
                    //if branch is empty
                    if(r.getLeft()==null){
                        r.setLeft(n);
                        return;
                        //sets left branch
                    }
                    r=r.getLeft(); 
                    //moves r to the next left child
                }
                //checks if the data in r is less than n
                else if(r.getData().compareTo(n.getData())>0){
                    //if branch is empty 
                    if(r.getRight()==null){  
                        r.setRight(n);
                        return;
                        //sets right branch as R
                    }
                    r=r.getRight();   
                    //moves r to the next right child
                }
                //if the node is already present, does not add it
                else if(r.getData().compareTo(n.getData())==0){   
                    return;
                }
            }
        }
    }
    //print in order
    public void inOrder(Node n) { 
        if (n == null) return; 
        //prints the left branches
        inOrder(n.left); 
        //prints the root
        System.out.print(n.getData() + " "); 
        System.out.println("");
        //prints the right branches
        inOrder(n.right);
    }
    
    //print in pre order
    public void preOrder(Node n){ 
        if (n == null) 
            return; 
        //prints the root
        System.out.print(n.getData() + " "); 
        System.out.println("");
        //prints the left side 
        preOrder(n.left); 
        //prints the right side
        preOrder(n.right);
    }
    //prints in post order
    public void postOrder(Node n){  
        if (n == null) 
            return; 
        //prints the left side
        postOrder(n.left);
         //print the right side
        postOrder(n.right);
        //prints the root
        System.out.print(n.getData() + " ");
        System.out.println("");
    }
    
    //deletes a node if found
    public void delete(double price,String color,String company){
        //sets data to coffee object to search
        Coffee r = new Coffee(price,color,company);
        //if the tree is empty do not delete anything
        if(root == null) return; 
        //checks if the root is equal to the node that needs to be deleted
        if(root.getData().compareTo(r) == 0) {
            //checks if left's right is needed to be deleted
            if (root.getLeft().getRight() == null) {
                root.getLeft().setRight(root.getRight());
                //sets the left of the root to be the new node
                root = root.getLeft(); 
                return;
            }
            //iterator node that's the left of the root
            Node it = root.getLeft(); 
            while (it.getRight().getRight() != null)
                //sets the iter to be its parent
                it = it.getRight();
            //deletes the node by setting the new root equal to it
            root.setData(it.getRight().getData());
            it.setRight(it.getRight().getLeft());
            return;
        }
        Node it=root;
        while(true){
            //if the left of the root is the same
            if(it.getLeft().getData().compareTo(r)==0){ 
                Node local=it.getLeft();
                //if the local root has no stems
                if(local.getLeft()==null&&local.getRight()==null){ 
                    //deletes the left note
                    it.setLeft(null);  
                    return;
                }
                //if there is only a right branch
                if(local.getLeft()==null){ 
                    //sets local root to the right child
                    it.setLeft(local.getRight());
                    return;
                }
                //if the left child is the only branch
                if(local.getRight()==null){ 
                    //sets local root to left child
                    it.setLeft(local.getLeft()); 
                    return;
                }
                //if the left child is the local root
                if(local.getLeft().getRight()==null){ 
                    local.getLeft().setRight(local.getRight());
                    //makes the right child the root
                    it.setLeft(local.getLeft()); 
                    return;
                }
                //2nd iter
                Node iter2=local.getLeft();
                //sets the iterator to be the local root of its local root
                while(iter2.getRight().getRight()!=null) iter2=iter2.getRight(); 
                //deletes data in the local root
                local.setData(iter2.getRight().getData()); 
                iter2.setRight(iter2.getRight().getLeft());
                return;
            }
            //if the local root is the right branch
            if(it.getRight().getData().compareTo(r)==0){
                Node local=it.getRight(); 
                //if the local root has null branches
                if(local.getLeft()==null&&local.getRight()==null){ 
                    it.setRight(null);
                    return;
                }
                //if only a right branch is present
                if(local.getLeft()==null){ 
                    it.setRight(local.getRight());
                    return;
                }
                //if only a left branch is present
                if(local.getRight()==null){ 
                    it.setRight(local.getLeft());
                    return;
                }
                //if the left branch is the predecessor of the local root
                if(local.getLeft().getRight()==null){ 
                    local.getLeft().setRight(local.getRight());
                    //makes the local root be the left branch
                    it.setRight(local.getLeft()); 
                    return;
                }
                Node iter=local.getLeft();
                //sets iter to be the parent of the local root
                while(iter.getRight().getRight()!=null) iter=iter.getRight(); 
                //sets the local root to be deleted
                local.setData(iter.getRight().getData());
                //sets the local root to be the right child
                iter.setRight(iter.getRight().getLeft());
                return;
            }
            //if the current node is not deleted and less than the current node
            if(it.getData().compareTo(r)<0)
                it=it.getLeft();
                //switch to the left branch
            //if the corrent node is note deleted and greater than the current node
            else if(it.getData().compareTo(r)>0) 
                it=it.getRight();
                //switch to the right branch
                //exit if node is not present 
            if(it==null)          
                return;
        }
    }
}
