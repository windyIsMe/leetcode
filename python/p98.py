from treenode import TreeNode

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root is None:
            return True
        if root.left is not None:
            p = root.left
            while p.right is not None:
                p = p.right
            if p.val >= root.val:
                return False
        if root.right is not None:
            p = root.right
            while p.left is not None:
                p = p.left
            if p.val <= root.val:
                return False
        return self.isValidBST(root.left) and self.isValidBST(root.right)

if __name__ == '__main__':
    root = TreeNode(1)
    root.right = TreeNode(1)

    print(Solution().isValidBST(root))