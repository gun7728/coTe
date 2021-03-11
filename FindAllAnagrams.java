import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args) {
        FindAllAnagrams a = new FindAllAnagrams();

        String txt = "BACDGABCDA";
        String pat = "ABCD";

        //output 056

        a.solve(txt, pat);
    }

    public void solve(String txt, String pat){
        List<Integer> result = new ArrayList<>();

        //2. 패턴어레이 생성
        int[] patArr = new int[256]; // [0,0,0,0,0,0,0]
        for(int i=0; i<pat.length();i++){
            patArr[pat.charAt(i)]++;
        }

        for(int i=0;i<txt.length()-pat.length()+1;i++){
            int[] txtArr = new int[256];

            for(int j=0;j<pat.length();j++){
                txtArr[txt.charAt(i+j)]++; //0+,1+,2+,
            }

            if(check(patArr, txtArr)){
                result.add(i);
            }
        }

        System.out.println(result);
        

    }

    public boolean check(int[] patArr, int[] txtArr){
        for(int i=0; i<patArr.length; i++){
            if(patArr[i]!=txtArr[i]){
                return false;
            }
        }
        return true;
    }
}
