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
public class TreeManager{
    private Node root;
    
    TreeManager(Coffee data){
        Node dummy;
        dummy = new Node((Coffee) data);
        dummy.setRight(null);
        dummy.setLeft(null);
        root = dummy;
    }
    public Node getRoot(){
        return this.root;
    }
    
    public void delete(double price,String color,String company){
        // Note that pred is the predecessor to the node to be deleted
        Coffee in=new Coffee(price,color,company);// creates a coffee instance for comparison.
        if(root==null) return; // if the tree is empty return
        if(root.getData().compareTo(in) == 0) { // if the root is the node to be deleted
            if (root.getLeft().getRight() == null) { // if the left child is the pred
                root.getLeft().setRight(root.getRight()); //make sure the tree is connected
                root = root.getLeft(); // make the left child the root
                return;
            }
            Node iter = root.getLeft(); // iter will be the parent to the pred
            while (iter.getRight().getRight() != null)
                iter = iter.getRight(); // set iter to be the parent to the pred
            root.setData((Coffee) iter.getRight().getData()); //set the root to have the data of the node to be deleted
            iter.setRight(iter.getRight().getLeft());// set the pred to be the preds left child.
            return;
        }
        Node it=root;   // it will be the parent to the local root.
        while(true){
            if(it.getLeft().getData().compareTo(in)==0){ // if the left child is the local root
                Node local=it.getLeft(); // set local to local root for clarity
                if(local.getLeft()==null&&local.getRight()==null){ //if the local root has no children
                    it.setLeft(null);   //delete it
                    return;
                }
                if(local.getLeft()==null){  // if there is only a right child
                    it.setLeft(local.getRight());   // set local to the child
                    return;
                }
                if(local.getRight()==null){ // if there is only a right child
                    it.setLeft(local.getLeft());    // set local to the child
                    return;
                }
                if(local.getLeft().getRight()==null){ // if the left child is the pred
                    local.getLeft().setRight(local.getRight());// make sure the tree is connected
                    it.setLeft(local.getLeft()); // make the left child the root
                    return;
                }
                Node iter=local.getLeft(); // iter will be the parent to the pred
                while(iter.getRight().getRight()!=null) iter=iter.getRight(); // set iter to be the parent to the pred
                local.setData((Coffee) iter.getRight().getData()); // set the local root to have the data of the node to be deleted
                iter.setRight(iter.getRight().getLeft()); // set the pred to be the preds left child.
                return;
            }
            if((it.getRight().getData()).compareTo(in)==0){// if the right child is the local root
                Node local=it.getRight(); // set local to local root for clarity
                if(local.getLeft()==null&&local.getRight()==null){ //if the local root has no children
                    it.setRight(null); //delete it
                    return;
                }
                if(local.getLeft()==null){ // if there is only a right child
                    it.setRight(local.getRight());  // set local to the child
                    return;
                }
                if(local.getRight()==null){ // if there is only a right child
                    it.setRight(local.getLeft()); // set local to the child
                    return;
                }
                if(local.getLeft().getRight()==null){ // if the left child is the pred
                    local.getLeft().setRight(local.getRight()); // make sure the tree is connected
                    it.setRight(local.getLeft()); // make the left child the root
                    return;
                }
                Node iter=local.getLeft();// iter will be the parent to the pred
                while(iter.getRight().getRight()!=null) iter=iter.getRight(); // set iter to be the parent to the pred
                local.setData((Coffee) iter.getRight().getData());// set the local root to have the data of the node to be deleted
                iter.setRight(iter.getRight().getLeft());// set the pred to be the preds left child.
                return;
            }
            if(it.getData().compareTo(in)<0)// if the node to be deleted is less than the current node 
                it=it.getLeft();    // go left
            else if(it.getData().compareTo(in)>0) // if the node to be deleted is greater than the current node 
                it=it.getRight();   //go right
            if(it==null)            // if the node your checking is null, node is not in tree
                return;
        }
    }
    
    public void add (Node n){
        if(this.root==null) {
            this.root=n;
            return;
        }
        Node r = this.root;      
        while(true){
            
            if(r.getData().compareTo(n.getData()) > 0){
                if(r.getLeft() == null){
                    r.setLeft(n);
                    return;
                }
               r = r.getLeft();
//                return;
            }
            else if(r.getData().compareTo(n.getData()) < 0){
                if(r.getRight() == null){
                    r.setRight(n);
                    return;
                }
               r = r.getRight();
//                return;
            }
            else if(r.getData().compareTo(n.getData()) == 0){ 
                return;
            }
        }
        
    }
    
    public void inOrder (Node data){
        if (data == null) return;
        inOrder(data.getLeft());
        System.out.print(data.getData().toString() + " ");
        inOrder(data.getRight());
    }

    public void preOrder (Node data){
        if (data == null) return;
        System.out.print(data.getData().toString() + " ");
        preOrder(data.getLeft());
        preOrder(data.getRight());
        
    }

    public void postOrder (Node data){
        if (data == null) return;
        preOrder(data.getLeft());
        preOrder(data.getRight());
        System.out.print(data.getData().toString() + " ");
    }
}
