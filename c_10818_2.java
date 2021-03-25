import java.util.*;

public class c_10818_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int min =  1000001;
        int max =  -1000001;
        for(int i=1; i<=a;i++){
            int b = sc.nextInt();
            if(i==1){
                min = b;
            }
            min = Math.min(min, b);
            max = Math.max(max, b);
        }

        System.out.println(min+" "+max);
    }
}