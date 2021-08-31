import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        TwoSum a = new TwoSum();
        int[] nums = { 2, 8, 11, 14 };
        int target = 16;
//		int[] result = a.solve_for(nums, target);
        int[] result = a.solve(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                result[0] = val+1;
                result[1] = i+1;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return result;
    }
//성능 안 좋음
    public int[] solve_for(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[] {0,0};
    }

    }

