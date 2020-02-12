from treenode import TreeNode


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> list:
        res, path = [], []
        if root == None:
            return res
        self.dfs(root, sum, path, res)
        return res

    def dfs(self, p: TreeNode, sumOfPath: int, path: list, res: list):
        path.append(p.val)
        if p.left == None and p.right == None:
            if sumOfPath == sum(path):
                res.append(list(path))
        if p.left != None:
            self.dfs(p.left, sumOfPath, path, res)
        if p.right != None:
            self.dfs(p.right, sumOfPath, path, res)
        path.pop(len(path) - 1)


if __name__ == '__main__':
    root = TreeNode(3)
    root.left = TreeNode(1)
    root.left.right = TreeNode(2)
    root.right = TreeNode(5)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(6)
    print(Solution().pathSum(root, 6))
