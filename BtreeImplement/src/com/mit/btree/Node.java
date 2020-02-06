package com.mit.btree;

/**
 * This is the the class of {@link btree.Btree} Node. In the class, we declare and define the the variables that we
 * need in the node of the {@link btree.Btree}. Also, we define the constructor of the node class.
 * 
 *Implementation of B-Tree Data Structure 

 */
public class Node {

    /**
     * number of nodes
     */
    public int numberOfNodes;              // number of nodes
    /**
     * the array that holds the keys value.
     */
    public int key[];                      // the array that holds the keys value.
    /**
     * the array that holds the references of the keys in the node.
     */
    public Node children[];                // the array that holds the references of the keys in the node.
    /**
     * the variable to determine if the node is is Leaf or not.
     */
    public boolean isLeaf;                   // the variable to determine if the node is is Leaf or not..

    /**
     * The constructor of the node class
     * The node can have at most 3 keys. We have 4 references for each node, and assign the node to be isLeaf.
     */
    Node() {
        key = new int[3];             // The node can have at most 3 keys
        children = new Node[4];       // We have 4 references for each node
        isLeaf = true;                  // assign the node to be Leaf.
    }
}
