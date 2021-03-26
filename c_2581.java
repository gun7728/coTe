import java.util.*;

public class c_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        
        if(a>b){
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=a;i<=b;i++){
            int count=0;
            for(int j=1;j<=i;j++){
                if(i%j==0)
                    count++;   
            }
            if(count==2){
                q.add(i);
            }
        }
        int sum = 0;
        if(q.isEmpty()){
            System.out.println(-1);
        }else{
            int result = q.peek();

            while(!q.isEmpty()){
                sum+=q.poll();
            }
    
            System.out.println(sum);
            System.out.println(result);
        }
      
    }
}
