package p61;

import model.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        int index = len - k % len;
        if (index == len) {
            return head;
        }
        ListNode temp = head;
        ListNode cut = head;
        for (int i = 0; i < index - 1; i++) {
            cut = cut.next;
        }
        head = cut.next;
        tail.next = temp;
        cut.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(6);
        //l2.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode node = solution.rotateRight(l1, 5);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
