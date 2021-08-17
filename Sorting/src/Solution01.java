import java.util.Arrays;

public class Solution01 {
    public static void main(String[] args) {
        Solution01 s = new Solution01();
        int array[] = {1, 5, 2, 6,3,7,5};
        int commands[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        for(int i =0; i < commands.length; i++)
            System.out.println(s.solution(array,commands)[i]);
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int start = 0;
        int end = 0;

        for (int i = 0; i < commands.length; i++) {
            start = commands[i][0];
            end = commands[i][1];
            int[] temp = new int[end-start+1];
            int result = 0;

            for(int j =start-1; j < end; j++){
                temp[result] = array[j];
                result++;
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];

        }
        return answer;
    }

}
