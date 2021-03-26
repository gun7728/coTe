import java.util.*;

public class c_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int count=0;
        for(int i=0;i<a;i++){
            int b=sc.nextInt();
            int innerCount = 0;
            for(int j =1;j<=b;j++){
                if(b%j==0)
                    innerCount++;                
            }
                if(innerCount==2)
                  count++;
                       
        }

        System.out.println(count);
    }
}
