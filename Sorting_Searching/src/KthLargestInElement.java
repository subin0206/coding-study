import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInElement {
    public static void main(String[] args) {
        KthLargestInElement a = new KthLargestInElement();
		int[] nums = { 2, 3, 1, 5, 6, 4 };
		int k = 2;

//        int[] nums = { 3,2,3,1,2,4,5,5,6 };
//        int k = 4;
        System.out.println(a.solve(nums, k));
        System.out.println(a.solve_pq(nums, k));
    }

    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;//6
        return nums[n-k]; // 6,5,4....etc
    }

    public int solve_pq(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(); // asc minHeap

        for (int i : nums) {
            pq.offer(i);//다 넣음
            if (pq.size() > k) { //사이즈를 오버하면
                pq.poll(); // 빼버림
            }
        }
        return pq.peek();

    }
}
