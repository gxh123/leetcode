public class ProductofArrayExceptSelf {

    public static void main(String[] args) {
        productExceptSelf3(new int[] { 1, 2, 3, 4 });
    }

    // 左边所有数的乘积*右边所有数的乘积
    public static int[] productExceptSelf(int[] nums) {
        int[] productOfLeft = new int[nums.length];
        int[] productOfRight = new int[nums.length];
        productOfLeft[0] = 1;
        productOfRight[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            productOfLeft[i] = productOfLeft[i - 1] * nums[i - 1];
            productOfRight[nums.length - 1 - i] = productOfRight[nums.length - i]
                    * nums[nums.length - i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = productOfLeft[i] * productOfRight[i];
        }
        return result;
    }

    // 不用额外的空间，作为结果的那个数组可以用来暂存
    // 省掉左边的数组
    public static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        int[] productOfRight = new int[nums.length];
        result[0] = 1;
        productOfRight[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
            productOfRight[nums.length - 1 - i] = productOfRight[nums.length - i]
                    * nums[nums.length - i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i] * productOfRight[i];
        }
        return result;
    }

    // 再省掉右边的数组
    public static int[] productExceptSelf3(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        return result;
    }
}
