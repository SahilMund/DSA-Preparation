package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

public class MirrorTree {

public static void swap(BinaryTreeNode<Integer> root){
        
        BinaryTreeNode<Integer> temp = root.left;
        root.left=root.right;
        root.right=temp;
    }

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){

        if(root == null)
            return;

        // swapping left and right nodes pointer
        swap(root);
       
        
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);


    }
}
