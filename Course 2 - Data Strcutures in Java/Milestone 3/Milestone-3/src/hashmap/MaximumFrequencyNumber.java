package hashmap;


import java.util.*;
public class MaximumFrequencyNumber {

    public static int maxFrequencyNumber(int[] arr){ 
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/

        HashMap<Integer,Integer> countMap = new HashMap<>();

        for (int i=0;i<arr.length;i++)
        {
            int ele=arr[i];
            
            if (countMap.containsKey(ele))
            {
                // incrementing the count
                int val = countMap.get(ele);
                countMap.put(ele,val+1);
            }
            else
            {
                countMap.put(ele,1);
            }

        }

        int maxCount = Integer.MIN_VALUE, maxEle = arr[0];
        for (int i=0;i<arr.length;i++)
        {
            if (countMap.get(arr[i]) > maxCount)
            {
                maxCount=countMap.get(arr[i]);
                maxEle=arr[i];
            }
        }
        return maxEle;
    }



}


