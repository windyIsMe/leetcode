package p86;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import model.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = start;
        int count = 0;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        ListNode tail = p;
        p = start;
        for (int i = 0; i < count; i++) {
            if (p.next.val < x) {
                p = p.next;
            } else if (p.next != tail){
                ListNode temp = p.next;
                p.next = p.next.next;
                tail.next = temp;
                tail = tail.next;
            }
        }
        tail.next = null;
        return start.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(3);
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode p = solution.partition(head1, 3);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
