import java.util.*;

public class c_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum =0;
        int[] list = new int[9];
        for(int i=0;i<list.length;i++){
            list[i]=sc.nextInt();
            sum += list[i];
        }

        Arrays.sort(list);;
        for(int i=0;i<9;i++){
            for(int j=i+1;j<9;j++){
                if(sum-list[i]-list[j]==100){
                    for(int k=0; k<9; k++){
                        if(i==k || j ==k){
                            continue;
                        }
                        System.out.println(list[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
