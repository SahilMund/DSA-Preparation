package Recursion_Advance;



public class PrintPermutationOfAString {


    public static void permutations(String input){
        // Write your code here
        permutationsHelper(input,"");

    }

    private static void permutationsHelper(String input, String output)
    {
        if (input.length()==0)
            System.out.println(output);

        for (int i=0;i<input.length();i++)
            //adding current character to output
            permutationsHelper(input.substring(0,i)+input.substring(i+1), output+input.charAt(i));
    }

}
