import java.util.*;

public class c_1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt()-1;
        int b = sc.nextInt()-1;
        int sum = 0;

        int[] list = new int[b+1];

        int count=0;

        for(int i=1;i<=b+1;i++){
            for(int j=1;j<=i;j++){ 
                if(count>b){
                    break;
                }else{             
                    list[count]=i;
                    count++;     
                }
            }
        }


        if(a!=b){
            for(int i=a;i<=b;i++){
                sum+=list[i];
            }
        }else{
            sum =list[a];
        }
       

        System.out.println(sum);

    }
}