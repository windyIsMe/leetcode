package p2;

import model.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int extra = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + extra;
            int val = sum % 10;
            extra = sum / 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + extra;
            int val = sum % 10;
            extra = sum / 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + extra;
            int val = sum % 10;
            extra = sum / 10;
            p.next = new ListNode(val);
            p = p.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null && extra == 1) {
            p.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}












