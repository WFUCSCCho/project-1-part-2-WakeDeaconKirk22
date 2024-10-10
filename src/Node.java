/********************************************************************************************
 @file: Parser.java
 @description: This program implements a Node generic class that represent the nodes of BST
 @author:  Kennedy Kirk
 @date  September 18,2024

 *******************************************************************************************/


public class Node<T> {
    private T element;
    private Node<T> left;
    private Node<T> right;

    // Implement the constructor

    public Node(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    // Implement the getElement method
    public T getElement(){ return element; }

// Implement the setElement method

    public void setElement(T element) {
        this.element = element;
    }
// Implement the setLeft method

    public void setLeft(Node<T> left) {this.left = left;}

    // Implement the setRight method
    public void setRight(Node<T> right) {this.right=right;}


// Implement the getLeft method

    public Node<T> getLeft() {return left;}

    // Implement the getRight method
    public Node<T> getRight() {return right;}




// Implement the isLeaf method

    public boolean isLeaf() {
        return left == null && right == null;
    }





}