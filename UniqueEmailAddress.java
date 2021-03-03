import java.util.HashSet;
import java.util.Set;

/**
 * UniqueEmailAddress
 */
public class UniqueEmailAddress {
    public static void main(String[] args) {
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] email = {"test.email+james@coding.com",
                        "test.e.mail+toto.jane@coding.com",
                        "testemail+tom@cod.ing.com"};
        //output : 2
        //testemail@coding.com
        //testemail@cod.ing.com

        a.solve(email);
    }

    public void solve(String[] emails){
        Set<String> set = new HashSet<>();

        for(String email : emails){
            String id = id(email);
            String add = add(email);

            String changeEmail = id+add;
            set.add(changeEmail);
        }

        System.out.println(set);
        System.out.println(set.size());

    }

    public String id(String email){
        for(int i=0;i<email.length();i++){
            if(email.charAt(i)=='+'){
                email = email.substring(0,i);
                email = email.replace(".", "");
            }
        }
        return email;
    }

    public String add(String email){
        for(int i=0;i<email.length();i++){
            if(email.charAt(i)=='@'){
                email = email.substring(i,email.length());
            }
        }

        return email;
    }
}