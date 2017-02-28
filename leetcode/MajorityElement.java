import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.print(majorityElement(new int[] { 1, 1, 2 }));
    }

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]) + 1;
                if (count > nums.length / 2)
                    return nums[i];
                map.put(nums[i], count);
            } else {
                if (1 > nums.length / 2)
                    return nums[i];
                map.put(nums[i], 1);
            }
        }
        return -1;
    }

}
