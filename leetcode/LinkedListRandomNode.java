import java.util.Random;

public class LinkedListRandomNode {

    ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    // 使用蓄水池算法
    public int getRandom() {
        ListNode temp = this.head;
        int result = temp.val;
        temp = temp.next;

        for (int i = 1; temp != null; i++) {
            Random rand = new Random();
            int pos = rand.nextInt(i + 1);
            if (pos < 1) {
                result = temp.val;
            }
            temp = temp.next;
        }
        return result;
    }

    public static void main(String[] args) {
        // for (int i = 0; i < 20; i++) {
        // int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // int[] result = reservoir(nums, 1);
        // System.out.println(result[0]);
        // }

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);

        LinkedListRandomNode l = new LinkedListRandomNode(root);
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
    }

    // 问题：如何从未知或者很大样本空间随机地取k个数?
    // 蓄水池算法：先把前k个数放入蓄水池，对接下来的k+1一直到结束(即i = k+1...N)，我们以k/i概率决定是否要把它换入蓄水池，换入时随机的选取一个作为替换项，这样一直做下去

    public static int[] reservoir(int[] nums, int k) {
        int[] result = new int[k];
        for (int i = 0; i < k; i++) { // 初始化蓄水池
            result[i] = nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            Random rand = new Random();
            int pos = rand.nextInt(i + 1);
            if (pos < k) {
                result[pos] = nums[i];
            }
        }
        return result;
    }
}
