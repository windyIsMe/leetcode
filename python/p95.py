from treenode import TreeNode


class Solution:
    def generateTrees(self, n: int) -> [TreeNode]:
        if n == 0:
            return []
        return self.generateTree(1, n)

    def generateTree(self, start, end):
        nodeList = []
        if start > end:
            nodeList.append(None)
        else:
            for i in range(start, end + 1):
                leftTree = self.generateTree(start, i - 1)
                rightTree = self.generateTree(i + 1, end)
                for leftRoot in leftTree:
                    for rightRoot in rightTree:
                        root = TreeNode(i)
                        root.left = leftRoot
                        root.right = rightRoot
                        nodeList.append(root)
        return nodeList

if __name__ == '__main__':
    nodeList = Solution().generateTrees(3)
    for node in nodeList:
        print(node.val)
