import java.util.Scanner;

public class baekjoon1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double A = sc.nextDouble();
        Double B = sc.nextDouble();
        if(A>0 && B<10){
            System.out.println(A/B);
        }
    }
}
