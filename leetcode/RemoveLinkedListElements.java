public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(1);
        removeElements(root, 1);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return dummyHead.next;
    }

}
