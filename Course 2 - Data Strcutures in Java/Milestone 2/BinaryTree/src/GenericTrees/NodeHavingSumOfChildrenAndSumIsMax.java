package GenericTrees;



class MaxNode<T>{

    TreeNode<T> node;
    T max;
}
public class NodeHavingSumOfChildrenAndSumIsMax {

    /*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/


    public static MaxNode<Integer> maxSumNodeHelper(TreeNode<Integer> root){

        int sum= root.data;

        // initially sum will be the addition of all the root's children.
        
        for(TreeNode<Integer> child:root.children){
            sum += child.data;
        }

        
        MaxNode<Integer> ans = new MaxNode<Integer>();

        ans.node=root;
        ans.max=sum;

        for(TreeNode<Integer> child:root.children){
            
            MaxNode<Integer> childResPair = maxSumNodeHelper(child);
            if(childResPair.max > ans.max){
                ans.max = childResPair.max;
                ans.node = childResPair.node;
            }
            
        }

        return ans;

    }
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        MaxNode<Integer> ans = maxSumNodeHelper(root);
        return ans.node;

    }
}
