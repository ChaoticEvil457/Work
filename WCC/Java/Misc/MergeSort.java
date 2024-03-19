package Misc;

public class MergeSort {

    public void merge(int[] ray, int low, int mid, int high) {
        int l = 0;
        int r = 0;
        int[] left = new int[mid + 1 - low];
        int[] right = new int[high - mid];

        for (int i = low; i <= high; i++) {
            if (i <= mid) {
                left[l] = ray[i];
                l++;
            } else {
                right[r] = ray[i];
                r++;
            }
        }
        l = r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                ray[low] = left[l];
                l++;
            } else {
                ray[low] = right[r];
                r++;
            }
            low++;
        }
        while (r < right.length) {
            ray[low] = right[r];
            r++;
            low++;
        }
        while (l < left.length) {
            ray[low] = left[l];
            l++;
            low++;
        }
    }

    public void sort(int[] ray, int low, int high) {
        if (low < high) {

            int mid = low + (high - low) / 2;

            sort(ray, low, mid);
            sort(ray, mid + 1, high);

            merge(ray, low, mid, high);
        }
    }

    public void sort(int[] ray) {
        sort(ray, 0, ray.length - 1);
    }

    public static void main(String[] args) {
        int[] ray = { 5, 8, 3, 6, 4, 1, 2, 7, 9 };

        for (int i : ray) {
            System.out.print(i + ", ");
        }
        System.out.println("\n");
        MergeSort o = new MergeSort();
        o.sort(ray);
        for (int i : ray) {
            System.out.print(i + ", ");
        }
    }
}
