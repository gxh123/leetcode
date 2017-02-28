public class SwapNodesinPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        ListNode current = head;
        prev.next = current;
        while (current != null && current.next != null) {
            ListNode temp = current.next.next;
            prev.next = current.next;
            // 画图就出来了，这么写可以
            // current.next.next = current;
            // current.next.next.next = temp;
            // 下面这么写也可以
            prev.next.next = current;
            prev.next.next.next = temp;

            current = prev.next.next.next; // 注意顺序，先写下面的会导致prev被修改
            prev = prev.next.next;

        }
        return dummyHead.next;
    }

}
