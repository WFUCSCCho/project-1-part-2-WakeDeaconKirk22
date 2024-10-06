
/***************************************************************************
 @file: BST.java
 @description: This program implements a generic BST that manages
 the structure of a tree along with a BST iterator
 @author:  Kennedy Kirk
 @date  September 18,2024

 *******************************************************************************/

import java.util.LinkedList;
import java.util.Stack;
import java.util.Iterator;

public class BST<T extends Comparable<? super T>> {
    private Node<T> root;
    private int nodeCount;
// Implement the constructor

    BST() {
        root = null;
        nodeCount = 0;
    }
    //retrieves the root
    public Node<T> getRoot() {
        return root;
    }

    // Implement the size method
    public int size() {
        return nodeCount;
    }

    //check if tree is empty
    public boolean isEmpty() {
        return nodeCount == 0;

    }
    //Implement clear method
    public Node<T> clear(Node<T> node) {
        root = null;
        nodeCount = 0;
        return node;
    }


    // implementing the deleteMax to remove the largest node in removeHelpd
    public Node<T> deleteMax(Node<T> node){
        if(root == null) { //base case
            return null;
        }
        if(node.getRight()==null) { //no right then current is the largest
            node.setRight(null);
            return node.getLeft();

        }
        node.setRight(deleteMax(node.getRight()));
        return node.getLeft();
    }


    public String print() {
        BstIterator stringBuilder = new BstIterator();
        String print = "";
        while(stringBuilder.hasNext()) {
            print = print + (stringBuilder.next() + " ");


        }
        return print;

    }

// Implement the insert method

    private Node<T> insertHelp(Node<T> root, T key) {
        if (root == null) { //base case if the current key is null create a new node with the key
            return new Node<T>(key);
        }
        if (root.getElement().compareTo(key) > 0) { // recurse to the left
            root.setLeft(insertHelp(root.getLeft(), key));

        } else if (root.getElement().compareTo(key) < 0) { //recurse to the right
            root.setRight(insertHelp(root.getRight(), key));
        }
        return root;
    }

    // Implement the remove method
    private Node<T> removeHelp(Node<T> root, T key) {
        if (root == null) {  //Case 1 the tree is empty or reached a leaf

            return null; //nothing to remove
        } else if (root.getElement().compareTo(key) > 0) { //if the key is less than root element recurse left

            root.setLeft(removeHelp(root.getLeft(), key));

        } else if (root.getElement().compareTo(key) < 0) { //case 2 otherwise recurse right

            root.setRight(removeHelp(root.getRight(), key));
        } else { // found
            if (root.getLeft() == null) { //only right child return right child
                return root.getRight();
            } else if (root.getRight() == null) { //only left child return left
                return root.getLeft();
            } else {
                Node<T> temp = root.getLeft(); //find largest element in left sub
                root.setElement(temp.getElement()); //set with the largest val
                root.setLeft(deleteMax(root.getLeft())); //remove largest node from left sub using deleteMax in main meth
            }


        }
        return root;
    }

    // Implement the Search method
    private T searchHelp(Node<T> root, T key) {
        if (root == null) { //base case
            return null;
        }
        if (root.getElement().compareTo(key) > 0) { // left
            System.out.println("Left");
            return searchHelp(root.getLeft(), key);

        }else if (root.getElement().compareTo(key) == 0) {
            System.out.println("Found"); //found
            return root.getElement();

        }
        else return searchHelp(root.getRight(), key); //right
    }
    public void insert(T key) {
        root = insertHelp(root, key);
        nodeCount++; //add
        System.out.println( key );
    }
    public T remove(T key) {
        T temp = searchHelp(root, key);
        if (temp != null) {
            root = removeHelp(root, key);
            nodeCount--; //decrement
        }

        return temp;

    }

    public T search(T key) {
        return searchHelp(root, key);
    }
    //implement the iterator
    public Iterator<T> iterator() {
        return new BstIterator();
    }
    //Implements a BSTIterator
    public class BstIterator implements Iterator<T> {
        LinkedList<Node<T>> stack = new LinkedList<>();

        public BstIterator() {

            Node<T> root = getRoot();
            pushLeft(root);
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();

        }


        @Override
        public T next(){
            Node<T> node= stack.pop(); // next node
            pushLeft(node.getRight()); // push left children of key node

            return node.getElement();

        }
        public void pushLeft(Node<T> current) {
            while(current !=null) {
                stack.push(current);
                current = current.getLeft(); // push left child
            }


        }
    }
}















