public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = root;
        // root.next = new ListNode(2);
        // root.next.next = new ListNode(3);
        // root.next.next.next = new ListNode(4);
        // root.next.next.next.next = root;
        System.out.println(hasCycle(root));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

}
