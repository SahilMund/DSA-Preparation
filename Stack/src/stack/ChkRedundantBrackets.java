package stack;


import java.util.Stack;
public class ChkRedundantBrackets {

    public static boolean checkRedundantBrackets(String expression) {

        Stack<Character> stack=new Stack<Character>();
        int count=0;

        for(int i=0;i<expression.length();i++)
        {
            char c = expression.charAt(i);


            if (c != ')')
            {
                stack.push(c);
            }
            else // if any closing bracket encounter
            {
                while(!stack.isEmpty() && stack.peek() != '(')
                { // pop one by one item and increment count by 1, till '(' open parenthesis encountered
                    count=count+1;
                    stack.pop();
                }

                // count = 1, is for the single letter expression ,e.g :->   (a)
                if (count == 0 || count == 1)
                {
                    return true;
                }

                // after popping out the elements till open parenthesis, now pop open parenthesis and make the count zero
                stack.pop();
                count=0;

            }
        }
        return false;
    }
}