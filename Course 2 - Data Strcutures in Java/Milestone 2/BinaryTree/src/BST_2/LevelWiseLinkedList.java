package BST_2;


import java.util.*;

import binaryTree_1.BinaryTreeNode;

public class LevelWiseLinkedList {
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	
	 // LinkedListNode Class
	  class LinkedListNode<T> 
	 { 
	  		T data; 
	  		LinkedListNode<T> next;
	  		public LinkedListNode(T data) 	
	  		{
	   		this.data = data; 
	   	} 
  }
	 
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		// Write your code here
         if(root==null){
            return null;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        ArrayList<LinkedListNode<Integer>> arr = new  ArrayList<LinkedListNode<Integer>>();
        
        q.add(root);
        q.add(null);
        
        
		LinkedListNode<Integer>head = null;
        LinkedListNode<Integer>tail = null;
            
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> front = q.poll();
            if(front==null) continue;
            if(front.left!=null) {
                q.add(front.left);
            }
            if(front.right!=null) {
                q.add(front.right);
            }
            
            LinkedListNode<Integer> newNode = new LinkedListNode<>(front.data);
			if(head==null){
                head = newNode;
                tail = newNode;
                arr.add(newNode);
            }else{
                tail.next=newNode;
                tail=newNode;
            }

            if(q.peek() ==null){
                q.poll();
                q.add(null);
                head=null;tail=null;
            }


        }//while end
        
        return arr;

    }//method end

        
	}//class end


