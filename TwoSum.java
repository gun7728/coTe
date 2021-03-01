import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum a = new TwoSum();

        int[] nums = {2,3,10,21,8};
        int target=10;

        //{1,2}

        int[] output = a.solve(nums,target);
        System.out.println(output[0]+", "+output[1]);
    }

    public int[] solve(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] output = new int[2];

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                output[0]=map.get(nums[i])+1;
                output[1]=i+1;
            }else{
                map.put(target-nums[i], i);     // 뺸 값 : 8 / 위치 : 0
            }                                   // 맵 안에 (8,0)
        }

        return output;
       
    }
}
