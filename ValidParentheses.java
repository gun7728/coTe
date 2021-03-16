import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String input ="{[]}";
        //true
        String input2="()[]{}";
        //true
        String input3="([)]";
        //false
        String input4="(]";
        //false

        System.out.println(solve(input2));
    }

    public static boolean solve(String input) {
        boolean output = false;
        if(input.length()==0 || input==null || input.length()%2 != 0)
            return false;
        
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<input.length();i++){
            switch (input.charAt(i)) {
                case ')':
                    if(stack.peek()=='(' && !stack.empty()){
                        stack.pop();
                    }
                    
                    break;

                case '}':
                    if(stack.peek()=='{' && !stack.empty()){
                        stack.pop();
                    }
                

                    break;

                case ']':
                    if(stack.peek()=='[' && !stack.empty()){
                        stack.pop();
                    }
                
                    
                    break;
            
                default:
                    stack.push(input.charAt(i));
                    break;
            }
        }
        if(stack.isEmpty()){
            output=true;
        }
        
        return output;
    }
}