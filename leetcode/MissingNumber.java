public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 3 };
        System.out.println(missingNumber(nums));
    }

    // 求和
    public static int missingNumber(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return (int) ((long) (n * (n + 1) / 2) - sum);
    }

    // 下面这种求和更好，可以防止overflow
    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            sum -= nums[i];
        }
        sum += nums.length;
        return sum;
    }

    // 如果nums本身是已经排好序的，可以用二分，O(logn)
    public int missingNumber3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    // 比较巧妙的是用异或，因为少一个数字，所以这个数最后会留下来
    public int missingNumber4(int[] nums) { // xor
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) { // 相同的两个数异或为0
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

}
