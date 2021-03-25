import java.util.*;

public class c_3460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int bi=sc.nextInt();
            StringBuffer bin = new StringBuffer();
            bin.append(Integer.toBinaryString(bi));
            bin.reverse();
            for(int j=0;j<bin.length();j++){
                if(bin.charAt(j)=='1'){
                    System.out.print(j+ "  ");
                }
            }
        }
    }
}
