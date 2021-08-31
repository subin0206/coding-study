public class QuickSort {
    public static void main(String[] args) {
        QuickSort q = new QuickSort(); // 왼쪽에서는 피벗보다 큰 값 오른쪽에서는 피벗보다 작은값 찾아서 바꿔주는 정렬
        int[] data = {1,10, 5,8,7,6,4,3,2,9};
        int number =10;
        q.sort(data, 0, number-1);
        for (int i = 0; i < 10; i++) {
            System.out.println(data[i]);
        }
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;//원소가 1개일 때

        int mid = partition(arr, low, high); //엇갈린 값 피벗으로 시작해 다시 시작
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2]; //피벗값 설정해줌 // data 기준 7
        while (low <= high) { // 왼쪽 값이 오른쪽 값보다 작을때까지 // data 기준 low 시작 0 high 시작 9
            while (arr[low] < pivot) low++; // 왼쪽에서 피벗보다 큰 값을 찾을때까지 low값 상승한다.
            while (arr[high] > pivot) high--; // 오른쪽에서 피벗보다 작은 값 찾을때까지 high값 낮춰줌
            if (low <= high) { // 왼쪽 값이 오른쪽 값보다 작을때
                swap(arr, low, high); // 왼쪽 값과 오른쪽 값을 바꿔준다.
                low++; //그리고 왼쪽 기준 한칸 이동
                high--; //오른쪽 기준 한칸 이동
            }
        }//왼쪽 큰 값이 오른쪽 작은값보다 작다면 반복문에서 빠져나온다.
        return low; // 왼쪽
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
