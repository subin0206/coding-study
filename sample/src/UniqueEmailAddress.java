import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@cod.ing.com",
                "testemail+tom@cod.ing.com" };
//        System.out.println(a.solve_1(emails));
        System.out.println(a.solve_split(emails));
    }
    public int solve_1(String[] emails){
        Set<String> set = new HashSet<>();

        //charAt
        for(String email : emails){
            String localName = makeLocalName(email);
            String dName = makeDName(email);

            set.add(localName+"@"+dName);
        }
        System.out.println(set);

        return set.size();
    }
    public int solve_split(String[] emails){
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String[] localName = parts[0].split("\\+");//+에러나서 \\ 붙여줌
            set.add(localName[0].replace(".","") +"@"+parts[1]); //.을 없게해줌
        }
        System.out.println(set);
        return set.size();
    }

    public String makeLocalName(String email){
        StringBuilder sb = new StringBuilder();

        for(int i =0; i < email.length(); i++){
            if(email.charAt(i)=='.'){
                continue;
            }
            if(email.charAt(i)=='+' || email.charAt(i)=='@'){
                break;
            }
            sb.append(email.charAt(i));
        }
        return  sb.toString();
    }

    public String makeDName(String email) {
        return email.substring(email.indexOf("@")+1);
    }
}

