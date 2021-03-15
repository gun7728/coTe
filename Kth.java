import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kth {
    public static void main(String[] args) {
        Kth a = new Kth();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        //out : 5
        System.out.println(a.solve_array(nums, k));
        System.err.println(a.solve_pq(nums,k));
    }

    public  int solve_array(int[] nums, int k) {

        int length = nums.length; // 6
        Arrays.sort(nums);
        return nums[length-k];        
    }

    public  int solve_pq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comp);

        for(int val : nums){
            pq.offer(val);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    Comparator<Integer> Comp = new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return a-b;
        }
    };

}
