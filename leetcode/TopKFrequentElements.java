import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        topKFrequent(nums, k);
    }

    // 桶排序：
    // 首先我们需要申请一个大小为11的数组int a[11]。第一个人的分数是5分，我们就将相对应的a[5]的值在原来的基础增加1。
    // 第二个人的分数是3分，我们就把相对应的a[3]的值在原来的基础上增加1。
    // 第三个人的分数也是5分，所以a[5]的值需要在此基础上再增加1...

    // 桶排序时间复杂度为O(n),这里是对每个数出现的次数进行桶排序
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1]; // 桶i中放的是出现次数为i的数，由于不一定是一个，所以用list
        for (int num : map.keySet()) {
            int frequency = map.get(num);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList();
            bucket[frequency].add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null)
                result.addAll(bucket[i]); // 有可能addAll加了不止一个导致大于k了
        }
        while (result.size() > k) {
            result.remove(result.size() - 1);
        }
        return result;
    }
}
