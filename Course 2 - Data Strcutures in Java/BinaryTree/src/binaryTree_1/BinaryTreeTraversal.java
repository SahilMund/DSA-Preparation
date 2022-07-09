package binaryTree_1;

public class BinaryTreeTraversal {

	public static void preOrder(BinaryTreeNode<Integer> root) {
        // preOrder ==> root -> left -> right
        if(root == null)
            return;
        
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
        
	}
	
    public static void postOrder(BinaryTreeNode<Integer> root) {

        // postOrder ==> left -> right -> root 
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");


    }
    
    public static void inOrder(BinaryTreeNode<Integer> root) {

        // postOrder ==> left ->  root  ->right
        if(root == null)
            return;

        postOrder(root.left);
        System.out.print(root.data + " ");
        postOrder(root.right);


    }
    
    
}
