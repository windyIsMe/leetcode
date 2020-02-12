from treenode import TreeNode

class Solution:
    def buildTree(self, preorder: list, inorder: list) -> TreeNode:
        if preorder:
            root = TreeNode(preorder[0])
            mid = inorder.index(preorder[0])
            root.left = self.buildTree(preorder[1:mid+1], inorder[0:mid])
            root.right = self.buildTree(preorder[mid+1:len(preorder)], inorder[mid+1:len(inorder)])
            return root

if __name__ == '__main__':
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    root = Solution().buildTree(preorder, inorder)
    print(root.val)
