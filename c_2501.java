import java.util.*;

public class c_2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i= 1;
        int count = 0;

        while(i<=a){
            if(a%i==0)
                count++;
            if(count==b)
                break;

            i++;
        }
        
        if(count < b){
            System.out.println(0);
        }  
            System.out.println(i);
      
    }
}
