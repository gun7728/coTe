import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int course = 4;
        int[][] input = {{1,0},{0,1}};
        //false
        int[][] input2 = {{1,0},{2,1},{3,2}};
        //true
        CourseSchedule a = new CourseSchedule();
        System.out.println(a.solve(course,input));
    }

    public boolean solve(int course, int[][] nums){
        if(course <= 0){
            return false;
        }
        //1. inDegree 배열, queue
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[course];

        //1-1 inDegree
        int numsLength = nums.length;
        for(int i=0;i<numsLength;i++){
            inDegree[nums[i][1]]++;
        }

        //1-2 큐에넣는다, 3을 찾는다
        int inDegreeLength = inDegree.length;
        for(int i=0;i<inDegreeLength;i++){
            if(inDegree[i]==0)
                queue.offer(i);
        }

        //1-3 3을 이용해서 2를 뽑아냄
        while(!queue.isEmpty()){
            int firstZeroVal = queue.poll(); // 3

            for(int i=0;i<numsLength;i++){
                if(firstZeroVal==nums[i][0]){
                    inDegree[nums[i][1]]--;
                    if(inDegree[nums[i][1]]==0)
                        queue.offer(nums[i][1]);
                }
            }
        }

        //1-4 
        for(int i=0;i<inDegreeLength;i++){
            if(inDegree[i]!=0)
                return false;
        }

        return true;

    }
}
