public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 5, 7, 8, 0, 0, 0, 0, 0, 0 };
        int[] nums2 = { 2, 4, 6 };
        merge(nums1, 5, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        // while (i < m + j && j < n) {
        // if (nums1[i] > nums2[j]) {
        // for (int k = m + j; k > i; k--) {
        // nums1[k] = nums1[k - 1];
        // }
        // nums1[i] = nums2[j];
        // i++;
        // j++;
        // } else {
        // i++;
        // }
        // }
        // while (j < n) {
        // nums1[i] = nums2[j];
        // i++;
        // j++;
        // }
        while (j < n) {
            if (nums1[i] > nums2[j]) {
                for (int k = m + j; k > i; k--) {
                    nums1[k] = nums1[k - 1];
                }
                nums1[i] = nums2[j];
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.print("111");
        /*
         * while (j < n) { nums1[i] = nums2[j]; i++; j++; }
         */
    }

}
