import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {
    public static void main(String[] args) {

        MeetingRoom2 a = new MeetingRoom2();
        int[][] intervals = { { 5, 10 }, { 16, 20 }, { 0, 30 } };
//		int[][] intervals = { { 7, 10 }, { 2, 4 } };
        System.out.println(a.solve(intervals));
    }
    public int solve(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);// 0번방 기준 오름차순
        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);//end 타임 기준 오름차순

        for (int[] arr : intervals) {
            if(q.isEmpty()) q.offer(arr);
            else{
                if (q.peek()[1] <= arr[0]) {
                    q.poll();
                }//10, 16
                q.offer(arr);
            }
        }
        return q.size();

    }

}
