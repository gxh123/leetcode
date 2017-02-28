public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[] { 1, 3, 2, 5, 7, 3, 2 }));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] money = new int[nums.length]; // 从开始到i这家最大的rob钱数
        money[0] = nums[0];
        money[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        // int maxMoney = money[1];
        for (int i = 2; i < nums.length; i++) {
            // if (money[i - 2] + nums[i] >= money[i - 1]) {
            // money[i] = money[i - 2] + nums[i]; // 从开始到i这家最大的rob钱数 要么是一直到i-2这家的再加i这家的
            // } else {
            // money[i] = money[i - 1]; // 要么就是一直到i-1这家的，不加i这家，不能相邻
            // }
            // if (maxMoney < money[i]) {
            // maxMoney = money[i];
            // }
            money[i] = Math.max(nums[i] + money[i - 2], money[i - 1]);
        }
        return money[nums.length - 1];
    }

}
