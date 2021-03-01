import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        DailyTemperature a = new DailyTemperature();

        int[] nums = {73,74,75,71,69,72,76,73};
        //out =        1 1  4  2  1  1   0  0  

        print(a.solve(nums));
    }

    public static int[] solve(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[nums.length];
        int count = 0;

        for(int i=0;i<nums.length;i++){
            while(!stack.empty() && nums[stack.peek()] < nums[i]){
                //1-0
                int index = stack.pop();
                output[index] = i-index;                

            }
            stack.push(i);
        }

        return output;
    }
    public static void print(int[] nums){
        for(int i : nums){
            System.out.println(i);
        }
    }  
}
