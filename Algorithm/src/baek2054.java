import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class baek2054 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        Stack<String> stringStack = new Stack<>();
        baek2054 baek = new baek2054();
        String[] inputArray = input.split("");
        int result = 0;
        // ( ( ) [ [ ] ] )
        // ( 2 9 2
        // 2
        //[()[()[()]]]
        //
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals("(")) {
                stringStack.push("(");
            } else if (inputArray[i].equals("[")) {
                stringStack.push("[");
            } else if (inputArray[i].equals(")")) {
                while (true && !stringStack.isEmpty()) {
                    String s1 = stringStack.pop();

                    if (baek.isNumber(s1)) {
                        int num = Integer.parseInt(s1) * 2;
                        if(baek.isNumber(stringStack.peek())){
                            num = num/2 +2;
                        }
                        if (stringStack.pop().equals("(")) {
                            stringStack.push(String.valueOf(num));
                            break;
                        } else{
                            stringStack.push(String.valueOf(num));
                        }
                    } else{
                        stringStack.push("2");
                        if (s1.equals("(")) {
                            break;
                        }
                    }
                    System.out.println(stringStack);
                }

            } else if (inputArray[i].equals("]")) {
                while (true && !stringStack.isEmpty()) {
                    String s1 = stringStack.pop();
                    if (baek.isNumber(s1)) {
                        int num = Integer.parseInt(s1) * 3;
                        if(baek.isNumber(stringStack.peek())){
                            num = num/3 +3;
                        }
                        if (stringStack.pop().equals("[")) {
                            stringStack.push(String.valueOf(num));
                            break;
                        } else{
                            stringStack.push(String.valueOf(num));
                        }
                    } else{
                        stringStack.push("3");
                        if (s1.equals("[")) {
                            break;
                        }
                    }

                }
            }
            System.out.println(stringStack);
        }
        while (!stringStack.isEmpty()) {
            if (!baek.isNumber(stringStack.peek())) {
                System.out.println(0);
                break;
            } else{
                result+=Integer.parseInt(stringStack.pop());
            }
        }
        System.out.println(result);
        }

        public boolean isNumber(String s){
            if (s.equals("(") || s.equals("[") || s.equals(")") || s.equals("]")) {
                return false;
            }
            else{
                return true;
            }
        }
    }

