from treenode import TreeNode


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        return self.sumOfTree(root, 0)

    def sumOfTree(self, root: TreeNode, num) -> int:
        if root is None:
            return 0
        elif root.left is None and root.right is None:
            return num * 10 + root.val
        else:
            return self.sumOfTree(root.left, num * 10 + root.val) + self.sumOfTree(root.right, num * 10 + root.val)

if __name__ == '__main__':
    root = TreeNode(3)
    root.left = TreeNode(1)
    root.left.right = TreeNode(2)
    root.right = TreeNode(5)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(6)
    print(Solution().sumNumbers(root))
    print(312+354+356)
