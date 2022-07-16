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

/*
Steps:-

1. Add root to the queue
2. while queue is not empty
a) take out first node (let front)
b) print the data (front.data)
c) if left children of front is present then print it
d) if right children of front is present then print it
*/

import java.util.*;

import binaryTree_1.BinaryTreeNode;
public class LevelOrderTraversal {

	
public static void printLevelWise(BinaryTreeNode<Integer> root) {

    if(root == null)
        return;

    Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
    queue.add(root);

    while(!queue.isEmpty()){
        BinaryTreeNode<Integer> front = queue.poll();

        System.out.print(front.data+":");
        if(front.left != null){
            queue.add(front.left);
            System.out.print("L:"+front.left.data+",");
        }
        else
        {
            System.out.print("L:-1,");
        }

        if(front.right != null){
            queue.add(front.right);
            System.out.print("R:"+front.right.data);
        }else
        {
            System.out.print("R:-1");
        }
        System.out.println();


    }

}

}