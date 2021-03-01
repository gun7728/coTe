/**
 * MoveZeros
 */
public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros a = new MoveZeros();

        int[] input = {3,0,9,7,2,6,8};

        a.solve(input);

    }
    

    public int[] solve(int[] input){
        int count = 0;
        for(int i=0;i<input.length;i++){
            if(input[i]==0){
                count++;
            }else{
                input[i-count]=input[i];
            }
        }


        for(int i=1;i<=count;i++){
            input[input.length-i]=0;
        }

        print(input);

        return input;
                
    }

    public void print(int[] input){
        for(int i=0;i<input.length;i++){
            System.out.println(input[i]);
        }
    }
}