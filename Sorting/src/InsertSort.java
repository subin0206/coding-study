public class InsertSort {
    public static void main(String[] args) {
        int[] array = {1,10, 5,8,7,6,4,3,2,9};
        int temp = 0;
        int j =0;
        for (int i = 0; i < 9; i++) {
            j =i;
            while (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j+1] = temp;
                j--;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }
}
