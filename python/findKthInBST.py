from treenode import TreeNode

class Solution:
    count = 0

    def findKth(self, root, k):
        if (root == None):
            return None
        else:
            left = self.findKth(root.left, k)
            if (left != None):
                return left
            self.count += 1
            if (self.count == k):
                return root
            right = self.findKth(root.right, k)
            if (right != None):
                return right

if __name__ == '__main__':
    sol = Solution()
    root = TreeNode(3)
    root.left = TreeNode(1)
    root.left.right = TreeNode(2)
    root.right = TreeNode(5)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(6)
    print(sol.findKth(root, 3).val)



