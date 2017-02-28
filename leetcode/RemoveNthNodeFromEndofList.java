public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        // root.next = new ListNode(2);
        // root.next.next = new ListNode(3);
        // root.next.next.next = new ListNode(4);
        // root.next.next.next.next = new ListNode(5);
        removeNthFromEnd(root, 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode current = head;
        ListNode nextNth = dummyHead;
        while (n > 0) {
            nextNth = nextNth.next;
            n--;
        }
        while (nextNth.next != null) {
            prev = current;
            current = current.next;
            nextNth = nextNth.next;
        }
        prev.next = current.next;
        return dummyHead.next;
    }

}
