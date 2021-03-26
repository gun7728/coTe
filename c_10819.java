import java.util.*;

public class c_10819 {
    static int n;
    static int[] arr;
    static int[] tArr;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] =sc.nextInt();
        }
        visited = new boolean[n];
        tArr = new int[n];
        max = 0;
        solve(0);
        System.out.println(max);
    }   

    private static void solve(int cnt){
        //배열이 만들어 지면 
        if(cnt==n){
            int sum =0;
            //만든 배열로 값 계산
            for(int i=0;i<n-1;i++){
                sum+= Math.abs(tArr[i]-tArr[i+1]);
                //최대값 찾기
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                tArr[cnt] = arr[i]; //새로운 배열 생성
                solve(cnt+1);
                visited[i] = false;
            }
        }
    }
}
