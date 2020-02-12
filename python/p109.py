from treenode import TreeNode
from listnode import ListNode

class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if not head:
            return None
        mid = self.getMidNode(head)
        root = TreeNode(mid.val)
        if head == mid:
            return root
        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(mid.next)
        return root

    def getMidNode(self, head: ListNode) -> TreeNode:
        front, behind, prev = head, head, None
        while front and front.next:
            prev = behind
            front = front.next.next
            behind = behind.next
        if prev is not None:
            prev.next = None
        return behind

if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    root = Solution().sortedListToBST(head)
    print(root)