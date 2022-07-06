package stack;


import java.util.Stack;
public class StockSpan {

    public static int[] stockSpan(int[] price) {
        //Your code goes here
        int[] span=new int[price.length];
        
        Stack<Integer> stack=new Stack<>();
        
        // first day span will by default 1 as it has nothing to compare
        span[0] = 1;
        
        stack.push(0); // adding index to this stack for comparisons

        // as 0th index is already handled, starting i from 1
        for (int i = 1;i < price.length;i++)
        {
            while(!stack.isEmpty() && price[stack.peek()] < price[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                span[i] = i+1;
            }
            else
            {
                span[i] = i - stack.peek();
            }
            
            stack.push(i);
        }
        return span;
    }

}
