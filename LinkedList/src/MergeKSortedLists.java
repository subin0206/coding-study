import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists a = new MergeKSortedLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        ListNode result = a.solve(list);
        a.print(result);
    }

    public ListNode solve(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((a,b)-> a.val-b.val);
        ListNode head = new ListNode(0);
        ListNode res = head;
        for (ListNode list : lists) {
            if(list!=null)
                q.offer(list);
        }
        while (!q.isEmpty()) {
            ListNode node =q.poll();
            res.next = node;
            res = res.next;
            if (node.next != null) {
                q.offer(node.next);
            }
        }
        return head.next;
    }
    private void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}