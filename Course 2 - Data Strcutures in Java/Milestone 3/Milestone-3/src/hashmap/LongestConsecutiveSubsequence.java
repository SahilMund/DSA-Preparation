package hashmap;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class LongestConsecutiveSubsequence {
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer,Boolean> map = new HashMap<>();

        // flagging all keys values as true, i.e. denoting all keys as startingpoint
        for(int val : arr){
            map.put(val,true);
        }

        // now, let's false the keys which are not considered as startingpoint by checking if it's previous 
        // values are present or not
        for(int val:arr){
            if(map.containsKey(val-1)){
                map.put(val,false);
            }
        }

        int maxLength = 0;
        int startPoint = 0;

        //iterate over the map and find which keys are having the LCS
        for(int val:arr){
            if(map.get(val) == true){
                int tempLength = 1;
                int tempStaryPoint = val;

                while(map.containsKey(tempStaryPoint + tempLength)){
                    tempLength++;
                }

                if(tempLength > maxLength){
                    maxLength = tempLength;
                    startPoint = tempStaryPoint;
                }
            }
        }

        output.add(startPoint);
        output.add(startPoint+maxLength-1);
        return output;

    }
}