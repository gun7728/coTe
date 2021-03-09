import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    public static void main(String[] args) {
        FindAnagramsMapping a = new FindAnagramsMapping();

        int[] A = {11,27,45,31,50};
        int[] B = {50,11,31,45,27};

        //out : 1 4 3 2 0

        a.solve(A,B);
    }
    public void solve(int[] A, int[] B){
        int[] output = new int[A.length];

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        int count =0;

        for(int i : B){
            map.put(i, count++);
        }

        count =0;

        for(int i : A){
            if(map.containsKey(i)){
                System.out.println(i);
                output[count] = map.get(i);           
                count++;
            }
        }


        for(int i:output){
            System.out.println(i);
        }
    }
}
