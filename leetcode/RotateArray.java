public class RotateArray {

    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        rotate(nums, 3);
        System.out.print(111);
    }

    // AB -> A'B -> A'B' -> BA
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length - k - 1);
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - 1);
    }

    public static void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
