package Recursion_Advance;


public class PrintKeyPadCombinationCode {

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
    public static void printKeypad(int input){
        printKeypadHelper(input,"");
    }

    public static void printKeypadHelper(int input, String ch) {
        if(input == 0) {
            System.out.println(ch);
            return;
        }
        int smallInput = input/10;
        int lastDigit = input%10;

        String lastOptions = getOptions(lastDigit);

        for(int i=0;i<lastOptions.length();i++){
            printKeypadHelper(smallInput,lastOptions.charAt(i)+ch);
        }

    }
}
