import java.util.Arrays;
import java.util.Scanner;

public class baek1920 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] ints = new int[size];
        for (int i = 0; i < ints.length; i++) {
            int n = s.nextInt();
            ints[i] = n;
        }
        Arrays.sort(ints);
        int resultSize = s.nextInt();
        int[] result = new int[resultSize];
        for (int i = 0; i < resultSize; i++) {
            int n = s.nextInt();
            result[i] = n;
            System.out.println( binarySearch(ints, result[i] ));

        }


    }
    public static int binarySearch(int[] ints, int n){
        int mid;
        int result;
        int low = 0;
        int high = ints.length-1;
        while(low <= high){
            mid = (low+high)/2;
            if(n==ints[mid]){
                return 1;
            } else if (n >ints[mid]) {
                low = mid+1;
            } else if (n <ints[mid]) {
                high = mid-1;
            }else
                return 0;
        }
        return 0;
    }
}
