import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones a = new JewelsAndStones();
        String j ="aA";
        String s = "aAAbbbb";

        //output = 3
        System.out.println(a.solve(j,s));
    }

    public int solve(String j, String s){
        Set<Character> set = new HashSet<>();
        for(int i=0;i<j.length();i++){
            set.add(j.charAt(i));   //a.A
        }
        int count=0;
        for(char stone : s.toCharArray()){
            if(set.contains(stone)){
                count++;
            }
        }
        

        return count;
    }
}
