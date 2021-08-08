import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon16916 {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = bf.readLine();
            String p = bf.readLine();
            if(s.contains(p))
                System.out.println(1);
            else
                System.out.println(0);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
