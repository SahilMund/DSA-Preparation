package hashmap;


import java.util.HashMap;

public class ExtractUniqueChars {

    public static String uniqueChar(String str){
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        HashMap<Character,Integer> map = new HashMap<>();

        String res = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(map.containsKey(ch)){
                // key already present
                continue;
            }
            map.put(ch,1);
            res += ch;
        }

        return res;

    }
}