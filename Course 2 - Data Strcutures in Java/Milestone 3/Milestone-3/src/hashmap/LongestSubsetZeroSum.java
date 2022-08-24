package hashmap;


import java.util.HashMap;
public class LongestSubsetZeroSum {

	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		// Write your code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxlen = 0;
        int i = -1;
        int sum = 0;
        
        //considering sum as key and index as value
        map.put(sum,i);
        
        //iterate over the map and check if previously the sum we have i.e. present or not\
        // if present in the map , then check the length and update the maxlength
        // if not present add it to the map with sum as key and index as it's value
        while(i < arr.length-1){
            i++;
            sum += arr[i];
            
            if(map.containsKey(sum) == false){
                map.put(sum,i);
            }else{
                int len = i - map.get(sum);
                if(len > maxlen){
                    maxlen = len;
                }
            }
        }
        
        return maxlen;
	}
}