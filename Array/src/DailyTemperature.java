import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
//		int[] res = solve_0(nums);
//        int[] res = solve_1(nums);
        int[] res = solve_stack(nums);

        System.out.println("====result===");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] solve_1(int[] tem) {
        int len = tem.length;
        int[] result = new int[len];
        int count = 0, j;
        for (int i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                if(tem[i] < tem[j]){
                    count++;
                    break;
                }else{
                    count++;
                }
            }
            if(j==tem.length)
                result[i] =0;
            else
                result[i] = count;
            count = 0;
        }
        return result;
    }

    public static int[] solve_stack(int[] tem) {
        int len = tem.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && tem[stack.peek()] < tem[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }
        return result;
    }
}
