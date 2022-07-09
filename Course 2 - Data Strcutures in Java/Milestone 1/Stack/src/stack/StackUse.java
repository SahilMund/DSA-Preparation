package stack;

import java.util.Stack;

public class StackUse {

	
	
	public static void main(String[] args) throws StackFullException, StackEmptyException {
		
		
		// TODO Auto-generated method stub

//		 	StackUsingArray stack = new StackUsingArray();
//	 		StackUsingArray stack = new StackUsingArray(20);
	 		
	 		StackUsingLL<Integer> stackLL = new StackUsingLL<>();

//	        stack.push(10);
//	        System.out.println("top" + stack.top());
//	        stack.pop();
//	        System.out.println("Size" + stack.size());
//	        
//	        System.out.println(stack.isEmpty());
	 		
	 		
	 		int arr[] = {4,5,6,7,8};
	 		
	 		for(int i=0;i<arr.length;i++) {
	 			stackLL.push(arr[i]);
	 		}
	 		
	 		while(!stackLL.isEmpty()) {
	 			System.out.println(stackLL.pop());
	 		}
	 		
	 		
	 		// stack collection in Java
	 		Stack<Integer> stack=new Stack<Integer>();
	        while(stack.isEmpty())
	        {
	            stack.push(10);
	        }
	        System.out.print(stack.pop()+" "+stack.size());
	}

}
