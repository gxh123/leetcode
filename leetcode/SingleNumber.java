import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 1, 2, 3, 4, 5, 4, 3, 2, 1 }));
    }

    // public static int singleNumber(int[] nums) {
    // Map<Integer, Integer> map = new HashMap<>();
    // for (int i = 0; i < nums.length; i++) {
    // if (!map.containsKey(nums[i])) {
    // map.put(nums[i], 1);
    // } else {
    // map.put(nums[i], map.get(nums[i]) + 1);
    // }
    // }
    // for (int i = 0; i < nums.length; i++) {
    // if (map.get(nums[i]) == 1) {
    // return nums[i];
    // }
    // }
    // return Integer.MIN_VALUE;
    // }

    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        return (int) set.toArray()[0];
    }

}
