package Feb1;
public class QuickSort {

    public static int partition(int[] ray, int low, int high) {
        int pivot = ray[high];
        int i = low - 1;
        int temp;
        for (int j = low; j < high; j++) {
            if (ray[j] < pivot) {
                i++;
                temp = ray[i];
                ray[i] = ray[j];
                ray[j] = temp;
            }
        }
        temp = ray[i + 1];
        ray[i + 1] = ray[high];
        ray[high] = temp;
        return i + 1;
    }

    public static void sort(int[] ray) {
        if (0 < ray.length - 1) {
            int pivot = partition(ray, 0, ray.length - 1);
            sort(ray, 0, pivot - 1);
            sort(ray, pivot + 1, ray.length - 1);
        }
    }

    public static void sort(int[] ray, int low, int high) {
        if (low < high) {
            int pivot = partition(ray, low, high);
            sort(ray, low, pivot - 1);
            sort(ray, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] ray = { 5, 8, 3, 6, 4, 1, 2, 7, 9 };

        for (int i : ray) {
            System.out.print(i + ", ");
        }
        System.out.println("\n");
        sort(ray);
        for (int i : ray) {
            System.out.print(i + ", ");
        }
    }
}