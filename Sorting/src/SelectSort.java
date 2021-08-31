public class SelectSort {
    public static void main(String[] args) {
        int i, j, min;
        int index = 0;
        min =0; int temp = 0;
        int[] array = {1,10, 5,8,7,6,4,3,2,9};
        for (i = 0; i < 10; i++) {
            min = 9999;//모든 원소들보다 큰 숫자 왜냐면 항상 최솟값 선택해야하기 때문에
            for (j = i; j < 10; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            //가장 앞에 있는것과 작은것을 비교
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        for (i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }
}
