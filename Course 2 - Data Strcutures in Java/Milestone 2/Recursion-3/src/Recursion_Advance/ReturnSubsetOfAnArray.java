package Recursion_Advance;



public class ReturnSubsetOfAnArray {

    // Return a 2D array that contains all the subsets
    public static int[][] subsets(int input[]) {
        // Write your code here

        return subsetsHelper(input,0);
    }

    private static int[][] subsetsHelper(int[] input, int startIndex)
    {
        // base case :- when reached last index , it should be empty, so row=1 , due to size
        if (startIndex==input.length)
        {
            // here row should be 1 , as the row of ouput arr should be double the row size of smalloutput array
            // [1][0] -- denotes an empty 2d matirx
            return new int[1][0];
        }

        int[][] smallOutput = subsetsHelper(input, startIndex+1);

        int[][] output = new int[smallOutput.length*2][];

        // Now , we have to directly copy and paste all the values of smalloutput ot the output array
        for (int i=0;i<smallOutput.length;i++)
        {
            output[i] = new int[smallOutput[i].length];
            int[] smallTemp = smallOutput[i];
            for (int j=0;j<smallOutput[i].length;j++)
            {
                output[i][j]=smallTemp[j];
            }
        }

        // and then, we need to add those small inputs to the ararys, with adding the currentIndex/startIndex
        //value at the 0th col index
        
        for (int i=0;i<smallOutput.length;i++)
        {
            output[i+smallOutput.length] = new int[smallOutput[i].length+1];
            output[i+smallOutput.length][0]=input[startIndex];
            int[] smallTemp = smallOutput[i];
            for (int j=1;j<=smallOutput[i].length;j++)
            {
                output[i+smallOutput.length][j]=smallTemp[j-1];
            }
        }
       
        return output;

    }
}
