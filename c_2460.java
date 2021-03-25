import java.util.*;

public class c_2460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        // map.put(1, 0);
        for(int i=1;i<=10;i++){
            if(i==1){
                int a= sc.nextInt();
                int b = sc.nextInt();
                int sum = b-a;
                map.put(i, sum);
            }else if(i==10){
                int a = map.get(i-1) - sc.nextInt();
                map.put(i,a);
               
            }else{
                int a= map.get(i-1) - sc.nextInt();
                int b = a+ sc.nextInt();
                map.put(i,b);
            }
            
        }
        int max = 0;
        for(int i=1;i<=map.size();i++){
            max = Math.max(max,map.get(i));
        }

        System.out.println(max);
    }
}
