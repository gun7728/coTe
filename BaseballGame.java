import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] input = {"5","-2","4","C","D","9","+","+"};

        //out : 27


        solve(input);
    }

    public static int solve(String[] input) {
        int output = 0;
        int sum =0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(String str : input){
            if(str.chars().allMatch( Character :: isDigit) || str.charAt(0) == '-'){
                stack.push(Integer.parseInt(str));
                sum += Integer.parseInt(str);
            }else{
                switch (str) {
                    case "C":
                        sum = sum - stack.pop();
                        System.out.println(sum);

                        break;

                    case "D":
                        int d = stack.peek()*2;
                        stack.push(d);
                        sum = sum+stack.peek();
                        System.out.println(sum);

                        break;

                    case "+":
                        System.out.println(sum);
                        int pop = stack.pop();
                        int pop2 = stack.pop();
                        int plus = pop+pop2;
                        System.out.println(pop+","+pop2);
                        sum = sum+plus;

                        stack.push(pop2);
                        stack.push(pop);
                        stack.push(plus);
                        


                        break;
                
                    default:
                        System.out.println("이상");
                }
            }
        }

            System.out.println(sum);

        return output;
    }
}
