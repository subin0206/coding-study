public class MergeSort {
    public static void main(String[] args) {
        int number = 8;
        MergeSort m = new MergeSort();
        int[] array = {7,6,5,8,3,5,9,1};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        m.mergeSort(array,0, number-1);
        for (int i = 0; i < number; i++) {
            System.out.println(array[i]);
        }

    }
    public void merge(int a[], int start, int middle, int end){
        int[] sort = new int[8];

        int i = start;
        int j = middle+1;
        int k = start;
        //작은 순서로 삽입
        while(i<= middle && j<= end){
            if (a[i] <= a[j]) {
                sort[k] = a[i];
                i++;
            } else {
                sort[k] = a[j];
                j++;
            }
            k++;
        }
        //i나 j가 먼저 정렬이 끝났을 경우
        if(i > middle){ // i가 끝난 경우
            for (int t = j; t <= end; t++) {
                sort[k] = a[t];
                k++;
            }
        }else{
            for (int t = i; t <= middle; t++) {
                sort[k] = a[t];
                k++;
            }
        }
        //정렬된 배열 삽입
        for (int t = start; t <= end; t++) {
            a[t] = sort[t];
        }
    }

    public void mergeSort(int a[], int start, int end) {
        if (start < end) {
            int middle =(start+end)/2;
            mergeSort(a, start, middle);//왼쪽으로 병합정렬
            mergeSort(a, middle+1, end); //오른쪽 병합 정렬
            merge(a, start, middle, end);
        }
    }
}
