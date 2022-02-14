import java.util.List;


public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        printNode(l1);
        ListNode head = reverseList(l1);
        printNode(head);
    }

    public static ListNode reverseList(ListNode cur) {
        ListNode next = null;
        ListNode prev = null;

        while (cur != null) {
            next= cur.next; // cur next step
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public static void printNode(ListNode head) {
        System.out.println("printNOde: ");
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }
}