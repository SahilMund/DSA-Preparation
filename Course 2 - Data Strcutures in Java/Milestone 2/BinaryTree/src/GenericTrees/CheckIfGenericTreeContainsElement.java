package GenericTrees;



public class CheckIfGenericTreeContainsElement {

/*	TreeNode class 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

		// Write your code here
        
        
        if(root.data == x)
            return true;
        
        boolean isPresent = false;
        for(TreeNode<Integer> child:root.children){
           
            if(checkIfContainsX(child,x)){
                isPresent = true;
            }
        }

        return isPresent;
	}
	
}
