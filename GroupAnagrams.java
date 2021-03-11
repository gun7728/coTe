import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};


        //out
        // ["ate","eat","tea"]
        // ["nat","tan"]
        // ["bat"]

        System.out.println( GroupAnagrams(input));
    }

    public static List<List<String>> GroupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length==0)
            return result;

        Map<String,List<String>> map = new HashMap<>();

        //2
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            
            String key = String.valueOf(charArray);
            
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
            
        }

        result.addAll(map.values());

        return result;

    }
}
