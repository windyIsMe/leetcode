from listnode import ListNode

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        preHead = ListNode(0)
        preHead.next = head
        cur = preHead
        for i in range(0, m-1):
            cur = cur.next
        start = cur
        cur = cur.next
        end = cur
        cur = cur.next
        for i in range(m, n):
            temp = start.next
            start.next = cur
            cur = cur.next
            start.next.next = temp
        end.next = cur
        return preHead.next

if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    sol = Solution()
    newHead = sol.reverseBetween(head, 1, 2)
    p = newHead
    while p != None:
        print(p.val)
        p = p.next
