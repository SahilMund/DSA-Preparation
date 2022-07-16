package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

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

public class PrintNodeatKfromATargetNode {

    public static void printnodeAtKdistance(BinaryTreeNode<Integer> root,int k){
        if(root == null)
            return;
        
        if(k==0){
            System.out.println(root.data);
            return;
        }
        
        printnodeAtKdistance(root.left,k-1);
        printnodeAtKdistance(root.right,k-1);
    }

    // helper method returns the distance between root and element
    public static int helper(BinaryTreeNode<Integer> root, int node, int k){

        if(root == null )
            return -1;
        
        if(root.data == node)
        {
            printnodeAtKdistance(root,k);
            return 0;
        }
        
        // calculating left distance
        int ld = helper(root.left,node,k);
        
        // if the distance from root to the node is reachable 
        if(ld!=-1){
            
            if(ld+1 == k){
                System.out.println(root.data);
            }else{
                // if element is not present in left subtree, then we should search for it in the right subtree
                // remaining distance to search on right subtree => k - (ld+1) -1 = k -ld-2
                // where ld+1 denotes left subtree and root distance , and -1 is for distnace from
                // root to right subtree
                printnodeAtKdistance(root.right,k-ld-2);
            }
            
            // ld+1 , 1 is incremented as we need the distnace from root
            return 1+ld;
        }
        
        int rd = helper(root.right,node,k);
        if(rd!=-1){
            if(rd+1 == k){
                System.out.println(root.data);

            }else{
                printnodeAtKdistance(root.left,k-rd-2);
            }
            return 1+rd;
        }


        return -1;
    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        //Your code goes here

        helper(root,node,k);

    }


}