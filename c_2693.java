import java.util.*;

public class c_2693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int[] result = new int[a];
        for(int i=0;i<a;i++){
            int[] list = new int[10];
            for(int j=0;j<10;j++){
                list[j]=sc.nextInt();
            }
            Arrays.sort(list);
            System.out.println(list[7]);
        }

       
    }
}
