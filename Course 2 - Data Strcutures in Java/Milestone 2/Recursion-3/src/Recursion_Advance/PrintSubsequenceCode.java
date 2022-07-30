package Recursion_Advance;


import java.util.Scanner;
public class PrintSubsequenceCode {


public static String[] Subsequences(String input) {
	if(input.length() == 0) {
		// base case
		String[] output = new String[1];
		output[0] = "";
		return output;
	}
	String[] smallOutput = Subsequences(input.substring(1));
	String[] output = new String[smallOutput.length*2];
	for(int i=0;i<smallOutput.length;i++) {
		output[i] = smallOutput[i];
	}
	for(int i=0;i<smallOutput.length;i++) {
		output[smallOutput.length + i] = input.substring(1);
	}
	
	return output;
}
public static void printsubsequences(String input, String stringSoFar) {
	if(input.length() == 0) {
		System.out.println(stringSoFar);
		return;
	}
	String smallInput = input.substring(1);
	printsubsequences(smallInput, stringSoFar);
	printsubsequences(smallInput, stringSoFar + input.charAt(0));
}
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter String");
	String input = s.next();
	Subsequences(input);

}
}