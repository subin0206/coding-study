import java.util.HashMap;
import java.util.Map;

public class LongestSubWithoutRepeatChar {
    public static void main(String[] args) {
		String input = "pwwkea";
//        String input = "abcabcd";
        System.out.println(solve_map(input));
    }

    public static int solve_map(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l =0, r=0, counter =0, max =0;

        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c,0)+1);
            if (map.get(c) > 1) {
                counter++;
            }
            r++;

            System.out.println(r+"- r");
            while (counter > 0) {
                char c2 = s.charAt(l);
                if(map.get(c2) >1)
                    counter--;
                map.put(c2, map.get(c2)-1);
                l++;
                System.out.println(l+"-l");
                System.out.println(counter+"-counter");
                System.out.println(c2+"-c2");

            }
            max = Math.max(max, r - 1);
        }
        return max;
    }
}
