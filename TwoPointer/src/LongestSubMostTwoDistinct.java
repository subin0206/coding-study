import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDistinct {
    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(solve_map(s));
    }

    public static int solve_map(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l =0, r =0, counter =0, max=0;
        //map을 채워주는 것을 의미
        while (r < s.length()) {
            char c = s.charAt(r); // ccaabbb
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c)==1) {
                counter++;
            }
            r++;
            //이 map에 있는것을 삭제하거나 조정
            while (counter > 2) {
                char c2 = s.charAt(l);
                map.put(c2, map.get(c2)-1);
                if (map.get(c2) == 0) {
                    counter--;
                    l++;
                }
            }
            max = Math.max(max, r-l);


        }
        return max;
    }
}
