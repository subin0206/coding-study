import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(solve(J, S));
    }

    public static int solve(String jew, String stones){
        //1.ds
        Set<Character> set = new HashSet<>();
        //jew
        char[] charArray = jew.toCharArray();
        for(int i =0; i < charArray.length; i++) {
            set.add(charArray[i]);//a,A
        }
        int count = 0;
        char[] stoneArr = stones.toCharArray();
        for(int i =0; i < stoneArr.length; i++) {
            if(set.contains(stoneArr[i])){
                count++;
            }
        }
        return count;
    }

}
