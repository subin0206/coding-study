import java.lang.reflect.Array;
import java.util.*;

public class bk2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number =sc.nextInt();
        Set<Integer> s = new HashSet<Integer>();

        for (int i = 0; i < number; i++) {
            s.add(sc.nextInt());
        }
        List<Integer> list = new ArrayList<>(s);
        Collections.sort(list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+" ");
        }
    }

}
