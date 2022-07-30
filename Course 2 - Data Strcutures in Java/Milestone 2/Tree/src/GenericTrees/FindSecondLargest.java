package GenericTrees;


class ReturnData{
    TreeNode<Integer> max;
    TreeNode<Integer> max2;

    // ReturnData(){
    //     this.node=null;
    //     this.max=Integer.MIN_VALUE;
    //     this.max2= Integer.MIN_VALUE;
    // }

}

public class FindSecondLargest {

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

    public static void findSecondLargestHelper(TreeNode<Integer> root ,ReturnData op){

        if(root==null){
            return;
        }

        if(op.max==null && op.max2==null){
            op.max=root;
            
        }else if(root.data>op.max.data){
            op.max2=op.max;
            op.max=root;
        }else if(op.max2==null && root.data<op.max.data){
            op.max2=root;
        }
        else if(root.data<op.max.data&&root.data>op.max2.data){
            op.max2=root;
        }
        
        
        for(TreeNode<Integer> child:root.children){
            findSecondLargestHelper(child,op);
        }

        return;

    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){

        ReturnData op = new ReturnData(); 
        findSecondLargestHelper(root,op);
        return op.max2;
    }


}








