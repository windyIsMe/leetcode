package p24;

import model.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            ListNode p = head.next;
            head.next = swapPairs(head.next.next);
            p.next = head;
            return p;
        }
        return head;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 0; i < 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        ListNode result = solution.swapPairs(head);
        p = result;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
