import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        MergeInterval a = new MergeInterval();
        int[][] intervals = {
                { 1, 4 },
                { 8, 10 },
                { 2, 6 },
                { 15, 18 }
        };
        int[][] res = a.solve(intervals);
        for (int[] arr : res) {
            System.out.println("result");
            System.out.println(arr[0] + ":" + arr[1]);
        }
    }
    public int[][] solve(int[][] intervals){
        List<int[]> res = new ArrayList<>();
        if(intervals.length==0||intervals ==null)
            return  res.toArray(new int[0][1]);

        //ds
        //1. sorting
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);//시작 기준 오름차순
        System.out.println(intervals);

        //for
        int start = intervals[0][0];
        int end = intervals[0][1];

        //start =1 end= 4
        for (int i = 0; i < intervals.length; i++) {
            if(end >= intervals[i][0]){ // 전end >= 현 start
                end = Math.max(end, intervals[i][1]);// 전 end 와 현 start 끝 시간중 큰 거가 합친 시간의 끝시간이 된다.
                //(1,4)(2,6) => 1,6
            }else{
                //1, 6
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            res.add(new int[]{start, end}); //15,18
        }
        return res.toArray(new int[0][]);
    }
}
