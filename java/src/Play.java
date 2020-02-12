import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Play {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(5);
        set.add(4);
        System.out.println(set);
        String str = "abdc";
        System.out.println(str.substring(1, 2));
        System.out.println("Hello world!\n");
    }
}
