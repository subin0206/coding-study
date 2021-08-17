import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution02 {
    public static void main(String[] args) {
        Solution02 s = new Solution02();
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.print(s.solution(numbers));
    }
    public String solution(int[] numbers) {
        String str = Arrays.toString(numbers).replaceAll("[^0-9]","");
        String[] strArray = str.split("");
        Integer [] intArray = new Integer[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        Arrays.sort(intArray, Collections.reverseOrder());

        String answer = Arrays.toString(intArray).replaceAll("[^0-9]","");
        return answer;
    }

}
