package Recursion_Advance;


public class ReturnKeypadCode {


    public static String getOptions(int last){

        switch(last){
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return "";
        }

    }
    // Return a string array that contains all the possible strings
    public static String[] keypad(int input){
        // Write your code here

        if(input==0){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }


        String[] smallOutput = keypad(input/10);

        int lastDigit = input%10;

        String lastOptions = getOptions(lastDigit);

        String[] output = new String[smallOutput.length * lastOptions.length()];

        int k = 0 ;
        for(int i=0; i<smallOutput.length;i++){
            for(int j=0;j<lastOptions.length();j++){
                output[k] = smallOutput[i]+lastOptions.charAt(j);
                k++;
            }
        }


        return output;
    }

}
