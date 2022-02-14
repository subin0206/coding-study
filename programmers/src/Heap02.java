import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap02 {
    public static void main(String[] args) {
//        int jobs[][] = {{0, 3}, {1, 9}, {2, 6}};
//        int jobs[][] = {{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}};
//        int jobs[][] = {{0, 10}, {2, 12}, {9, 19}, {15, 17}};
        int jobs[][] = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
//          int jobs[][] = {{1,9},{0,11}};
        Heap02 heap02 = new Heap02();
        System.out.println(heap02.solution(jobs)
);
        heap02.solution(jobs);
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        int[] job = new int[0];
        int len = jobs.length;
        int sumTime = 0;
        int i = 0;
        int j = 0;
        while(j < len || !pq.isEmpty()) {
            while( i <len &&sumTime>=jobs[i][0] ){ // 이전 작업 요청이 끝나서 큐가 비어있음 도착한대로 처리
                pq.offer(jobs[i++]);
            }
                if(pq.isEmpty())
                    sumTime = jobs[i][0];
                else {
                    job = pq.poll(); // 내가 처리할 작업시간
                    answer += (sumTime - job[0]) + job[1]; //요청에서 종료까지 걸린 시간 더해주면서...// 3, 7 , 17
                    sumTime += job[1]; // 이전 작업들 완료 시간
                }
                j++;
        }
        return answer/len;
    }
}
