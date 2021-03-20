import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import jdk.internal.jshell.tool.resources.l10n;

public class cote2 {
    public static void main(String[] args) {
        // 1.
        //  8 ≤ password 길이 ≤ 15
        // 2.
        // [1] 알파벳 대문자(A~Z)
        // [2] 알파벳 소문자(a~z)
        // [3] 숫자(0~9)
        // [4] 특수문자(~!@#$%^&*)
        // 3.
        // password는 (2.)에서 명시된 4 종류의 문자 그룹 중에서 3 종류 이상을 포함해야 합니다.
        // 4.
        // password에 어떤 문자라도 같은 문자가 4개 이상 연속될 수 없습니다.
        // 5.
        // password에 어떤 문자라도 같은 문자가 5개 이상 포함될 수 없습니다.

        cote2 a =new cote2();
        // String inp_str ="AaTa+!12-3";
        // String inp_str ="aaaaZZZZ)";
        String inp_str ="CaCbCgCdC888834A";
        //2
        a.solution(inp_str);
    }
    public int[] solution(String inp_str) {
        boolean[] pass = new boolean[4];
        pass[0]=false;
        pass[1]=false;
        pass[2]=false;
        pass[3]=false;
        int[] answer2 = new int[5];
        String two_4 = "~!@#$%^&*";
        if(inp_str.length()>15 || inp_str.length()<8){
           answer2[0]=1;
        } 
        for(char chrInput : inp_str.toCharArray()){            
            if (chrInput >= 0x61 && chrInput <= 0x7A) {
                // 영문(소문자) OK!
                pass[0]=true;
            } 
            else if (chrInput >=0x41 && chrInput <= 0x5A) {
                // 영문(대문자) OK!
                pass[1]=true;
            }
            else if (chrInput >= 0x30 && chrInput <= 0x39) {
                pass[2]=true;
                // 숫자 OK!
            }
            else if(two_4.contains(String.valueOf(chrInput))){
                pass[3]=true;

            }else{            
                answer2[1]=2;

            }
        }
        int count=0;
        for(boolean p : pass){
            System.out.println(p);
            if(p==true){         
                count++;
            }
        }
        if(count>=3){

        }else{
            answer2[2]=3;
        }
        count=0;
        Stack<Character> num4 = new Stack<>();
        for(char chrInput : inp_str.toCharArray()){
            if(num4.isEmpty()){
                num4.push(chrInput);
            }else if(num4.peek()==chrInput){
                count++;
            }
        }
        System.out.println("count : "+count);
        if(count>=4){
            answer2[3]=4;
        }
       

        

        count =1;
        Set<Character> num5 = new HashSet<>();
        for(char chrInput : inp_str.toCharArray()){  
            if(num5.contains(chrInput)){
                count++;
            }else{
                num5.add(chrInput);
            }

            
        }
        if(count>=5){
            answer2[4]=5;
        }
        System.out.println("count : "+count);

        
        

        // Arrays.sort(answer);        
        count=0;
        for(int i : answer2){
            if(i!=0){
                count++;
            }
        }
        int[] answer=new int[count];
        if(count==0){
            answer = new int[1];
            answer[0]=0;
        }        
        System.out.println(count);

        count=0;
        for(int i: answer2){
            if(i!=0){                
                answer[count]=i;
                count++;
            }
        }

      
        return answer2;
    }
}
