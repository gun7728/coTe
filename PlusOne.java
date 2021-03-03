import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne a = new PlusOne();
        int[] input ={2,9,9,9};
        //out 124

        int[] input2 = {9,9,9};
        //out 1000

        a.solve(input);
    }

    public void solve(int[] input){
        List<Integer> list = new ArrayList<Integer>();
        
        int add=1;

        for(int i=input.length-1; i>=0; i--){
            if((input[i]+add)/10==1){
                list.add((input[i]+add)%10);
                add=1;
            }else{
                list.add((input[i]+add)%10);
                add=0;
            }
        }
        if(add==1){
            list.add(1);
        }

        Collections.reverse(list);


        System.out.println(list);
        // for(int i : output){
        //     System.out.println(i);
        // }
        
    }

    
  
}
