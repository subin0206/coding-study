import java.util.*;

public class BruteForce01 {
    public static void main(String[] args) {
        BruteForce01 b = new BruteForce01();
        int[] answers = {1,2,3,4,5};
//        int[] answers = {1,3,2,4,2};
        b.solution(answers);
    }
    public int[] solution(int[] answers) {
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};

        int[] testResult = {0,0,0};
        for (int i = 0; i < answers.length; i++) {
            if(student1[i%student1.length]==answers[i]) {
                testResult[0]++;
            }
            if(student2[i%student2.length]==answers[i])
                testResult[1]++;
            if(student3[i%student3.length]==answers[i])
                testResult[2]++;

        }
        ArrayList<Integer> list = new ArrayList<>();

        int maxV = 0;
        for (int i = 0; i < testResult.length; i++) {
            list.add(testResult[i]);
        }

        maxV = Collections.max(list);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(maxV == list.get(i))
                count++;
        }
        int[] answer = new int[count];
        int j =0;
        for (int i = 0; i < list.size(); i++) {
            if(maxV == list.get(i)) {
                answer[j] = i + 1;
                j++;
            }
        }

        return answer;
    }
}
