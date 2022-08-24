package hashmap;

/*  Time Complexity: O(n + m)
Space Complexity : O(min(n, m))

Where 'n' and 'm' are the sizes of the input arrays/lists
*/

import java.util.*;
public class PrintIntersection {

public static void intersection(int[] arr1, int[] arr2) {
    //Your code goes here
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int key:arr1)
    {	
        if(map.containsKey(key))
        {
            map.put(key,map.get(key)+1);
        }
        else
        {
            map.put(key,1);
        }

    }

    // beacuse we want, the intersection elements printed would be in ascending order.
    Arrays.sort(arr2);

    for (int key:arr2)
    {
        if (map.containsKey(key))
        {
            int val = map.get(key);
            if (val>0)
            {
                System.out.print(key + " ");
                map.put(key,val-1);
            }

        }
    }

}

}
