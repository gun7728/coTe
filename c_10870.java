import java.util.*;

public class c_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] pi = new int[n+1];

        for(int i=0;i<pi.length;i++){
            if(i==0){
                pi[0]=0;
            }else if(i==1){
                pi[1]=1;
            }else
                pi[i] = pi[i-1]+pi[i-2];
        }

        System.out.println(pi[n]);
    }
}
