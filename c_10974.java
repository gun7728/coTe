import java.util.*;

public class c_10974 {
    static int[] output;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];  
        output = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            System.out.println(" : "+i);
            visited[i] = true;
            dfs(arr, visited,n,i,0);
            visited[i] =false;
        }
    }

    private static void dfs(int[] arr, boolean[] visited, int n, int start, int depth){  
        output[depth] = start+1;

        if(depth == n-1){
            for(int i=0;i<n;i++){
                System.out.print(output[i]+ " ");
                System.out.println(" : "+i);
            }   
            System.out.println();
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(arr,visited,n,i,depth+1);
                visited[i]=false;
            }
        }
    }
}
