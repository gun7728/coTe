import java.util.HashMap;
import java.util.Map;

/**
 * LongestSubstringWithAtMostTwoDistinct
 */
public class LongestSubstringWithAtMostTwoDistinct {

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinct a = new LongestSubstringWithAtMostTwoDistinct();

        String input = "ccaabddeeeea";

        System.out.println(a.solve(input));

    }

    public int solve(String input) {

        int start = 0, end = 0, length = 0, counter = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end < input.length()) {
            char endChar = input.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1); // c=2, a=2, b=3
            if (map.get(endChar) == 1)
                counter++;
            end++;

            while (counter > 2) {
                char startChar = input.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0)
                    counter--;
                start++;
            }
            length = Math.max(length, end - start);
        }

        System.out.println(map);

        return length;

    }
}