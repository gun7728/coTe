import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String input = "(a)())()";
        // out : ["(a)()()","(a())()"]

        String input2 = "()())()";
        // out : ["()()()","(())()"]

        RemoveInvalidParentheses a = new RemoveInvalidParentheses();
        System.out.println(a.removeInvalidParentheses(input));
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        // 2
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    res.add(str);
                    found = true;
                }
                if (found) {
                    continue;
                }

                // 0 ~ 7 -> 6 자리
                for (int j = 0; j < str.length(); j++) {
                    //1
                    if(str.charAt(j)!='(' && str.charAt(j)!=')')
                        continue;

                    //2
                    String newStr = str.substring(0,j)+str.substring(j+1);
                    if(!visited.contains(newStr)){
                        queue.offer(newStr);
                        visited.add(newStr);
                    }                    
                }
            }
        }
        return res;
    }

    public boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                // (), ())(
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
