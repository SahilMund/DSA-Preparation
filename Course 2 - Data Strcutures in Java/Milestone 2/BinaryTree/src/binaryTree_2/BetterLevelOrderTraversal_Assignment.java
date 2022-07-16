package binaryTree_2;



/*

Following is the structure used to represent the Binary Tree Node

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

*/
import java.util.*;

import binaryTree_1.BinaryTreeNode;
public class BetterLevelOrderTraversal_Assignment {

public static void printLevelWise(BinaryTreeNode<Integer> root) {
    //Your code goes here
    if(root == null)
        return;

    Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();

    // adding null as a differentiator, which denotes the end of an level
    // in 1st level only root node is present, hence we are adding null to the queue after root node.
    if(q.isEmpty()){
        q.add(root);
        q.add(null);
    }

    while(!q.isEmpty()){
        BinaryTreeNode<Integer> front = q.poll();

        // checking if we reached the differentiator, and if queue is not empty, giving an enter and adding 
        // another null, to denote a new level
        if(front == null){
            if(!q.isEmpty()){
                System.out.println();
                q.add(null);
            }
            else{
                return;
            }}
        
        else{
            System.out.print(front.data + " ");

            if(front.left != null)
                q.add(front.left);

            if(front.right != null)
                q.add(front.right);


        }
    }

}}