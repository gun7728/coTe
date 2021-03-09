public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray a =new MaximumSubarray();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};        
        int[] nums2 = {-2,1,-3,4,-1,2,1,-5,4,9,7,-12,21,1,7,-4,5,9,};

        a.solve(nums);
    }

    public void solve(int[] input){
        int max =0;
        int newSum=0;
        for(int i=0; i<input.length; i++){
            if(i==0){
                newSum = input[0];            }
                newSum = Math.max(input[i],newSum+input[i] );
                max = Math.max(max, newSum);

                System.out.println("newSum : "+newSum+"   max : "+max);
        }
        System.out.println(max);
    }
}
