import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] list = { "eat", "tea", "tan", "ate", "nat", "bat" };
//        System.out.println("re "+groupAnagrams(list));
//		System.out.println(groupAnagrams_ascii(list));
        System.out.println(solve(list));
    }

    public static List<List<String>> solve(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null||strs.length==0)
            return result;
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
//            System.out.println(key);

//            if (map.containsKey(key)) {
//                map.get(key).add(str);
//            }else{
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(key, list);
//            }
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
//        result.addAll(map.values());
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> solve_ascii(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int k = 0; k < str.length(); k++) {
                count[str.charAt(k)-'a']++;
            }
            String key = Arrays.toString(count);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return result;
    }
}
