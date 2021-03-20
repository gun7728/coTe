import java.util.*;

public class Dfs_Bfs {
    static int[][] arr;   //간선 연결상태
    static boolean[] visited;   //확인여부
    
    public static void main(String[] args) {    
        Scanner sc = new Scanner(System.in);

        int point = sc.nextInt();
        int line = sc.nextInt();
        int start = sc.nextInt();
        
        arr = new int[point+1][point+1];
        
        for(int i=0;i<line;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] =1;
            arr[b][a] =1;
        }
        
        //dfs
        
        visited = new boolean[point+1];
        dfs(start);
        System.out.println();
        
        visited = new boolean[point+1];
        bfs(start);
    }

    public static void dfs(int start){
        visited[start]=true;
        System.out.print(start+ " ");
        if(start==arr.length) return;

        for(int i=1;i<arr.length;i++){
            if(arr[start][i]==1 && visited[i]==false){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=1; i<arr.length;i++){
                if(arr[temp][i]==1 && visited[i]==false){
                    queue.offer(i);
                    visited[i]=true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
