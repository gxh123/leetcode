import java.util.Arrays;

public class ShuffleanArray {
    int[] origin;

    public ShuffleanArray(int[] nums) {
        origin = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = Arrays.copyOf(this.origin, this.origin.length);
        shuffleInPlace(temp);
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 7, 9, 11, 13, 15, 17 };
        ShuffleanArray s = new ShuffleanArray(nums);
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
    }

    // 参考算法导论上的随机排列算法
    // 主要思想是：索引牌从第一张开始，到最后一张结束。每一次索引牌只和剩下还没有洗的牌进行交换
    public static void shuffleInPlace(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [i, n-1] //i+(0,1,2,3...(n-i-1))
            int r = i + (int) (Math.random() * (n - i)); // Math.random() 产生>=0 ,<1的随机数
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

}
