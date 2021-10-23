import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] strs = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(strs));
    }
    public static int calPoints(String[] strs){
        Stack<Integer> stack = new Stack();
        for (String op : strs) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek()*2);
                    break;
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x+y);
                    break;
                default:
                    stack.push(Integer.valueOf(op));

            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
