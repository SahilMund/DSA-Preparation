package binaryTree_1;

public class IsNodePresent {

	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    //Your code goes here
        
        if (root == null)
        {
            return false;
        }
        
        if(root.data == x)
            return true;
        
//         boolean isleft = isNodePresent(root.left,x);
//         boolean isRight = isNodePresent(root.right,x);
        
//         if(isleft || isRight)
//             return true;
//         else
//             return false;
        
         return (isNodePresent(root.left,x) || isNodePresent(root.right,x));
 
        
	}
}
