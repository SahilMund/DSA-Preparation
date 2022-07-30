package BST_1;

import binaryTree_1.BinaryTreeNode;

class PassNode<T>
{
	T head;
    T tail;
}

 class LinkedListNode<T> { T data; LinkedListNode<T> next;

 public LinkedListNode(T data) { this.data = data; } }


public class BST_TO_LL {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */

	/*
	 * LinkedList Node Class
	 *
	 * 
	 * class LinkedListNode<T> { T data; LinkedListNode<T> next;
	 * 
	 * public LinkedListNode(T data) { this.data = data; } }
	 */

public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        PassNode<LinkedListNode<Integer>> passNode= constructLinkedListHelper(root);
        return passNode.head;
	}

    public static PassNode<LinkedListNode<Integer>> constructLinkedListHelper(BinaryTreeNode<Integer> root){

    	// base case
    	if(root == null)
        {
            return new PassNode<LinkedListNode<Integer>>();
        }


    	// 1. take left subtree and right subtree 
        PassNode<LinkedListNode<Integer>> leftList = constructLinkedListHelper(root.left);
        PassNode<LinkedListNode<Integer>> rightList = constructLinkedListHelper(root.right);
        
        // 2. Make a node for root 
        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(root.data);

        PassNode<LinkedListNode<Integer>> pair = new PassNode<LinkedListNode<Integer>>();

		// 3.connecting left list with rootnode
		if(leftList.tail != null){
        leftList.tail.next = newNode;
        }
		// 4. connect rightlist with root node
		newNode.next = rightList.head;
        
        // 5. getting head data
        if(leftList.head != null){
        	pair.head = leftList.head;
        }else{
        pair.head = newNode;
        }
        
        // 6. getting tail data
        if(rightList.tail != null){
        	pair.tail = rightList.tail;
        }else{
        	pair.tail = newNode;
        }
        
        return pair;

    }
}
