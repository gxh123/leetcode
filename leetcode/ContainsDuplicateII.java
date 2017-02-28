import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5, 2, 5, 6 };
        int k = 20;
        System.out.print(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int index = map.get(nums[i]);
                if (i - index <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
        }
        return false;
    }

}
