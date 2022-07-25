package GenericTrees;


public class SumOfNodes {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}
	
*/
	
	
	
	public static int sumOfAllNode(TreeNode<Integer> root){
	
        int sum = root.data;
        
        for(int i=0;i<root.children.size();i++){
            
            int childSum = sumOfAllNode(root.children.get(i));
            sum += childSum;
        }
        
        return sum;
	}
}
