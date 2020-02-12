from treenode import TreeNode

class Solution:
    def inorderTraversal(self, root: TreeNode):
        res = []
        self.traverse(res, root)
        return res

    def inorderTraversalIterative(self, root: TreeNode):
        stack = []
        res = []
        cur = root
        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right
        return res

    def traverse(self, res: list, p: TreeNode):
        if p != None:
            self.traverse(res, p.left)
            res.append(p.val)
            self.traverse(res, p.right)

if __name__ == '__main__':
    root = TreeNode(3)
    root.left = TreeNode(1)
    root.left.right = TreeNode(2)
    root.right = TreeNode(5)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(6)
    print(Solution().inorderTraversalIterative(root))

