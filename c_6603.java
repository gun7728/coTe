import java.util.*;

public class c_6603 {
    static int n;
    static int[] arr;
    static int[] result;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            n = sc.nextInt();

            if(n==0) break;

            arr = new int[n];
            result = new int[6];

            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

    
            dfs(0,0);
            System.out.println();
        }       
        
    }

    private static void dfs(int start, int depth){
        if(depth==6){

            for(int i=0;i<6;i++){
                System.out.print(result[i] + " ");
            }

            System.out.println();
            return;
        }


        for(int i=start;i<n;i++){
            result[depth] = arr[i];
            System.out.println("result["+depth+"] : "+arr[i]+" : arr["+i+"]");
            dfs(i+1,depth+1);
        }
    }
}
