package Recursion_Advance;

import java.util.*;
public class ReturnSubsequence {

	public static String[] subsequences(String data) {

		if(data.length() == 0) {
			//base case
			String[] output = new String[1];
			output[0] = "";
			return output;
		}

		String[] smallOutPut = subsequences(data.substring(1));
		String[] myOutput = new String[2*smallOutPut.length];

		for(int i=0;i<smallOutPut.length;i++) {

			myOutput[i] = smallOutPut[i];
		}

		for(int i=0;i<smallOutPut.length;i++) {

			myOutput[smallOutPut.length + i] = data.charAt(0) + smallOutPut[i];
		}


		return myOutput;

	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter String");
		String input = s.next();
		String[] output = subsequences(input);
		for(String outputString: output) {
			System.out.println(outputString);
		}


	}
	}
