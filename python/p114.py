from treenode import TreeNode

class Solution:
    def flatten(self, root: TreeNode) -> None:
        if root is None:
            return

        numList = []
        self.preOrder(root, numList)
        root.val = numList[0];
        root.left = None
        cur = root
        for i in range(1, len(numList)):
            cur.right = TreeNode(numList[i])
            cur = cur.right

    def flatten1(self, root: TreeNode) -> None:
        if root is None:
            return

        left = root.left
        right = root.right
        root.left = None
        self.flatten(left)
        self.flatten(right)
        root.right = left
        cur = root
        while cur.right:
            cur = cur.right
        cur.right = right

    def preOrder(self, root: TreeNode, numList: list) -> None:
        if (root is not None):
            numList.append(root.val)
            self.preOrder(root.left, numList)
            self.preOrder(root.right, numList)