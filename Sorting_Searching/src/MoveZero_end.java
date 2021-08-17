public class MoveZero_end {
    public static void main(String args[]) {

        int[] nums = { 0, 3, 2, 0, 8, 5 };
        int n = nums.length;//6 , index-1

        int index = n-1;// 5

        //2for
        //array+0 index
        for(int i =n-1; i>=0; i--){
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index--;
                System.out.println(nums[i]+"nums");
            }
        }
        while (index >=0) {
            nums[index] = 0;
            index--;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

}
