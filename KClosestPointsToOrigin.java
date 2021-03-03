import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin a = new KClosestPointsToOrigin();
        int[][] points = {{1,3},{-2,2}};
        int k=1;    //가장 빠른 길 몇개 추출할지
        int[][] result = a.solve(points,k);
        a.print(result);

    }


    public int[][] solve(int[][] points, int k){
        Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);
        int[][] result = new int[k][2];
        int index = 0;

        for(int[] p:points){
            queue.offer(p);
        }

        while(index<k){
            result[index] = queue.poll();
            index++;
        }

        return result;
    }   

    Comparator<int[]> Comp = new Comparator<int[]>(){

        @Override
        public int compare(int[] a, int[] b) {
            // TODO Auto-generated method stub
            return (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]);
        }
        
    };
    
    public void print(int[][] result){
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result.length;j++){
                System.out.println(result[i][j]);
            }
        }
    }

}
