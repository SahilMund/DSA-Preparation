package binaryTree_2;
import java.util.*;

import binaryTree_1.BinaryTreeNode;
/*
 Steps:-
 
 1. Take the root input
 2. Insert it into a queue
 3. while queue is not empty
 	a) pop the first element
 	b) ask for it's left node data and if the it is != 1, attach it to the 
 	   left side and push it to the queue.
 	c) ask for it's right node data and if the it is != 1, attach it to the 
 	   right side and push it to the queue.
 */

public class LevelWiseInput {
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		
		Scanner sc = new Scanner(System.in);
		
		int rootData = sc.nextInt();
		
		// user don't want to create a B.T.
		if(rootData == -1)
			return null;
		
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		// we are creating a queue of B.T nodes
		Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
		
		pendingChildren.add(root);
		
		while(!pendingChildren.isEmpty()) {

			BinaryTreeNode<Integer> front = pendingChildren.poll();
			
			System.out.print("Enter the left child of " + front.data);
			int leftChild = sc.nextInt();
			if(leftChild != -1) {
			BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(leftChild);
			front.left = leftNode;
			pendingChildren.add(leftNode);				
			}
			System.out.print("Enter the right child of " + front.data);
			int rightChild = sc.nextInt();
			if(rightChild != -1) {
			BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(rightChild);
			front.right = rightNode;
			pendingChildren.add(rightNode);				
			}

		}
		

		return root;
	}
	
	
}


