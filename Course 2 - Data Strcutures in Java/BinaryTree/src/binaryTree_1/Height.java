package binaryTree_1;

public class Height {

public static int height(BinaryTreeNode<Integer> root) {
        
        if(root == null)
            return 0;
        
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        
        return 1 +  Math.max(leftheight,rightheight);
	}
}
