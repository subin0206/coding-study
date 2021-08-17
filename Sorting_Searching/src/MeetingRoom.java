import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args) {

        MeetingRoom a = new MeetingRoom();
//        int[][] intervals = { { 5, 10 }, { 16, 20 }, { 0, 30 } };
		int[][] intervals = { { 7, 10 }, { 2, 4 } };

        System.out.println(a.solve(intervals));

    }
    public boolean solve(int[][] intervals){
        if(intervals ==null|| intervals.length==0)
            return true;
        //1.sorting
        print(intervals);
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        System.out.println("=====================");
        print(intervals);
        //2. for
        int end = intervals[0][1]; // 0,30 sorting한 상태에서
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }

    private void print(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.println(grid[i][j] );
            }
            System.out.println();
        }
    }
}
