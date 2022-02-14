import java.util.*;

public class Queue01 {
    public static void main(String[] args) {
     int[] progress = {20, 99, 93, 30, 55, 10};
     int[] speeds = {5, 10, 1, 1, 30, 5};
        solution(progress, speeds);
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Stack <Integer>  stack= new Stack();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] answer = {};
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            queue.offer((int) Math.ceil((100-progresses[i])/(double)speeds[i]));
        }
        int temp1 = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
                int temp2 = queue.poll();
                if(temp1 >= temp2){
                    count++;
                }else{
                    temp1 = temp2;
                    arrayList.add(count);
                    count=1;
                }
            }
        arrayList.add(count);
        System.out.println(arrayList);
        answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
