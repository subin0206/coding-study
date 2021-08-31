import java.util.PriorityQueue;
import java.util.Queue;

public class Heap01 {
    public static void main(String[] args) {
        Heap01 heap01 = new Heap01();
        int[]scoville = {1, 2, 3, 9, 10, 12};
        heap01.solution(scoville, 7);
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int mix = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            q.add(scoville[i]);
        }

        while (!moreK(q, K)) {
            if (q.size() == 1) {
                answer = -1;
                return answer;
            }
            mix = mixScoville((int)q.poll(), (int)q.poll());
            q.add(mix);
            answer++;
        }
        return answer;
    }
    public int mixScoville(int a, int b){
        int mix = a+(b*2);
        return mix;
    }
    public boolean moreK(PriorityQueue pq, int k){
        if((int)pq.peek()>=k){
            return true;
        }
        else
            return false;
    }
}
