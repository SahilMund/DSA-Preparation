package stack;


import java.util.*;

public class BalancedBrackets {


    public static boolean isBalanced(String expression) {
        //Your code goes here
        Stack<Character> stack = new Stack<>();

        for(int j=0;j<expression.length();j++){

            char letter = expression.charAt(j);

            if(letter == '(' || letter == '{' ||letter == '['){
                stack.push(letter);
            }
            else{  // if stack has closing brackets

                // if stack is empty
                if(stack.isEmpty())
                    return false;

                // if stack is not empty, check for the closed paranthesis and start remove 
                // the open paranthesis from stack
                if (letter == ']')
                {
                    if (stack.peek() != '[')
                        return false;
                    else
                        stack.pop();
                }

                else if (letter == '}')
                {
                    if (stack.peek() != '{')
                        return false;
                    else
                        stack.pop();
                }

                else if (letter == ')')
                {
                    if (stack.peek() != '(')
                        return false;
                    else
                        stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}