package Recursion_Advance;

public class PrintSubsetOfSumK {

	public static void printSubsetsSumTokHelper(int[] input, int startIndex, int[] output, int k){
		if(startIndex == input.length){
			if(k == 0){
				for(int i : output){
					System.out.print(i+" ");
				}
				System.out.println();
				return;
			}else{
				return;
			}
		}	
        
		int[] newOutput = new int[output.length+1];
		
        int i = 0;
		for(;i < output.length; i++){
			newOutput[i] = output[i];
		}
        
		newOutput[i] = input[startIndex];
        
         //Considering recursive hypothesis where we have the subsets of two cases
        //1. Subsets containing current input[startIndex] element - 
        //2. Subsets not containing current input[startIndex] element - 
		printSubsetsSumTokHelper(input, startIndex + 1, output, k);
		printSubsetsSumTokHelper(input, startIndex + 1, newOutput, k - input[startIndex]);
	}
	
    
	public static void printSubsetsSumTok(int input[], int k) {
		int output[] = new int[0];
		printSubsetsSumTokHelper(input, 0, output, k);
	}
}


