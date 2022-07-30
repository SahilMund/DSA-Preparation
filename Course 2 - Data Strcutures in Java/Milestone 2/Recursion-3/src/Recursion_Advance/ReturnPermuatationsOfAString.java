package Recursion_Advance;



public class ReturnPermuatationsOfAString {

    public static String[] permutationOfString(String input){
        // Write your code here

        if (input.length()==0)
            return new String[1];

        if (input.length()==1)
        {
            String[] arr = new String[1];
            arr[0]=input;
            return arr;
        }


        char ch = input.charAt(0);

        String[] smallerOutput = permutationOfString(input.substring(1));
        String[] output = new String[smallerOutput.length*input.length()];

        int k =0;
        for(int i = 0; i < smallerOutput.length; i++){
            String currentString = smallerOutput[i];
            for(int j = 0; j <= currentString.length(); j++){		
                output[k] = currentString.substring(0, j) + ch + currentString.substring(j);
                k++;
            }
        }

        return output;
    }

}
