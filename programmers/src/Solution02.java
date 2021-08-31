import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution02 {
    public static void main(String[] args) {
        Solution02 s = new Solution02();
        int[] numbers = {6, 10, 2};

        System.out.print(s.solution(numbers));
    }
    public String solution(int[] numbers) {
        String answer = "";
        doPermutation(numbers,0);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }

        return answer;
    }
    public int[] doPermutation(int[] arr, int startIdx) {
        int length = arr.length;
        int result[] = new int[(arr.length*arr.length-1)-2];
        int count =0;

        if(startIdx == length - 1) {
            for (int i = 0; i < result.length; i++) {
                result[i] = arr[i];

            }

            System.out.println(count+"count");
            System.out.println();
        }

        for(int i = startIdx; i < length; i++) {
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx + 1);
            swap(arr, startIdx, i);
        }
        return arr;
    }

    public void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

}
