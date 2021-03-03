public class LicenseKeyFormatting {
    public static void main(String[] args) {
        LicenseKeyFormatting a = new LicenseKeyFormatting();
        String str = "8F3Z-2e-9-w-8-5g-3-J";
        String str2 = "8-5g-3-J";
        int k=4;

        //8F3Z-2E9W  ,  8-5G3J
        System.out.println(a.solve(str,k));
    }

    public StringBuilder solve(String str, int k){
        StringBuilder output = new StringBuilder();
        
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != '-'){
                output.append(str.charAt(i));
            }
        }
        
        for(int i=output.length();i>0;i= i-4){
            if(i==0 || i==output.length()){

            }else{
                output.insert(i, "-");
            }
        }

        
        

        return output;
    }
}
