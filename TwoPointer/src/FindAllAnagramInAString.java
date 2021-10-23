import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramInAString {
    public static void main(String args[]) {
        FindAllAnagramInAString a = new FindAllAnagramInAString();
        String s = "bacdgabcda";
        String p = "abcd";
//        System.out.println(a.solve_array(s, p));
        a.solve_array(s,p);
    }

    public List<Integer> solve_array(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s==null||s.length() == 0 || p==null || p.length() == 0 || s.length() < p.length())
            return result;

        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i)-'a']++;
            System.out.println(pArr[i]);
        }
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] sArr = new int[26];
            for (int j = 0; j < p.length(); j++) {
                sArr[s.charAt(i+j)-'a']++;
            }

        }

        return result;

    }
}
