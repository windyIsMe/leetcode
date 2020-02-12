from treenode import TreeNode
from queue import Queue

class Solution:
    def levelOrder(self, root: TreeNode) -> [[]]:
        if root is None:
            return []
        res = []
        nodeQueue = Queue()
        nodeQueue.put(root)
        while (not nodeQueue.empty()):
            levelList = []
            size = nodeQueue.qsize()
            for i in range(0, size):
                curNode = nodeQueue.get()
                levelList.append(curNode.val)
                if (curNode.left is not None):
                    nodeQueue.put(curNode.left)
                if (curNode.right is not None):
                    nodeQueue.put(curNode.right)
            res.append(levelList)
        return res

if __name__ == '__main__':
    root = TreeNode(3)
    root.left = TreeNode(1)
    root.left.right = TreeNode(2)
    root.right = TreeNode(5)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(6)
    print(Solution().levelOrder(root))