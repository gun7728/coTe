import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class cote3 {
    public static void main(String[] args) {
        String program = "trip";
        String[] flag_rules = {"-days NUMBERS", "-dest STRING"};        
        String[] commands ={"trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"};
        // String[] commands ={"line -s 123 -n HI", "line fun"};
        // String[] commands ={"line -n 100 -s hi -e", "lien -s Bye"};

        
        cote3 a= new cote3();
       a.solve(program, flag_rules, commands);
    }

    public  boolean[] solve(String program, String[] flag_rules, String[] commands){
        boolean[] comBoolean = new boolean[commands.length];    //  판별을 담을 배열 생성        
        Arrays.fill(comBoolean, true);

        if(flag_rules.length==0 || flag_rules==null || commands.length==0 || commands ==null){  // 널판별
             Arrays.fill(comBoolean, false);
            return comBoolean;
        }

        if(program.length()<1 || program.length()>10 || flag_rules.length<1 ||
             flag_rules.length>100 || commands.length<1 || commands.length >100 ){  //길이 판별
            Arrays.fill(comBoolean, false);
            return comBoolean;
        }
        
        Map<String, String> flagMap = new HashMap<>();  // flag_name과 flag_argument_type을 담을 그릇 생성
        for(int i=0;i<flag_rules.length;i++){
            String[] flag = flag_rules[i].split(" ");
            String flag_name = flag[0];             // name에 앞부분 값 설정
            String flag_rule = flag[1];             // rule에 뒷부분 값 설정

            if(flag_name.charAt(0)=='-' && flag_name.length() >=2 && flag_name.length() <=10){    // "-"" 시작 및 길이 판별                
                String name = flag_name.substring(1,flag_name.length());                          // "-"를 제외한 부분
                for(char c : name.toCharArray()){  // 제외한 부분에 여어 대소문자 판별
                    if(c>=0x61 && c <=0x7A){
                        
                    }
                    else if (c >=0x41 && c <= 0x5A) {

                    }else{
                        Arrays.fill(comBoolean, false);
                        return comBoolean;
                    }
                }
                
                flagMap.put(flag_name, flag_rule);
            }else{
                Arrays.fill(comBoolean, false);
                return comBoolean;
            }

        }
        System.out.println(flagMap); // 맵 확인

        Queue<String> comStack = new LinkedList<>();                 //  커맨드를 담을 스택        
     
        int loc = 0;                                            //  판별을 위치를 위한 값 선언
        String[] commandList;                                   //  커맨드를 담을 그릇 생성

        for(String command : commands){
            if(command.length() <1 || command.length() >100){   //  커맨드속에 커맨드 길이 판별 후 스택에 쌓기
                Arrays.fill(comBoolean, false);
                return comBoolean;
            }
                comStack.offer(command);

        }        
        System.out.println(comStack);
        while(!comStack.isEmpty()){                             //  스택이 0될때까지 반복
            String com = comStack.poll();
            //lien -s Bye1
            //line -n 100 -s hi -e2
            Queue<String[]> bool = new LinkedList<>();                 // 명령어가 맞는지 판별하기 위한 스택 생성
            // System.out.println(com);
            bool.offer(com.split(" "));
            
            if(!bool.peek()[loc].equals(program)){
                comBoolean[loc]=false;
            }else{
                for(int i=0;i<bool.peek()[loc].length();i++){
                    switch (bool.peek()[i]) {
                        case "-days" :
                        case "-n" :
                            if(flagMap.get("-n").equals("NUMBERS") || flagMap.get("-days").equals("NUMBERS")){    
                                for(int j=i+1;j<bool.peek().length;j++){
                                    for(char chrInput : bool.peek()[j].toCharArray()){ 
                                       if(chrInput=='-'){
                                            j=bool.peek().length;
                                            break;
                                       }else{
                                            if (chrInput >= 0x61 && chrInput <= 0x7A) {
                                                comBoolean[loc] = false;
            
                                            } 
                                            else if (chrInput >=0x41 && chrInput <= 0x5A) {
                                                comBoolean[loc] = false;
            
                                            }else{ 
                                                comBoolean[loc]= true;
                                                    
                                            }        
                                       }
                                       
                                    }
                                }

                            }else if(flagMap.get("-n").equals("NUMBER") || flagMap.get("-days").equals("NUMBER")){
                                for(char chrInput : bool.peek()[i+1].toCharArray()){
                                    if (chrInput >= 0x61 && chrInput <= 0x7A) {
                                        comBoolean[loc] = false;
    
                                    } 
                                    else if (chrInput >=0x41 && chrInput <= 0x5A) {
                                        comBoolean[loc] = false;
    
                                    }else{ 
                                        comBoolean[loc]= true;
                                            
                                    }            
                                }  
                            }
                            
                            break;

                        case "-s":
                            if(flagMap.get("-s").equals("STRING") || flagMap.get("-dest").equals("STRING")){    
                                for(char chrInput : bool.peek()[i+1].toCharArray()){
                                    System.out.println(chrInput);
                                    if (chrInput >= 0x61 && chrInput <= 0x7A) {
                                        comBoolean[loc]= true;
                                    } 
                                    else if (chrInput >=0x41 && chrInput <= 0x5A) {
                                        comBoolean[loc]= true;
                                    }else{                                
                                        comBoolean[loc] = false;
                                    }                          
                                }
                            }else  if(flagMap.get("-s").equals("STRINGS") || flagMap.get("-dest").equals("STRINGS")){
                                for(int j=i+1;j<bool.peek().length;j++){
                                    for(char chrInput : bool.peek()[j].toCharArray()){
                                        if(chrInput=='-'){
                                            j=bool.peek().length;
                                            break;                                        
                                        }else{
                                            if (chrInput >= 0x61 && chrInput <= 0x7A) {
                                                comBoolean[loc] = false;
                                            }else if (chrInput >=0x41 && chrInput <= 0x5A) {
                                                comBoolean[loc] = false;
                                            }else{                                
                                                comBoolean[loc] = true;
                                            }     
                                        }                     
                                    }
                                }
                            }
                        
                            break;

                        case "-e":
                            if(bool.peek()[i+1]!=null){
                                comBoolean[loc] = false;
                            }                      
            
                            break;
                        default:
                    }
                }


            }

           



            loc++;
        }
        //{-n=NUMBER, -s=STRING, -e=NULL}
        

        

        boolean[] answer = new boolean[comBoolean.length];
        answer = comBoolean;
        
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        
        return answer;
    }
}
