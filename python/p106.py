from treenode import TreeNode

class Solution:
    def buildTree(self, inorder: list, postorder: list) -> TreeNode:
        if inorder:
            root = TreeNode(postorder[len(postorder)-1])
            mid = inorder.index(postorder[len(postorder)-1])
            root.left = self.buildTree(inorder[0:mid], postorder[0:mid])
            root.right = self.buildTree(inorder[mid+1:len(inorder)], postorder[mid:len(inorder)-1])
            return root

if __name__ == '__main__':
    inorder = [9, 3, 15, 20, 7]
    postorder = [9, 15, 7, 20, 3]
    root = Solution().buildTree(inorder, postorder)
    print(root.val)