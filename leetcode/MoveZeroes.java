public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0 };
        moveZeroes(nums);
        System.out.print("1");
    }

    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;

        while (zeroIndex < nums.length && nonZeroIndex < nums.length) {
            while (nums[zeroIndex] != 0) {
                zeroIndex++;
                if (zeroIndex >= nums.length)
                    return;
            }
            while (nums[nonZeroIndex] == 0) {
                nonZeroIndex++;
                if (nonZeroIndex >= nums.length)
                    return;
            }
            if (zeroIndex < nonZeroIndex) {
                nums[zeroIndex++] = nums[nonZeroIndex];
                nums[nonZeroIndex++] = 0;
            } else
                nonZeroIndex++;
        }
    }

}
