package stack;

import java.util.*;
public class ReverseStack {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		
		//Your code goes here
        if(input.size() == 0 || input.size() == 1)
            return;
        
        // 1. getting the top element
        int peek = input.pop();
        
        // 2. using recursion to reverse this stack
        // or, we can also say, using recursion call stack as
        // another stack to reverse the element
        reverseStack(input,extra);
        
        // 3. move stack elements  to helper stack
        while(!input.isEmpty()){
            int temp = input.pop();
            extra.push(temp);
        }
        
        // 4. Now stack is empty, put the top element in the stack
        input.push(peek);
        
        // 5. Now copy all the rest elements from helper to main stack
        while(!extra.isEmpty()){
            int temp = extra.pop();
            input.push(temp);
        }
        
        
        
	}
}